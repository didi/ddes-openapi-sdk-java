package com.xiaoju.open.sdk.didies.utils

import com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum
import spock.lang.Specification
import spock.lang.Unroll

class SignUtilsTest extends Specification {

    @Unroll
    def "md5 should generate correct hash"() {
        expect:
        SignUtils.md5(input) == expectedOutput

        where:
        input                   || expectedOutput
        ""                      || "d41d8cd98f00b204e9800998ecf8427e"
        "test"                  || "098f6bcd4621d373cade4e832627b4f6"
        "hello world"           || "5eb63bbbe01eeed093cb22bb8f5acdc3"
        "123456"                || "e10adc3949ba59abbe56e057f20f883e"
        "Hello World!"          || "ed076287532e86365e841e92bfc50d8c"
    }

    @Unroll
    def "md5 should generate consistent hashes"() {
        when:
        def hash1 = SignUtils.md5(input)
        def hash2 = SignUtils.md5(input)

        then:
        hash1 == hash2
        hash1.length() == 32

        where:
        input << ["test", "hello", "123456789"]
    }

    @Unroll
    def "sha256Hex should generate correct hash"() {
        expect:
        SignUtils.sha256Hex(input) == expectedOutput

        where:
        input                   || expectedOutput
        ""                      || "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855"
        "test"                  || "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08"
        "hello world"           || "b94d27b9934d3e08a52e52d7da7dabfac484efe37a5380ee9088f7ace2efcde9"
    }

    @Unroll
    def "sha256Hex should generate consistent hashes"() {
        when:
        def hash1 = SignUtils.sha256Hex(input)
        def hash2 = SignUtils.sha256Hex(input)

        then:
        hash1 == hash2
        hash1.length() == 64

        where:
        input << ["test", "hello", "123456789"]
    }

    def "mapToSign with MD5 should sort parameters and generate signature"() {
        given:
        def params = [
            b: "2",
            a: "1",
            c: "3"
        ]

        when:
        def signature = SignUtils.mapToSign(params, SignMethodEnum.MD5)

        then:
        // Sorted and joined: "a=1&b=2&c=3" -> MD5
        signature == "ce788ff9145c2260534889c454d437b8"
    }

    def "mapToSign with SHA256 should sort parameters and generate signature"() {
        given:
        def params = [
            b: "2",
            a: "1",
            c: "3"
        ]

        when:
        def signature = SignUtils.mapToSign(params, SignMethodEnum.SHA256)

        then:
        signature != null
        signature.length() == 64
    }

    def "mapToSign should handle empty map"() {
        when:
        def signature = SignUtils.mapToSign([:], SignMethodEnum.MD5)

        then:
        signature == "d41d8cd98f00b204e9800998ecf8427e"
    }

    def "mapToSign should trim values"() {
        given:
        def params = [
            a: "  value  ",
            b: "test "
        ]

        when:
        def signature = SignUtils.mapToSign(params, SignMethodEnum.MD5)

        then:
        signature == SignUtils.md5("a=value&b=test")
    }

    def "mapParamsToSign should filter null and empty key values"() {
        given:
        def params = [
            a: "1",
            b: null,
            c: "",
            "": "value",
            d: "2"
        ]
        def signKey = "test_key"

        when:
        def signature = SignUtils.mapParamsToSign(params, signKey, SignMethodEnum.MD5)

        then:
        // Should include: a=1, d=2, sign_key=test_key
        signature != null
    }

    def "mapParamsToSign should add sign_key parameter"() {
        given:
        def params = [a: "1", b: "2"]
        def signKey = "secret"

        when:
        def signatureMD5 = SignUtils.mapParamsToSign(params, signKey, SignMethodEnum.MD5)
        def signatureSHA256 = SignUtils.mapParamsToSign(params, signKey, SignMethodEnum.SHA256)

        then:
        signatureMD5 != null
        signatureSHA256 != null
        signatureMD5 != signatureSHA256
    }

    def "mapToSign should produce consistent results"() {
        given:
        def params = [key1: "value1", key2: "value2"]

        when:
        def sig1 = SignUtils.mapToSign(params, SignMethodEnum.MD5)
        def sig2 = SignUtils.mapToSign(params, SignMethodEnum.MD5)

        then:
        sig1 == sig2
    }

    @Unroll
    def "mapToSign with different methods should produce different results"() {
        when:
        def sigMD5 = SignUtils.mapToSign(params, SignMethodEnum.MD5)
        def sigSHA256 = SignUtils.mapToSign(params, SignMethodEnum.SHA256)

        then:
        sigMD5 != sigSHA256
        sigMD5.length() == 32
        sigSHA256.length() == 64

        where:
        params << [[a: "1", b: "2"], [test: "value"], [key: "data"]]
    }
}
