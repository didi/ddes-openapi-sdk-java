package com.xiaoju.open.sdk.didies.service.afterapproval.v1;

import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.CreatePersonalReceiptApiReply;
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.CreatePersonalReceiptRequest;
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.GetPersonalReceiptOrderApiReply;
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.GetPersonalReceiptOrderRequest;

public class V1 extends BaseService {

    public V1(ITokenHolder tokenHolder, Config config) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 行后审批结果同步（行后授权）
    * 注意  - 审批人要求在企业中; - 行后审批驳回流程： - 用户用车且企业支付 →  企业管理员在企业系统审核后发起个人付款单创建请求 → 滴滴侧创建行后审批单 → 滴滴侧驳回行后审批单 → 用户登录滴滴企业版APP后即可看到个人付款单并发起支付;
    * @param createPersonalReceiptRequest  (required)
    * @return CreatePersonalReceiptApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public CreatePersonalReceiptApiReply createPersonalReceipt(CreatePersonalReceiptRequest createPersonalReceiptRequest) throws Exception {
        
        return doPost(createPersonalReceiptRequest, "/river/AfterApproval/createPersonalReceipt", CreatePersonalReceiptApiReply.class, 0);
    }
    /**
    * 行后审批完订单～查询个人付款单
    * 
    * @param getPersonalReceiptOrderRequest  (required)
    * @return GetPersonalReceiptOrderApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetPersonalReceiptOrderApiReply getPersonalReceiptOrder(GetPersonalReceiptOrderRequest getPersonalReceiptOrderRequest) throws Exception {
        return doGet(getPersonalReceiptOrderRequest, "/river/AfterApproval/getPersonalReceiptOrder", GetPersonalReceiptOrderApiReply.class, 0);
        
    }
}

