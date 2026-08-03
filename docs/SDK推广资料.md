# 滴滴企业级开放接口 SDK（Java）推广资料

> 滴滴企业级（DDES）开放接口 Java SDK，提供 fluent API 供企业客户端一键调用滴滴企业级平台的 **18 个服务模块、90 个 API 方法**，覆盖用车、出行管理、审批、账单、员工、项目等企业出行管理全场景。
>
> - **官方文档**：https://opendocs.xiaojukeji.com/version2024
> - **最低 Java 版本**：JDK 1.8
> - **Maven 坐标**：`com.xiaojukeji.esapi:ddes-open-sdk:1.1.0`

本文档面向首次接入的开发者，包含三部分：**SDK 能力介绍**、**接入代码**、**代码示例**。如需快速参考，可对照仓库根目录的 [README.md](../README.md)；如需逐接口的可运行示例，可对照 [sample](../sample) 模块。

---

## 一、SDK 能力介绍

### 1.1 SDK 能力亮点

- **全场景覆盖**：18 个服务模块、90 个 API 方法，一站式打通企业出行管理的认证、组织、审批、订单、账单、制度等全链路。
- **Fluent API 链式调用**：统一三层结构 `ApiClient → Service → V1 → API方法`，调用语义清晰、可读性强。
- **自动 Token 管理**：默认 `LocalTokenHolder` 自动获取并缓存 Token（默认 30 分钟有效期），`errno=401` 失效时自动刷新并重试，业务代码无感知。
- **`__obj__` 便捷字段**：对 API 中的 `json-string` 类型字段，SDK 提供 `__obj__` 后缀的对象字段，开发者直接传对象，SDK 自动序列化为 JSON 字符串，免去手工拼装。
- **AES 加密自动处理**：开启 `enableAES` 后，SDK 自动加密请求体、解密响应 `encrypt_data`，支持 AES128 / AES256。
- **可扩展的 Token / HTTP 层**：`ITokenHolder` 与 `IHttpTransport` 均可自定义实现，适配 Redis 分布式 Token 缓存、免 Spring 依赖等场景。
- **签名机制内置**：参数字典序拼接 + `sign_key` 摘要，支持 MD5（默认）与 SHA256。

### 1.2 模块总览

| 服务模块 | 入口方法 | 业务域 | 方法数 | 典型场景 |
|---|---|---|---|---|
| auth | `client.auth()` | 认证鉴权 | 1 | 获取 access_token |
| login | `client.login()` | 单点登录 | 1 | 获取 SSO 加密字符串 |
| member | `client.member()` | 员工管理 | 6 | 员工增删改查、限额 |
| role | `client.role()` | 角色管理 | 1 | 角色查询 |
| rank | `client.rank()` | 职级管理 | 4 | 职级增删改查 |
| legalentity | `client.legalentity()` | 公司主体管理 | 4 | 法人主体增改停查 |
| budgetcenter | `client.budgetcenter()` | 部门/成本中心 | 4 | 部门或项目增改停查 |
| project | `client.project()` | 项目与人员关联 | 4 | 项目人员绑定/查询 |
| approval | `client.approval()` | 行前审批/差旅申请单 | 10 | 差旅/用车审批单创建改查 |
| afterapproval | `client.afterapproval()` | 行后审批/授权 | 2 | 行后个人付款单 |
| outapproval | `client.outapproval()` | 外部审批状态通知 | 1 | 审批单状态变更同步 |
| regulation | `client.regulation()` | 制度管理 | 2 | 制度列表/详情 |
| order | `client.order()` | 订单查询 | 9 | 用车/机票/酒店/火车票订单 |
| bill | `client.bill()` | 账单管理 | 26 | 已出/未出账单、调账、汇总 |
| city | `client.city()` | 城市查询 | 6 | 开城城市列表 |
| extend | `client.extend()` | 拓展信息/档案 | 3 | 拓展信息批量同步 |
| traveler | `client.traveler()` | 外部出行人管理 | 3 | 出行人增删改 |
| workplace | `client.workplace()` | 地点/职场管理 | 3 | 地点增删改 |

> 合计 **18 个服务模块、90 个 API 方法**。

### 1.3 全量方法清单

#### 认证与登录

**auth — 认证鉴权**

| 方法 | 用途 | HTTP 路径 | 请求类 | 响应类 |
|---|---|---|---|---|
| `authorize` | 授权认证，获取 access_token | `/river/Auth/authorize` | `AuthorizeRequest` | `AuthorizeApiReply` |

