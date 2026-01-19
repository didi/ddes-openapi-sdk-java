package com.xiaoju.open.sdk.didies.core.enums

import spock.lang.Specification

class SignMethodEnumTest extends Specification {

    def "SignMethodEnum should have two values"() {
        expect:
        SignMethodEnum.values().length == 2
    }

    def "SignMethodEnum should contain MD5 and SHA256"() {
        expect:
        SignMethodEnum.values() as Set == [SignMethodEnum.MD5, SignMethodEnum.SHA256] as Set
    }

    def "MD5 should have correct signMethod value"() {
        expect:
        SignMethodEnum.MD5.signMethod == "MD5"
    }

    def "SHA256 should have correct signMethod value"() {
        expect:
        SignMethodEnum.SHA256.signMethod == "SHA256"
    }

    def "valueOf should return correct enum for valid name"() {
        expect:
        SignMethodEnum.valueOf("MD5") == SignMethodEnum.MD5
        SignMethodEnum.valueOf("SHA256") == SignMethodEnum.SHA256
    }

    def "valueOf should throw exception for invalid name"() {
        when:
        SignMethodEnum.valueOf("INVALID")

        then:
        thrown(IllegalArgumentException)
    }

    def "enum values should be in correct order"() {
        expect:
        SignMethodEnum.values()[0] == SignMethodEnum.MD5
        SignMethodEnum.values()[1] == SignMethodEnum.SHA256
    }

    def "all enum values should have non-null signMethod"() {
        expect:
        SignMethodEnum.values().every { it.signMethod != null }
    }

    def "all signMethods should be unique"() {
        expect:
        SignMethodEnum.values().collect { it.signMethod }.size() ==
            SignMethodEnum.values().collect { it.signMethod }.unique().size()
    }

    def "getter method should work for all enums"() {
        expect:
        SignMethodEnum.MD5.getSignMethod() == "MD5"
        SignMethodEnum.SHA256.getSignMethod() == "SHA256"
    }

    def "signMethod values should match standard algorithm names"() {
        expect:
        SignMethodEnum.MD5.signMethod.toUpperCase() == "MD5"
        SignMethodEnum.SHA256.signMethod.toUpperCase() == "SHA256"
    }
}
