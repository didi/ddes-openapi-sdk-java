package com.xiaoju.open.sdk.didies.service.budgetcenter

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.V1
import spock.lang.Specification

class BudgetCenterTest extends Specification {

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

    def "BudgetCenter should create instance with tokenHolder and config"() {
        when:
        def budgetCenter = new BudgetCenter(mockTokenHolder, testConfig)

        then:
        budgetCenter != null
        budgetCenter.tokenHolder == mockTokenHolder
        budgetCenter.config == testConfig
    }

    def "BudgetCenter v1 method should return V1 instance"() {
        given:
        def budgetCenter = new BudgetCenter(mockTokenHolder, testConfig)

        when:
        def v1 = budgetCenter.v1()

        then:
        v1 != null
        v1 instanceof V1
    }

    def "BudgetCenter v1 method should return same instance on multiple calls"() {
        given:
        def budgetCenter = new BudgetCenter(mockTokenHolder, testConfig)

        when:
        def v1_1 = budgetCenter.v1()
        def v1_2 = budgetCenter.v1()

        then:
        v1_1 == v1_2
        v1_1.is(v1_2)
    }

    def "BudgetCenter should extend BaseService"() {
        when:
        def budgetCenter = new BudgetCenter(mockTokenHolder, testConfig)

        then:
        budgetCenter instanceof com.xiaoju.open.sdk.didies.service.BaseService
    }

    def "BudgetCenter should store tokenHolder and config"() {
        when:
        def budgetCenter = new BudgetCenter(mockTokenHolder, testConfig)

        then:
        budgetCenter.tokenHolder == mockTokenHolder
        budgetCenter.config == testConfig
    }

    def "multiple BudgetCenter instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def budgetCenter1 = new BudgetCenter(holder1, config1)
        def budgetCenter2 = new BudgetCenter(holder2, config2)

        then:
        budgetCenter1.tokenHolder == holder1
        budgetCenter2.tokenHolder == holder2
        budgetCenter1.config.clientId == "client1"
        budgetCenter2.config.clientId == "client2"
    }

    def "BudgetCenter v1 should have access to parent config and tokenHolder"() {
        given:
        def budgetCenter = new BudgetCenter(mockTokenHolder, testConfig)
        def v1 = budgetCenter.v1()

        expect:
        v1.config == testConfig
        v1.@config == testConfig
    }

    def "BudgetCenter should work with different config values"() {
        given:
        def config = Config.builder()
                .clientId("different_client")
                .clientSecret("different_secret")
                .baseUrl("https://different.api.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .build()

        when:
        def budgetCenter = new BudgetCenter(mockTokenHolder, config)

        then:
        budgetCenter.config.clientId == "different_client"
        budgetCenter.config.clientSecret == "different_secret"
        budgetCenter.config.baseUrl == "https://different.api.com"
        budgetCenter.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
    }

    def "BudgetCenter should handle null tokenHolder gracefully"() {
        when:
        def budgetCenter = new BudgetCenter(null, testConfig)

        then:
        budgetCenter != null
        budgetCenter.tokenHolder == null
    }

    def "BudgetCenter should handle null config gracefully"() {
        when:
        def budgetCenter = new BudgetCenter(mockTokenHolder, null)

        then:
        budgetCenter != null
        budgetCenter.config == null
    }
}