**login — 单点登录**

| 方法 | 用途 | HTTP 路径 | 请求类 | 响应类 |
|---|---|---|---|---|
| `getLoginEncryptStr` | 获取单点登录加密字符串 | `/river/Login/getLoginEncryptStr` | `GetLoginEncryptStrRequest` | `GetLoginEncryptStrApiReply` |

#### 组织与人员管理

**member — 员工管理**

| 方法 | 用途 | HTTP 路径 | 请求类 | 响应类 |
|---|---|---|---|---|
| `createMember` | 员工新增 | `/river/Member/single` | `CreateMemberRequest` | `CreateMemberApiReply` |
| `updateMember` | 员工修改 | `/river/Member/edit` | `UpdateMemberRequest` | `UpdateMemberApiReply` |
| `delMember` | 员工删除 | `/river/Member/del` | `DelMemberRequest` | `DelMemberApiReply` |
| `listMember` | 员工列表（批量查询） | `/river/Member/get` | `ListMemberRequest` | `ListMemberApiReply` |
| `getMemberDetail` | 员工明细查询 | `/river/Member/detail` | `GetMemberDetailRequest` | `GetMemberDetailApiReply` |
| `getMemberQuota` | 员工限额查询 | `/river/Member/getQuota` | `GetMemberQuotaRequest` | `GetMemberQuotaApiReply` |

**role — 角色管理**

| 方法 | 用途 | HTTP 路径 | 请求类 | 响应类 |
|---|---|---|---|---|
| `listRole` | 角色查询 | `/river/Role/get` | `ListRoleRequest` | `ListRoleApiReply` |

**rank — 职级管理**

| 方法 | 用途 | HTTP 路径 | 请求类 | 响应类 |
|---|---|---|---|---|
| `createRank` | 职级新增 | `/open-apis/v1/rank/create` | `CreateRankRequest` | `CreateRankApiReply` |
| `updateRank` | 职级修改 | `/open-apis/v1/rank/update` | `UpdateRankRequest` | `UpdateRankApiReply` |
| `delRank` | 职级删除 | `/open-apis/v1/rank/del` | `DelRankRequest` | `DelRankApiReply` |
| `listRank` | 职级查询 | `/river/Rank/getRanks` | `ListRankRequest` | `ListRankApiReply` |

**legalentity — 公司主体管理**

| 方法 | 用途 | HTTP 路径 | 请求类 | 响应类 |
|---|---|---|---|---|
| `createLegalEntity` | 公司主体新增 | `/river/LegalEntity/add` | `CreateLegalEntityRequest` | `CreateLegalEntityApiReply` |
| `updateLegalEntity` | 公司主体修改 | `/river/LegalEntity/edit` | `UpdateLegalEntityRequest` | `UpdateLegalEntityApiReply` |
| `delLegalEntity` | 公司主体停用 | `/river/LegalEntity/del` | `DelLegalEntityRequest` | `DelLegalEntityApiReply` |
| `getLegalEntity` | 公司主体查询 | `/river/LegalEntity/get` | `GetLegalEntityRequest` | `GetLegalEntityApiReply` |

**budgetcenter — 部门/项目管理（成本中心）**

| 方法 | 用途 | HTTP 路径 | 请求类 | 响应类 |
|---|---|---|---|---|
| `createBudgetCenter` | 部门或项目新增 | `/river/BudgetCenter/add` | `CreateBudgetCenterRequest` | `CreateBudgetCenterApiReply` |
| `updateBudgetCenter` | 部门或项目修改 | `/river/BudgetCenter/edit` | `UpdateBudgetCenterRequest` | `UpdateBudgetCenterApiReply` |
| `delBudgetCenter` | 部门或项目停用 | `/river/BudgetCenter/del` | `DelBudgetCenterRequest` | `DelBudgetCenterApiReply` |
| `getBudgetCenter` | 部门或项目查询 | `/river/BudgetCenter/get` | `GetBudgetCenterRequest` | `GetBudgetCenterApiReply` |

**project — 项目管理与人员关联**

| 方法 | 用途 | HTTP 路径 | 请求类 | 响应类 |
|---|---|---|---|---|
| `getProjectDetail` | 查询项目下的人员关联信息 | `/river/Project/detail` | `GetProjectDetailRequest` | `GetProjectDetailApiReply` |
| `outTravelerList` | 查询项目外部出行人列表 | `/open-apis/v2/project/outTravelerList` | `OutTravelerListRequest` | `OutTravelerListApiReply` |
| `updateMember` | 绑定项目与人员关系 | `/river/Project/updateMember` | `UpdateMemberRequest` | `UpdateMemberApiReply` |
| `delMember` | 删除项目与人员关系 | `/river/Project/delMember` | `DelMemberRequest` | `DelMemberApiReply` |

