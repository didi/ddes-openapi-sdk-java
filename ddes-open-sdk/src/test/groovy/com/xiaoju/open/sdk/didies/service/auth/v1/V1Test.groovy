package com.xiaoju.open.sdk.didies.service.auth.v1

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.BaseService
import spock.lang.Specification

class V1Test extends Specification {

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

    def "V1 should create instance with tokenHolder and config"() {
        when:
        def v1 = new V1(mockTokenHolder, testConfig)

        then:
        v1 != null
        v1.tokenHolder == mockTokenHolder
        v1.config == testConfig
    }

    def "V1 should extend BaseService"() {
        when:
        def v1 = new V1(mockTokenHolder, testConfig)

        then:
        v1 instanceof BaseService
    }

    def "V1 should store tokenHolder and config in parent class"() {
        given:
        def v1 = new V1(mockTokenHolder, testConfig)

        expect:
        v1.@tokenHolder == mockTokenHolder
        v1.config == testConfig
    }

    def "multiple V1 instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def v1_1 = new V1(holder1, config1)
        def v1_2 = new V1(holder2, config2)

        then:
        v1_1.tokenHolder == holder1
        v1_2.tokenHolder == holder2
        v1_1.config.clientId == "client1"
        v1_2.config.clientId == "client2"
    }

    def "V1 should work with minimal config"() {
        given:
        def minimalConfig = Config.builder()
                .clientId("client")
                .clientSecret("secret")
                .build()

        when:
        def v1 = new V1(mockTokenHolder, minimalConfig)

        then:
        v1 != null
        v1.config.clientId == "client"
    }

    def "V1 should work with full config"() {
        given:
        def fullConfig = Config.builder()
                .clientId("client")
                .clientSecret("secret")
                .baseUrl("https://api.example.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .enableAES(true)
                .enableRequestLog(true)
                .build()

        when:
        def v1 = new V1(mockTokenHolder, fullConfig)

        then:
        v1 != null
        v1.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
        v1.config.enableAES == true
    }

    def "V1 should handle null tokenHolder"() {
        when:
        def v1 = new V1(null, testConfig)

        then:
        v1 != null
        v1.tokenHolder == null
    }

    def "V1 should handle null config"() {
        when:
        def v1 = new V1(mockTokenHolder, null)

        then:
        v1 != null
        v1.config == null
    }

    def "V1 should work with custom tokenHolder implementation"() {
        given:
        def customHolder = new ITokenHolder() {
            @Override
            String getAccessToken() {
                return "custom_token"
            }

            @Override
            boolean isExpired() {
                return false
            }
        }

        when:
        def v1 = new V1(customHolder, testConfig)

        then:
        v1.tokenHolder.getAccessToken() == "custom_token"
        !v1.tokenHolder.isExpired()
    }
}
