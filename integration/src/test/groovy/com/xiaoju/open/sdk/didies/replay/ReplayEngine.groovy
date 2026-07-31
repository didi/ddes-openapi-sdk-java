package com.xiaoju.open.sdk.didies.replay

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.MappingIterator
import com.fasterxml.jackson.databind.ObjectMapper
import groovy.json.JsonSlurper

import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 * 回放引擎（对齐 Go replay.go，design D4/D5/D6）。
 *
 * - loadFixtures: 读 REPLAY_FIXTURES_DIR，walk *.json，uri -> []fixture；目录不存在返回空（调用方 skip）
 * - buildRiverApiReq: 剔除通用字段后 snakeToCamel 反射调 builder 方法 + 类型适配，build() 返回 Request
 * - adaptArg: BigDecimal/Integer/Long/String/Boolean -> Integer/Long/String/Boolean 四源四目标适配
 * - buildRequestApiReq: param_json 接口走 paramJson 字符串字段（不碰 paramJsonObj），平铺字段接口复用 river 反射
 * - extractReply: 反射取 ApiReply 的 errno（Integer，判空）+ data
 * - jsonTagsOf: 遍历类及父类的 @JsonProperty 注解值，收集 reply Data 的 json tag 集合
 * - fieldCoverage: 对比 out.data 顶层 key 与 reply Data 的 tag 集合，返回"真实返回但 SDK 未接住"的字段
 */
class ReplayEngine {

    /** 通用字段：回填时剔除（对齐 Go buildRiverApiReq 的 common set） */
    static final Set<String> COMMON_FIELDS = [
            "client_id", "client_secret", "access_token",
            "company_id", "sign", "timestamp", "sign_key",
    ] as Set<String>

    // ===== 3.1 loadFixtures =====

    /**
     * 解析 fixtures 根目录（env REPLAY_FIXTURES_DIR 或默认候选路径）。不存在返回 null。
     */
    static File resolveFixturesRoot(String dir) {
        if (dir == null || dir.isEmpty()) {
            dir = System.getenv("REPLAY_FIXTURES_DIR")
        }
        if (dir != null && !dir.isEmpty()) {
            File f = new File(dir)
            return f.exists() ? f : null
        }
        // 默认候选路径：指向本机并列的 Go 仓库（design D2）
        List<String> candidates = [
                "../../golang/ddes-openapi-sdk-go/replay/testdata/replay", // 从 Java 仓库根启动
                "../../../golang/ddes-openapi-sdk-go/replay/testdata/replay", // 从 integration 子模块启动
        ]
        for (String c : candidates) {
            File f = new File(c)
            if (f.exists()) {
                return f
            }
        }
        return null
    }

    /**
     * 读 REPLAY_FIXTURES_DIR（默认指向本机 Go 仓库 replay/testdata/replay），
     * walk *.json，JsonSlurper 解析为 uri -> []fixture；目录不存在返回空（调用方据此 skip）。
     *
     * 注意：此方法一次性加载全部 fixture 到内存，仅适用于小规模或被 REPLAY_LIMIT_PER_URI 限流的场景。
     * 全量回放（97000+ 条）会用 {@link #listFixtureUris} + {@link #loadFixturesForUri} 按 URI 惰性加载，
     * 避免内存堆积 OOM。
     */
    static Map<String, List<Map>> loadFixtures(String dir) {
        File root = resolveFixturesRoot(dir)
        if (root == null) {
            return [:]
        }
        Map<String, List<Map>> out = [:].withDefault { [] }
        root.eachFileRecurse { File f ->
            if (f.isDirectory() || !f.name.endsWith(".json")) {
                return
            }
            for (Map fx : parseFixturesFile(f)) {
                Object uri = fx.get("uri")
                if (uri != null) {
                    out[(String) uri] << fx
                }
            }
        }
        return out
    }

    /**
     * 轻量扫描：只读每个 json 文件的 URI（首个 fixture 的 uri 字段），返回 uri -> [文件路径]。
     * 不加载 in/out 内容，避免全量 fixture 一次性驻留内存。
     * 一个文件通常对应一个 URI（replaygen 按 URI 分桶）。
     */
    static Map<String, List<File>> listFixtureUris(String dir) {
        File root = resolveFixturesRoot(dir)
        if (root == null) {
            return [:]
        }
        Map<String, List<File>> out = [:].withDefault { [] }
        root.eachFileRecurse { File f ->
            if (f.isDirectory() || !f.name.endsWith(".json")) {
                return
            }
            // 仅提取 uri，不保留 in/out：用流式解析首个元素或解析后只取 uri
            for (String u : urisOfFile(f)) {
                out[u] << f
            }
        }
        return out
    }