#### 审批

**approval — 行前审批/差旅申请单**

| 方法 | 用途 | HTTP 路径 | 请求类 | 响应类 |
|---|---|---|---|---|
| `createTravelApproval` | 创建差旅申请单 | `/river/Approval/create` | `CreateApprovalRequest` | `CreateApprovalApiReply` |
| `createBusinessByTimesApproval` | 创建行前审批-按次数申请单 | `/river/Approval/create` | `CreateApprovalBusinessByTimesRequest` | `CreateApprovalApiReply` |
| `createBusinessByDateApproval` | 创建行前审批-按日期申请单 | `/river/Approval/create` | `CreateApprovalBusinessByDateRequest` | `CreateApprovalApiReply` |
| `updateApproval` | 修改差旅申请单 | `/river/Approval/update` | `UpdateApprovalRequest` | `UpdateApprovalApiReply` |
| `updateBusinessByTimesApproval` | 修改用车按次数申请单 | `/river/Approval/update` | `UpdateApprovalBusinessByTimesRequest` | `UpdateApprovalApiReply` |
| `updateBusinessByDateApproval` | 修改用车按日期申请单 | `/river/Approval/update` | `UpdateApprovalBusinessByDateRequest` | `UpdateApprovalApiReply` |
| `cancelApproval` | 取消申请单 | `/river/Approval/cancel` | `CancelApprovalRequest` | `CancelApprovalApiReply` |
| `approvalPass` | 外部审批处理（个转企审批结果同步） | `/river/Approval/pass` | `ApprovalPassRequest` | `ApprovalPassApiReply` |
| `getApprovalDetail` | 申请单详情查询 | `/open-apis/v1/approval/detail` | `GetApprovalDetailRequest` | `GetApprovalDetailApiReply` |
| `listApprovalOrder` | 审批单查询关联用车订单 | `/river/Approval/getOrder` | `ListApprovalOrderRequest` | `ListApprovalOrderApiReply` |

**afterapproval — 行后审批/行后授权**

| 方法 | 用途 | HTTP 路径 | 请求类 | 响应类 |
|---|---|---|---|---|
| `createPersonalReceipt` | 行后审批结果同步（创建个人付款单） | `/river/AfterApproval/createPersonalReceipt` | `CreatePersonalReceiptRequest` | `CreatePersonalReceiptApiReply` |
| `getPersonalReceiptOrder` | 查询行后审批个人付款单 | `/river/AfterApproval/getPersonalReceiptOrder` | `GetPersonalReceiptOrderRequest` | `GetPersonalReceiptOrderApiReply` |

**outapproval — 外部审批状态通知**

| 方法 | 用途 | HTTP 路径 | 请求类 | 响应类 |
|---|---|---|---|---|
| `updateOutApprovalStatus` | 外部通知审批单状态变更 | `/river/OutApproval/Status` | `UpdateOutApprovalStatusRequest` | `UpdateOutApprovalStatusApiReply` |

**regulation — 制度管理**

| 方法 | 用途 | HTTP 路径 | 请求类 | 响应类 |
|---|---|---|---|---|
| `listRegulation` | 制度列表查询 | `/river/Regulation/get` | `ListRegulationRequest` | `ListRegulationApiReply` |
| `getRegulation` | 制度详情查询 | `/river/Regulation/detail` | `GetRegulationRequest` | `GetRegulationApiReply` |

#### 订单查询

**order — 订单查询**

