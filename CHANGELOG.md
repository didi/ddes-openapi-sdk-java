# 变更日志（Changelog）

本文件记录 `ddes-open-sdk`（`com.xiaojukeji.esapi:ddes-open-sdk`）的版本变更。

格式参考 [Keep a Changelog](https://keepachangelog.com/zh-CN/)，版本号遵循 [语义化版本](https://semver.org/lang/zh-CN/)。

## [1.2.0] - 2026-08-03

### 💥 破坏性变更（Breaking Changes）

> 以下字段类型变更会导致对应 getter/setter 签名变化，**升级后需调整调用方代码**（如 `Long lastId = reply.getLastId()` 将编译失败）。本次对齐源于后端 API 实际返回结构变化——ID 类字段统一为字符串，避免大整数精度丢失。

**字段类型变更：**

| 所在 Model | Java 字段（API 字段名） | 旧类型 | 新类型 |
|---|---|---|---|
| `bill.BillListItemOfWangYC` | `isSensitive`（`is_sensitive`） | `BigDecimal` | `String` |
| `bill.GetBillDetailOfWangYCReply` | `lastId`（`last_id`） | `Long` | `String` |
| `city.ListAirportCityReply` | `cityId`（`city_id`） | `Integer` | `String` |
| `city.ListAirportCityReply` | `countryId`（`country_id`） | `Integer` | `String` |
| `city.ListCountryReply` | `countryId`（`country_id`） | `Integer` | `String` |
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
