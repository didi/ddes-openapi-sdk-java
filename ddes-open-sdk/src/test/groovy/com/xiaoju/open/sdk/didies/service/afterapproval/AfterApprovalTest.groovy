package com.xiaoju.open.sdk.didies.service.afterapproval

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.V1
import spock.lang.Specification

class AfterApprovalTest extends Specification {

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

    def "AfterApproval should create instance with tokenHolder and config"() {
        when:
        def afterApproval = new AfterApproval(mockTokenHolder, testConfig)

        then:
        afterApproval != null
        afterApproval.tokenHolder == mockTokenHolder
        afterApproval.config == testConfig
    }

    def "AfterApproval v1 method should return V1 instance"() {
        given:
        def afterApproval = new AfterApproval(mockTokenHolder, testConfig)

        when:
        def v1 = afterApproval.v1()

        then:
        v1 != null
        v1 instanceof V1
    }

    def "AfterApproval v1 method should return same instance on multiple calls"() {
        given:
        def afterApproval = new AfterApproval(mockTokenHolder, testConfig)

        when:
        def v1_1 = afterApproval.v1()
        def v1_2 = afterApproval.v1()

        then:
        v1_1 == v1_2
        v1_1.is(v1_2)
    }

    def "AfterApproval should extend BaseService"() {
        when:
        def afterApproval = new AfterApproval(mockTokenHolder, testConfig)

        then:
        afterApproval instanceof com.xiaoju.open.sdk.didies.service.BaseService
    }

    def "AfterApproval should store tokenHolder and config"() {
        when:
        def afterApproval = new AfterApproval(mockTokenHolder, testConfig)

        then:
        afterApproval.tokenHolder == mockTokenHolder
        afterApproval.config == testConfig
    }

    def "multiple AfterApproval instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def afterApproval1 = new AfterApproval(holder1, config1)
        def afterApproval2 = new AfterApproval(holder2, config2)

        then:
        afterApproval1.tokenHolder == holder1
        afterApproval2.tokenHolder == holder2
        afterApproval1.config.clientId == "client1"
        afterApproval2.config.clientId == "client2"
    }

    def "AfterApproval v1 should have access to parent config and tokenHolder"() {
        given:
        def afterApproval = new AfterApproval(mockTokenHolder, testConfig)
        def v1 = afterApproval.v1()

        expect:
        v1.config == testConfig
        v1.@config == testConfig
    }

    def "AfterApproval should work with different config values"() {
        given:
        def config = Config.builder()
                .clientId("different_client")
                .clientSecret("different_secret")
                .baseUrl("https://different.api.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .build()

        when:
        def afterApproval = new AfterApproval(mockTokenHolder, config)

        then:
        afterApproval.config.clientId == "different_client"
        afterApproval.config.clientSecret == "different_secret"
        afterApproval.config.baseUrl == "https://different.api.com"
        afterApproval.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
    }

    def "AfterApproval should handle null tokenHolder gracefully"() {
        when:
        def afterApproval = new AfterApproval(null, testConfig)

        then:
        afterApproval != null
        afterApproval.tokenHolder == null
    }

    def "AfterApproval should handle null config gracefully"() {
        when:
        def afterApproval = new AfterApproval(mockTokenHolder, null)

        then:
        afterApproval != null
        afterApproval.config == null
    }
}
