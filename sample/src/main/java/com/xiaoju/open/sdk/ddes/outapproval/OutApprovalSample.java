package com.xiaoju.open.sdk.ddes.outapproval;

import com.xiaoju.open.sdk.didies.ApiClient;
import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.service.approval.enums.ApprovalTypeEnum;
import com.xiaoju.open.sdk.didies.service.outapproval.enums.OutApprovalStatusEnum;
import com.xiaoju.open.sdk.didies.service.outapproval.v1.model.UpdateOutApprovalStatusApiReply;
import com.xiaoju.open.sdk.didies.service.outapproval.v1.model.UpdateOutApprovalStatusRequest;
import com.xiaoju.open.sdk.didies.utils.JacksonUtils;

public class OutApprovalSample {

  public static void main(String[] args) throws Exception {
    Config config = new Config()
        .setClientId("your_client_id")
        .setClientSecret("your_client_secret")
        .setSignKey("your_sign_key");
    ApiClient client = new ApiClient(config);

  }

  /**
   * 外部通知审批单状态变更接口【此接口文档未标注返回值，待验证】
   * <p>
   * 说明: 使用预订中审批时，企业级生成了审批单，可以使用该接口进行审批结果的同步;
   */
  public static void updateOutApprovalStatusTest(ApiClient client) throws Exception {
    UpdateOutApprovalStatusRequest request = UpdateOutApprovalStatusRequest.builder()
        .companyId("替换成自己的companyId")
        .outId("替换成自己的outApprovalId")
        .status(OutApprovalStatusEnum.NO.getCode())
        .approvalType(ApprovalTypeEnum.TRAVEL.getCode())
        .build();

    UpdateOutApprovalStatusApiReply response = client.outapproval().v1().updateOutApprovalStatus(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

}
