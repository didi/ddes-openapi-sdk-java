package com.xiaoju.open.sdk.didies.core.exception

import spock.lang.Specification

class ExceptionTest extends Specification {

    def "SystemException should be RuntimeException"() {
        expect:
        new SystemException("test") instanceof RuntimeException
    }

    def "SystemException should store message"() {
        given:
        def message = "Test system error"
        def exception = new SystemException(message)

        expect:
        exception.message == message
    }

    def "SystemException should be throwable"() {
        when:
        throw new SystemException("Test error")

        then:
        thrown(SystemException)
    }

    def "SystemException can be caught as RuntimeException"() {
        when:
        throw new SystemException("Test error")

        then:
        RuntimeException e = thrown()
        e.message == "Test error"
    }

    def "ServerTimeoutException should be RuntimeException"() {
        expect:
        new ServerTimeoutException() instanceof RuntimeException
    }

    def "ServerTimeoutException should have default message"() {
        given:
        def exception = new ServerTimeoutException()

        expect:
        exception.message == "请求响应超时！"
    }

    def "ServerTimeoutException should be throwable"() {
        when:
        throw new ServerTimeoutException()

        then:
        thrown(ServerTimeoutException)
    }

    def "ServerTimeoutException can be caught as RuntimeException"() {
        when:
        throw new ServerTimeoutException()

        then:
        RuntimeException e = thrown()
        e.message == "请求响应超时！"
    }

    def "DataEncryptException should be Exception"() {
        when:
        throw new DataEncryptException("Encryption failed")

        then:
        DataEncryptException e = thrown()
        e.message == "Encryption failed"
    }

    def "DataEncryptException can wrap cause"() {
        given:
        def cause = new RuntimeException("Root cause")

        when:
        throw new DataEncryptException("Encryption failed", cause)

        then:
        DataEncryptException e = thrown()
        e.message == "Encryption failed"
        e.cause == cause
    }

    def "DataDecryptException should be Exception"() {
        when:
        throw new DataDecryptException("Decryption failed")

        then:
        DataDecryptException e = thrown()
        e.message == "Decryption failed"
    }

    def "DataDecryptException can wrap cause"() {
        given:
        def cause = new RuntimeException("Root cause")

        when:
        throw new DataDecryptException("Decryption failed", cause)

        then:
        DataDecryptException e = thrown()
        e.message == "Decryption failed"
        e.cause == cause
    }

    def "AuthorizeException should be Exception"() {
        when:
        throw new AuthorizeException("Authorization failed")

        then:
        AuthorizeException e = thrown()
        e.message == "Authorization failed"
    }

    def "AccessTokenNotGivenException should be Exception"() {
        when:
        throw new AccessTokenNotGivenException()

        then:
        AccessTokenNotGivenException e = thrown()
        e.message == "未提供access_token！"
    }

    def "SystemException should have null cause when not specified"() {
        given:
        def exception = new SystemException("Test error")

        expect:
        exception.cause == null
    }

    def "multiple exceptions can be caught in same catch block"() {
        when:
        throw new SystemException("Test")

        then:
        Exception e = thrown()
        e instanceof SystemException
    }

    def "exception messages should be preserved through stack trace"() {
        given:
        def message = "Detailed error message"

        when:
        try {
            throw new SystemException(message)
        } catch (SystemException e) {
            throw e
        }

        then:
        SystemException e = thrown()
        e.message == message
    }
}
