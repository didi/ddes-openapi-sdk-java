package com.xiaoju.open.sdk.ddes.afterapproval;


import com.xiaoju.open.sdk.didies.ApiClient;
import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.GetPersonalReceiptOrderApiReply;
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.GetPersonalReceiptOrderRequest;
import com.xiaoju.open.sdk.didies.utils.JacksonUtils;

public class AfterApprovalSample {

  public static void main(String[] args) throws Exception {

    // 请替换为实际的appKey和appSecret
    Config config = Config.builder()
        .clientId("your_client_id")
        .clientSecret("your_client_secret")
        .signKey("your_sign_key")
        .build();

    ApiClient client = new ApiClient(config);
    GetPersonalReceiptOrderRequest authorizeRequest = GetPersonalReceiptOrderRequest.builder()
        .phone("")
        .length("10")
        .offset("0")
        .build();
    GetPersonalReceiptOrderApiReply response = client.afterapproval().v1().getPersonalReceiptOrder(authorizeRequest);
    if (response != null) {
      System.out.println("data: " + JacksonUtils.toJson(response.getData()));
    }
  }
}
