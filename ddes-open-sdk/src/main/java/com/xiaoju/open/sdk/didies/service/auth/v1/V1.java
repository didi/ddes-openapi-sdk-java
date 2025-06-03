package com.xiaoju.open.sdk.didies.service.auth.v1;

import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.auth.v1.model.AuthorizeApiReply;
import com.xiaoju.open.sdk.didies.service.auth.v1.model.AuthorizeRequest;

public class V1 extends BaseService {

    public V1(ITokenHolder tokenHolder, Config config) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 授权认证
    * 用于获取接口access_token
    * @param authorizeRequest  (required)
    * @return AuthorizeApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public AuthorizeApiReply authorize(AuthorizeRequest authorizeRequest) throws Exception {
        
        return doPost(authorizeRequest, "/river/Auth/authorize", AuthorizeApiReply.class, 0);
    }
}

