package com.xiaoju.open.sdk.didies.core.enums

import spock.lang.Specification
import spock.lang.Unroll

class EncryptTypeEnumTest extends Specification {

    def "EncryptTypeEnum should have three values"() {
        expect:
        EncryptTypeEnum.values().length == 3
    }

    def "EncryptTypeEnum should contain NORMAL, AES128, and AES256"() {
        expect:
        EncryptTypeEnum.values() as Set == [EncryptTypeEnum.NORMAL, EncryptTypeEnum.AES128, EncryptTypeEnum.AES256] as Set
    }

    @Unroll
    def "EncryptTypeEnum #enum should have correct type value"() {
        expect:
        encryptType.type == expectedType

        where:
        encryptType           | expectedType
        EncryptTypeEnum.NORMAL | 0
        EncryptTypeEnum.AES128 | 1
        EncryptTypeEnum.AES256 | 2
    }

    @Unroll
    def "EncryptTypeEnum #enum should have correct description"() {
        expect:
        encryptType.description == expectedDescription

        where:
        encryptType           | expectedDescription
        EncryptTypeEnum.NORMAL | "不加密"
        EncryptTypeEnum.AES128 | "aes 128"
        EncryptTypeEnum.AES256 | "aes 256"
    }

    def "NORMAL should have type 0"() {
        expect:
        EncryptTypeEnum.NORMAL.type == 0
        EncryptTypeEnum.NORMAL.description == "不加密"
    }

    def "AES128 should have type 1"() {
        expect:
        EncryptTypeEnum.AES128.type == 1
        EncryptTypeEnum.AES128.description == "aes 128"
    }

    def "AES256 should have type 2"() {
        expect:
        EncryptTypeEnum.AES256.type == 2
        EncryptTypeEnum.AES256.description == "aes 256"
    }

    def "valueOf should return correct enum for valid name"() {
        expect:
        EncryptTypeEnum.valueOf("NORMAL") == EncryptTypeEnum.NORMAL
        EncryptTypeEnum.valueOf("AES128") == EncryptTypeEnum.AES128
        EncryptTypeEnum.valueOf("AES256") == EncryptTypeEnum.AES256
    }

    def "valueOf should throw exception for invalid name"() {
        when:
        EncryptTypeEnum.valueOf("INVALID")

        then:
        thrown(IllegalArgumentException)
    }

    def "enum values should be in correct order"() {
        expect:
        EncryptTypeEnum.values()[0] == EncryptTypeEnum.NORMAL
        EncryptTypeEnum.values()[1] == EncryptTypeEnum.AES128
        EncryptTypeEnum.values()[2] == EncryptTypeEnum.AES256
    }

    def "all enum values should have non-null type and description"() {
        expect:
        EncryptTypeEnum.values().every { it.type != null }
        EncryptTypeEnum.values().every { it.description != null }
    }

    def "all types should be unique"() {
        expect:
        EncryptTypeEnum.values().collect { it.type }.size() ==
            EncryptTypeEnum.values().collect { it.type }.unique().size()
    }

    @Unroll
    def "getter methods should work for #enum"() {
        expect:
        encryptType.getType() != null
        encryptType.getDescription() != null

        where:
        encryptType << EncryptTypeEnum.values()
    }
}
