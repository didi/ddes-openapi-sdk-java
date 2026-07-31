package com.xiaoju.open.sdk.didies.replay

import spock.lang.IgnoreIf
import spock.lang.Unroll

/**
 * 回放主测试（对齐 Go replay_test.go），基建复用 {@link ReplayBase}（design D3）。
 *
 * 逐条用真实流量 fixture 的 out 喂 SDK 反序列化链路：
 * 逐 URI -> 逐条 setOut 切换响应 -> entry.build(in) -> entry.call(client, req) -> entry.reply(resp)。
 *
 * - 无 fixtures 时（CI/新克隆，testdata 不存在且未设 REPLAY_FIXTURES_DIR）skip PASS。
 * - build/call/反序列化失败分别计数，记录但不阻断后续 fixture。
 * - 成功类 fixture 跑 fieldCoverage，缺失字段按 URI 去重收集。
 * - 默认仅 log 字段覆盖差异不 fail；REPLAY_STRICT=1 时缺失字段视为失败。
 * - REPLAY_LIMIT_PER_URI=N 限制每 URI 回放条数（0=全量），快速验证用。
 */
class ReplayTest extends ReplayBase {

    /** uri -> fixture 文件列表（轻量扫描，仅记录路径不加载 in/out，避免全量 fixture 驻留内存 OOM） */
    static final Map<String, List<File>> URI_FILES = ReplayEngine.listFixtureUris(null)

    /** 是否 strict 模式 */
    static final boolean STRICT = System.getenv("REPLAY_STRICT") == "1"

    /** 每 URI 回放条数上限（0=全量） */
    static final int LIMIT_PER_URI = envInt("REPLAY_LIMIT_PER_URI", 0)

    /** 有映射且有 fixture 的 URI 列表（排序保证输出稳定） */
    static final List<String> REPLAY_URIS = {
        List<String> us = []
        for (String u : URI_FILES.keySet()) {
            if (ReplayMap.REPLAY_MAP.containsKey(u)) {
                us << u
            }
        }
        return us.sort()
    }()

    /** 无 fixtures 时跳过整个回放（对齐 Go t.Skip） */
    @IgnoreIf({ ReplayTest.URI_FILES.isEmpty() })
    @Unroll
    def "回放 #uri"() {
        given: "该 URI 的 entry（fixture 流式逐条加载，不驻留整个文件，避免大文件 OOM）"
        ReplayEntry entry = ReplayMap.REPLAY_MAP[uri]
        List<File> files = URI_FILES[uri]

        when: "流式逐条回放"
        Set<String> missingSet = [] as Set<String>
        // 用 Map 持有可变计数（闭包内修改 int 不影响外层，故用 holder）
        Map<String, Integer> cnt = [buildFail: 0, callFail: 0, deserialFail: 0]
        String uriRef = uri
        int[] res = ReplayEngine.forEachFixtureOfUri(uri, files, LIMIT_PER_URI) { Map f ->
            // 切换 mock 响应为当前这条 fixture 的 out
            setOut(uriRef, (Map<String, Object>) f.get("out"))

            Object req
            try {
                req = entry.build.call((Map) f.get("in"))
            } catch (Exception e) {
                cnt.buildFail++
                return false
            }
            Object resp
            try {
                resp = entry.call.call(apiClient, req)
            } catch (Throwable e) {
                // 反序列化错误是重要发现（类型不匹配），记录但不阻断
                // 捕获 Throwable 以兼容 NoClassDefFoundError 等 Error（环境类加载问题）
                cnt.callFail++
                if (isDeserialErr(e)) {
                    cnt.deserialFail++
                }
                return false
            }
            Object[] er = entry.reply.call(resp)
            Object replyData = er[1]

            // 字段覆盖差异（成功响应才对比）
            if (f.get("category") == "success") {
                Map out = (Map) f.get("out")
                Object outData = out?.get("data")
                for (String m : ReplayEngine.fieldCoverage(outData, replyData)) {
                    missingSet << m
                }
            }
            return true
        }
        int total = res[0]
        int n = res[1]

        then: "汇总该 URI"
        List<String> missing = missingSet.sort().unique()
        println("[${entry.family}] ${uri}: 回放 ${n} 条（共 ${total}）build失败=${cnt.buildFail} call失败=${cnt.callFail}(其中反序列化=${cnt.deserialFail}) 缺失字段 ${missing.size()} 个")
        if (missing.size() > 0) {
            println("  缺失: ${missing.join(', ')}")
        }

        if (STRICT && missing.size() > 0) {
            assert false: "strict 模式：缺失字段 ${missing}"
        }

        where:
        uri << REPLAY_URIS
    }

    /** 无 fixtures 时的跳过逻辑验证（对齐 Go TestReplaySkipWhenNoFixtures） */
    def "无 fixtures 时 loadFixtures 返回空"() {
        expect:
        ReplayEngine.loadFixtures("/nonexistent/replay/path").isEmpty()
    }

    /** 回放汇总（独立测试，跑完所有 URI 子测试后输出总览） */
    def "回放汇总"() {
        expect:
        println("=== 回放汇总：覆盖 ${REPLAY_URIS.size()} 个接口，strict=${STRICT}, limit=${LIMIT_PER_URI} ===")
        println("（每 URI 的回放条数与缺失字段见上方各子测试输出）")
        true
    }

    /** 判断是否为 JSON 反序列化错误（类型不匹配等重要发现），对齐 Go isDeserialErr */
    static boolean isDeserialErr(Throwable e) {
        if (e == null) {
            return false
        }
        String msg = e.message ?: ""
        // Jackson: MismatchedInputException / Cannot deserialize
        if (e.class.name.contains("jackson")) {
            return true
        }
        return msg.contains("Cannot deserialize") ||
                msg.contains("MismatchedInput") ||
                msg.contains("cannot deserialize")
    }

    static int envInt(String key, int defVal) {
        String v = System.getenv(key)
        if (v == null || v.isEmpty()) {
            return defVal
        }
        try {
            return Integer.parseInt(v.trim())
        } catch (NumberFormatException ignore) {
            return defVal
        }
    }
}
