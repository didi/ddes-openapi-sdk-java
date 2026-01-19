package com.xiaoju.open.sdk.didies.core

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.core.exception.AuthorizeException
import com.xiaoju.open.sdk.didies.service.auth.v1.model.AuthorizeApiReply
import com.xiaoju.open.sdk.didies.service.auth.v1.model.AuthorizeRequest
import spock.lang.Specification

import java.util.concurrent.TimeUnit

class LocalTokenHolderTest extends Specification {

    ApiClient apiClient
    Config testConfig

    def setup() {
        testConfig = Config.builder()
                .clientId("test_client")
                .clientSecret("test_secret")
                .baseUrl("https://test.api.com")
                .build()
        apiClient = new ApiClient(testConfig)
    }

    // Helper method to invoke package-private setAccessTokenResult method
    def setAccessTokenResult(LocalTokenHolder holder, AuthorizeApiReply reply) {
        def method = LocalTokenHolder.getDeclaredMethod("setAccessTokenResult", AuthorizeApiReply)
        method.setAccessible(true)
        method.invoke(holder, reply)
    }

    // Helper method to directly set the generateAccessTokenTime field
    def setGenerateAccessTokenTime(LocalTokenHolder holder, long time) {
        def field = LocalTokenHolder.getDeclaredField("generateAccessTokenTime")
        field.setAccessible(true)
        field.setLong(holder, time)
    }

    def "getAccessToken should return cached token if not expired"() {
        given:
        def holder = new LocalTokenHolder(apiClient)
        def reply = new AuthorizeApiReply()
        reply.setAccessToken("test_token")
        reply.setExpiresIn(1800)

        setAccessTokenResult(holder, reply)

        when:
        def token = holder.getAccessToken()

        then:
        token == "test_token"
    }

    def "isExpired should return true when token is old"() {
        given:
        def holder = new LocalTokenHolder(apiClient)
        def reply = new AuthorizeApiReply()
        reply.setAccessToken("test_token")
        reply.setExpiresIn(1800)

        setAccessTokenResult(holder, reply)
        // Manually set the generation time to more than TOKEN_TIMEOUT (1800000ms) in the past
        setGenerateAccessTokenTime(holder, System.currentTimeMillis() - 2000000)

        expect:
        holder.isExpired()
    }

    def "isExpired should return false for fresh token"() {
        given:
        def holder = new LocalTokenHolder(apiClient)
        def reply = new AuthorizeApiReply()
        reply.setAccessToken("test_token")
        reply.setExpiresIn(1800)

        setAccessTokenResult(holder, reply)

        expect:
        !holder.isExpired()
    }

    def "should handle token with max expires in"() {
        given:
        def holder = new LocalTokenHolder(apiClient)
        def reply = new AuthorizeApiReply()
        reply.setAccessToken("test_token")
        reply.setExpiresIn(Integer.MAX_VALUE)

        setAccessTokenResult(holder, reply)

        expect:
        !holder.isExpired()
        holder.getAccessToken() == "test_token"
    }

    def "should handle token with min expires in"() {
        given:
        def holder = new LocalTokenHolder(apiClient)
        def reply = new AuthorizeApiReply()
        reply.setAccessToken("test_token")
        reply.setExpiresIn(1)

        setAccessTokenResult(holder, reply)

        // With expiresIn=1, generateAccessTokenTime is set to ~30 minutes ago
        // But the token is only expired when more than 30 minutes have passed
        // So we need to manually set it to be older than TOKEN_TIMEOUT
        setGenerateAccessTokenTime(holder, System.currentTimeMillis() - 1810000)

        expect:
        holder.isExpired()
    }

    def "setAccessTokenResult should set token and generation time"() {
        given:
        def holder = new LocalTokenHolder(apiClient)
        def reply = new AuthorizeApiReply()
        reply.setAccessToken("new_token")
        reply.setExpiresIn(3600)

        when:
        setAccessTokenResult(holder, reply)

        then:
        holder.getAccessToken() == "new_token"
        // The generateAccessTokenTime is calculated as:
        // currentTime - (DEFAULT_EXPIRES_IN - expiresIn) * 1000
        // For expiresIn=3600: currentTime - (1800 - 3600) * 1000 = currentTime + 1800000
        // So it should be in the future
        holder.generateAccessTokenTime > System.currentTimeMillis() - 2000
    }

    def "should store and retrieve access token"() {
        given:
        def holder = new LocalTokenHolder(apiClient)
        def reply = new AuthorizeApiReply()
        reply.setAccessToken("stored_token")
        reply.setExpiresIn(1800)

        when:
        setAccessTokenResult(holder, reply)

        then:
        holder.getAccessToken() == "stored_token"
    }

    def "isExpired should calculate correctly based on generation time"() {
        given:
        def holder = new LocalTokenHolder(apiClient)
        def reply = new AuthorizeApiReply()
        reply.setAccessToken("test")
        reply.setExpiresIn(1800)

        setAccessTokenResult(holder, reply)
        def currentTime = System.currentTimeMillis()

        when:
        def isExpired = holder.isExpired()

        then:
        // Token should not be expired just after creation
        !isExpired

        and:
        // Check that the calculation is based on generation time
        def timeSinceGeneration = currentTime - holder.generateAccessTokenTime
        timeSinceGeneration < 1800000 // Less than 30 minutes in milliseconds
    }
}