| 方法 | 用途 | HTTP 路径 | 请求类 | 响应类 |
|---|---|---|---|---|
| `getOrder` | 用车订单列表查询 | `/river/Order/get` | `GetOrderRequest` | `GetOrderApiReply` |
| `getCarOrderDetail` | 用车订单详情查询 | `/river/Order/detail` | `GetCarOrderDetailRequest` | `GetCarOrderDetailApiReply` |
| `listOrder` | 订单号列表查询（机票/酒店/火车票/用车） | `/open-apis/v1/order/list` | `ListOrderRequest` | `ListOrderApiReply` |
| `getFlightOrderDetail` | 机票订单详情查询 | `/api-gateway/g/flight/orderDetail` | `GetFlightOrderDetailRequest` | `GetFlightOrderDetailApiReply` |
| `getFlightEstimatePrice` | 机票预估价查询（预算管理） | `/api-gateway/g/flight/info/estimatePrice` | `GetFlightEstimatePriceRequest` | `GetFlightEstimatePriceApiReply` |
| `getHotelOrderDetail` | 酒店订单详情查询 | `/api-gateway/g/hotel/orderDetail` | `GetHotelOrderDetailRequest` | `GetHotelOrderDetailApiReply` |
| `getTrainOrderDetail` | 火车票订单详情查询 | `/api-gateway/g/train/orderDetail` | `GetTrainOrderDetailRequest` | `GetTrainOrderDetailApiReply` |
| `listTrainLeftTicket` | 火车票直达余票列表查询 | `/api-gateway/train/queryLeftTicket` | `ListTrainLeftTicketRequest` | `ListTrainLeftTicketApiReply` |
| `listTransferTrainTicket` | 火车票中转车次列表查询 | `/api-gateway/g/train/transfer/queryLeftTicket` | `ListTransferTrainTicketRequest` | `ListTransferTrainTicketApiReply` |

#### 账单管理

**bill — 账单管理（26 个方法）**

账单查询按「账单列表 / 汇总 / 账单树 / 确认 / 调账 / 已出账单明细 / 未出账单明细 / 交易明细」组织：

| 方法 | 用途 | HTTP 路径 |
|---|---|---|
| `listBill` | 账单列表查询 | `/river/Bill/get` |
| `getBillSummary` | 账单汇总查询（商旅/网约车/出租车） | `/river/Bill/summary` |
| `getBillStructure` | 网约车/商旅账单树查询 | `/river/Bill/getBillStructure` |
| `billConfirm` | 商旅/网约车账单确认 | `/river/Bill/confirm` |
| `updateAdjustBillData` | 账单调整提交 | `/river/Bill/adjustBillData` |
| `getAdjustBillDataResult` | 调账查询结果 | `/river/Bill/queryAdjustBillDataResult` |

**已出账单明细**（请求类前缀 `GetBillDetailOf*Request`，响应类 `GetBillDetailOf*ApiReply`，路径均为 `/river/Bill/detail`）：

| 方法 | 业务类型 |
|---|---|
| `getBillDetailOfWangYC` | 网约车 |
| `getBillDetailOfDaiJia` | 代驾 |
| `getBillDetailOfTaxi` | 出租车 |
| `getBillDetailOfTrainTicket` | 火车票 |
| `getBillDetailOfDomesticFlight` | 国内机票 |
| `getBillDetailOfInterFlight` | 国际机票 |
| `getBillDetailOfDomesticHotel` | 国内酒店 |
| `getBillDetailOfInterHotel` | 海外酒店 |
| `getBillDetailOfManualOrder` | 增值手工单 |

**未出账单明细**（请求类前缀 `GetNotGenBillDetailOf*Request`，路径均为 `/river/Bill/getNotGeneratedBillDetail`）：

| 方法 | 业务类型 |
|---|---|
| `getNotGenBillDetailOfWangYC` | 网约车 |
| `getNotGenBillDetailOfDaiJia` | 代驾 |
| `getNotGenBillDetailOfTaxi` | 出租车 |
| `getNotGenBillDetailOfTrain` | 火车票 |
| `getNotGenBillDetailOfFlight` | 国内机票 |
| `getNotGenBillDetailOfInterFlight` | 国际机票 |
| `getNotGenBillDetailOfHotel` | 国内酒店 |
| `getNotGenBillDetailOfInterHotel` | 海外酒店 |
| `getNotGenBillDetailOfManualOrder` | 增值手工单 |

**交易明细**（路径均为 `/river/Bill/transactionDetail`）：

| 方法 | 业务类型 | 请求类 | 响应类 |
|---|---|---|---|
| `getTransactionBillDetail` | 网约车 | `GetTransactionBillDetailRequest` | `GetTransactionBillDetailApiReply` |
| `getTransactionBillDetailOfTaxi` | 出租车 | `GetTransactionBillDetailOfTaxiRequest` | `GetTransactionBillDetailOfTaxiApiReply` |

#### 城市与基础

**city — 城市查询**

