# 滴滴企业级开放接口SDK

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

- JDK 1.8及以上

## 安装方法

---

### Maven 仓库

```xml
<dependency>
  <groupId>com.xiaoju.sdk</groupId>
  <artifactId>ddes-openapi-sdk-java</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

## 快速使用

### 流程概述

调用API的流程如下：
1. 创建应用
2. 获取访问凭证
3. 设置IP白名单 [前3步参考：[接入前必读](https://opendocs.xiaojukeji.com/version2024/10957)]
4. 调用API 

### 使用示例 [以查询公司主体为例]
```java

import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.GetLegalEntityApiReply;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.GetLegalEntityRequest;

public class test {

  public static void main(String[] args) throws Exception {
    // 1. 构建配置对象
    Config config = new Config();
    config.setClientId("替换成自己的clientId");
    config.setClientSecret("替换成自己的clientSecret");
    config.setSignKey("替换成自己的signKey");
    // 2. 构建客户端对象
    ApiClient client = new ApiClient(config);
    // 3. 构建请求对象
    GetLegalEntityRequest request = new GetLegalEntityRequest();
    request.setCompanyId("替换成自己的companyId");
    request.setLength(1);
    request.setOffset(0);
    // 4. 调用接口
    GetLegalEntityApiReply legalEntity = client.legalentity().v1().getLegalEntity(request);
    // 5. 处理响应
    System.out.println(legalEntity);
  }
}
```

> 注意：
1. 请替换代码中的`clientId`、`clientSecret`和`signKey`为实际的值，以及替换实际入参中的`companyId`
2. 所有用例代码均在`test`包下
3. 使用用例代码使用的是groovy编写，不需要额外安装环境，安装完依赖之后直接运行就行

## SDK配置参数说明[`com.xiaoju.open.sdk.didies.core.Config`]

| 配置项                     | 配置方式                                                                 | 描述                                                           |
|---------------------------|--------------------------------------------------------------------------|--------------------------------------------------------------|
| `clientId`                | 必填                                                                | 客户端 ID，用于身份认证。                                               |
| `clientSecret`            | 必填                                                                | 客户端密钥，用于身份认证。                                                |
| `signKey`                 | 必填                                                                | 签名密钥，用于请求签名。                                                 |
| `baseUrl`                 | 可选，默认值：`https://api.es.xiaojukeji.com`                           | 接口请求的基础 URL。                                                 |
| `grantType`               | 可选，默认值：`client_credentials`                                     | OAuth 认证的授权类型，默认使用客户端凭证模式。                                   |
| `unauthorizedRetryTimes`  | 可选，默认值：`2`                                                       | 因 Token 失效导致接口请求失败时的重试次数。                                    |
| `unauthorizedRetryInterval` | 可选，默认值：`1000`（毫秒）                                           | Token 失效重试的时间间隔，默认1秒。                                        |
| `httpTransport`           | 可选，默认自动创建 `RestHttpTransport` 实例                             | 自定义 HTTP 请求实现类，需实现 `IHttpTransport` 接口。未设置时使用默认实现。           |
| `signMethod`              | 可选，默认值：`MD5`                                                     | 签名方法，可选枚举值（如 `MD5`、`SHA256`，默认MD5）。                          |
| `enableHoldToken`         | 可选，默认值：`true`                                                    | 是否开启自动获取并持有 Token（如未开启，需用自己管理token在每个接口中设置，推荐开启）。            |
| `enableRequestLog`        | 可选                                                                     | 是否开启请求日志打印。需配合 `logLevel` 使用。                                |
| `logLevel`                | 可选                                                                     | 请求日志的打印级别（需开启 `enableRequestLog`），可选枚举如 `DEBUG`、`INFO` 。     |
| `enableAES`               | 可选，默认值：`false`                                                   | 是否启用 AES 加密（此加密为整体加密，开启整体加密时人员信息不需要额外加密）。                    |
| `aesKey`                  | 条件必填（当 `enableAES` 为 `true` 时需设置）                           | AES 加密使用的密钥。                                                 |
| `encryptType`             | 可选，默认值：`NORMAL`                                                  | 加密类型。默认不加密（`NORMAL`），启用 AES 时可选择 `AES128` 或 `AES256` 。 |
| `connectTimeout`          | 可选，默认值：`3000`（毫秒）                                            | 网络连接超时时间（单位由 `timeoutUnit` 决定）。                              |
| `callTimeOut`             | 可选，默认值：`3000`（毫秒）                                            | 接口调用超时时间（单位由 `timeoutUnit` 决定）。                              |
| `timeoutUnit`             | 可选，默认值：`MILLISECONDS`                                            | 超时时间单位（如 `MILLISECONDS`、`SECONDS` 等）。                        |

说明：
1. 必填项：`clientId`、`clientSecret`、`signKey` 必须通过代码手动设置（如 `setClientId("your-id")`）。
2. 条件必填：`aesKey` 仅在启用 AES 加密（`enableAES=true`）时需设置。
3. 默认行为：  
   • `httpTransport` 未设置时，自动使用 `RestHttpTransport` 实现类。

   • 加密默认关闭（`enableAES=false`），签名方法默认使用 `MD5`。

4. 超时配置：`connectTimeout` 和 `callTimeOut` 的单位由 `timeoutUnit` 统一控制，默认毫秒。
5. 依赖关系：  
   • `logLevel` 仅在 `enableRequestLog=true` 时生效。

   • `encryptType` 的具体值需根据 `EncryptTypeEnum` 枚举定义选择（如 `NORMAL` 表示不加密）。
