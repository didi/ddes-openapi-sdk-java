package com.xiaoju.open.sdk.didies.service

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.auth.Auth
import com.xiaoju.open.sdk.didies.service.auth.v1.V1
import spock.lang.Specification

class AuthTest extends Specification {

    ITokenHolder mockTokenHolder
    Config testConfig

    def setup() {
        mockTokenHolder = Mock(ITokenHolder)
        testConfig = Config.builder()
                .clientId("test_client")
                .clientSecret("test_secret")
                .baseUrl("https://test.api.com")
                .build()
    }

    def "Auth should create instance with tokenHolder and config"() {
        when:
        def auth = new Auth(mockTokenHolder, testConfig)

        then:
        auth != null
        auth.tokenHolder == mockTokenHolder
        auth.config == testConfig
    }

    def "Auth v1 method should return V1 instance"() {
        given:
        def auth = new Auth(mockTokenHolder, testConfig)

        when:
        def v1 = auth.v1()

        then:
        v1 != null
        v1 instanceof V1
    }

    def "Auth v1 method should return same instance on multiple calls"() {
        given:
        def auth = new Auth(mockTokenHolder, testConfig)

        when:
        def v1_1 = auth.v1()
        def v1_2 = auth.v1()

        then:
        v1_1 == v1_2
        v1_1.is(v1_2)
    }

    def "Auth should extend BaseService"() {
        when:
        def auth = new Auth(mockTokenHolder, testConfig)

        then:
        auth instanceof BaseService
    }

    def "Auth should store tokenHolder and config"() {
        when:
        def auth = new Auth(mockTokenHolder, testConfig)

        then:
        auth.tokenHolder == mockTokenHolder
        auth.config == testConfig
    }

    def "multiple Auth instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def auth1 = new Auth(holder1, config1)
        def auth2 = new Auth(holder2, config2)

        then:
        auth1.tokenHolder == holder1
        auth2.tokenHolder == holder2
        auth1.config.clientId == "client1"
        auth2.config.clientId == "client2"
    }

    def "Auth v1 should have access to parent config and tokenHolder"() {
        given:
        def auth = new Auth(mockTokenHolder, testConfig)
        def v1 = auth.v1()

        expect:
        v1.config == testConfig
        v1.@config == testConfig
    }

    def "Auth should work with different config values"() {
        given:
        def config = Config.builder()
                .clientId("different_client")
                .clientSecret("different_secret")
                .baseUrl("https://different.api.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .build()

        when:
        def auth = new Auth(mockTokenHolder, config)

        then:
        auth.config.clientId == "different_client"
        auth.config.clientSecret == "different_secret"
        auth.config.baseUrl == "https://different.api.com"
        auth.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
    }

    def "Auth should handle null tokenHolder gracefully"() {
        when:
        def auth = new Auth(null, testConfig)

        then:
        auth != null
        auth.tokenHolder == null
    }

    def "Auth should handle null config gracefully"() {
        when:
        def auth = new Auth(mockTokenHolder, null)

        then:
        auth != null
        auth.config == null
    }
}
