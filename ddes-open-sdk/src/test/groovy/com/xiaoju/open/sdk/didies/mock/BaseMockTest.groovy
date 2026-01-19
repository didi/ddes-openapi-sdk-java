package com.xiaoju.open.sdk.didies.mock

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.ITokenHolder
import com.xiaoju.open.sdk.didies.core.request.OkHttpTransport
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import spock.lang.Specification
import java.util.concurrent.TimeUnit
import java.net.URLDecoder

/**
 * Base class for mock server tests
 * Provides common setup and utilities for testing HTTP requests with automatic token management
 */
abstract class BaseMockTest extends Specification {

    MockWebServer mockWebServer
    Config testConfig
    ApiClient apiClient
    ITokenHolder tokenHolder

    def setup() {
        // Create and start mock server
        mockWebServer = new MockWebServer()
        mockWebServer.start()

        // Create config with mock server URL and OkHttp transport
        testConfig = Config.builder()
                .clientId("test_client_id")
                .clientSecret("test_client_secret")
                .signKey("test_sign_key")
                .baseUrl("http://localhost:" + mockWebServer.port)
                .enableHoldToken(true)
                .httpTransport(new OkHttpTransport())
                .build()

        // Create API client
        apiClient = new ApiClient(testConfig)
        tokenHolder = apiClient.@tokenHolder

        // Mock the authorize endpoint to return a valid token
        mockAuthEndpoint()
    }

    def cleanup() {
        // Shutdown mock server after each test
        mockWebServer.shutdown()
    }

    /**
     * Mock the auth endpoint to return a valid access token
     * This is called automatically in setup() so tests don't need to worry about authentication
     * Note: Authorize API has a different response format - fields are at root level, not in data object
     */
    protected void mockAuthEndpoint() {
        def authResponse = """{
            "errno": 0,
            "errmsg": "success",
            "request_id": "test_auth_request_id",
            "access_token": "test_access_token_12345",
            "expires_in": 7200,
            "token_type": "Bearer"
        }"""
        enqueueAuthResponse(authResponse)
    }

    /**
     * Enqueue a mock response for the auth endpoint
     */
    protected void enqueueAuthResponse(String responseJson) {
        MockResponse response = new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(responseJson)
        mockWebServer.enqueue(response)
    }

    /**
     * Enqueue a mock success response for business APIs
     */
    protected void enqueueSuccess(String responseJson) {
        MockResponse response = new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(responseJson)
        mockWebServer.enqueue(response)
    }

    /**
     * Create a successful response with the given data
     */
    protected String createSuccessResponse(String dataJson = "{}") {
        return """{
            "errno": 0,
            "errmsg": "success",
            "request_id": "test_request_id",
            "data": ${dataJson}
        }"""
    }

    /**
     * Create a response without data field (for some APIs)
     */
    protected String createBaseResponse(Integer errno, String errmsg) {
        return """{
            "errno": ${errno},
            "errmsg": "${errmsg}",
            "request_id": "test_request_id"
        }"""
    }

    /**
     * Create an error response
     */
    protected String createErrorResponse(Integer errno, String errmsg) {
        return createBaseResponse(errno, errmsg)
    }

    /**
     * Get the last request sent to the mock server
     * After auth request, this gets the next request (business API request)
     * Uses a longer timeout to ensure auth request is processed first
     */
    protected RecordedRequest getLastRequest() {
        // Skip the auth request - use blocking call with longer timeout
        mockWebServer.takeRequest(5, TimeUnit.SECONDS)
        return mockWebServer.takeRequest(5, TimeUnit.SECONDS)
    }

    /**
     * Get the Nth request (0-indexed, after auth)
     * Uses a longer timeout to ensure auth request is processed first
     */
    protected RecordedRequest getRequest(int index) {
        // Skip the auth request
        mockWebServer.takeRequest(5, TimeUnit.SECONDS)
        RecordedRequest request = null
        for (int i = 0; i <= index; i++) {
            request = mockWebServer.takeRequest(5, TimeUnit.SECONDS)
        }
        return request
    }

    /**
     * Verify that the request contains required headers
     */
    protected void verifyRequiredHeaders(RecordedRequest request) {
        assert request.getHeader("User-Agent") != null
        // User-Agent format: ddies-open-sdk-java/1.0.0 or ddies-open-sdk
        def userAgent = request.getHeader("User-Agent")
        assert userAgent.contains("ddies") || userAgent.contains("open-sdk")
    }

    /**
     * Verify that the request contains required parameters
     */
    protected void verifyRequiredParams(RecordedRequest request, String clientId) {
        def body = getRequestBody(request)
        body.contains("client_id")
        body.contains(clientId)
        body.contains("sign")
        body.contains("timestamp")
        body.contains("access_token")
    }

    /**
     * Verify the request path
     */
    protected void verifyPath(RecordedRequest request, String expectedPath) {
        assert request.path.startsWith(expectedPath)
    }

    /**
     * Get request body as string
     */
    protected String getRequestBody(RecordedRequest request) {
        return request.body?.readUtf8() ?: ""
    }

    /**
     * Get request query parameters
     * Handles both GET requests (query in path) and POST requests
     * Returns decoded parameter values
     */
    protected Map<String, String> getQueryParams(RecordedRequest request) {
        def params = [:]
        try {
            // Try to parse query parameters from the path
            def path = request.path
            if (path.contains('?')) {
                def queryString = path.substring(path.indexOf('?') + 1)
                queryString.split('&').each { param ->
                    def parts = param.split('=', 2)
                    if (parts.length >= 2) {
                        def name = parts[0]
                        def value = parts[1]
                        // Decode URL-encoded values
                        try {
                            name = URLDecoder.decode(name, 'UTF-8')
                            value = URLDecoder.decode(value, 'UTF-8')
                        } catch (Exception decodeEx) {
                            // If decoding fails, use original values
                            println("URL decode failed for: ${name}=${value}, using original values")
                        }
                        params[name] = value
                    } else if (parts.length == 1 && parts[0]) {
                        def name = parts[0]
                        try {
                            name = URLDecoder.decode(name, 'UTF-8')
                        } catch (Exception decodeEx) {
                            // If decoding fails, use original value
                        }
                        params[name] = ''
                    }
                }
            }
        } catch (Exception e) {
            // If parsing fails, return empty params
            println("Warning: Failed to parse query params: ${e.message}")
            e.printStackTrace()
        }
        return params
    }

    /**
     * Parse JSON body to map
     */
    protected Map<String, Object> parseJsonBody(String body) {
        if (!body || body.isEmpty()) return [:]
        // Simple JSON parsing for test purposes
        // For complex JSON, consider using a proper JSON library
        def slurper = new groovy.json.JsonSlurper()
        return slurper.parseText(body) as Map<String, Object>
    }

    /**
     * Verify request contains field
     */
    protected void verifyFieldPresent(RecordedRequest request, String fieldName, String value = null) {
        def body = getRequestBody(request)
        if (request.method == "GET") {
            def params = getQueryParams(request)
            assert params.containsKey(fieldName)
            if (value != null) {
                assert params[fieldName] == value
            }
        } else {
            def json = parseJsonBody(body)
            assert json.containsKey(fieldName)
            if (value != null) {
                assert json[fieldName] == value
            }
        }
    }
}
