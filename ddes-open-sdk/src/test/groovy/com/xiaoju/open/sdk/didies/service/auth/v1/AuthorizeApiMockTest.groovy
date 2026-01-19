package com.xiaoju.open.sdk.didies.service.auth.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.auth.v1.model.AuthorizeApiReply
import com.xiaoju.open.sdk.didies.service.auth.v1.model.AuthorizeRequest
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for Auth V1
 * Tests the authorize endpoint with proper request/response validation
 */
class AuthorizeApiMockTest extends BaseMockTest {

    def "authorize should send POST request with correct parameters"() {
        given: "A mock success response for authorize"
        def responseData = """{
            "access_token": "test_access_token_12345",
            "expires_in": 7200,
            "token_type": "Bearer"
        }"""
        mockWebServer.enqueue(new okhttp3.mockwebserver.MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(createSuccessResponse(responseData)))

        and: "Create authorize request"
        AuthorizeRequest request = AuthorizeRequest.builder()
                .grantType("client_credentials")
                .build()

        when: "Call authorize API"
        AuthorizeApiReply response = apiClient.auth().v1().authorize(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be sent to correct path"
        RecordedRequest recordedRequest = mockWebServer.takeRequest()
        verifyPath(recordedRequest, "/river/Auth/authorize")

        and: "Request should be POST method"
        recordedRequest.method == "POST"

        and: "Request should have required headers"
        verifyRequiredHeaders(recordedRequest)

        and: "Request should contain grant_type"
        def body = getRequestBody(recordedRequest)
        body.contains("grant_type")
        body.contains("client_credentials")
    }

    def "authorize should include client_secret when provided"() {
        given: "A mock success response"
        def responseData = """{
            "access_token": "test_access_token_12345",
            "expires_in": 7200
        }"""
        mockWebServer.enqueue(new okhttp3.mockwebserver.MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(createSuccessResponse(responseData)))

        and: "Create authorize request with client_secret"
        AuthorizeRequest request = AuthorizeRequest.builder()
                .grantType("client_credentials")
                .clientSecret("test_client_secret")
                .build()

        when: "Call authorize API"
        apiClient.auth().v1().authorize(request)

        then: "Request should include client_secret"
        RecordedRequest recordedRequest = mockWebServer.takeRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("client_secret")
        body.contains("test_client_secret")
    }

    def "authorize should send JSON content type"() {
        given: "A mock success response"
        mockWebServer.enqueue(new okhttp3.mockwebserver.MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(createSuccessResponse("{}")))

        and: "Create authorize request"
        AuthorizeRequest request = AuthorizeRequest.builder()
                .grantType("client_credentials")
                .build()

        when: "Call authorize API"
        apiClient.auth().v1().authorize(request)

        then: "Request should have JSON content type"
        RecordedRequest recordedRequest = mockWebServer.takeRequest()
        recordedRequest.getHeader("Content-Type").startsWith("application/json")
    }

    def "authorize should include all required parameters"() {
        given: "A mock success response"
        mockWebServer.enqueue(new okhttp3.mockwebserver.MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(createSuccessResponse("{}")))

        and: "Create authorize request"
        AuthorizeRequest request = AuthorizeRequest.builder()
                .grantType("client_credentials")
                .build()

        when: "Call authorize API"
        apiClient.auth().v1().authorize(request)

        then: "Request should contain all required parameters"
        RecordedRequest recordedRequest = mockWebServer.takeRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("client_id")
        body.contains("test_client_id")
        body.contains("sign")
        body.contains("timestamp")
    }
}
