package com.xiaoju.open.sdk.ddes.auth;


import com.xiaoju.open.sdk.didies.ApiClient;
import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.service.auth.v1.model.AuthorizeApiReply;
import com.xiaoju.open.sdk.didies.service.auth.v1.model.AuthorizeRequest;

public class AuthSample {

  public static void main(String[] args) throws Exception {

    // 请替换为实际的appKey和appSecret
    Config config = new Config()
        .setClientId("your_client_id")
        .setClientSecret("your_client_secret")
        .setSignKey("your_sign_key");

    ApiClient client = new ApiClient(config);
    AuthorizeRequest authorizeRequest = new AuthorizeRequest();
    AuthorizeApiReply authorize = client.auth().v1().authorize(authorizeRequest);
    if (authorize != null) {
      System.out.println("Access Token: " + authorize.getAccessToken());
      System.out.println("Expires In: " + authorize.getExpiresIn());
    }
  }
}
