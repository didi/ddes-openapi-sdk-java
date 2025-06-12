package com.xiaoju.open.sdk.ddes.role;

import com.xiaoju.open.sdk.didies.ApiClient;
import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.service.role.v1.model.ListRoleApiReply;
import com.xiaoju.open.sdk.didies.service.role.v1.model.ListRoleRequest;
import com.xiaoju.open.sdk.didies.utils.JacksonUtils;

public class RoleSample {

  public static void main(String[] args) throws Exception {
    Config config = new Config()
        .setClientId("your_client_id")
        .setClientSecret("your_client_secret")
        .setSignKey("your_sign_key");
    ApiClient client = new ApiClient(config);
    listRoleTest(client);
  }

  /**
   * 角色查询
   * <p>
   * 用于查询员工角色信息
   */
  public static void listRoleTest(ApiClient client) throws Exception {
    ListRoleRequest request = ListRoleRequest.builder()
        .companyId("替换成自己的companyId")
        .build();
    ListRoleApiReply response = client.role().v1().listRole(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }
}
