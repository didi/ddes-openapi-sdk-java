package com.xiaoju.open.sdk.didies.service.auth

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.service.auth.v1.model.AuthorizeApiReply
import com.xiaoju.open.sdk.didies.service.auth.v1.model.AuthorizeRequest
import com.xiaoju.open.sdk.didies.utils.JacksonUtils
import spock.lang.Ignore
import spock.lang.Specification

/**
 * API tests for Auth
 */
@Ignore
class AuthTest extends Specification {

    private Auth api

    def setup() {
        Config config = new Config(
                clientId: "替换成自己的clientId",
                clientSecret: "替换成自己的clientSecret",
                signKey: "替换成自己的signKey",
        )
        ApiClient client = new ApiClient(config)
        api = client.auth()
    }

    /**
     * 授权认证
     *
     * 用于获取接口access_token
     */
    def authorizeTest() {
        AuthorizeRequest authorizeRequest = AuthorizeRequest.builder()
                .clientId(api.config.getClientId())
                .clientSecret(api.config.getClientSecret())
                .grantType(api.config.getGrantType())
                .build()

        AuthorizeApiReply response = api.v1().authorize(authorizeRequest)
        println JacksonUtils.toJson(response)
        expect:
        response != null
    }

}