package com.xiaoju.open.sdk.didies.service.outapproval.v1;

import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.outapproval.v1.model.UpdateOutApprovalStatusApiReply;
import com.xiaoju.open.sdk.didies.service.outapproval.v1.model.UpdateOutApprovalStatusRequest;

public class V1 extends BaseService {

    public V1(ITokenHolder tokenHolder, Config config) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 外部通知审批单状态变更接口【此接口文档未标注返回值，待验证】
    * 说明: 使用预订中审批时，企业级生成了审批单，可以使用该接口进行审批结果的同步;
    * @param updateOutApprovalStatusRequest  (required)
    * @return UpdateOutApprovalStatusApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public UpdateOutApprovalStatusApiReply updateOutApprovalStatus(UpdateOutApprovalStatusRequest updateOutApprovalStatusRequest) throws Exception {
        
        return doPost(updateOutApprovalStatusRequest, "/river/OutApproval/Status", UpdateOutApprovalStatusApiReply.class, 0);
    }
}

