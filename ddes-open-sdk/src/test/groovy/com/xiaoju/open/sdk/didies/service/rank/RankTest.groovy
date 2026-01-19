package com.xiaoju.open.sdk.didies.service.rank

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.rank.v1.V1
import spock.lang.Specification

class RankTest extends Specification {

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

    def "Rank should create instance with tokenHolder and config"() {
        when:
        def rank = new Rank(mockTokenHolder, testConfig)

        then:
        rank != null
        rank.tokenHolder == mockTokenHolder
        rank.config == testConfig
    }

    def "Rank v1 method should return V1 instance"() {
        given:
        def rank = new Rank(mockTokenHolder, testConfig)

        when:
        def v1 = rank.v1()

        then:
        v1 != null
        v1 instanceof V1
    }

    def "Rank v1 method should return same instance on multiple calls"() {
        given:
        def rank = new Rank(mockTokenHolder, testConfig)

        when:
        def v1_1 = rank.v1()
        def v1_2 = rank.v1()

        then:
        v1_1 == v1_2
        v1_1.is(v1_2)
    }

    def "Rank should extend BaseService"() {
        when:
        def rank = new Rank(mockTokenHolder, testConfig)

        then:
        rank instanceof com.xiaoju.open.sdk.didies.service.BaseService
    }

    def "Rank should store tokenHolder and config"() {
        when:
        def rank = new Rank(mockTokenHolder, testConfig)

        then:
        rank.tokenHolder == mockTokenHolder
        rank.config == testConfig
    }

    def "multiple Rank instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def rank1 = new Rank(holder1, config1)
        def rank2 = new Rank(holder2, config2)

        then:
        rank1.tokenHolder == holder1
        rank2.tokenHolder == holder2
        rank1.config.clientId == "client1"
        rank2.config.clientId == "client2"
    }

    def "Rank v1 should have access to parent config and tokenHolder"() {
        given:
        def rank = new Rank(mockTokenHolder, testConfig)
        def v1 = rank.v1()

        expect:
        v1.config == testConfig
        v1.@config == testConfig
    }

    def "Rank should work with different config values"() {
        given:
        def config = Config.builder()
                .clientId("different_client")
                .clientSecret("different_secret")
                .baseUrl("https://different.api.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .build()

        when:
        def rank = new Rank(mockTokenHolder, config)

        then:
        rank.config.clientId == "different_client"
        rank.config.clientSecret == "different_secret"
        rank.config.baseUrl == "https://different.api.com"
        rank.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
    }

    def "Rank should handle null tokenHolder gracefully"() {
        when:
        def rank = new Rank(null, testConfig)

        then:
        rank != null
        rank.tokenHolder == null
    }

    def "Rank should handle null config gracefully"() {
        when:
        def rank = new Rank(mockTokenHolder, null)

        then:
        rank != null
        rank.config == null
    }
}
