package com.xiaoju.open.sdk.ddes.login;

import com.xiaoju.open.sdk.didies.ApiClient;
import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.service.login.enums.LoginTypeEnum;
import com.xiaoju.open.sdk.didies.service.login.v1.model.GetLoginEncryptStrApiReply;
import com.xiaoju.open.sdk.didies.service.login.v1.model.GetLoginEncryptStrRequest;
import com.xiaoju.open.sdk.didies.utils.JacksonUtils;

public class LoginSample {


  public static void main(String[] args) throws Exception {
    Config config = new Config()
        .setClientId("your_client_id")
        .setClientSecret("your_client_secret")
        .setSignKey("your_sign_key");

    ApiClient client = new ApiClient(config);

    // 单点请求
    GetLoginEncryptStrRequest request = GetLoginEncryptStrRequest.builder()
        .companyId("替换成自己的companyId")
        .phone("00016218408")
        .appType(String.valueOf(LoginTypeEnum.H5.getCode()))
        .build();
    GetLoginEncryptStrApiReply response = client.login().v1().getLoginEncryptStr(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }
}
