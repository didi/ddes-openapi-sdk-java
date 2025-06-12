# 滴滴企业级开放接口SDK[`Java版本`]

## 概述

---

- 滴滴企业级开发接口SDK，便捷调用开放平台API,目前包括以下服务：
    - 接口认证[auth]
    - 审批 [行前(approval)、行后(afterapproval)、外部(outapproval)]
    - 账单 [bill]
    - 成本中心 [budgetcenter]
    - 城市信息 [city]
    - 扩展信息 [extend]
    - 公司主体 [legalentity]
    - 单点登录 [login]
    - 用户信息 [member]
    - 订单 [order]
    - 职级 [rank]
    - 制度 [regulation]
    - 角色 [role]
    - 外部人员 [traveler]
    - 工作地点 [workplace]
      具体可以访问 [管理API对接文档（2024版）](https://opendocs.xiaojukeji.com/version2024) 查看。

## 运行环境

---

- JDK 1.8

## 安装方法

---

### 1、Maven 仓库

```xml

<dependency>
  <groupId>com.xiaojukeji.esapi</groupId>
  <artifactId>ddes-open-sdk</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### 2、手动下载

- 1、下载最新的源码
- 2、使用Maven命令打包：`mvn clean install`
- 3、将生成的jar包引入到项目中

---

## 快速使用

### 流程概述

调用API的流程如下：

1. 创建应用
2. 获取访问凭证
3. 设置IP白名单 [前3步参考：[接入前必读](https://opendocs.xiaojukeji.com/version2024/10957)]
4. 调用API

---

### SDK配置参数说明(`com.xiaoju.open.sdk.didies.core.Config`)

| 配置项                         | 配置方式                                   | 描述                                                       |
|-----------------------------|----------------------------------------|----------------------------------------------------------|
| `clientId`                  | 必填                                     | 客户端 ID，用于身份认证。                                           |
| `clientSecret`              | 必填                                     | 客户端密钥，用于身份认证。                                            |
| `signKey`                   | 必填                                     | 签名密钥，用于请求签名。                                             |
| `baseUrl`                   | 可选，默认值：`https://api.es.xiaojukeji.com` | 接口请求的基础 URL。                                             |
| `grantType`                 | 可选，默认值：`client_credentials`            | OAuth 认证的授权类型，默认使用客户端凭证模式。                               |
| `unauthorizedRetryTimes`    | 可选，默认值：`2`                             | 因 Token 失效导致接口请求失败时的重试次数。                                |
| `unauthorizedRetryInterval` | 可选，默认值：`1000`（毫秒）                      | Token 失效重试的时间间隔，默认1秒。                                    |
| `httpTransport`             | 可选，默认自动创建 `RestHttpTransport` 实例       | 自定义 HTTP 请求实现类，需实现 `IHttpTransport` 接口。未设置时使用默认实现。       |
| `signMethod`                | 可选，默认值：`MD5`                           | 签名方法，可选枚举值（如 `MD5`、`SHA256`，默认MD5）。                      |
| `enableHoldToken`           | 可选，默认值：`true`                          | 是否开启自动获取并持有 Token（如未开启，需用自己管理token在每个接口中设置，推荐开启）。        |
| `enableRequestLog`          | 可选                                     | 是否开启请求日志打印。需配合 `logLevel` 使用。                            |
| `logLevel`                  | 可选                                     | 请求日志的打印级别（需开启 `enableRequestLog`），可选枚举如 `DEBUG`、`INFO` 。 |
| `enableAES`                 | 可选，默认值：`false`                         | 是否启用 AES 加密（此加密为整体加密，开启整体加密时人员信息不需要额外加密）。                |
| `aesKey`                    | 条件必填（当 `enableAES` 为 `true` 时需设置）      | AES 加密使用的密钥。                                             |
| `encryptType`               | 可选，默认值：`NORMAL`                        | 加密类型。默认不加密（`NORMAL`），启用 AES 时可选择 `AES128` 或 `AES256` 。   |
| `connectTimeout`            | 可选，默认值：`3000`（毫秒）                      | 网络连接超时时间（单位由 `timeoutUnit` 决定）。                          |
| `callTimeOut`               | 可选，默认值：`3000`（毫秒）                      | 接口调用超时时间（单位由 `timeoutUnit` 决定）。                          |
| `timeoutUnit`               | 可选，默认值：`MILLISECONDS`                  | 超时时间单位（如 `MILLISECONDS`、`SECONDS` 等）。                    |

--- 
说明：

1. 必填项：`clientId`、`clientSecret`、`signKey` 必须通过代码手动设置（如 `setClientId("your-id")`）。
2. 条件必填：`aesKey` 仅在启用 AES 加密（`enableAES=true`）时需设置。
3. 默认行为：  
   • `httpTransport` 未设置时，自动使用 `RestHttpTransport` 实现类。

   • 接口整体加密默认关闭（`enableAES=false`），签名方法默认使用 `MD5`。

4. 超时配置：`connectTimeout` 和 `callTimeOut` 的单位由 `timeoutUnit` 统一控制，默认毫秒。
5. 依赖关系：  
   • `logLevel` 仅在 `enableRequestLog=true` 时生效。

   • `encryptType` 的具体值需根据 `EncryptTypeEnum` 枚举定义选择（如 `NORMAL` 表示不加密）。

--- 

### 使用示例

1、以查询公司主体为例,更多示例请参考：`sample`module

```java

public class Test {

  public static void main(String[] args) {
    Config config = new Config()
        .setClientId("your_client_id")
        .setClientSecret("your_client_secret")
        .setSignKey("your_sign_key")
        .signMethod(SignMethodEnum.MD5) // 默认使用MD5签名，可选SHA256签名，具体和对接人确认
        .build();

    ApiClient client = new ApiClient(config);
    getLegalEntityTest(client);
  }

  /**
   * 公司主体查询
   * <p>
   * 说明： * 查询公司在滴滴侧的具体信息; * 通过获取的信息用于确认相关的配置信息，可以用于同步滴滴ES后台的信息; * 只返回有效的公司信息。不包含禁用和过期的公司主体信息。需要返回全部的，是不是需要重新封接口。
   */
  public static void getLegalEntityTest(ApiClient client) throws Exception {
    GetLegalEntityRequest request = GetLegalEntityRequest.builder()
        .companyId("替换成自己的companyId")
        .legalEntityId("xxx")
        .build();

    GetLegalEntityApiReply response = client.legalentity().v1().getLegalEntity(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }
}
```

2、使用整体加密

```java

public class EncryptTest {

  public static void main(String[] args) {
    Config config = new Config()
        .setClientId("your_client_id")
        .setClientSecret("your_client_secret")
        .setSignKey("your_sign_key")
        .setEnableAES(true) // 启用整体加密[默认为false]
        .setAesKey("your_aes_key") // 设置AES密钥[enableAES为false的时候，该值无效]
        .setEncryptType(EncryptTypeEnum.AES128); // 设置加密方式[enableAES为false的时候，该值无效]

    ApiClient client = new ApiClient(config);
    // 接口的调用不需要任何额外的操作，SDK会自动处理加密和解密
    getLegalEntityTest(client);
  }

  /**
   * 公司主体查询
   * <p>
   * 说明： * 查询公司在滴滴侧的具体信息; * 通过获取的信息用于确认相关的配置信息，可以用于同步滴滴ES后台的信息; * 只返回有效的公司信息。不包含禁用和过期的公司主体信息。需要返回全部的，是不是需要重新封接口。
   */
  public static void getLegalEntityTest(ApiClient client) throws Exception {
    GetLegalEntityRequest request = GetLegalEntityRequest.builder()
        .companyId("替换成自己的companyId")
        .legalEntityId("xxx")
        .build();

    GetLegalEntityApiReply response = client.legalentity().v1().getLegalEntity(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }
}
```

3、更多示例

| 示例模块   | 示例代码路径                          | 包含接口                 | 接口地址                                          |
|--------|---------------------------------|----------------------|-----------------------------------------------|
| 接口认证   | sample/AuthSample.java          | 接口认证(获取access_token) | /river/Auth/authorize                         |
| 行后授权   | sample/AfterapprovalSample.java | 行后审批结果同步             | /river/AfterApproval/createPersonalReceipt    |
|        |                                 | 行后审批完订单查询个人付款单       | /river/AfterApproval/getPersonalReceiptOrder  |
| 审批对接   | sample/ApprovalSample.java      | 创建申请单(已按业务拆分)        | /river/Approval/create                        |
|        |                                 | 修改申请单(已按业务拆分)        | /river/Approval/update                        |
|        |                                 | 取消申请单                | /river/Approval/cancel                        |
|        |                                 | 查询审批单列表              | /river/Approval/getOrder                      |
|        |                                 | 查询申请单详情              | /open-apis/v1/approval/detail                 |
|        |                                 | 外部审批处理               | /river/Approval/pass                          |
| 外部审批处理 | sample/OutapprovalSample.java   | 外部通知审批单状态变更          | /river/OutApproval/Status                     |
| 财税信息   | sample/BillSample.java          | 账单列表                 | /river/Bill/get                               |
|        |                                 | 已出账单(已按业务类型拆分)       | /river/Bill/detail                            |
|        |                                 | 未出账单(已按业务类型拆分)       | /river/Bill/getNotGeneratedBillDetail         |
|        |                                 | 网约车，出租车交易明细          | /river/Bill/transactionDetail                 |
|        |                                 | 账单汇总查询-商旅、网约车、出租车    | /river/Bill/summary                           |
|        |                                 | 网约车、商旅账单树查询          | /river/Bill/getBillStructure                  |
|        |                                 | 商旅、网约车账单确认           | /river/Bill/confirm                           |
|        |                                 | 调账提交                 | /river/Bill/adjustBillData                    |
|        |                                 | 调账结果查询               | /river/Bill/queryAdjustBillDataResult         |
| 部门或项目  | sample/BudgetcenterSample.java  | 部门或项目查询              | /river/BudgetCenter/get                       |
|        |                                 | 部门或项目新增              | /river/BudgetCenter/add                       |
|        |                                 | 部门或项目修改              | /river/BudgetCenter/edit                      |
|        |                                 | 部门或项目停用              | /river/BudgetCenter/del                       |
| 城市     | sample/CitySample.java          | 国家查询(全量获取国际ID)       | /river/DemeterAres/Country/index              |
|        |                                 | 全量开城城市列表查询           | /open-apis/v1/city/list                       |
| 地点     | sample/WorkspaceSample.java     | 地点新增                 | /open-apis/v1/workplace/create                |
|        |                                 | 地点删除                 | /open-apis/v1/workplace/del                   |
|        |                                 | 地点修改                 | /open-apis/v1/workplace/update                |
| 外部出行人  | sample/TravelerSample.java      | 外部出行人新增              | /open-apis/v1/traveler/create                 |
|        |                                 | 外部出行人修改              | /open-apis/v1/traveler/update                 |
|        |                                 | 外部出行人删除              | /open-apis/v1/traveler/del                    |
| 角色     | sample/RoleSample.java          | 角色查询                 | /river/Role/get                               |
| 制度     | sample/RegulationSample.java    | 制度列表                 | /river/Regulation/get                         |
|        |                                 | 制度详情                 | /river/Regulation/detail                      |
| 职级     | sample/RankSample.java          | 职级新增                 | /open-apis/v1/rank/create                     |
|        |                                 | 职级更新                 | /open-apis/v1/rank/update                     |
|        |                                 | 职级删除                 | /open-apis/v1/rank/del                        |
|        |                                 | 职级查询                 | /river/Rank/getRanks                          |
| 订单     | sample/OrderSample.java         | 订单号列表查询              | /open-apis/v1/order/list                      |
|        |                                 | 机票订单详情查询             | /api-gateway/g/flight/orderDetail             |
|        |                                 | 酒店订单详情查询             | /api-gateway/g/hotel/orderDetail              |
|        |                                 | 火车票订单详情查询            | /api-gateway/g/train/orderDetail              |
|        |                                 | 用车订单详情查询             | /river/Order/detail                           |
|        |                                 | 用车列表                 | /river/Order/get                              |
|        |                                 | 机票预估价获取              | /api-gateway/g/flight/info/estimatePrice      |
|        |                                 | 火车票直达列表              | /api-gateway/train/queryLeftTicket            |
|        |                                 | 火车票中转车次列表            | /api-gateway/g/train/transfer/queryLeftTicket |
| 用户     | sample/MemberSample.java        | 用户查询~员工列表（批量查询）      | /river/Member/get                             |
|        |                                 | 用户查询~员工明细            | /river/Member/detail                          |
|        |                                 | 员工限额查询               | /river/Member/getQuota                        |
|        |                                 | 用户新增                 | /river/Member/single                          |
|        |                                 | 用户修改                 | /river/Member/edit                            |
|        |                                 | 用户删除                 | /river/Member/del                             |
| 单点页面   | sample/LoginSample.java         | 单点请求                 | /river/Login/getLoginEncryptStr               |
| 公司主体   | sample/LegalentitySample.java   | 公司主体查询               | /river/LegalEntity/get                        |
|        |                                 | 公司主体新增               | /river/LegalEntity/add                        |
|        |                                 | 公司主体修改               | /river/LegalEntity/edit                       |
|        |                                 | 公司主体停用               | /river/LegalEntity/del                        |
| 拓展     | sample/ExtendSample.java        | 拓展信息批量创建             | /river/ExtendInfo/BatchSync                   |
|        |                                 | 档案状态处理               | /river/ExtendInfo/Status                      |
|        |                                 | 拓展信息查询               | /river/ExtendInfo/Get                         |

---
`📢注意`： 请替换代码中的`clientId`、`clientSecret`和`signKey`为实际的值，以及替换实际入参中的`companyId`

---

## 特殊说明

1、接口中以obj结尾的字段均为SDK特有字段，在文档中无Obj结尾，文档中为字段类型为json-string，SDK中可直接使用对象，SDK自动完成对象转为json-string的过程。

如（仅保留了特殊处理的Obj字段及源字段信息）：

```java
public class CreateApprovalRequest extends BaseReq {
  /**
   * 扩展信息，扩展信息，自定义字段；最长不大于 500 字符；(必须为json字符串)；默认为空字符
   */
  @JsonProperty("extra_info")
  private String extraInfo;
  /**
   * 扩展信息。转成json赋值给extra_info字段
   */
  @JsonProperty("extra_info__obj__")
  private Map<String, String> extraInfoObj;
  /**
   * 扩展信息list，自定义字段，最长不大于 500 字符，将extend_field_list转为 json 字符串，三个字段仅作为备注性字段。详见extend_field_list
   */
  @JsonProperty("extend_field_list")
  private String extendFieldList;
  /**
   * extendFieldListObj
   */
  @JsonProperty("extend_field_list__obj__")
  private ExtendFieldList extendFieldListObj;

  /**
   * 差旅单行程信息，差旅单行程信息，将travel_detail的值转为 json 字符串，approval_type &#x3D; 1 时必传。
   */
  @JsonProperty("travel_detail")
  private String travelDetail;
  /**
   * travelDetailObj
   */
  @JsonProperty("travel_detail__obj__")
  private TravelDetail travelDetailObj;
  /**
   * 差旅预算总额，差旅预算控制，一个申请单对应一个总预算纬度，一次只能全部或者选择部分品类。
   */
  @JsonProperty("travel_budget")
  private String travelBudget;
  /**
   * travelBudgetObj
   */
  @JsonProperty("travel_budget__obj__")
  private TravelBudget travelBudgetObj;
  /**
   * 差旅管控，差旅管控，目前仅支持市内用车每日限额设置（为json字符串类型，具体看请求示例）
   */
  @JsonProperty("travel_management")
  private String travelManagement;
  /**
   * travelManagementObj
   */
  @JsonProperty("travel_management__obj__")
  private TravelManagement travelManagementObj;
  /**
   * 出行人信息，出行人信息，不传时默认出行人为申请人，将passenger_list 转为 json 数组字符串。详见passenger_list
   */
  @JsonProperty("passenger_list")
  private String passengerList;
  /**
   * 出行人信息,可使用脚本将其转换为json后赋值给 passenger_list 字段
   */
  @JsonProperty("passenger_list__obj__")
  private List<TripPassenger> passengerListObj;
  /**
   * 多成本中心(array)，序号1对应远成本中心字段，依然支持滴滴内部主键ID。使用部门CODE主键，和项目时名称和code作为主键。
   */
  @JsonProperty("budget_center_list")
  private String budgetCenterList;
  /**
   * 差旅预算总额,可使用脚本将其转换为json后赋值给 budget_center_list 字段
   */
  @JsonProperty("budget_center_list__obj__")
  private List<BudgetCenterListItem> budgetCenterListObj;
}

```

> 上述实体在使用时，可直接通过已Obj结尾的属性赋值，实际传调用接口时，SDK会自动将Obj结尾的属性转为json字符串，赋值给原属性传递给滴滴企业级。

