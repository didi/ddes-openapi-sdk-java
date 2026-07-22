package com.xiaoju.open.sdk.ddes.project;

import com.xiaoju.open.sdk.didies.ApiClient;
import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.service.project.v1.model.*;
import com.xiaoju.open.sdk.didies.utils.JacksonUtils;

public class ProjectSample {

  public static void main(String[] args) throws Exception {
    Config config = Config.builder()
        .clientId("your_client_id")
        .clientSecret("your_client_secret")
        .signKey("your_sign_key")
        .build();

    ApiClient client = new ApiClient(config);

//    getProjectDetailTest(client);
//    outTravelerListTest(client);
//    updateMemberTest(client);
//    delMemberTest(client);
  }

  /**
   * 查询项目下的人员关联信息
   */
  public static void getProjectDetailTest(ApiClient client) throws Exception {
    GetProjectDetailRequest request = GetProjectDetailRequest.builder()
        .companyId("替换成自己的companyId")
        .projectId("替换成自己的projectId")
        .offset(0)
        .lenth(20)
        .build();
    GetProjectDetailApiReply response = client.project().v1().getProjectDetail(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 查询项目外部出行人列表
   */
  public static void outTravelerListTest(ApiClient client) throws Exception {
    OutTravelerListRequest request = OutTravelerListRequest.builder()
        .companyId("替换成自己的companyId")
        .projectId("替换成自己的projectId")
        .page(1)
        .pageSize(20)
        .build();
    OutTravelerListApiReply response = client.project().v1().outTravelerList(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 绑定项目与人员关系
   */
  public static void updateMemberTest(ApiClient client) throws Exception {
    UpdateMemberRequest request = UpdateMemberRequest.builder()
        .companyId("替换成自己的companyId")
        .projectId("替换成自己的projectId")
        .memberType(0)
        .memberValues("替换成逗号分隔的手机号")
        .build();
    UpdateMemberApiReply response = client.project().v1().updateMember(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 删除项目与人员关系
   */
  public static void delMemberTest(ApiClient client) throws Exception {
    DelMemberRequest request = DelMemberRequest.builder()
        .companyId("替换成自己的companyId")
        .projectId("替换成自己的projectId")
        .type(2)
        .memberIds("替换成逗号分隔的员工ID")
        .build();
    DelMemberApiReply response = client.project().v1().delMember(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }
}
