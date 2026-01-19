package com.xiaoju.open.sdk.didies.service.outapproval

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.outapproval.v1.V1
import spock.lang.Specification

class OutApprovalTest extends Specification {

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

    def "OutApproval should create instance with tokenHolder and config"() {
        when:
        def outApproval = new OutApproval(mockTokenHolder, testConfig)

        then:
        outApproval != null
        outApproval.tokenHolder == mockTokenHolder
        outApproval.config == testConfig
    }

    def "OutApproval v1 method should return V1 instance"() {
        given:
        def outApproval = new OutApproval(mockTokenHolder, testConfig)

        when:
        def v1 = outApproval.v1()

        then:
        v1 != null
        v1 instanceof V1
    }

    def "OutApproval v1 method should return same instance on multiple calls"() {
        given:
        def outApproval = new OutApproval(mockTokenHolder, testConfig)

        when:
        def v1_1 = outApproval.v1()
        def v1_2 = outApproval.v1()

        then:
        v1_1 == v1_2
        v1_1.is(v1_2)
    }

    def "OutApproval should extend BaseService"() {
        when:
        def outApproval = new OutApproval(mockTokenHolder, testConfig)

        then:
        outApproval instanceof com.xiaoju.open.sdk.didies.service.BaseService
    }

    def "OutApproval should store tokenHolder and config"() {
        when:
        def outApproval = new OutApproval(mockTokenHolder, testConfig)

        then:
        outApproval.tokenHolder == mockTokenHolder
        outApproval.config == testConfig
    }

    def "multiple OutApproval instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def outApproval1 = new OutApproval(holder1, config1)
        def outApproval2 = new OutApproval(holder2, config2)

        then:
        outApproval1.tokenHolder == holder1
        outApproval2.tokenHolder == holder2
        outApproval1.config.clientId == "client1"
        outApproval2.config.clientId == "client2"
    }

    def "OutApproval v1 should have access to parent config and tokenHolder"() {
        given:
        def outApproval = new OutApproval(mockTokenHolder, testConfig)
        def v1 = outApproval.v1()

        expect:
        v1.config == testConfig
        v1.@config == testConfig
    }

    def "OutApproval should work with different config values"() {
        given:
        def config = Config.builder()
                .clientId("different_client")
                .clientSecret("different_secret")
                .baseUrl("https://different.api.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .build()

        when:
        def outApproval = new OutApproval(mockTokenHolder, config)

        then:
        outApproval.config.clientId == "different_client"
        outApproval.config.clientSecret == "different_secret"
        outApproval.config.baseUrl == "https://different.api.com"
        outApproval.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
    }

    def "OutApproval should handle null tokenHolder gracefully"() {
        when:
        def outApproval = new OutApproval(null, testConfig)

        then:
        outApproval != null
        outApproval.tokenHolder == null
    }

    def "OutApproval should handle null config gracefully"() {
        when:
        def outApproval = new OutApproval(mockTokenHolder, null)

        then:
        outApproval != null
        outApproval.config == null
    }
}
