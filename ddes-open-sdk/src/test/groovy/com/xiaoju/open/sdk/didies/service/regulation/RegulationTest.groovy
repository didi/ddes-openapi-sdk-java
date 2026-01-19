package com.xiaoju.open.sdk.didies.service.regulation

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.regulation.v1.V1
import spock.lang.Specification

class RegulationTest extends Specification {

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

    def "Regulation should create instance with tokenHolder and config"() {
        when:
        def regulation = new Regulation(mockTokenHolder, testConfig)

        then:
        regulation != null
        regulation.tokenHolder == mockTokenHolder
        regulation.config == testConfig
    }

    def "Regulation v1 method should return V1 instance"() {
        given:
        def regulation = new Regulation(mockTokenHolder, testConfig)

        when:
        def v1 = regulation.v1()

        then:
        v1 != null
        v1 instanceof V1
    }

    def "Regulation v1 method should return same instance on multiple calls"() {
        given:
        def regulation = new Regulation(mockTokenHolder, testConfig)

        when:
        def v1_1 = regulation.v1()
        def v1_2 = regulation.v1()

        then:
        v1_1 == v1_2
        v1_1.is(v1_2)
    }

    def "Regulation should extend BaseService"() {
        when:
        def regulation = new Regulation(mockTokenHolder, testConfig)

        then:
        regulation instanceof com.xiaoju.open.sdk.didies.service.BaseService
    }

    def "Regulation should store tokenHolder and config"() {
        when:
        def regulation = new Regulation(mockTokenHolder, testConfig)

        then:
        regulation.tokenHolder == mockTokenHolder
        regulation.config == testConfig
    }

    def "multiple Regulation instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def regulation1 = new Regulation(holder1, config1)
        def regulation2 = new Regulation(holder2, config2)

        then:
        regulation1.tokenHolder == holder1
        regulation2.tokenHolder == holder2
        regulation1.config.clientId == "client1"
        regulation2.config.clientId == "client2"
    }

    def "Regulation v1 should have access to parent config and tokenHolder"() {
        given:
        def regulation = new Regulation(mockTokenHolder, testConfig)
        def v1 = regulation.v1()

        expect:
        v1.config == testConfig
        v1.@config == testConfig
    }

    def "Regulation should work with different config values"() {
        given:
        def config = Config.builder()
                .clientId("different_client")
                .clientSecret("different_secret")
                .baseUrl("https://different.api.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .build()

        when:
        def regulation = new Regulation(mockTokenHolder, config)

        then:
        regulation.config.clientId == "different_client"
        regulation.config.clientSecret == "different_secret"
        regulation.config.baseUrl == "https://different.api.com"
        regulation.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
    }

    def "Regulation should handle null tokenHolder gracefully"() {
        when:
        def regulation = new Regulation(null, testConfig)

        then:
        regulation != null
        regulation.tokenHolder == null
    }

    def "Regulation should handle null config gracefully"() {
        when:
        def regulation = new Regulation(mockTokenHolder, null)

        then:
        regulation != null
        regulation.config == null
    }
}
