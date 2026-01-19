package com.xiaoju.open.sdk.didies.service.city

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.city.v1.V1
import spock.lang.Specification

class CityTest extends Specification {

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

    def "City should create instance with tokenHolder and config"() {
        when:
        def city = new City(mockTokenHolder, testConfig)

        then:
        city != null
        city.tokenHolder == mockTokenHolder
        city.config == testConfig
    }

    def "City v1 method should return V1 instance"() {
        given:
        def city = new City(mockTokenHolder, testConfig)

        when:
        def v1 = city.v1()

        then:
        v1 != null
        v1 instanceof V1
    }

    def "City v1 method should return same instance on multiple calls"() {
        given:
        def city = new City(mockTokenHolder, testConfig)

        when:
        def v1_1 = city.v1()
        def v1_2 = city.v1()

        then:
        v1_1 == v1_2
        v1_1.is(v1_2)
    }

    def "City should extend BaseService"() {
        when:
        def city = new City(mockTokenHolder, testConfig)

        then:
        city instanceof com.xiaoju.open.sdk.didies.service.BaseService
    }

    def "City should store tokenHolder and config"() {
        when:
        def city = new City(mockTokenHolder, testConfig)

        then:
        city.tokenHolder == mockTokenHolder
        city.config == testConfig
    }

    def "multiple City instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def city1 = new City(holder1, config1)
        def city2 = new City(holder2, config2)

        then:
        city1.tokenHolder == holder1
        city2.tokenHolder == holder2
        city1.config.clientId == "client1"
        city2.config.clientId == "client2"
    }

    def "City v1 should have access to parent config and tokenHolder"() {
        given:
        def city = new City(mockTokenHolder, testConfig)
        def v1 = city.v1()

        expect:
        v1.config == testConfig
        v1.@config == testConfig
    }

    def "City should work with different config values"() {
        given:
        def config = Config.builder()
                .clientId("different_client")
                .clientSecret("different_secret")
                .baseUrl("https://different.api.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .build()

        when:
        def city = new City(mockTokenHolder, config)

        then:
        city.config.clientId == "different_client"
        city.config.clientSecret == "different_secret"
        city.config.baseUrl == "https://different.api.com"
        city.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
    }

    def "City should handle null tokenHolder gracefully"() {
        when:
        def city = new City(null, testConfig)

        then:
        city != null
        city.tokenHolder == null
    }

    def "City should handle null config gracefully"() {
        when:
        def city = new City(mockTokenHolder, null)

        then:
        city != null
        city.config == null
    }
}
