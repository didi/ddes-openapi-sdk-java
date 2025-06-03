package com.xiaoju.open.sdk.ddes.service.login

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum
import com.xiaoju.open.sdk.didies.service.login.Login
import com.xiaoju.open.sdk.didies.service.login.v1.model.GetLoginEncryptStrApiReply
import com.xiaoju.open.sdk.didies.service.login.v1.model.GetLoginEncryptStrRequest
import com.xiaoju.open.sdk.didies.utils.JacksonUtils
import spock.lang.Ignore
import spock.lang.Specification

/**
 * API tests for Login
 */
@Ignore
class LoginTest extends Specification {

    private Login api

    def setup() {
        Config config = Config.builder()
                .baseUrl("https://api.es.xiaojukeji.com")
                .clientId("替换成自己的clientId")
                .clientSecret("替换成自己的clientSecret")
                .signKey("替换成自己的signKey")
                .enableRequestLog(true)
                .logLevel(LogLevelEnum.INFO).build()
        ApiClient client = new ApiClient(config)
        api = client.login()
    }

    /**
     * 单点请求
     *
     * 提供GET方法用于提供可供使用的单点的方案
     */
    def getLoginEncryptStrTest() {
        GetLoginEncryptStrRequest getLoginEncryptStrApiRequest = new GetLoginEncryptStrRequest(
                companyId: "替换成自己的companyId",
                phone: "00016218408",
                appType: 2
        )

        GetLoginEncryptStrApiReply response = api.v1().getLoginEncryptStr(getLoginEncryptStrApiRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }

}