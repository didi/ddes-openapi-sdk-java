package com.xiaoju.open.sdk.ddes.service.afterapproval

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum
import com.xiaoju.open.sdk.didies.service.afterapproval.AfterApproval
import com.xiaoju.open.sdk.didies.service.afterapproval.enums.AfterApprovalIsPassEnum
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.CreatePersonalReceiptApiReply
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.CreatePersonalReceiptRequest
import com.xiaoju.open.sdk.didies.utils.JacksonUtils
import spock.lang.Ignore
import spock.lang.Specification

/**
 * API tests for AfterApproval
 */
@Ignore
class AfterApprovalTest extends Specification {

    private AfterApproval api

    def setup() {
        Config config = Config.builder()
                .baseUrl("https://api.es.xiaojukeji.com")
                .clientId("替换成自己的clientId")
                .clientSecret("替换成自己的clientSecret")
                .signKey("替换成自己的signKey")
                .enableRequestLog(true)
                .logLevel(LogLevelEnum.INFO).build()
        ApiClient client = new ApiClient(config)
        api = client.afterapproval()
    }

    /**
     * 行后审批结果同步（行后授权）
     *
     * 注意  - 审批人要求在企业中; - 行后审批驳回流程： - 用户用车且企业支付 →  企业管理员在企业系统审核后发起个人付款单创建请求 → 滴滴侧创建行后审批单 → 滴滴侧驳回行后审批单 → 用户登录滴滴企业版APP后即可看到个人付款单并发起支付;
     */
    def afterApprovalCreatePersonalReceiptTest() {
        CreatePersonalReceiptRequest createPersonalReceiptRequest = CreatePersonalReceiptRequest.builder()
                .companyId("替换成自己的companyId")
                .orderId("1125965117295259")
                .isPass(AfterApprovalIsPassEnum.YES.getCode()).build()
        CreatePersonalReceiptApiReply response = api.v1().createPersonalReceipt(createPersonalReceiptRequest)
        println JacksonUtils.toJson(response)
        expect:
        response != null
    }

}