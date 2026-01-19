package com.xiaoju.open.sdk.didies.service.traveler

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.traveler.v1.V1
import spock.lang.Specification

class TravelerTest extends Specification {

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

    def "Traveler should create instance with tokenHolder and config"() {
        when:
        def traveler = new Traveler(mockTokenHolder, testConfig)

        then:
        traveler != null
        traveler.tokenHolder == mockTokenHolder
        traveler.config == testConfig
    }

    def "Traveler v1 method should return V1 instance"() {
        given:
        def traveler = new Traveler(mockTokenHolder, testConfig)

        when:
        def v1 = traveler.v1()

        then:
        v1 != null
        v1 instanceof V1
    }

    def "Traveler v1 method should return same instance on multiple calls"() {
        given:
        def traveler = new Traveler(mockTokenHolder, testConfig)

        when:
        def v1_1 = traveler.v1()
        def v1_2 = traveler.v1()

        then:
        v1_1 == v1_2
        v1_1.is(v1_2)
    }

    def "Traveler should extend BaseService"() {
        when:
        def traveler = new Traveler(mockTokenHolder, testConfig)

        then:
        traveler instanceof com.xiaoju.open.sdk.didies.service.BaseService
    }

    def "Traveler should store tokenHolder and config"() {
        when:
        def traveler = new Traveler(mockTokenHolder, testConfig)

        then:
        traveler.tokenHolder == mockTokenHolder
        traveler.config == testConfig
    }

    def "multiple Traveler instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def traveler1 = new Traveler(holder1, config1)
        def traveler2 = new Traveler(holder2, config2)

        then:
        traveler1.tokenHolder == holder1
        traveler2.tokenHolder == holder2
        traveler1.config.clientId == "client1"
        traveler2.config.clientId == "client2"
    }

    def "Traveler v1 should have access to parent config and tokenHolder"() {
        given:
        def traveler = new Traveler(mockTokenHolder, testConfig)
        def v1 = traveler.v1()

        expect:
        v1.config == testConfig
        v1.@config == testConfig
    }

    def "Traveler should work with different config values"() {
        given:
        def config = Config.builder()
                .clientId("different_client")
                .clientSecret("different_secret")
                .baseUrl("https://different.api.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .build()

        when:
        def traveler = new Traveler(mockTokenHolder, config)

        then:
        traveler.config.clientId == "different_client"
        traveler.config.clientSecret == "different_secret"
        traveler.config.baseUrl == "https://different.api.com"
        traveler.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
    }

    def "Traveler should handle null tokenHolder gracefully"() {
        when:
        def traveler = new Traveler(null, testConfig)

        then:
        traveler != null
        traveler.tokenHolder == null
    }

    def "Traveler should handle null config gracefully"() {
        when:
        def traveler = new Traveler(mockTokenHolder, null)

        then:
        traveler != null
        traveler.config == null
    }
}
