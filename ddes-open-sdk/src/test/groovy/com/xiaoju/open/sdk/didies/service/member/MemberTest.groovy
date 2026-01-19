package com.xiaoju.open.sdk.didies.service.member

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.member.v1.V1
import spock.lang.Specification

class MemberTest extends Specification {

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

    def "Member should create instance with tokenHolder and config"() {
        when:
        def member = new Member(mockTokenHolder, testConfig)

        then:
        member != null
        member.tokenHolder == mockTokenHolder
        member.config == testConfig
    }

    def "Member v1 method should return V1 instance"() {
        given:
        def member = new Member(mockTokenHolder, testConfig)

        when:
        def v1 = member.v1()

        then:
        v1 != null
        v1 instanceof V1
    }

    def "Member v1 method should return same instance on multiple calls"() {
        given:
        def member = new Member(mockTokenHolder, testConfig)

        when:
        def v1_1 = member.v1()
        def v1_2 = member.v1()

        then:
        v1_1 == v1_2
        v1_1.is(v1_2)
    }

    def "Member should extend BaseService"() {
        when:
        def member = new Member(mockTokenHolder, testConfig)

        then:
        member instanceof com.xiaoju.open.sdk.didies.service.BaseService
    }

    def "Member should store tokenHolder and config"() {
        when:
        def member = new Member(mockTokenHolder, testConfig)

        then:
        member.tokenHolder == mockTokenHolder
        member.config == testConfig
    }

    def "multiple Member instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def member1 = new Member(holder1, config1)
        def member2 = new Member(holder2, config2)

        then:
        member1.tokenHolder == holder1
        member2.tokenHolder == holder2
        member1.config.clientId == "client1"
        member2.config.clientId == "client2"
    }

    def "Member v1 should have access to parent config and tokenHolder"() {
        given:
        def member = new Member(mockTokenHolder, testConfig)
        def v1 = member.v1()

        expect:
        v1.config == testConfig
        v1.@config == testConfig
    }

    def "Member should work with different config values"() {
        given:
        def config = Config.builder()
                .clientId("different_client")
                .clientSecret("different_secret")
                .baseUrl("https://different.api.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .build()

        when:
        def member = new Member(mockTokenHolder, config)

        then:
        member.config.clientId == "different_client"
        member.config.clientSecret == "different_secret"
        member.config.baseUrl == "https://different.api.com"
        member.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
    }

    def "Member should handle null tokenHolder gracefully"() {
        when:
        def member = new Member(null, testConfig)

        then:
        member != null
        member.tokenHolder == null
    }

    def "Member should handle null config gracefully"() {
        when:
        def member = new Member(mockTokenHolder, null)

        then:
        member != null
        member.config == null
    }
}
