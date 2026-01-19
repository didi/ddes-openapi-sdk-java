package com.xiaoju.open.sdk.didies.service.bill

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.bill.v1.V1
import spock.lang.Specification

class BillTest extends Specification {

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

    def "Bill should create instance with tokenHolder and config"() {
        when:
        def bill = new Bill(mockTokenHolder, testConfig)

        then:
        bill != null
        bill.tokenHolder == mockTokenHolder
        bill.config == testConfig
    }

    def "Bill v1 method should return V1 instance"() {
        given:
        def bill = new Bill(mockTokenHolder, testConfig)

        when:
        def v1 = bill.v1()

        then:
        v1 != null
        v1 instanceof V1
    }

    def "Bill v1 method should return same instance on multiple calls"() {
        given:
        def bill = new Bill(mockTokenHolder, testConfig)

        when:
        def v1_1 = bill.v1()
        def v1_2 = bill.v1()

        then:
        v1_1 == v1_2
        v1_1.is(v1_2)
    }

    def "Bill should extend BaseService"() {
        when:
        def bill = new Bill(mockTokenHolder, testConfig)

        then:
        bill instanceof com.xiaoju.open.sdk.didies.service.BaseService
    }

    def "Bill should store tokenHolder and config"() {
        when:
        def bill = new Bill(mockTokenHolder, testConfig)

        then:
        bill.tokenHolder == mockTokenHolder
        bill.config == testConfig
    }

    def "multiple Bill instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def bill1 = new Bill(holder1, config1)
        def bill2 = new Bill(holder2, config2)

        then:
        bill1.tokenHolder == holder1
        bill2.tokenHolder == holder2
        bill1.config.clientId == "client1"
        bill2.config.clientId == "client2"
    }

    def "Bill v1 should have access to parent config and tokenHolder"() {
        given:
        def bill = new Bill(mockTokenHolder, testConfig)
        def v1 = bill.v1()

        expect:
        v1.config == testConfig
        v1.@config == testConfig
    }

    def "Bill should work with different config values"() {
        given:
        def config = Config.builder()
                .clientId("different_client")
                .clientSecret("different_secret")
                .baseUrl("https://different.api.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .build()

        when:
        def bill = new Bill(mockTokenHolder, config)

        then:
        bill.config.clientId == "different_client"
        bill.config.clientSecret == "different_secret"
        bill.config.baseUrl == "https://different.api.com"
        bill.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
    }

    def "Bill should handle null tokenHolder gracefully"() {
        when:
        def bill = new Bill(null, testConfig)

        then:
        bill != null
        bill.tokenHolder == null
    }

    def "Bill should handle null config gracefully"() {
        when:
        def bill = new Bill(mockTokenHolder, null)

        then:
        bill != null
        bill.config == null
    }
}
