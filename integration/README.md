# integration — 真实脱敏流量回放验证

本模块使用**真实生产流量的脱敏 fixture**逐条喂 Java SDK 反序列化链路，并检测字段覆盖缺口（真实返回但 reply DTO 未接住的字段）。

> **隔离**：本模块是独立 Maven 子模块，仅在 `integration` profile 激活时参与构建。普通 `mvn install` / `mvn test` **不构建**本模块，与 `ddes-open-sdk` 的 59 个 mock 测试完全隔离，且**不带** `central-publishing` / GPG / source / javadoc 插件，不发布到 Maven Central。

## 运行方式

```bash
# 激活 integration profile 跑回放
mvn -Pintegration test

# 仅编译（验证代码可编译）
mvn -Pintegration test-compile
```

普通构建（不激活 profile）不会触及本模块：

```bash
mvn install          # integration 模块不参与构建
mvn test             # 现有 59 个 mock 测试不受影响
```

## fixtures 定位

回放读取已生成的脱敏 fixture（`replay/testdata/replay/**/*.json`，含真实业务 PII，**不入库**）。

路径由环境变量 `REPLAY_FIXTURES_DIR` 指定；未设置时使用测试代码中的默认路径。

**目录不存在或无 `*.json` 时 skip**，测试标记为 skipped 而非 failed。

```bash
# 指定自定义路径
REPLAY_FIXTURES_DIR=/path/to/replay/fixtures mvn -Pintegration test

# CI / 仅装 Java 仓库的场景（无 fixtures）→ 回放自动 skip
REPLAY_FIXTURES_DIR=/nonexistent mvn -Pintegration test
```

## 环境变量

| 变量 | 默认 | 说明 |
|------|------|------|
| `REPLAY_FIXTURES_DIR` | 测试代码中的默认路径 | fixtures 根目录；不存在则 skip |
| `REPLAY_STRICT` | （未设） | 设为 `1` 时，字段覆盖缺口视为测试失败（倒逼补字段）；未设则仅 log |
| `REPLAY_LIMIT_PER_URI` | `0`（全量） | 限制每个 URI 回放的 fixture 条数，`0` 表示全量；快速验证用（fixtures 数量大时建议设小值） |

## 串行执行与内存

Surefire 配置 `forkCount=1` + `reuseForks=false`，回放测试在单个 fork 内串行执行，避免 mock server 状态竞争与 token 刷新干扰。

**全量回放**（`REPLAY_LIMIT_PER_URI=0`）会逐条回放全部 ~97000 条 fixture（含 order_list 32177 条、Order/detail 13048 条等大文件，最大 75MB）。为避免大文件一次性解析撑爆堆：

- fixture 按 **URI 流式惰性加载**（Jackson `MappingIterator` 逐条解析，处理完即释放），内存峰值是单条 fixture 大小而非整个文件
- Surefire `argLine=-Xmx1g -Xms256m`（可在 pom 覆盖）

全量回放约 2 分钟（43 URI / 97000 条）。快速验证用 `REPLAY_LIMIT_PER_URI=20`（~15 秒），但会漏报后续 fixture 的反序列化失败与字段缺口——全量才能覆盖完整。

## 结果预期

每个 URI 输出一行汇总，例如：

```
[river] /river/Order/get: 回放 N 条（共 M）build失败=0 call失败=0(其中反序列化=0) 缺失字段 K 个
  缺失: foo, bar, baz
```

末尾输出总览：

```
=== 回放汇总：覆盖 X 个接口，回放 Y 条，缺失字段总数 Z（strict=false, limit=0）===
```

- **build 失败**：fixture 的 `in` 字段类型无法适配到 Request builder 参数（如 BigDecimal → Long 失败），记录但跳过该条，不阻断。
- **call 失败 / 反序列化失败**：SDK 调用因 Jackson 类型不匹配抛异常，记录为「重要发现」但不阻断（`FAIL_ON_UNKNOWN_PROPERTIES` 已关闭，类型不匹配才会炸）。
- **缺失字段**：成功类 fixture 的 `out.data` 顶层 key 与 reply Data DTO 的 `@JsonProperty` 集合对比，差集即为「真实返回但 SDK 未接住」的字段。默认 log，`REPLAY_STRICT=1` 时 fail。

## 文件结构

```
integration/
├── pom.xml
├── README.md
└── src/test/groovy/com/xiaoju/open/sdk/didies/replay/
    ├── ReplayBase.groovy    # Spock 基类：MockWebServer + auth mock + OkHttpTransport 注入
    ├── ReplayEngine.groovy  # 回放引擎：反射回填 + 类型适配 + reply 提取 + 字段覆盖
    ├── ReplayMap.groovy     # URI → 接口元数据映射表（43 URI）
    └── ReplayTest.groovy    # 主测试：逐条喂响应、字段覆盖、STRICT/limit
```
