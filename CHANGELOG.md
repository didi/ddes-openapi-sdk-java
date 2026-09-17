# 变更日志（Changelog）

本文件记录 `ddes-open-sdk`（`com.xiaojukeji.esapi:ddes-open-sdk`）的版本变更。

格式参考 [Keep a Changelog](https://keepachangelog.com/zh-CN/)，版本号遵循 [语义化版本](https://semver.org/lang/zh-CN/)。

## [1.3.0] - 2026-09-09

### 🚀 新增功能（接口对齐 2025–2026 文档批次）

- **legalentity**：`get` 请求新增 `outLegalEntityId`；`get` 响应 records 新增 `outParentId`；`add`/`edit` 请求新增 `outParentId`（2025.06.18 批次）。
- **member**：请求新增 `residentsAdcode`、`homeAddress`（single/edit 共用）；`single` 响应新增 `memberId`/`status`（员工已存在场景，2025.11.17）；`detail` 响应新增 `otherCompaniesList`（一人多企业，保守建模 `List<Object>`）；`getQuota` 请求新增 `monthlyLimitOnlyQuery`（2026.02 限额升级）；`del` 请求新增 `employeePhone`/`employeeEmail` 及 `__obj__` 便捷字段（2025.06.18）。
- **traveler**：`TravelerInfo` 新增 `type`（项目维度外部出行人，2026.06.23）。
- **regulation**：detail 响应新增 `CarRule`（`callType`/`useScene`）及 `regulationEmployeeName`/`regulationEmployeeDescription`。
- **集团账户「上级公司统一对接」参数**：为 19 个接口补齐 `belongEnterpriseName`/`taxpayerNo` 可选参数（budgetcenter add/edit/del、member get/detail、project 等在 1.2.0 已支持，本批不涉及）：legalentity add/edit/del 与 member single/edit/del 为 POST body 顶层字段；legalentity get、budgetcenter get、member getQuota、regulation get/list、role get、rank getRanks 为 GET query 参数；rank create/update/del 与 traveler create/update/del 随 `param_json` 内嵌提交，位于 `RankInfo`/`TravelerInfo`（param_json 形态接口服务端不读请求体顶层，与 Go SDK 契约对齐）。`query_sub_company`/`next_token` 属 `/open-apis/v2/...` 备用路径专属参数，主路径不生效，本次未提供（member get 请求侧既有字段保持不动）。
- **Sample**：7 个服务域示例类新增上述字段的用法示例。

### 🚀 新增功能（集团账户专用路径）

- **新增 4 个集团账户查询方法**（【上级公司统一对接】备用路径 `/open-apis/v2/...`）：
  - `legalentity.v1.getLegalEntityV2` → `/open-apis/v2/legalEntity/get`
  - `budgetcenter.v1.getBudgetCenterV2` → `/open-apis/v2/budgetCenter/get`
  - `member.v1.listMemberV2` → `/open-apis/v2/member/get`
  - `regulation.v1.listRegulationV2` → `/open-apis/v2/regulation/get`
- 响应为统一信封（`records`/`nextToken`/`companyTotal`/`companyListHasChange`/`progress`，后三者为实测补充字段、文档暂未声明）；各域集团 Record 独立建模（legalentity 集团返回 `legal_entity_id` 为字符串）。
- **注意**：`query_sub_company` 服务端按整数解析，请传 `"1"/"0"`（文档标注 boolean 有误，传 `"true"` 会报错）。
- **废弃标记**：`member.ListMemberRequest.querySubCompany`/`nextToken` 标注 `@Deprecated`（主路径不生效），集团场景请迁移至 `listMemberV2`。

### 🚀 新增功能（对齐 Go SDK 097910a 基线）

- **budgetcenter**：V2 get 请求（`GetBudgetCenterV2Request`）新增 `isNeedLimitRule`（与 v1 get 同名同型，真机验证参数透传至下游 zeus 服务）；`BudgetCenterV2Record` 新增 `companyId`（`company_id`，服务端 IDL 佐证，真机实测集团 records 均返回该字段且为字符串）。
- **member**：V2 get 请求（`ListMemberV2Request`）新增 `email`/`employeeNumber`/`phone`/`status` 过滤字段（与 v1 get 同名同型；文档未声明 v2 支持，真机实测 email/employee_number/status 过滤均生效）；`GetMemberDetailReply` 新增 `belongEnterpriseName`（一人多企业场景，主对象与 `otherCompaniesList` 元素均携带；非该场景缺失时为 null）。
- **V2 分页口径**：4 个 V2 请求采用游标分页（`length` + `next_token`），不设 `offset`，真机复验通过（不带 offset 返回 errno=0，此前「必填」实测结论过时）；member V2 真机实测 `regulation_id` 确以数组返回（佐证 `List<String>` 建模正确）；regulation V2 真机实测响应为嵌套信封（data 为对象），现行建模正确。
- **有意保留、不跟随 Go 的差异**：v1 get 集团参数（`belongEnterpriseName`/`taxpayerNo`，以文档为更高基准）；`ResidentsListInfo.id` 维持 `Long`（1.2.0 已发布存量字段，避免真实破坏性更新；97000 条真实流量回放验证数字形态零失败）；member getQuota 金额字段维持 `BigDecimal`（优于 Go 的 float32）；`GetMemberDetailReply.otherCompaniesList` 维持 `List<Object>` 保守建模；`monthlyLimitOnlyQuery` 维持 `String`。

### 📝 备注

- 集团账户备用路径已随 1.3.0 落地（见上方"集团账户专用路径"）；信封中 `company_total`/`company_list_has_change`/`progress` 为实测补充字段，官方语义待文档补全。
- Go SDK 已于 2026-09-14（`097910a`）完成 V2 集团接口参数口径收敛与字段审计，Java 侧本次对齐以该版本为基准；Go 侧遗留缺口（v1 get 缺集团参数、core 加密与 `__obj__` 替换顺序缺陷）不在 Java 仓库范围，已反馈 Go 侧跟进。

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
