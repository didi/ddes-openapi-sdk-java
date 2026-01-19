package com.xiaoju.open.sdk.didies.utils

import spock.lang.Specification
import spock.lang.Unroll

class StringUtilsTest extends Specification {

    @Unroll
    def "isEmpty should return true for null or empty strings"() {
        expect:
        StringUtils.isEmpty(str) == result

        where:
        str     || result
        null    || true
        ""      || true
        " "     || false
        "test"  || false
    }

    @Unroll
    def "isNotEmpty should return false for null or empty strings"() {
        expect:
        StringUtils.isNotEmpty(str) == result

        where:
        str     || result
        null    || false
        ""      || false
        " "     || true
        "test"  || true
    }

    @Unroll
    def "join should join strings with separator"() {
        expect:
        StringUtils.join(list, separator) == result

        where:
        list                    | separator || result
        null                    | ","       || null
        []                      | ","       || null
        ["a", "b", "c"]         | ","       || "a,b,c"
        ["a", "b", "c"]         | "-"       || "a-b-c"
        ["a"]                   | ","       || "a"
        ["a", "b", "c"]         | null      || null
        ["a", "b", "c"]         | ""        || null
    }

    def "join should handle complex lists"() {
        given:
        def list = ["hello", "world", "test"]

        expect:
        StringUtils.join(list, "-") == "hello-world-test"
        StringUtils.join(list, ", ") == "hello, world, test"
    }

    def "isEmpty and isNotEmpty should be inverse of each other"() {
        expect:
        StringUtils.isEmpty(str) != StringUtils.isNotEmpty(str)

        where:
        str << [null, "", " ", "test", "123"]
    }
}