    /** 按需加载单个 URI 的全部 fixture（仅该 URI，用完即可 GC）。 */
    static List<Map> loadFixturesForUri(String uri, Map<String, List<File>> uriFiles) {
        List<Map> out = []
        List<File> files = uriFiles.get(uri)
        if (files == null) {
            return out
        }
        for (File f : files) {
            for (Map fx : parseFixturesFile(f)) {
                if (uri == fx.get("uri")) {
                    out << fx
                }
            }
        }
        return out
    }

    /** 解析单个 fixture 文件为 List<Map>，解析失败返回空。 */
    private static List<Map> parseFixturesFile(File f) {
        Object parsed
        try {
            parsed = new JsonSlurper().parse(f)
        } catch (Exception ignore) {
            return []
        }
        if (!(parsed instanceof List)) {
            return []
        }
        List<Map> out = []
        for (Object item : (List) parsed) {
            if (item instanceof Map) {
                out << (Map) item
            }
        }
        return out
    }

    /** 提取一个 fixture 文件涉及的全部 URI（流式逐条读，不保留 in/out 内容，省内存）。 */
    private static List<String> urisOfFile(File f) {
        List<String> uris = []
        FileInputStream fis = null
        MappingIterator<Map> it = null
        try {
            fis = new FileInputStream(f)
            it = OBJECT_MAPPER.readerFor(Map.class).readValues(fis)
            while (it.hasNext()) {
                Map fx = it.nextValue()
                Object u = fx.get("uri")
                if (u != null && !uris.contains(u)) {
                    uris << (String) u
                }
            }
        } catch (Exception ignore) {
            // 解析异常忽略
        } finally {
            if (it != null) { try { it.close() } catch (Exception ignore) {} }
            if (fis != null) { try { fis.close() } catch (Exception ignore) {} }
        }
        return uris
    }

    /** 共享 ObjectMapper（Jackson，用于流式解析大 fixture 文件）。 */
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()

    /**
     * 流式逐条回放：用 Jackson MappingIterator 逐条解析 fixture 文件，匹配 uri 的条目回调处理，
     * 处理完即释放，不把整个文件驻留内存（根治大文件 75MB / 32177 条 OOM）。
     *
     * @param uri 目标 URI
     * @param files 该 URI 的 fixture 文件列表（来自 listFixtureUris）
     * @param limitPerURI 每 URI 回放条数上限（0=全量）
     * @param callback 单条 fixture 的回放回调，返回 true 表示已计入有效回放条数（用于 limit 计数）
     * @return int[2]: [匹配 URI 的总条数, 实际有效回放条数]
     */
    static int[] forEachFixtureOfUri(String uri, List<File> files, int limitPerURI, Closure callback) {
        if (files == null || files.isEmpty()) {
            return [0, 0] as int[]
        }
        int total = 0
        int n = 0
        for (File f : files) {
            FileInputStream fis = null
            MappingIterator<Map> it = null
            try {
                fis = new FileInputStream(f)
                // readValues 对顶层 JSON 数组会逐元素迭代返回 Map
                it = OBJECT_MAPPER.readerFor(Map.class).readValues(fis)
                while (it.hasNext()) {
                    Map fx = it.nextValue()
                    if (uri != fx.get("uri")) {
                        continue
                    }
                    total++
                    if (limitPerURI > 0 && n >= limitPerURI) {
                        continue
                    }
                    if (callback.call(fx)) {
                        n++
                    }
                }
            } catch (Exception ignore) {
                // 解析异常忽略，继续下一个文件
            } finally {
                if (it != null) { try { it.close() } catch (Exception ignore) {} }
                if (fis != null) { try { fis.close() } catch (Exception ignore) {} }
            }
        }
        return [total, n] as int[]
    }


    // ===== 3.2 buildRiverApiReq =====

    /**
     * 通用 river 平铺字段回填：剔除通用字段后，按 snake_case->CamelCase 反射调 builder 方法 + 类型适配，
     * build() 返回 Request。builder 是 Lombok @SuperBuilder 生成的 XxxRequestBuilder。
     */
    static Object buildRiverApiReq(Object builder, Map inMap) {
        inMap.each { k, v ->
            if (COMMON_FIELDS.contains(k)) {
                return
            }
            String methodName = snakeToCamel((String) k)
            Method m = findBuilderMethod(builder.class, methodName)
            if (m == null) {
                // 字段无对应 builder 方法，跳过（记录由调用方处理）
                return
            }
            Object arg = adaptArg(v, m.parameterTypes[0])
            if (arg == ADAPT_FAIL) {
                throw new IllegalArgumentException("field ${k}: 无法适配类型 ${v?.class?.name} -> ${m.parameterTypes[0].name}")
            }
            m.invoke(builder, arg)
        }
        Method build = builder.class.getMethod("build")
        build.setAccessible(true)
        return build.invoke(builder)
    }

