package com.xiaoju.open.sdk.ddes.legalentity;

import com.xiaoju.open.sdk.didies.ApiClient;
import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.CreateLegalEntityApiReply;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.CreateLegalEntityRequest;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.DelLegalEntityApiReply;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.DelLegalEntityRequest;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.GetLegalEntityApiReply;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.GetLegalEntityRequest;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.UpdateLegalEntityApiReply;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.UpdateLegalEntityRequest;
import com.xiaoju.open.sdk.didies.utils.JacksonUtils;

public class LegalEntitySample {


  public static void main(String[] args) throws Exception {
    Config config = new Config()
        .setClientId("your_client_id")
        .setClientSecret("your_client_secret")
        .setSignKey("your_sign_key");

    ApiClient client = new ApiClient(config);

    createLegalEntity(client);
    updateLegalEntityTest(client);
    delLegalEntityTest(client);
    getLegalEntityTest(client);
  }

  /**
   * 公司主体新增
   * <p>
   * 说明： * 新增公司主体信息后，可以使用查询接口查询ES后台的维护情况。
   */
  public static void createLegalEntity(ApiClient client) throws Exception {
    CreateLegalEntityRequest request = CreateLegalEntityRequest.builder()
        .companyId("替换成自己的companyId")
        .name("自定义")
        .build();
    CreateLegalEntityApiReply response = client.legalentity().v1().createLegalEntity(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 公司主体修改
   * <p>
   * 说明： * 修改公司主体信息后，可以使用查询接口查询ES后台的维护情况。
   */
  public static void updateLegalEntityTest(ApiClient client) throws Exception {
    UpdateLegalEntityRequest request = UpdateLegalEntityRequest.builder()
        .companyId("替换成自己的companyId")
        .legalEntityId("xxx")
        .name("自定义_修改")
        .build();
    UpdateLegalEntityApiReply response = client.legalentity().v1().updateLegalEntity(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 公司主体停用
   * <p>
   * 说明：停用公司主体信息。
   */
  public static void delLegalEntityTest(ApiClient client) throws Exception {
    DelLegalEntityRequest request = DelLegalEntityRequest.builder()
        .companyId("替换成自己的companyId")
        .legalEntityId("xxx")
        .build();
    DelLegalEntityApiReply response = client.legalentity().v1().delLegalEntity(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
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

  /**
   * 公司主体查询
   * <p>
   * 说明： * 查询公司在滴滴侧的具体信息; * 通过获取的信息用于确认相关的配置信息，可以用于同步滴滴ES后台的信息; * 只返回有效的公司信息。不包含禁用和过期的公司主体信息。需要返回全部的，是不是需要重新封接口。
   */
  public static void getLegalEntityTest1(ApiClient client) throws Exception {
    GetLegalEntityRequest request = GetLegalEntityRequest.builder()
        .companyId("替换成自己的companyId")
        .length(1)
        .offset(0)
        .build();
    GetLegalEntityApiReply response = client.legalentity().v1().getLegalEntity(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

}
