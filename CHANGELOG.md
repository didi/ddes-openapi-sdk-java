# 变更日志（Changelog）

本文件记录 `ddes-open-sdk`（`com.xiaojukeji.esapi:ddes-open-sdk`）的版本变更。

格式参考 [Keep a Changelog](https://keepachangelog.com/zh-CN/)，版本号遵循 [语义化版本](https://semver.org/lang/zh-CN/)。

## [Unreleased]

### 💥 破坏性变更（Breaking Changes）

- **`rank.ListRankReply.records` 元素类型由 `RankInfo` 变更为新增的 `RankRecord`**（字段 `id`/`name`）。原实现复用写请求模型 `RankInfo`（序列化名 `rank_id`），导致文档响应字段 `id` 恒反序列化为 null——本次为缺陷修复；受影响字段原值本就为 null，不存在有效依赖。
- **`member.UpdateMemberApiReply.data` 类型由 `Object` 变更为新增的 `UpdateMemberReply`**（`member_id`/`phone`/`status`）。原先仅能以 raw Map 读取。

### 🛠 缺陷修复

- **`member.MemberInfo.residentsIds` 序列化名由 `redisents_ids` 修正为 `residents_ids`**（原拼写错误，服务端不识别该字段，员工常驻地 ID 从未生效；Java 字段名同步修正为 `residentsIds`）。

### 🚀 新增功能（接口对齐 2025–2026 文档批次）

- **legalentity**：`get` 请求新增 `outLegalEntityId`；`get` 响应 records 新增 `outParentId`；`add`/`edit` 请求新增 `outParentId`（2025.06.18 批次）。
- **member**：请求新增 `residentsAdcode`、`homeAddress`（single/edit 共用）；`single` 响应新增 `memberId`/`status`（员工已存在场景，2025.11.17）；`detail` 响应新增 `otherCompaniesList`（一人多企业，保守建模 `List<Object>`）；`getQuota` 请求新增 `monthlyLimitOnlyQuery`（2026.02 限额升级）；`del` 请求新增 `employeePhone`/`employeeEmail` 及 `__obj__` 便捷字段（2025.06.18）。
- **traveler**：`TravelerInfo` 新增 `type`（项目维度外部出行人，2026.06.23）。
- **regulation**：detail 响应新增 `CarRule`（`callType`/`useScene`）及 `regulationEmployeeName`/`regulationEmployeeDescription`。
- **集团账户「上级公司统一对接」参数**：18 个接口的请求模型新增 `belongEnterpriseName`/`taxpayerNo` 可选字段；4 个分页查询接口（legalentity/budgetcenter/member/regulation 的 get）新增 `querySubCompany` 请求参数及 legalentity/budgetcenter/member 响应 `nextToken`。
- **Sample**：7 个服务域示例类新增上述字段的用法示例。

### 📝 备注

- `/open-apis/v2/...` 集团账户备用路径本次未实现（路径保持主路径），如需支持另行立项。
- regulation get 集团场景响应 `next_token` 因文档未明确 data 结构（当前为数值）暂未建模，待文档澄清。

## [1.2.0] - 2026-08-03

### 💥 破坏性变更（Breaking Changes）

> 以下字段类型变更会导致对应 getter/setter 签名变化，**升级后需调整调用方代码**（如 `Long lastId = reply.getLastId()` 将编译失败）。本次对齐源于后端 API 实际返回结构变化——ID 类字段统一为字符串，避免大整数精度丢失。

**字段类型变更：**

| 所在 Model | Java 字段（API 字段名） | 旧类型 | 新类型 |
|---|---|---|---|
| `bill.BillListItemOfWangYC` | `isSensitive`（`is_sensitive`） | `BigDecimal` | `String` |
| `bill.GetBillDetailOfWangYCReply` | `lastId`（`last_id`） | `Long` | `String` |
| `member.DelMemberApiReply` | `data`（`data`） | `List<Long>` | `List<String>` |

**枚举值变更：**
- `budgetcenter.BudgetCycleEnum`：`YEAR` 的 code 由 `2` 修正为 `3`（原先与 `QUARTER` 重复为 `2`，属缺陷修复），并新增 `ONCE(4)`、`DAILY(5)`、`CUSTOM(6)`、`ORIGINAL_DEPT(7)` 四个枚举值。依赖 `BudgetCycleEnum.YEAR.getCode()` 的下游代码需关注。

### 🚀 新增功能
- **新增 `Project`（项目）服务模块**，对外暴露 4 个 API 方法（`client.project().v1()`）：
  - `getProjectDetail` — 查询项目下的人员关联信息（GET `/river/Project/detail`）
  - `outTravelerList` — 查询项目外部出行人列表（GET `/open-apis/v2/project/outTravelerList`）
  - `updateMember` — 绑定项目与人员关系（POST `/river/Project/updateMember`）
  - `delMember` — 删除项目与人员关系（POST `/river/Project/delMember`）
- **`Config` 为所有带默认值的字段补充 `@Builder.Default` 注解**（`baseUrl`、`signMethod`、`enableAES`、`enableHoldToken`、超时、重试次数等）—— 修复使用 Builder 构造 `Config` 时默认值丢失的隐患。

### 🔧 改进（纯新增字段，源码兼容）
- **`budgetcenter`（成本中心）**：`BudgetCenterRecord`、`CreateBudgetCenterRequest`、`UpdateBudgetCenterRequest`、`GetBudgetCenterRequest`、`DelBudgetCenterRequest` 等新增字段；新增 `ExtendFieldItem`、`LimitRuleItem`、`OutTravelerItem`、`PoiItem`、`RelatedEmployeeItem` 等 model。
- **`member`（员工）**：`GetMemberDetailReply`、`MemberRecord`、`ListMemberRequest/Reply` 新增字段；新增 `HomeAddressInfo`、`LimitRuleInfo`、`ResidentsListInfo` 等 model。

### 🐛 修复
- **`BaseService.setDecryptData`**：用 `Boolean.TRUE.equals(config.getEnableAES())` 替代直接布尔判定，避免 `enableAES` 未设置时的潜在空指针。
- **流量回放 bug 修复**。

### 🧪 测试
- 新增独立子模块 **`integration`**：真实脱敏流量回放验证引擎（43 个 URI 回放，仅 `integration` profile 激活时构建，与主模块 59 个 mock 测试完全隔离）。
- 新增 `Project`、`Member`、`BudgetCenter`、`City` 的 mock 测试。

### 📦 升级指引
- Maven 依赖：

```xml
<dependency>
  <groupId>com.xiaojukeji.esapi</groupId>
  <artifactId>ddes-open-sdk</artifactId>
  <version>1.2.0</version>
</dependency>
```

> ⚠️ 已知遗留问题（非本版本引入）：`README.md` 依赖示例的 GAV 仍为错误的历史值（`com.xiaoju.sdk:ddes-open-sdk:1.0.0`），请以上方正确 GAV 为准。