    // ===== 3.3 adaptArg =====

    /** 适配失败的哨兵（null 是合法值，不能用 null 表示失败） */
    static final Object ADAPT_FAIL = new Object()

    /**
     * 将 in 字段值适配为 builder 方法参数类型。
     * 源: BigDecimal/Integer/Long/String/Boolean；目标: Integer/Long/String/Boolean。
     * 关键 case: member_id 字符串 "7030" -> Long 7030；BigDecimal 7030 -> Long 7030。
     * 无法适配返回 ADAPT_FAIL。
     */
    static Object adaptArg(Object v, Class targetType) {
        if (v == null) {
            return null
        }
        if (targetType == String.class) {
            return toString(v)
        }
        if (targetType == Integer.class || targetType == int.class) {
            Long l = toLong(v)
            return l == null ? ADAPT_FAIL : l.intValue()
        }
        if (targetType == Long.class || targetType == long.class) {
            Long l = toLong(v)
            return l == null ? ADAPT_FAIL : l
        }
        if (targetType == Boolean.class || targetType == boolean.class) {
            Boolean b = toBool(v)
            return b == null ? ADAPT_FAIL : b
        }
        // 其他类型（如 BigDecimal/Double 目标）兜底
        if (targetType == BigDecimal.class) {
            return toBigDecimal(v)
        }
        if (targetType == Double.class || targetType == double.class) {
            BigDecimal bd = toBigDecimal(v)
            return bd == null ? ADAPT_FAIL : bd.doubleValue()
        }
        if (targetType == Float.class || targetType == float.class) {
            BigDecimal bd = toBigDecimal(v)
            return bd == null ? ADAPT_FAIL : bd.floatValue()
        }
        return ADAPT_FAIL
    }

    static String toString(Object v) {
        if (v instanceof BigDecimal) {
            return ((BigDecimal) v).toPlainString()
        }
        return v.toString()
    }

    static Long toLong(Object v) {
        if (v instanceof Number) {
            return ((Number) v).longValue()
        }
        if (v instanceof Boolean) {
            return ((Boolean) v) ? 1L : 0L
        }
        if (v instanceof String) {
            try {
                return new BigDecimal((String) v).longValueExact()
            } catch (Exception ignore) {
                return null
            }
        }
        return null
    }

    static Boolean toBool(Object v) {
        if (v instanceof Boolean) {
            return (Boolean) v
        }
        if (v instanceof Number) {
            return ((Number) v).doubleValue() != 0d
        }
        if (v instanceof String) {
            String s = ((String) v).trim()
            if (s.equalsIgnoreCase("true") || s == "1") {
                return true
            }
            if (s.equalsIgnoreCase("false") || s == "0") {
                return false
            }
            return null
        }
        return null
    }

    static BigDecimal toBigDecimal(Object v) {
        if (v instanceof BigDecimal) {
            return (BigDecimal) v
        }
        if (v instanceof Number) {
            return new BigDecimal(v.toString())
        }
        if (v instanceof String) {
            try {
                return new BigDecimal((String) v)
            } catch (Exception ignore) {
                return null
            }
        }
        return null
    }

    // ===== 3.4 buildRequestApiReq =====

    /**
     * 通用 POST-body 回填：构造 RequestBuilder（param_json 或直接字段），build 后返回 Request。
     * - param_json 接口（open-apis）：in 含 param_json 字符串，调 RequestBuilder.paramJson。
     * - 直接字段接口（river POST-body）：in 为平铺字段，反射调 RequestBuilder 字段方法。
     *
     * 注意：param_json 走 paramJson(String) 字段，不碰 paramJsonObj 对象（design D5）。
     * Java 的 Request 直接就是带 builder 的 DTO，不像 Go 有 ApiReqBuilder/RequestBuilder 两层；
     * 故本方法对 Java 简化为：直接在 requestBuilder 上回填并 build。
     */
    static Object buildRequestApiReq(Object requestBuilder, Map inMap) {
        if (inMap.containsKey("param_json")) {
            String pjStr = toString(inMap.get("param_json"))
            Method m = findBuilderMethod(requestBuilder.class, "paramJson")
            if (m != null) {
                m.invoke(requestBuilder, pjStr)
            }
        } else {
            // 直接字段：复用 river 平铺反射，作用在 RequestBuilder 上
            buildRiverApiReq(requestBuilder, inMap)
        }
        Method build = requestBuilder.class.getMethod("build")
        build.setAccessible(true)
        return build.invoke(requestBuilder)
    }

