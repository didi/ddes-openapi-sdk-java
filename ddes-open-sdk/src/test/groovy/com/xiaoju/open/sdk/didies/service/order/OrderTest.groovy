package com.xiaoju.open.sdk.didies.service.order

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.order.v1.V1
import spock.lang.Specification

class OrderTest extends Specification {

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

    def "Order should create instance with tokenHolder and config"() {
        when:
        def order = new Order(mockTokenHolder, testConfig)

        then:
        order != null
        order.tokenHolder == mockTokenHolder
        order.config == testConfig
    }

    def "Order v1 method should return V1 instance"() {
        given:
        def order = new Order(mockTokenHolder, testConfig)

        when:
        def v1 = order.v1()

        then:
        v1 != null
        v1 instanceof V1
    }

    def "Order v1 method should return same instance on multiple calls"() {
        given:
        def order = new Order(mockTokenHolder, testConfig)

        when:
        def v1_1 = order.v1()
        def v1_2 = order.v1()

        then:
        v1_1 == v1_2
        v1_1.is(v1_2)
    }

    def "Order should extend BaseService"() {
        when:
        def order = new Order(mockTokenHolder, testConfig)

        then:
        order instanceof com.xiaoju.open.sdk.didies.service.BaseService
    }

    def "Order should store tokenHolder and config"() {
        when:
        def order = new Order(mockTokenHolder, testConfig)

        then:
        order.tokenHolder == mockTokenHolder
        order.config == testConfig
    }

    def "multiple Order instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def order1 = new Order(holder1, config1)
        def order2 = new Order(holder2, config2)

        then:
        order1.tokenHolder == holder1
        order2.tokenHolder == holder2
        order1.config.clientId == "client1"
        order2.config.clientId == "client2"
    }

    def "Order v1 should have access to parent config and tokenHolder"() {
        given:
        def order = new Order(mockTokenHolder, testConfig)
        def v1 = order.v1()

        expect:
        v1.config == testConfig
        v1.@config == testConfig
    }

    def "Order should work with different config values"() {
        given:
        def config = Config.builder()
                .clientId("different_client")
                .clientSecret("different_secret")
                .baseUrl("https://different.api.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .build()

        when:
        def order = new Order(mockTokenHolder, config)

        then:
        order.config.clientId == "different_client"
        order.config.clientSecret == "different_secret"
        order.config.baseUrl == "https://different.api.com"
        order.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
    }

    def "Order should handle null tokenHolder gracefully"() {
        when:
        def order = new Order(null, testConfig)

        then:
        order != null
        order.tokenHolder == null
    }

    def "Order should handle null config gracefully"() {
        when:
        def order = new Order(mockTokenHolder, null)

        then:
        order != null
        order.config == null
    }
}
