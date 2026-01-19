package com.xiaoju.open.sdk.didies.service.login

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.service.login.v1.V1
import spock.lang.Specification

class LoginTest extends Specification {

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

    def "Login should create instance with tokenHolder and config"() {
        when:
        def login = new Login(mockTokenHolder, testConfig)

        then:
        login != null
        login.tokenHolder == mockTokenHolder
        login.config == testConfig
    }

    def "Login v1 method should return V1 instance"() {
        given:
        def login = new Login(mockTokenHolder, testConfig)

        when:
        def v1 = login.v1()

        then:
        v1 != null
        v1 instanceof V1
    }

    def "Login v1 method should return same instance on multiple calls"() {
        given:
        def login = new Login(mockTokenHolder, testConfig)

        when:
        def v1_1 = login.v1()
        def v1_2 = login.v1()

        then:
        v1_1 == v1_2
        v1_1.is(v1_2)
    }

    def "Login should extend BaseService"() {
        when:
        def login = new Login(mockTokenHolder, testConfig)

        then:
        login instanceof com.xiaoju.open.sdk.didies.service.BaseService
    }

    def "Login should store tokenHolder and config"() {
        when:
        def login = new Login(mockTokenHolder, testConfig)

        then:
        login.tokenHolder == mockTokenHolder
        login.config == testConfig
    }

    def "multiple Login instances should be independent"() {
        given:
        def holder1 = Mock(ITokenHolder)
        def holder2 = Mock(ITokenHolder)
        def config1 = Config.builder().clientId("client1").build()
        def config2 = Config.builder().clientId("client2").build()

        when:
        def login1 = new Login(holder1, config1)
        def login2 = new Login(holder2, config2)

        then:
        login1.tokenHolder == holder1
        login2.tokenHolder == holder2
        login1.config.clientId == "client1"
        login2.config.clientId == "client2"
    }

    def "Login v1 should have access to parent config and tokenHolder"() {
        given:
        def login = new Login(mockTokenHolder, testConfig)
        def v1 = login.v1()

        expect:
        v1.config == testConfig
        v1.@config == testConfig
    }

    def "Login should work with different config values"() {
        given:
        def config = Config.builder()
                .clientId("different_client")
                .clientSecret("different_secret")
                .baseUrl("https://different.api.com")
                .signMethod(com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256)
                .build()

        when:
        def login = new Login(mockTokenHolder, config)

        then:
        login.config.clientId == "different_client"
        login.config.clientSecret == "different_secret"
        login.config.baseUrl == "https://different.api.com"
        login.config.signMethod == com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum.SHA256
    }

    def "Login should handle null tokenHolder gracefully"() {
        when:
        def login = new Login(null, testConfig)

        then:
        login != null
        login.tokenHolder == null
    }

    def "Login should handle null config gracefully"() {
        when:
        def login = new Login(mockTokenHolder, null)

        then:
        login != null
        login.config == null
    }
}
