package com.xiaoju.open.sdk.didies.service.auth;



import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.auth.v1.model.AuthorizeApiReply;
import com.xiaoju.open.sdk.didies.service.auth.v1.model.AuthorizeRequest;
import com.xiaoju.open.sdk.didies.service.auth.v1.V1;

public class Auth extends BaseService {

    protected final ITokenHolder tokenHolder;

    protected final Config config;

    private final V1 v1;

    public Auth(ITokenHolder tokenHolder, Config config) {
        this.tokenHolder = tokenHolder;
        this.config = config;
        this.v1 = new V1(tokenHolder, config);
    }

    public V1 v1() {
        return this.v1;
    }
}

