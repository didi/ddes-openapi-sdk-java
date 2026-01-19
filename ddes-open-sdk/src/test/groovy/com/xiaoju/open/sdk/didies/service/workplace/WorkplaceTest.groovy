package com.xiaoju.open.sdk.didies.service.workplace

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.workplace.v1.V1
import spock.lang.Specification

class WorkplaceTest extends Specification {

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

    def "Workplace should create instance with tokenHolder and config"() {
        when:
        def workplace = new Workplace(mockTokenHolder, testConfig)

        then:
        workplace != null
        workplace.tokenHolder == mockTokenHolder
        workplace.config == testConfig
    }

    def "Workplace v1 method should return V1 instance"() {
        given:
        def workplace = new Workplace(mockTokenHolder, testConfig)

        when:
        def v1 = workplace.v1()

        then:
        v1 != null
        v1 instanceof V1
    }

    def "Workplace v1 method should return same instance on multiple calls"() {
        given:
        def workplace = new Workplace(mockTokenHolder, testConfig)

        when:
        def v1_1 = workplace.v1()
        def v1_2 = workplace.v1()

        then:
        v1_1 == v1_2
        v1_1.is(v1_2)
    }

    def "Workplace should extend BaseService"() {
        when:
        def workplace = new Workplace(mockTokenHolder, testConfig)

        then:
        workplace instanceof com.xiaoju.open.sdk.didies.service.BaseService
    }

    def "Workplace should store tokenHolder and config"() {
        when:
        def workplace = new Workplace(mockTokenHolder, testConfig)

        then:
        workplace.tokenHolder == mockTokenHolder
        workplace.config == testConfig
    }

    def "multiple Workplace instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def workplace1 = new Workplace(holder1, config1)
        def workplace2 = new Workplace(holder2, config2)

        then:
        workplace1.tokenHolder == holder1
        workplace2.tokenHolder == holder2
        workplace1.config.clientId == "client1"
        workplace2.config.clientId == "client2"
    }

    def "Workplace v1 should have access to parent config and tokenHolder"() {
        given:
        def workplace = new Workplace(mockTokenHolder, testConfig)
        def v1 = workplace.v1()

        expect:
        v1.config == testConfig
        v1.@config == testConfig
    }

    def "Workplace should work with different config values"() {
        given:
        def config = Config.builder()
                .clientId("different_client")
                .clientSecret("different_secret")
                .baseUrl("https://different.api.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .build()

        when:
        def workplace = new Workplace(mockTokenHolder, config)

        then:
        workplace.config.clientId == "different_client"
        workplace.config.clientSecret == "different_secret"
        workplace.config.baseUrl == "https://different.api.com"
        workplace.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
    }

    def "Workplace should handle null tokenHolder gracefully"() {
        when:
        def workplace = new Workplace(null, testConfig)

        then:
        workplace != null
        workplace.tokenHolder == null
    }

    def "Workplace should handle null config gracefully"() {
        when:
        def workplace = new Workplace(mockTokenHolder, null)

        then:
        workplace != null
        workplace.config == null
    }
}
