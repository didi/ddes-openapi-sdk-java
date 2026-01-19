package com.xiaoju.open.sdk.didies.service.extend

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.extend.v1.V1
import spock.lang.Specification

class ExtendTest extends Specification {

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

    def "Extend should create instance with tokenHolder and config"() {
        when:
        def extend = new Extend(mockTokenHolder, testConfig)

        then:
        extend != null
        extend.tokenHolder == mockTokenHolder
        extend.config == testConfig
    }

    def "Extend v1 method should return V1 instance"() {
        given:
        def extend = new Extend(mockTokenHolder, testConfig)

        when:
        def v1 = extend.v1()

        then:
        v1 != null
        v1 instanceof V1
    }

    def "Extend v1 method should return same instance on multiple calls"() {
        given:
        def extend = new Extend(mockTokenHolder, testConfig)

        when:
        def v1_1 = extend.v1()
        def v1_2 = extend.v1()

        then:
        v1_1 == v1_2
        v1_1.is(v1_2)
    }

    def "Extend should extend BaseService"() {
        when:
        def extend = new Extend(mockTokenHolder, testConfig)

        then:
        extend instanceof com.xiaoju.open.sdk.didies.service.BaseService
    }

    def "Extend should store tokenHolder and config"() {
        when:
        def extend = new Extend(mockTokenHolder, testConfig)

        then:
        extend.tokenHolder == mockTokenHolder
        extend.config == testConfig
    }

    def "multiple Extend instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def extend1 = new Extend(holder1, config1)
        def extend2 = new Extend(holder2, config2)

        then:
        extend1.tokenHolder == holder1
        extend2.tokenHolder == holder2
        extend1.config.clientId == "client1"
        extend2.config.clientId == "client2"
    }

    def "Extend v1 should have access to parent config and tokenHolder"() {
        given:
        def extend = new Extend(mockTokenHolder, testConfig)
        def v1 = extend.v1()

        expect:
        v1.config == testConfig
        v1.@config == testConfig
    }

    def "Extend should work with different config values"() {
        given:
        def config = Config.builder()
                .clientId("different_client")
                .clientSecret("different_secret")
                .baseUrl("https://different.api.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .build()

        when:
        def extend = new Extend(mockTokenHolder, config)

        then:
        extend.config.clientId == "different_client"
        extend.config.clientSecret == "different_secret"
        extend.config.baseUrl == "https://different.api.com"
        extend.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
    }

    def "Extend should handle null tokenHolder gracefully"() {
        when:
        def extend = new Extend(null, testConfig)

        then:
        extend != null
        extend.tokenHolder == null
    }

    def "Extend should handle null config gracefully"() {
        when:
        def extend = new Extend(mockTokenHolder, null)

        then:
        extend != null
        extend.config == null
    }
}
