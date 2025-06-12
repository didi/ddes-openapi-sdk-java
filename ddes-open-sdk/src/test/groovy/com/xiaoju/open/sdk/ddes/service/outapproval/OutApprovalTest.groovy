package com.xiaoju.open.sdk.ddes.service.outapproval

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum
import com.xiaoju.open.sdk.didies.service.approval.enums.ApprovalTypeEnum
import com.xiaoju.open.sdk.didies.service.outapproval.OutApproval
import com.xiaoju.open.sdk.didies.service.outapproval.enums.OutApprovalStatusEnum
import com.xiaoju.open.sdk.didies.service.outapproval.v1.model.UpdateOutApprovalStatusApiReply
import com.xiaoju.open.sdk.didies.service.outapproval.v1.model.UpdateOutApprovalStatusRequest
import com.xiaoju.open.sdk.didies.utils.JacksonUtils
import spock.lang.Ignore
import spock.lang.Specification

/**
 * API tests for OutApproval
 */
@Ignore
class OutApprovalTest extends Specification {

    private OutApproval api

    def setup() {
        Config config = new Config()
                .setClientId("your_client_id")
                .setClientSecret("your_client_secret")
                .setSignKey("your_sign_key")
        ApiClient client = new ApiClient(config)
        api = client.outapproval()
    }


    /**
     * 外部通知审批单状态变更接口【此接口文档未标注返回值，待验证】
     *
     * 说明: 使用预订中审批时，企业级生成了审批单，可以使用该接口进行审批结果的同步;
     */
    def updateOutApprovalStatusTest() {
        UpdateOutApprovalStatusRequest updateOutApprovalStatusRequest = UpdateOutApprovalStatusRequest.builder()
                .companyId("替换成自己的companyId")
                .outId("替换成自己的outApprovalId")
                .status(OutApprovalStatusEnum.NO.getCode())
                .approvalType(ApprovalTypeEnum.TRAVEL.getCode())
                .build()

        println(JacksonUtils.toJson(updateOutApprovalStatusRequest))
        UpdateOutApprovalStatusApiReply response = api.v1().updateOutApprovalStatus(updateOutApprovalStatusRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }

}