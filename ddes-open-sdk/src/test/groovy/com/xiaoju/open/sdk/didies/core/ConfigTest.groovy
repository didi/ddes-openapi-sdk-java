package com.xiaoju.open.sdk.didies.core

import com.xiaoju.open.sdk.didies.core.enums.EncryptTypeEnum
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum
import com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum
import com.xiaoju.open.sdk.didies.core.request.IHttpTransport
import spock.lang.Specification
import spock.lang.Unroll

import java.util.concurrent.TimeUnit

class ConfigTest extends Specification {

    def "Config builder should create config with default values"() {
        when:
        def config = Config.builder().build()

        then:
        config != null
        // Lombok @Builder doesn't use field initialization defaults
        config.getClientId() == null
        config.getClientSecret() == null
        config.getBaseUrl() == null
        config.getGrantType() == null
        config.getUnauthorizedRetryTimes() == null
        config.getUnauthorizedRetryInterval() == null
        config.getConnectTimeout() == null
        config.getCallTimeOut() == null
        config.getTimeoutUnit() == null
        config.getSignMethod() == null
        config.getEnableHoldToken() == null
        config.getEnableAES() == null
        config.getEncryptType() == null
    }

    def "Config builder should set custom values"() {
        when:
        def config = Config.builder()
                .clientId("test_client")
                .clientSecret("test_secret")
                .signKey("test_sign_key")
                .baseUrl("https://custom.api.com")
                .grantType("custom_grant")
                .unauthorizedRetryTimes(5)
                .unauthorizedRetryInterval(2000)
                .connectTimeout(5000L)
                .callTimeOut(10000L)
                .timeoutUnit(TimeUnit.SECONDS)
                .signMethod(SignMethodEnum.SHA256)
                .enableHoldToken(false)
                .enableRequestLog(true)
                .logLevel(LogLevelEnum.DEBUG)
                .enableAES(true)
                .aesKey("test_aes_key")
                .encryptType(EncryptTypeEnum.AES128)
                .build()

        then:
        config.getClientId() == "test_client"
        config.getClientSecret() == "test_secret"
        config.getSignKey() == "test_sign_key"
        config.getBaseUrl() == "https://custom.api.com"
        config.getGrantType() == "custom_grant"
        config.getUnauthorizedRetryTimes() == 5
        config.getUnauthorizedRetryInterval() == 2000
        config.getConnectTimeout() == 5000L
        config.getCallTimeOut() == 10000L
        config.getTimeoutUnit() == TimeUnit.SECONDS
        config.getSignMethod() == SignMethodEnum.SHA256
        config.getEnableHoldToken() == false
        config.getEnableRequestLog() == true
        config.getLogLevel() == LogLevelEnum.DEBUG
        config.getEnableAES() == true
        config.getAesKey() == "test_aes_key"
        config.getEncryptType() == EncryptTypeEnum.AES128
    }

    def "getHttpTransport should return custom transport if set"() {
        given:
        def customTransport = Mock(IHttpTransport)
        def config = Config.builder()
                .httpTransport(customTransport)
                .build()

        when:
        def transport = config.getHttpTransport()

        then:
        transport == customTransport
    }

    def "getHttpTransport should create default transport if not set"() {
        given:
        def config = Config.builder().build()

        when:
        def transport = config.getHttpTransport()

        then:
        transport != null
        transport instanceof com.xiaoju.open.sdk.didies.core.request.RestHttpTransport
    }

    def "getHttpTransport should cache the created transport"() {
        given:
        def config = Config.builder().build()

        when:
        def transport1 = config.getHttpTransport()
        def transport2 = config.getHttpTransport()

        then:
        transport1 == transport2
        transport1.is(transport2)
    }

    def "equals should exclude httpTransport"() {
        given:
        def transport1 = Mock(IHttpTransport)
        def transport2 = Mock(IHttpTransport)

        def config1 = Config.builder()
                .clientId("test")
                .httpTransport(transport1)
                .build()

        def config2 = Config.builder()
                .clientId("test")
                .httpTransport(transport2)
                .build()

        expect:
        config1 == config2
    }

    def "equals should return false for different configurations"() {
        given:
        def config1 = Config.builder()
                .clientId("client1")
                .build()

        def config2 = Config.builder()
                .clientId("client2")
                .build()

        expect:
        config1 != config2
    }

    def "equals should return true for same configuration"() {
        given:
        def config1 = Config.builder()
                .clientId("test")
                .clientSecret("secret")
                .build()

        def config2 = Config.builder()
                .clientId("test")
                .clientSecret("secret")
                .build()

        expect:
        config1 == config2
    }

    def "hashCode should be consistent with equals"() {
        given:
        def config1 = Config.builder()
                .clientId("test")
                .clientSecret("secret")
                .build()

        def config2 = Config.builder()
                .clientId("test")
                .clientSecret("secret")
                .build()

        expect:
        config1.hashCode() == config2.hashCode()
    }

    def "should handle all enum types"() {
        when:
        def config = Config.builder()
                .signMethod(SignMethodEnum.MD5)
                .encryptType(EncryptTypeEnum.AES256)
                .logLevel(LogLevelEnum.INFO)
                .timeoutUnit(TimeUnit.SECONDS)
                .build()

        then:
        config.getSignMethod() == SignMethodEnum.MD5
        config.getEncryptType() == EncryptTypeEnum.AES256
        config.getLogLevel() == LogLevelEnum.INFO
        config.getTimeoutUnit() == TimeUnit.SECONDS
    }

    def "builder should create independent instances"() {
        given:
        def config1 = Config.builder()
                .clientId("client1")
                .build()

        def config2 = Config.builder()
                .clientId("client2")
                .build()

        expect:
        config1.getClientId() == "client1"
        config2.getClientId() == "client2"
        config1 != config2
    }

    def "should handle null values in optional fields"() {
        when:
        def config = Config.builder()
                .clientId("test")
                .clientSecret(null)
                .signKey(null)
                .aesKey(null)
                .build()

        then:
        config.getClientId() == "test"
        config.getClientSecret() == null
        config.getSignKey() == null
        config.getAesKey() == null
    }

    @Unroll
    def "should validate timeout values - #field"() {
        when:
        def config = Config.builder()
                ."$field"(value)
                .build()

        then:
        config."$getter"() == value

        where:
        field             | value   | getter
        "connectTimeout" | 1000L   | "getConnectTimeout"
        "callTimeOut"     | 5000L   | "getCallTimeOut"
        "connectTimeout" | 0L      | "getConnectTimeout"
        "callTimeOut"     | 0L      | "getCallTimeOut"
    }

    def "should handle retry configuration"() {
        when:
        def config = Config.builder()
                .unauthorizedRetryTimes(3)
                .unauthorizedRetryInterval(500)
                .build()

        then:
        config.getUnauthorizedRetryTimes() == 3
        config.getUnauthorizedRetryInterval() == 500
    }

    def "should handle boolean configuration"() {
        when:
        def config = Config.builder()
                .enableHoldToken(true)
                .enableRequestLog(true)
                .enableAES(true)
                .build()

        then:
        config.getEnableHoldToken() == true
        config.getEnableRequestLog() == true
        config.getEnableAES() == true
    }

    def "should allow setting values to null"() {
        when:
        def config = Config.builder()
                .clientId(null)
                .baseUrl(null)
                .signKey(null)
                .build()

        then:
        config.getClientId() == null
        config.getBaseUrl() == null
        config.getSignKey() == null
    }
}
