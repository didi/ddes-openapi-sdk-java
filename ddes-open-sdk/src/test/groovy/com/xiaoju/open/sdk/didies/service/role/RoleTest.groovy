package com.xiaoju.open.sdk.didies.service.role

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.role.v1.V1
import spock.lang.Specification

class RoleTest extends Specification {

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

    def "Role should create instance with tokenHolder and config"() {
        when:
        def role = new Role(mockTokenHolder, testConfig)

        then:
        role != null
        role.tokenHolder == mockTokenHolder
        role.config == testConfig
    }

    def "Role v1 method should return V1 instance"() {
        given:
        def role = new Role(mockTokenHolder, testConfig)

        when:
        def v1 = role.v1()

        then:
        v1 != null
        v1 instanceof V1
    }

    def "Role v1 method should return same instance on multiple calls"() {
        given:
        def role = new Role(mockTokenHolder, testConfig)

        when:
        def v1_1 = role.v1()
        def v1_2 = role.v1()

        then:
        v1_1 == v1_2
        v1_1.is(v1_2)
    }

    def "Role should extend BaseService"() {
        when:
        def role = new Role(mockTokenHolder, testConfig)

        then:
        role instanceof com.xiaoju.open.sdk.didies.service.BaseService
    }

    def "Role should store tokenHolder and config"() {
        when:
        def role = new Role(mockTokenHolder, testConfig)

        then:
        role.tokenHolder == mockTokenHolder
        role.config == testConfig
    }

    def "multiple Role instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def role1 = new Role(holder1, config1)
        def role2 = new Role(holder2, config2)

        then:
        role1.tokenHolder == holder1
        role2.tokenHolder == holder2
        role1.config.clientId == "client1"
        role2.config.clientId == "client2"
    }

    def "Role v1 should have access to parent config and tokenHolder"() {
        given:
        def role = new Role(mockTokenHolder, testConfig)
        def v1 = role.v1()

        expect:
        v1.config == testConfig
        v1.@config == testConfig
    }

    def "Role should work with different config values"() {
        given:
        def config = Config.builder()
                .clientId("different_client")
                .clientSecret("different_secret")
                .baseUrl("https://different.api.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .build()

        when:
        def role = new Role(mockTokenHolder, config)

        then:
        role.config.clientId == "different_client"
        role.config.clientSecret == "different_secret"
        role.config.baseUrl == "https://different.api.com"
        role.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
    }

    def "Role should handle null tokenHolder gracefully"() {
        when:
        def role = new Role(null, testConfig)

        then:
        role != null
        role.tokenHolder == null
    }

    def "Role should handle null config gracefully"() {
        when:
        def role = new Role(mockTokenHolder, null)

        then:
        role != null
        role.config == null
    }
}