| 方法 | 用途 | HTTP 路径 | 请求类 | 响应类 |
|---|---|---|---|---|
| `listCity` | 全量开城城市列表查询（推荐） | `/open-apis/v1/city/list` | `ListCityRequest` | `ListCityApiReply` |
| `listCarCity` | 用车城市查询（已废弃，推荐 `listCity`） | `/river/City/get` | `ListCarCityRequest` | `ListCarCityApiReply` |
| `listAirportCity` | 机票城市查询（已废弃，推荐 `listCity`） | `/river/DemeterAres/AirportCity/index` | `ListAirportCityRequest` | `ListAirportCityApiReply` |
| `listHotelCity` | 酒店城市查询（已废弃，推荐 `listCity`） | `/river/DemeterAres/HotelCity/index` | `ListHotelCityRequest` | `ListHotelCityApiReply` |
| `listTrainCity` | 火车票城市查询（已废弃，推荐 `listCity`） | `/river/DemeterAres/TrainCity` | `ListTrainCityRequest` | `ListTrainCityApiReply` |
| `listCountry` | 国家查询（已废弃） | `/river/DemeterAres/Country/index` | `ListCountryRequest` | `ListCountryApiReply` |

#### 拓展信息与外部出行人

**extend — 拓展信息/档案管理**

| 方法 | 用途 | HTTP 路径 | 请求类 | 响应类 |
|---|---|---|---|---|
| `createExtendBatch` | 拓展信息批量创建（含子档案） | `/river/ExtendInfo/BatchSync` | `CreateExtendBatchRequest` | `CreateExtendBatchApiReply` |
| `listExtend` | 拓展信息查询 | `/river/ExtendInfo/Get` | `ListExtendRequest` | `ListExtendApiReply` |
| `updateExtendStatus` | 档案状态处理（删除等） | `/river/ExtendInfo/Status` | `UpdateExtendStatusRequest` | `UpdateExtendStatusApiReply` |

**traveler — 外部出行人管理**

| 方法 | 用途 | HTTP 路径 | 请求类 | 响应类 |
|---|---|---|---|---|
| `createTraveler` | 外部出行人新增 | `/open-apis/v1/traveler/create` | `CreateTravelerRequest` | `CreateTravelerApiReply` |
| `updateTraveler` | 外部出行人修改 | `/open-apis/v1/traveler/update` | `UpdateTravelerRequest` | `UpdateTravelerApiReply` |
| `delTraveler` | 外部出行人删除 | `/open-apis/v1/traveler/del` | `DelTravelerRequest` | `DelTravelerApiReply` |

**workplace — 地点/职场管理**

| 方法 | 用途 | HTTP 路径 | 请求类 | 响应类 |
|---|---|---|---|---|
| `createWorkplace` | 地点新增 | `/open-apis/v1/workplace/create` | `CreateWorkplaceRequest` | `CreateWorkplaceApiReply` |
| `updateWorkplace` | 地点修改 | `/open-apis/v1/workplace/update` | `UpdateWorkplaceRequest` | `UpdateWorkplaceApiReply` |
| `deleteWorkplace` | 地点删除 | `/open-apis/v1/workplace/del` | `DeleteWorkplaceRequest` | `DeleteWorkplaceApiReply` |

### 1.4 汇总统计

| 模块 | 方法数 |
|---|---|
| auth | 1 |
| login | 1 |
| member | 6 |
| role | 1 |
| rank | 4 |
| legalentity | 4 |
| budgetcenter | 4 |
| project | 4 |
| approval | 10 |
| afterapproval | 2 |
| outapproval | 1 |
| regulation | 2 |
| order | 9 |
| bill | 26 |
| city | 6 |
| extend | 3 |
| traveler | 3 |
| workplace | 3 |
| **合计** | **90** |

---

## 二、接入代码

### 2.1 环境要求

- JDK 1.8 及以上
- Maven 3.x（推荐）

### 2.2 Maven 依赖

在 `pom.xml` 中引入 SDK：

```xml
<dependency>
  <groupId>com.xiaojukeji.esapi</groupId>
  <artifactId>ddes-open-sdk</artifactId>
  <version>1.1.0</version>
</dependency>
```

