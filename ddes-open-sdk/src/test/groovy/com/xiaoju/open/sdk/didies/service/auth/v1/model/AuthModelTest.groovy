package com.xiaoju.open.sdk.didies.service.auth.v1.model

import spock.lang.Specification

class AuthModelTest extends Specification {

    // ==================== AuthorizeRequest Tests ====================
    def "AuthorizeRequest should create instance with builder"() {
        when:
        def request = AuthorizeRequest.builder()
                .clientSecret("secret123")
                .grantType("client_credentials")
                .build()

        then:
        request != null
        request.clientSecret == "secret123"
        request.grantType == "client_credentials"
    }

    def "AuthorizeRequest should create instance with no-args constructor"() {
        when:
        def request = new AuthorizeRequest()

        then:
        request != null
        request.clientSecret == null
        request.grantType == null
    }

    def "AuthorizeRequest should create instance with all-args constructor"() {
        when:
        def request = new AuthorizeRequest("my_secret", "password")

        then:
        request.clientSecret == "my_secret"
        request.grantType == "password"
    }

    def "AuthorizeRequest should have working getters and setters"() {
        given:
        def request = new AuthorizeRequest()

        when:
        request.setClientSecret("test_secret")
        request.setGrantType("test_grant")

        then:
        request.getClientSecret() == "test_secret"
        request.getGrantType() == "test_grant"
    }

    def "AuthorizeRequest should extend BaseReq"() {
        when:
        def request = new AuthorizeRequest()

        then:
        request instanceof com.xiaoju.open.sdk.didies.core.model.BaseReq
    }

    def "AuthorizeRequest should handle null values"() {
        when:
        def request = AuthorizeRequest.builder()
                .clientSecret(null)
                .grantType(null)
                .build()

        then:
        request.clientSecret == null
        request.grantType == null
    }

    def "AuthorizeRequest should handle empty strings"() {
        when:
        def request = AuthorizeRequest.builder()
                .clientSecret("")
                .grantType("")
                .build()

        then:
        request.clientSecret == ""
        request.grantType == ""
    }

    // ==================== AuthorizeApiReply Tests ====================
    def "AuthorizeApiReply should create instance with builder"() {
        when:
        def reply = AuthorizeApiReply.builder()
                .accessToken("token123")
                .expiresIn(3600)
                .tokenType("Bearer")
                .scope("read write")
                .errno(0)
                .errmsg("success")
                .build()

        then:
        reply != null
        reply.accessToken == "token123"
        reply.expiresIn == 3600
        reply.tokenType == "Bearer"
        reply.scope == "read write"
        reply.errno == 0
        reply.errmsg == "success"
    }

    def "AuthorizeApiReply should create instance with no-args constructor"() {
        when:
        def reply = new AuthorizeApiReply()

        then:
        reply != null
        reply.accessToken == null
        reply.expiresIn == null
        reply.tokenType == null
        reply.scope == null
    }

    def "AuthorizeApiReply should create instance with all fields"() {
        when:
        def reply = AuthorizeApiReply.builder()
                .accessToken("my_token")
                .expiresIn(7200)
                .tokenType("Bearer")
                .scope("all")
                .errno(0)
                .errmsg("ok")
                .build()

        then:
        reply.accessToken == "my_token"
        reply.expiresIn == 7200
        reply.tokenType == "Bearer"
        reply.scope == "all"
        reply.errno == 0
        reply.errmsg == "ok"
    }

    def "AuthorizeApiReply should have working getters and setters"() {
        given:
        def reply = new AuthorizeApiReply()

        when:
        reply.setAccessToken("new_token")
        reply.setExpiresIn(1800)
        reply.setTokenType("Basic")
        reply.setScope("admin")

        then:
        reply.getAccessToken() == "new_token"
        reply.getExpiresIn() == 1800
        reply.getTokenType() == "Basic"
        reply.getScope() == "admin"
    }

    def "AuthorizeApiReply should extend BaseResp"() {
        when:
        def reply = new AuthorizeApiReply()

        then:
        reply instanceof com.xiaoju.open.sdk.didies.core.model.BaseResp
    }

    def "AuthorizeApiReply should handle null values"() {
        when:
        def reply = AuthorizeApiReply.builder()
                .accessToken(null)
                .expiresIn(null)
                .tokenType(null)
                .scope(null)
                .build()

        then:
        reply.accessToken == null
        reply.expiresIn == null
        reply.tokenType == null
        reply.scope == null
    }

    def "AuthorizeApiReply should handle zero expiresIn"() {
        when:
        def reply = AuthorizeApiReply.builder()
                .expiresIn(0)
                .build()

        then:
        reply.expiresIn == 0
    }

    def "AuthorizeApiReply should handle negative expiresIn"() {
        when:
        def reply = AuthorizeApiReply.builder()
                .expiresIn(-1)
                .build()

        then:
        reply.expiresIn == -1
    }

    def "AuthorizeApiReply should handle long token strings"() {
        given:
        def longToken = "a" * 1000

        when:
        def reply = AuthorizeApiReply.builder()
                .accessToken(longToken)
                .build()

        then:
        reply.accessToken == longToken
    }

    def "AuthorizeApiReply should handle special characters in scope"() {
        when:
        def reply = AuthorizeApiReply.builder()
                .scope("read write admin:all user:profile")
                .build()

        then:
        reply.scope == "read write admin:all user:profile"
    }

    def "AuthorizeApiReply equals should work correctly"() {
        given:
        def reply1 = AuthorizeApiReply.builder().accessToken("token").build()
        def reply2 = AuthorizeApiReply.builder().accessToken("token").build()
        def reply3 = AuthorizeApiReply.builder().accessToken("other").build()

        expect:
        reply1 == reply2
        reply1 != reply3
    }

    def "AuthorizeRequest equals should work correctly"() {
        given:
        def req1 = AuthorizeRequest.builder().clientSecret("secret").build()
        def req2 = AuthorizeRequest.builder().clientSecret("secret").build()
        def req3 = AuthorizeRequest.builder().clientSecret("other").build()

        expect:
        req1 == req2
        req1 != req3
    }

    def "AuthorizeApiReply builder should support inheritance from BaseResp"() {
        when:
        def reply = AuthorizeApiReply.builder()
                .errno(401)
                .errmsg("unauthorized")
                .requestId("req-123")
                .accessToken("token")
                .build()

        then:
        reply.errno == 401
        reply.errmsg == "unauthorized"
        reply.requestId == "req-123"
        reply.accessToken == "token"
    }
}
