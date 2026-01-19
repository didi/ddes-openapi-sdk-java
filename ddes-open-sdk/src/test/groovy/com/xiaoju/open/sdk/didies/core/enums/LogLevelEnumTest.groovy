package com.xiaoju.open.sdk.didies.core.enums

import spock.lang.Specification

class LogLevelEnumTest extends Specification {

    def "LogLevelEnum should have two values"() {
        expect:
        LogLevelEnum.values().length == 2
    }

    def "LogLevelEnum should contain DEBUG and INFO"() {
        expect:
        LogLevelEnum.values() as Set == [LogLevelEnum.DEBUG, LogLevelEnum.INFO] as Set
    }

    def "DEBUG should have correct level value"() {
        expect:
        LogLevelEnum.DEBUG.level == "debug"
    }

    def "INFO should have correct level value"() {
        expect:
        LogLevelEnum.INFO.level == "info"
    }

    def "valueOf should return correct enum for valid name"() {
        expect:
        LogLevelEnum.valueOf("DEBUG") == LogLevelEnum.DEBUG
        LogLevelEnum.valueOf("INFO") == LogLevelEnum.INFO
    }

    def "valueOf should throw exception for invalid name"() {
        when:
        LogLevelEnum.valueOf("INVALID")

        then:
        thrown(IllegalArgumentException)
    }

    def "enum values should be in correct order"() {
        expect:
        LogLevelEnum.values()[0] == LogLevelEnum.DEBUG
        LogLevelEnum.values()[1] == LogLevelEnum.INFO
    }

    def "all enum values should have non-null level"() {
        expect:
        LogLevelEnum.values().every { it.level != null }
    }

    def "all levels should be unique"() {
        expect:
        LogLevelEnum.values().collect { it.level }.size() ==
            LogLevelEnum.values().collect { it.level }.unique().size()
    }

    def "getter method should work for all enums"() {
        expect:
        LogLevelEnum.DEBUG.getLevel() == "debug"
        LogLevelEnum.INFO.getLevel() == "info"
    }

    def "level values should be lowercase"() {
        expect:
        LogLevelEnum.DEBUG.level == LogLevelEnum.DEBUG.level.toLowerCase()
        LogLevelEnum.INFO.level == LogLevelEnum.INFO.level.toLowerCase()
    }
}
