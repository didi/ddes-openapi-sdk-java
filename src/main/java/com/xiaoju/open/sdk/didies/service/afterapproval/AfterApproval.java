package com.xiaoju.open.sdk.didies.service.afterapproval;



import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.CreatePersonalReceiptApiReply;
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.CreatePersonalReceiptRequest;
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.GetPersonalReceiptOrderApiReply;
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.GetPersonalReceiptOrderRequest;
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.V1;

public class AfterApproval extends BaseService {

    protected final ITokenHolder tokenHolder;

    protected final Config config;

    private final V1 v1;

    public AfterApproval(ITokenHolder tokenHolder, Config config) {
        this.tokenHolder = tokenHolder;
        this.config = config;
        this.v1 = new V1(tokenHolder, config);
    }

    public V1 v1() {
        return this.v1;
    }
}

