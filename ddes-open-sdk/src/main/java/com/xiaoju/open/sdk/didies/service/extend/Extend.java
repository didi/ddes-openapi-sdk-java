package com.xiaoju.open.sdk.didies.service.extend;



import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.extend.v1.model.CreateExtendBatchApiReply;
import com.xiaoju.open.sdk.didies.service.extend.v1.model.CreateExtendBatchRequest;
import com.xiaoju.open.sdk.didies.service.extend.v1.model.ListExtendApiReply;
import com.xiaoju.open.sdk.didies.service.extend.v1.model.ListExtendRequest;
import com.xiaoju.open.sdk.didies.service.extend.v1.model.UpdateExtendStatusApiReply;
import com.xiaoju.open.sdk.didies.service.extend.v1.model.UpdateExtendStatusRequest;
import com.xiaoju.open.sdk.didies.service.extend.v1.V1;

public class Extend extends BaseService {

    protected final ITokenHolder tokenHolder;

    protected final Config config;

    private final V1 v1;

    public Extend(ITokenHolder tokenHolder, Config config) {
        this.tokenHolder = tokenHolder;
        this.config = config;
        this.v1 = new V1(tokenHolder, config);
    }

    public V1 v1() {
        return this.v1;
    }
}