> **⚠️ 重点提醒：spring-web 依赖**
>
> SDK 将 `org.springframework:spring-web` 声明为 `provided` scope，即默认 HTTP 传输实现 `RestHttpTransport` 依赖 Spring `RestTemplate`，但不会随 SDK 传递。
>
> - **若使用默认 HTTP 传输**（即不自定义 `IHttpTransport`）：需在项目中额外引入 `spring-web`：
>   ```xml
>   <dependency>
>     <groupId>org.springframework</groupId>
>     <artifactId>spring-web</artifactId>
>     <version>5.2.12.RELEASE</version>
>   </dependency>
>   ```
> - **若自定义 `IHttpTransport`**（如使用内置的 `OkHttpTransport`）：可不必引入 `spring-web`，详见 [3.3 自定义 HTTP 传输](#33-自定义-http-传输)。

### 2.3 Config 配置项

`Config` 使用 Lombok `@Builder` 构建，所有字段均可通过 `Config.builder().字段名(值)` 设置：

| 字段名 | 类型 | 必填 | 默认值 | 说明 |
|---|---|---|---|---|
| `clientId` | `String` | 是 | — | 应用 ID |
| `clientSecret` | `String` | 是 | — | 应用密钥 |
| `signKey` | `String` | 是 | — | 签名 key |
| `baseUrl` | `String` | 否 | `https://api.es.xiaojukeji.com` | 接口请求基础 URL |
| `grantType` | `String` | 否 | `client_credentials` | OAuth 授权类型 |
| `unauthorizedRetryTimes` | `Integer` | 否 | `2` | Token 失效时请求重试次数 |
| `unauthorizedRetryInterval` | `Integer` | 否 | `1000` | Token 失效重试间隔（毫秒） |
| `httpTransport` | `IHttpTransport` | 否 | `null`（懒加载为 `RestHttpTransport`） | 自定义 HTTP 传输实现 |
| `connectTimeout` | `Long` | 否 | `3000` | 连接超时（毫秒） |
| `callTimeOut` | `Long` | 否 | `3000` | 调用超时（毫秒） |
| `timeoutUnit` | `TimeUnit` | 否 | `MILLISECONDS` | 超时时间单位 |
| `signMethod` | `SignMethodEnum` | 否 | `MD5` | 签名方法，可选 `MD5` / `SHA256` |
| `enableHoldToken` | `Boolean` | 否 | `true` | 是否开启自动获取并持有 Token |
| `enableRequestLog` | `Boolean` | 否 | `false` | 是否开启请求日志打印 |
| `logLevel` | `LogLevelEnum` | 否 | — | 日志级别，可选 `DEBUG` / `INFO`（需 `enableRequestLog=true`） |
| `enableAES` | `Boolean` | 否 | `false` | 是否开启 AES 整体加密 |
| `aesKey` | `String` | 条件必填 | — | AES 加密密钥（`enableAES=true` 时必填） |
| `encryptType` | `EncryptTypeEnum` | 否 | `NORMAL` | 加密类型：`NORMAL`(0,不加密) / `AES128`(1) / `AES256`(2) |

> `httpTransport` 懒加载逻辑：调用 `config.getHttpTransport()` 时若为 `null`，自动创建 `new RestHttpTransport(...)`。

### 2.4 ApiClient 初始化

`ApiClient` 提供两个构造器：

```java
// 方式一：使用默认 Token 管理（LocalTokenHolder，自动获取/缓存/刷新 Token）
ApiClient client = new ApiClient(config);

// 方式二：自定义 Token 持有者（如分布式 Redis 缓存）
ApiClient client = new ApiClient(config, customTokenHolder);
```

初始化后，通过 `client.服务名().v1().方法名(request)` 链式调用任意接口。

### 2.5 核心机制简述

**签名机制**（`SignUtils`）：

1. 将所有请求参数（含 `client_id`、`access_token`、`timestamp`）加上 `sign_key` 组装为 Map；
2. 按 key 字典序排序；
3. 拼接为 `key1=value1&key2=value2...` 格式字符串；
4. 对拼接字符串做摘要——`MD5`（默认，32 位小写 hex）或 `SHA256`。

签名方法由 `Config.signMethod` 控制，具体使用哪种需与滴滴对接人确认。

**Token 管理**（`LocalTokenHolder`）：

- 默认有效期 30 分钟，过期后自动通过 `client.auth().v1().authorize()` 重新获取；
- `getAccessToken()` / `generateAccessToken()` 使用 `synchronized` 保证并发安全；
- 当接口返回 `errno=401`（Token 失效）时，`BaseService` 自动刷新 Token 并重试，重试次数与间隔由 `unauthorizedRetryTimes` / `unauthorizedRetryInterval` 控制；
- 如需分布式 Token 共享（如多节点共用一个 Token），实现 `ITokenHolder` 接口后通过双参构造器注入。

**AES 整体加密**（`enableAES=true`）：

- 开启后须设置 `aesKey` 与 `encryptType`（`AES128` 或 `AES256`）；
- 请求时：SDK 将除 `client_id`、`access_token` 外的参数加密后放入 `encrypt_content` 字段，并设置 `ent` 标识加密类型，重新签名；
- 响应时：若响应包含 `encrypt_data` 字段，SDK 自动 AES 解密后反序列化为响应对象；
- 认证接口 `/river/Auth/authorize` 不走加密逻辑。

| 加密类型 | 密钥格式 | 算法 | 输出编码 |
|---|---|---|---|
| `AES128` | 16 字节 UTF-8 字符串 | AES-128-ECB / PKCS5Padding | Base64 |
| `AES256` | 64 字符十六进制字符串（32 字节） | AES-256-ECB / PKCS5Padding | URL-Safe Base64 |

---

## 三、代码示例

### 3.1 配置初始化

最基础的接入方式（来源：`LegalEntitySample`）：

```java
import com.xiaoju.open.sdk.didies.ApiClient;
import com.xiaoju.open.sdk.didies.core.Config;

Config config = Config.builder()
    .clientId("your_client_id")
    .clientSecret("your_client_secret")
    .signKey("your_sign_key")
    .build();

ApiClient client = new ApiClient(config);
```

进阶配置（SHA256 签名 + 自定义超时 + 请求日志 + AES 加密）：

```java
import com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum;
import com.xiaoju.open.sdk.didies.core.enums.EncryptTypeEnum;
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum;

Config config = Config.builder()
    .clientId("your_client_id")
    .clientSecret("your_client_secret")
    .signKey("your_sign_key")
    .signMethod(SignMethodEnum.SHA256)        // 使用 SHA256 签名
    .connectTimeout(5000L)                    // 连接超时 5s
    .callTimeOut(5000L)                       // 调用超时 5s
    .enableRequestLog(true)                   // 开启请求日志
    .logLevel(LogLevelEnum.DEBUG)             // DEBUG 级别
    .enableAES(true)                          // 开启整体加密
    .aesKey("your_aes_key")
    .encryptType(EncryptTypeEnum.AES128)      // AES128 加密
    .build();

ApiClient client = new ApiClient(config);
```

### 3.2 简单 GET 查询

以「公司主体查询」为例，展示完整的 Request 构建、调用与 Response 取数（来源：`LegalEntitySample.getLegalEntityTest`）：

```java
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.*;
import com.xiaoju.open.sdk.didies.utils.JacksonUtils;

GetLegalEntityRequest request = GetLegalEntityRequest.builder()
    .companyId("替换成自己的companyId")
    .legalEntityId("xxx")
    .build();

GetLegalEntityApiReply response = client.legalentity().v1().getLegalEntity(request);
if (response != null) {
    // 方式一：打印完整响应（调试用）
    System.out.println(JacksonUtils.toJson(response));

    // 方式二：取业务数据
    // response.getErrno()    // 0 表示成功
    // response.getErrmsg()   // 错误信息
    // response.getData()     // 业务数据对象
}
```

调用链 `client.legalentity().v1().getLegalEntity(request)` 是 SDK 的标准三层结构：

```
ApiClient  ──legalentity()──>  LegalEntity（Service）
                                     └──v1()──>  V1
                                                    └──getLegalEntity(request)──> 响应
```

### 3.3 进阶特性

#### 3.3.1 `__obj__` 便捷字段（POST 调用）

API 文档中部分字段类型为 `json-string`，手工拼接 JSON 字符串易错。SDK 提供 `__obj__` 后缀的对象字段：开发者直接传对象，SDK 在 `BaseService.resetObjToJson()` 中自动将其序列化为 JSON 字符串赋给原字段。

以「员工新增」为例（来源：`MemberSample.createMemberTest`），`data` 字段是 json-string，SDK 提供 `dataObj` 便捷字段：

```java
import com.xiaoju.open.sdk.didies.service.member.enums.MemberIdCardTypeEnum;
import com.xiaoju.open.sdk.didies.service.member.enums.MemberTypeEnum;
import com.xiaoju.open.sdk.didies.service.member.v1.model.*;
import com.xiaoju.open.sdk.didies.utils.AesUtils;
import com.xiaoju.open.sdk.didies.core.enums.EncryptTypeEnum;
import java.util.ArrayList;
import java.util.List;

// 身份证号需单独 AES 加密（注意：此 signKey 与 config 中的不同，需联系客服单独申请）
String signKey = "your_sign_key";
String encryptCardNo = AesUtils.encrypt("511xxxxxxxxxxxxxx4672", signKey, EncryptTypeEnum.AES128);
// 若接口已开启整体加密，则无需再单独加密此字段

List<CardInfo> cardList = new ArrayList<>();
cardList.add(CardInfo.builder()
    .cardType(MemberIdCardTypeEnum.ID_CARD.getCode().toString())
    .cardNo(encryptCardNo)
    .build());

CreateMemberRequest request = CreateMemberRequest.builder()
    .companyId("替换成自己的companyId")
    .dataObj(MemberInfo.builder()        // <-- __obj__ 便捷字段，SDK 自动序列化为 data
        .realname("自定义_")
        .email("xxxx@qq.com")
        .memberType(MemberTypeEnum.EMAIL.getCode())
        .cardList(cardList)
        .build())
    .build();

CreateMemberApiReply response = client.member().v1().createMember(request);
if (response != null) {
    System.out.println(JacksonUtils.toJson(response));
}
```

**`__obj__` 字段处理规则**（`BaseService.resetObjToJson`）：

1. 遍历所有字段，找到以 `__obj__` 结尾的字段；
2. 计算对应的原始 key（去掉 `__obj__` 后缀，如 `data__obj__` → `data`）；
3. **若原始字段已有非空值，则不覆盖**；
4. 否则将 `__obj__` 字段值通过 `JacksonUtils.toJson()` 序列化为 JSON 字符串，赋给原字段；
5. 从请求中移除 `__obj__` 后缀字段。

> 其他常见 `__obj__` 字段：`travelDetailObj`（差旅审批行程）、`passengerListObj`（乘机人列表）、`paramJsonObj`（订单查询参数）、`extraInfoObj`（附加信息）等。

#### 3.3.2 自定义 Token 持有者

分布式部署场景下，多个节点共享同一个 Token（如存 Redis），避免每节点独立获取。实现 `ITokenHolder` 接口后通过双参构造器注入：

```java
import com.xiaoju.open.sdk.didies.core.ITokenHolder;

public class RedisTokenHolder implements ITokenHolder {
    @Override
    public String getAccessToken() {
        // 从 Redis 读取；若不存在则调用 client.auth().v1().authorize() 获取并回写
        return "...";
    }

    @Override
    public boolean isExpired() {
        // 判断 Token 是否过期
        return false;
    }
}

// 注入自定义 Token 持有者
ApiClient client = new ApiClient(config, new RedisTokenHolder());
```

#### 3.3.3 自定义 HTTP 传输

若不想引入 Spring `RestTemplate`，可使用内置的 `OkHttpTransport`（基于 OkHttp 3.x），或实现 `IHttpTransport` 接口自定义：

```java
import com.xiaoju.open.sdk.didies.core.request.OkHttpTransport;

Config config = Config.builder()
    .clientId("your_client_id")
    .clientSecret("your_client_secret")
    .signKey("your_sign_key")
    .httpTransport(new OkHttpTransport())   // 使用 OkHttp，免 Spring 依赖
    .build();

ApiClient client = new ApiClient(config);
```

`IHttpTransport` 接口包含三个方法，可按需实现：

```java
public interface IHttpTransport {
    RawResponse get(Request request);          // GET，Content-Type: application/x-www-form-urlencoded
    RawResponse post(RawRequest request);      // POST JSON，Content-Type: application/json
    RawResponse post(FormRequest request);     // POST 表单，Content-Type: application/x-www-form-urlencoded
}
```

#### 3.3.4 AES 加密配置

开启整体加密后，SDK 自动加密请求体、解密响应，业务代码无需改动：

```java
Config config = Config.builder()
    .clientId("your_client_id")
    .clientSecret("your_client_secret")
    .signKey("your_sign_key")
    .enableAES(true)                         // 开启整体加密
    .aesKey("your_aes_key")                  // AES 密钥（enableAES=true 时必填）
    .encryptType(EncryptTypeEnum.AES128)     // AES128 或 AES256
    .build();
```

> 注意：对部分接口中的敏感字段（如员工身份证号），仍需通过 `AesUtils.encrypt(明文, signKey, EncryptTypeEnum.AES128)` 单独加密后传入；若接口已开启整体加密，则无需再单独加密。

---

## 更多资源

- **快速参考**：[README.md](../README.md)
- **逐接口可运行示例**：[sample](../sample) 模块（每个服务模块均有对应 `*Sample.java`）
- **官方接口文档**：https://opendocs.xiaojukeji.com/version2024
