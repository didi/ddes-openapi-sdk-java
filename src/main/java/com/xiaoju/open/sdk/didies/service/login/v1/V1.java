package com.xiaoju.open.sdk.didies.service.login.v1;

import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.login.v1.model.GetLoginEncryptStrApiReply;
import com.xiaoju.open.sdk.didies.service.login.v1.model.GetLoginEncryptStrRequest;

public class V1 extends BaseService {

    public V1(ITokenHolder tokenHolder, Config config) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 单点请求
    * 提供GET方法用于提供可供使用的单点的方案
    * @param getLoginEncryptStrRequest  (required)
    * @return GetLoginEncryptStrApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetLoginEncryptStrApiReply getLoginEncryptStr(GetLoginEncryptStrRequest getLoginEncryptStrRequest) throws Exception {
        return doGet(getLoginEncryptStrRequest, "/river/Login/getLoginEncryptStr", GetLoginEncryptStrApiReply.class, 0);
        
    }
}