    // ===== 3.5 extractReply =====

    /**
     * 从 ApiReply 提取 (errno, data)。
     * Java 的 service 方法直接返回 XxxApiReply（extends BaseResp，有 errno 顶层字段），
     * data 是 ApiReply 上的 data 字段（类型为 XxxReply）。
     * 返回 [errno, data]，errno 可为 null，data 可为 null。
     */
    static Object[] extractReply(Object resp) {
        if (resp == null) {
            return [null, null] as Object[]
        }
        Class clazz = resp.class
        Integer errno = null
        Object data = null
        // errno: 找 BaseResp 上的 errno 字段（含父类）
        Field errnoField = findField(clazz, "errno")
        if (errnoField != null) {
            errnoField.setAccessible(true)
            Object ev = errnoField.get(resp)
            if (ev instanceof Number) {
                errno = ((Number) ev).intValue()
            }
        }
        // data: ApiReply 上的 data 字段（类型名不以 ApiReply 结尾，是 XxxReply）
        Field dataField = findField(clazz, "data")
        if (dataField != null) {
            dataField.setAccessible(true)
            data = dataField.get(resp)
        }
        return [errno, data] as Object[]
    }

    // ===== 3.6 jsonTagsOf =====

    /**
     * 遍历类及父类（getSuperclass()）的 @JsonProperty 注解值，收集 reply Data 的 json tag 集合。
     * Lombok @Data/@SuperBuilder 生成的字段是真字段，getDeclaredFields() + getAnnotation(JsonProperty) 可达。
     */
    static Set<String> jsonTagsOf(Object dataObj) {
        Set<String> tags = new LinkedHashSet<>()
        if (dataObj == null) {
            return tags
        }
        Class clazz = dataObj.class
        while (clazz != null && clazz != Object.class) {
            for (Field f : clazz.getDeclaredFields()) {
                JsonProperty ann = f.getAnnotation(JsonProperty.class)
                if (ann != null) {
                    String name = ann.value()
                    if (name != null && !name.isEmpty() && name != "-") {
                        tags << name
                    }
                }
            }
            clazz = clazz.getSuperclass()
        }
        return tags
    }

    // ===== 3.7 fieldCoverage =====

    /**
     * 对比 out.data 的顶层 key 与 reply Data 的 tag 集合，
     * 返回"真实返回但 SDK 未接住"的字段（排序去重）。
     */
    static List<String> fieldCoverage(Object outData, Object replyData) {
        if (!(outData instanceof Map)) {
            return []
        }
        Map dataMap = (Map) outData
        if (dataMap.isEmpty()) {
            return []
        }
        Set<String> tags = jsonTagsOf(replyData)
        if (tags.isEmpty()) {
            return []
        }
        List<String> missing = []
        for (Object k : dataMap.keySet()) {
            if (!tags.contains(k)) {
                missing << (String) k
            }
        }
        return missing.sort()
    }

    // ===== 工具方法 =====

    /** snake_case -> CamelCase: order_id -> OrderId, need_rule_info -> NeedRuleInfo（对齐 Go snakeToCamel） */
    static String snakeToCamel(String s) {
        if (s == null || s.isEmpty()) {
            return s
        }
        StringBuilder sb = new StringBuilder()
        boolean cap = true
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i)
            if (c == '_' as char) {
                cap = true
                continue
            }
            if (cap) {
                sb.append(Character.toUpperCase(c))
                cap = false
            } else {
                sb.append(c)
            }
        }
        return sb.toString()
    }

    /** 在 builder 类上找名为 methodName、单参数的方法（Lombok builder 方法）。
     *  注意：Lombok @SuperBuilder 生成的 BuilderImpl 是包级私有类，其方法虽 public 但
     *  反射调用时会被 Java 访问检查拒绝，故 setAccessible(true) 绕过。 */
    static Method findBuilderMethod(Class clazz, String methodName) {
        for (Method m : clazz.getMethods()) {
            if (m.name == methodName && m.parameterCount == 1) {
                m.setAccessible(true)
                return m
            }
        }
        return null
    }

    /** 在类及父类上找字段 */
    static Field findField(Class clazz, String name) {
        Class c = clazz
        while (c != null && c != Object.class) {
            try {
                return c.getDeclaredField(name)
            } catch (NoSuchFieldException ignore) {
                c = c.getSuperclass()
            }
        }
        return null
    }
}
