package com.xiaoju.open.sdk.didies.core

import spock.lang.Specification

class ConstantsTest extends Specification {

    def "VERSION should be defined"() {
        expect:
        Constants.VERSION == "1.0.0"
    }

    def "USER_AGENT should be defined"() {
        expect:
        Constants.USER_AGENT == "User-Agent"
    }

    def "DIDI_AGENT should contain version"() {
        expect:
        Constants.DIDI_AGENT == "didies-open-sdk-java/1.0.0"
        Constants.DIDI_AGENT.contains(Constants.VERSION)
    }

    def "INVALID_ACCESS_TOKEN_CODE should be 401"() {
        expect:
        Constants.INVALID_ACCESS_TOKEN_CODE == 401
    }

    def "AUTH_URI should be defined"() {
        expect:
        Constants.AUTH_URI == "/river/Auth/authorize"
    }

    def "OBJECT_SUFFIX should be defined"() {
        expect:
        Constants.OBJECT_SUFFIX == "__obj__"
    }

    def "BASE_REQ_NAMES should be accessible"() {
        expect:
        Constants.BASE_REQ_NAMES != null
    }

    def "BaseReqName should contain all required fields"() {
        expect:
        Constants.BASE_REQ_NAMES.ACCESS_TOKEN == "access_token"
        Constants.BASE_REQ_NAMES.CLIENT_ID == "client_id"
        Constants.BASE_REQ_NAMES.TIMESTAMP == "timestamp"
        Constants.BASE_REQ_NAMES.SIGN == "sign"
        Constants.BASE_REQ_NAMES.ENCRYPT_CONTENT == "encrypt_content"
        Constants.BASE_REQ_NAMES.ENT == "ent"
    }

    def "Constants should not be instantiable"() {
        when:
        def constructor = Constants.getDeclaredConstructor()
        constructor.setAccessible(true)
        constructor.newInstance()

        then:
        thrown(Exception) // Abstract class cannot be instantiated
    }

    def "BaseReqName should be instantiable"() {
        when:
        def baseReqName = new Constants.BaseReqName()

        then:
        baseReqName != null
        baseReqName instanceof Constants.BaseReqName
    }

    def "all constant values should be immutable"() {
        expect:
        // These are final, so trying to reassign should not be possible
        Constants.VERSION.getClass() == String
        Constants.INVALID_ACCESS_TOKEN_CODE.getClass() == Integer
    }

    def "DIDI_AGENT format should be correct"() {
        expect:
        Constants.DIDI_AGENT.startsWith("didies-open-sdk-java/")
        Constants.DIDI_AGENT.endsWith("/" + Constants.VERSION)
    }

    def "all BaseReqName fields should be strings"() {
        expect:
        Constants.BASE_REQ_NAMES.ACCESS_TOKEN instanceof String
        Constants.BASE_REQ_NAMES.CLIENT_ID instanceof String
        Constants.BASE_REQ_NAMES.TIMESTAMP instanceof String
        Constants.BASE_REQ_NAMES.SIGN instanceof String
        Constants.BASE_REQ_NAMES.ENCRYPT_CONTENT instanceof String
        Constants.BASE_REQ_NAMES.ENT instanceof String
    }

    def "constant values should not be empty"() {
        expect:
        !Constants.VERSION.isEmpty()
        !Constants.USER_AGENT.isEmpty()
        !Constants.DIDI_AGENT.isEmpty()
        !Constants.AUTH_URI.isEmpty()
        !Constants.OBJECT_SUFFIX.isEmpty()
    }

    def "AUTH_URI should start with slash"() {
        expect:
        Constants.AUTH_URI.startsWith("/")
    }

    def "OBJECT_SUFFIX should contain double underscores"() {
        expect:
        Constants.OBJECT_SUFFIX.contains("__")
    }
}
