package com.xiaoju.open.sdk.didies.service.approval;



import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.ApprovalPassApiReply;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.ApprovalPassRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.CancelApprovalApiReply;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.CancelApprovalRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.CreateApprovalApiReply;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.CreateApprovalBusinessByDateRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.CreateApprovalBusinessByTimesRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.CreateApprovalRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.GetApprovalDetailApiReply;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.GetApprovalDetailRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.ListApprovalOrderApiReply;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.ListApprovalOrderRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.UpdateApprovalApiReply;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.UpdateApprovalBusinessByDateRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.UpdateApprovalBusinessByTimesRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.UpdateApprovalRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.V1;

public class Approval extends BaseService {

    protected final ITokenHolder tokenHolder;

    protected final Config config;

    private final V1 v1;

    public Approval(ITokenHolder tokenHolder, Config config) {
        this.tokenHolder = tokenHolder;
        this.config = config;
        this.v1 = new V1(tokenHolder, config);
    }

    public V1 v1() {
        return this.v1;
    }
}

