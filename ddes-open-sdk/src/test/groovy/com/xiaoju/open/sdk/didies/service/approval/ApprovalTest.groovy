package com.xiaoju.open.sdk.didies.service.approval

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.approval.v1.V1
import spock.lang.Specification

class ApprovalTest extends Specification {

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

    def "Approval should create instance with tokenHolder and config"() {
        when:
        def approval = new Approval(mockTokenHolder, testConfig)

        then:
        approval != null
        approval.tokenHolder == mockTokenHolder
        approval.config == testConfig
    }

    def "Approval v1 method should return V1 instance"() {
        given:
        def approval = new Approval(mockTokenHolder, testConfig)

        when:
        def v1 = approval.v1()

        then:
        v1 != null
        v1 instanceof V1
    }

    def "Approval v1 method should return same instance on multiple calls"() {
        given:
        def approval = new Approval(mockTokenHolder, testConfig)

        when:
        def v1_1 = approval.v1()
        def v1_2 = approval.v1()

        then:
        v1_1 == v1_2
        v1_1.is(v1_2)
    }

    def "Approval should extend BaseService"() {
        when:
        def approval = new Approval(mockTokenHolder, testConfig)

        then:
        approval instanceof com.xiaoju.open.sdk.didies.service.BaseService
    }

    def "Approval should store tokenHolder and config"() {
        when:
        def approval = new Approval(mockTokenHolder, testConfig)

        then:
        approval.tokenHolder == mockTokenHolder
        approval.config == testConfig
    }

    def "multiple Approval instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def approval1 = new Approval(holder1, config1)
        def approval2 = new Approval(holder2, config2)

        then:
        approval1.tokenHolder == holder1
        approval2.tokenHolder == holder2
        approval1.config.clientId == "client1"
        approval2.config.clientId == "client2"
    }

    def "Approval v1 should have access to parent config and tokenHolder"() {
        given:
        def approval = new Approval(mockTokenHolder, testConfig)
        def v1 = approval.v1()

        expect:
        v1.config == testConfig
        v1.@config == testConfig
    }

    def "Approval should work with different config values"() {
        given:
        def config = Config.builder()
                .clientId("different_client")
                .clientSecret("different_secret")
                .baseUrl("https://different.api.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .build()

        when:
        def approval = new Approval(mockTokenHolder, config)

        then:
        approval.config.clientId == "different_client"
        approval.config.clientSecret == "different_secret"
        approval.config.baseUrl == "https://different.api.com"
        approval.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
    }

    def "Approval should handle null tokenHolder gracefully"() {
        when:
        def approval = new Approval(null, testConfig)

        then:
        approval != null
        approval.tokenHolder == null
    }

    def "Approval should handle null config gracefully"() {
        when:
        def approval = new Approval(mockTokenHolder, null)

        then:
        approval != null
        approval.config == null
    }
}
