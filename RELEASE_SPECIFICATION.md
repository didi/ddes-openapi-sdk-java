# SDK 发布规范

本文适用于 `github.com/didi/ddes-openapi-sdk-java`（发布产物 GAV：`com.xiaojukeji.esapi:ddes-open-sdk`）的版本规划、发布前检查和版本发布。

> 注意：用户引入的依赖是 `com.xiaojukeji.esapi:ddes-open-sdk`，不是父 POM 的 `com.xiaoju.sdk:ddes-openapi-sdk-java`。版本号变更只针对前者。

## 1. 版本号规范

项目采用 [语义化版本 2.0.0](https://semver.org/lang/zh-CN/)：

```text
主版本号.次版本号.修订号[-预发布标识]
```

示例：`1.2.3`、`1.3.0`、`2.0.0`、`1.3.0-rc.1`。

发布版本号必须同步更新以下位置：

- `ddes-open-sdk/pom.xml` 中的 `<version>`（SDK 自身版本，即发布产物版本）；
- `sample/pom.xml` 与 `integration/pom.xml` 中引用的 `ddes-open-sdk` 依赖版本；
- `CHANGELOG.md` 对应版本章节；
- Git tag，格式为 `v<版本号>`。

> 父 POM（`com.xiaoju.sdk:ddes-openapi-sdk-java`）与各模块自身的 `<version>`（当前 `1.0.1`）不随 SDK 发布版本变化，无需同步。

## 2. 版本升级规则

### 2.1 主版本号（Major）

以下情况必须升级主版本号：

- 删除或重命名公开类、字段、方法或服务（如移除某个 `service` 模块或 `v1` 方法）；
- 修改公开字段类型，例如 `Long` 改为 `String`、`Integer` 改为 `String`、`List<Long>` 改为 `List<String>`；
- 修改 Lombok Builder 生成的方法参数类型或返回类型，导致已有调用代码无法编译；
- 修改 `@JsonProperty` 的 JSON 字段名，导致序列化/反序列化行为不兼容；
- 修改已有接口的请求路径、HTTP 方法或请求参数语义，导致已有调用方无法正常工作；
- 删除已废弃但仍在支持周期内的 API；
- 修改已有响应字段的语义，使已有调用方产生不兼容行为。

示例：

```text
1.2.3 → 2.0.0
```

仅增加 Jackson 自定义反序列化容错能力、修复 number/string 混合响应解析问题，且不改变公开字段类型时，不属于主版本升级。

### 2.2 次版本号（Minor）

以下情况通常升级次版本号：

- 新增服务模块、接口方法、`Request` 或 `ApiReply` 模型；
- 为已有模型新增可选字段；
- 新增向后兼容的 SDK 能力（如新的 `Config` 选项、新的 `IHttpTransport` 实现）；
- 性能优化或内部实现调整，且不改变公开 API 行为。

示例：

```text
1.2.3 → 1.3.0
```

新增的数值/布尔类型字段应使用包装类型（`Integer`/`Long`/`Boolean` 等）而非基本类型，以区分「未返回（null）」和「零值」，并遵循项目现有模型类型规范。

### 2.3 修订号（Patch）

以下情况升级修订号：

- 修复不正确的请求构造、签名（`SignUtils`）、加密（`AesUtils`）或响应解析（`JacksonUtils`）；
- 修复不影响公开 API 类型和方法签名的 Bug；
- 修复安全问题；
- 更新文档、示例或测试；
- 优化内部代码且不改变公开行为。

示例：

```text
1.2.3 → 1.2.4
```

如果修复需要修改已有公开字段类型或 Builder 签名，即使目的是修复 Bug，也必须按破坏性变更处理，升级主版本号或提供兼容过渡方案。

## 3. Java SDK 兼容性判定

发布前必须检查以下公开 API 是否发生变化：

- `ApiClient` 及其服务方法（如 `client.order()`、`client.member()` 等）；
- 各 `service` 模块、`V1` 类及其 API 方法；
- `Request`、`ApiReply`、`BaseResp`、`ErrorInfo` 及各模型类；
- 公开字段的名称、Java 类型（含包装类型与集合泛型）、`@JsonProperty` 标签；
- Lombok `@Builder` / `@SuperBuilder` 生成的方法签名；
- `core` / `utils` 包中的公开函数、接口（如 `IHttpTransport`、`ITokenHolder`）、枚举（`SignMethodEnum`、`EncryptTypeEnum`）和常量；
- 请求路径、HTTP 方法、请求参数和响应字段语义。

以下规则适用于新增或修复接口：

1. 不修改已有字段或方法的类型和行为；
2. 新接口定义独立的 `Request`、`ApiReply`、`ErrorInfo` 等模型类型；
3. number/string 混合响应优先通过 Jackson 自定义反序列化或 `JacksonUtils` 兼容，不以修改已有公开字段类型作为默认方案；
4. 大 ID、订单号等字段必须使用 `Long` 或 `String` 承载，避免经过 `Double`/`Float` 中间层，确保精度；
5. 如果无法兼容旧类型，必须在 `CHANGELOG.md` 中明确列出破坏性变更及迁移方式。

> `__obj__` 后缀便捷字段（如 `extraInfoObj` 对应 json-string 字段 `extra_info`）属于公开 API 的一部分，新增/删除/改类型同样适用上述兼容性规则。

## 4. 预发布版本

### 4.1 预发布标识

- `alpha`：内部验证版本，功能或接口可能继续调整；
- `beta`：面向受控用户验证的版本，功能基本确定；
- `rc`：发布候选版本，仅允许修复阻塞发布的问题。

### 4.2 版本格式与晋级

```text
1.3.0-alpha.1
1.3.0-beta.1
1.3.0-rc.1
1.3.0
```

同一阶段修复问题时递增序号，例如 `rc.1` → `rc.2`。正式版本发布后，不再沿用同一预发布 tag。

> 开发期的每日构建可使用 Maven `SNAPSHOT` 版本（如 `1.3.0-SNAPSHOT`），但 **`SNAPSHOT` 不得发布到 Maven Central release 仓库**，正式发布必须是固定版本号。

## 5. CHANGELOG 规范

每次发布必须在 `CHANGELOG.md` 增加版本章节，至少包含：

- 版本号和发布日期；
- 破坏性变更；
- 新增接口或能力；
- Bug 修复；
- 测试、工程化或构建相关变化；
- 需要用户迁移的代码示例或说明。

破坏性变更必须写明：

```text
接口/模型、字段或方法、旧类型、新类型、迁移方式
```

如果最终恢复了历史公开类型（即把一度变更的字段类型改回原样），`CHANGELOG` 不应继续把该字段列为破坏性变更，但应说明仍保留的响应兼容逻辑。

## 6. 发布前检查

发布人必须按顺序完成以下检查：

### 6.1 代码与测试

```bash
# 编译 SDK 主代码
mvn -q clean compile -pl ddes-open-sdk

# 运行 SDK 单元测试（Spock + JUnit，MockWebServer mock）
mvn test -pl ddes-open-sdk

# 含覆盖率（JaCoCo）的完整校验
mvn clean verify -pl ddes-open-sdk
# 覆盖率报告：ddes-open-sdk/target/site/jacoco/index.html

# 检查工作区干净、无空白符错误
git diff --check
```

回放/集成测试位于 `integration` 子模块，默认不参与构建，需显式激活 profile：

```bash
mvn -Pintegration test
```

如果环境限制导致 mock 测试无法运行，至少执行编译检查（`mvn test-compile`），并记录未执行的测试及原因；不得将「仅编译通过」表述为「全部测试通过」。

### 6.2 变更检查

- 确认 `git diff` 只包含本次发布相关内容；
- 确认没有提交本地凭证、真实请求参数、响应 fixture 或敏感信息；
- 确认新增接口包含必要的模型测试、请求构造测试和响应反序列化测试；
- 确认加密接口覆盖 `EncryptTypeEnum` 的 `NORMAL`、`AES128`、`AES256` 场景；
- 确认 `ddes-open-sdk/pom.xml`、`sample/pom.xml`、`integration/pom.xml`、`CHANGELOG.md` 与发布 tag 的版本号一致。

## 7. 发布流程

1. 在功能分支完成开发、评审和测试；
2. 根据本规范确定版本号；
3. 更新 `ddes-open-sdk/pom.xml`（及 `sample`、`integration` 引用版本）和 `CHANGELOG.md`；
4. 执行第 6 节全部发布前检查；
5. 合并到主分支（`master`）；
6. 创建并推送 tag：

   ```bash
   git tag -a v1.3.0 -m "release: v1.3.0"
   git push origin v1.3.0
   ```

7. 发布到 Maven Central（Sonatype Central Portal，由 `central-publishing-maven-plugin` 自动发布、`maven-gpg-plugin` 自动签名，并附带 source/javadoc jar）：

   ```bash
   mvn clean deploy -pl ddes-open-sdk
   ```

   > 需在本地 `settings.xml` 中配置 `<server>` 的 `central` 凭证，并保证 GPG 可用。`autoPublish=true` 会自动推进 staging 发布。

8. 确认目标版本可被获取：

   ```bash
   mvn dependency:get -Dartifact=com.xiaojukeji.esapi:ddes-open-sdk:1.3.0
   ```

9. 在发布记录中附上版本说明、测试结果和已知限制。

## 8. 回滚与补发

- 发布后发现阻塞问题时，优先停止继续传播该版本（注意：Maven Central 已发布版本**不可删除或覆盖**，只能在其后的修订版本中修复），并在发布记录中标明问题；
- 已公开发布的版本号不得复用或覆盖；
- 修复后必须递增修订号，重新执行发布前检查；
- 如果问题涉及公开 API 破坏性变更，必须重新评估主版本号和迁移方案；
- 回滚代码分支与撤回错误版本号是两个独立动作，不能通过重新推送同名 tag 替代。
