package com.xiaoju.open.sdk.didies.service.legalentity

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.legalentity.v1.V1
import spock.lang.Specification

class LegalEntityTest extends Specification {

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

    def "LegalEntity should create instance with tokenHolder and config"() {
        when:
        def legalEntity = new LegalEntity(mockTokenHolder, testConfig)

        then:
        legalEntity != null
        legalEntity.tokenHolder == mockTokenHolder
        legalEntity.config == testConfig
    }

    def "LegalEntity v1 method should return V1 instance"() {
        given:
        def legalEntity = new LegalEntity(mockTokenHolder, testConfig)

        when:
        def v1 = legalEntity.v1()

        then:
        v1 != null
        v1 instanceof V1
    }

    def "LegalEntity v1 method should return same instance on multiple calls"() {
        given:
        def legalEntity = new LegalEntity(mockTokenHolder, testConfig)

        when:
        def v1_1 = legalEntity.v1()
        def v1_2 = legalEntity.v1()

        then:
        v1_1 == v1_2
        v1_1.is(v1_2)
    }

    def "LegalEntity should extend BaseService"() {
        when:
        def legalEntity = new LegalEntity(mockTokenHolder, testConfig)

        then:
        legalEntity instanceof com.xiaoju.open.sdk.didies.service.BaseService
    }

    def "LegalEntity should store tokenHolder and config"() {
        when:
        def legalEntity = new LegalEntity(mockTokenHolder, testConfig)

        then:
        legalEntity.tokenHolder == mockTokenHolder
        legalEntity.config == testConfig
    }

    def "multiple LegalEntity instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def legalEntity1 = new LegalEntity(holder1, config1)
        def legalEntity2 = new LegalEntity(holder2, config2)

        then:
        legalEntity1.tokenHolder == holder1
        legalEntity2.tokenHolder == holder2
        legalEntity1.config.clientId == "client1"
        legalEntity2.config.clientId == "client2"
    }

    def "LegalEntity v1 should have access to parent config and tokenHolder"() {
        given:
        def legalEntity = new LegalEntity(mockTokenHolder, testConfig)
        def v1 = legalEntity.v1()

        expect:
        v1.config == testConfig
        v1.@config == testConfig
    }

    def "LegalEntity should work with different config values"() {
        given:
        def config = Config.builder()
                .clientId("different_client")
                .clientSecret("different_secret")
                .baseUrl("https://different.api.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .build()

        when:
        def legalEntity = new LegalEntity(mockTokenHolder, config)

        then:
        legalEntity.config.clientId == "different_client"
        legalEntity.config.clientSecret == "different_secret"
        legalEntity.config.baseUrl == "https://different.api.com"
        legalEntity.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
    }

    def "LegalEntity should handle null tokenHolder gracefully"() {
        when:
        def legalEntity = new LegalEntity(null, testConfig)

        then:
        legalEntity != null
        legalEntity.tokenHolder == null
    }

    def "LegalEntity should handle null config gracefully"() {
        when:
        def legalEntity = new LegalEntity(mockTokenHolder, null)

        then:
        legalEntity != null
        legalEntity.config == null
    }
}
