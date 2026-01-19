package com.xiaoju.open.sdk.didies.service.login.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.login.v1.model.GetLoginEncryptStrApiReply
import com.xiaoju.open.sdk.didies.service.login.v1.model.GetLoginEncryptStrRequest
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for Login V1
 * Tests all Login APIs with proper request/response validation
 */
class LoginV1ApiMockTest extends BaseMockTest {

    def "getLoginEncryptStr - GET /river/Login/getLoginEncryptStr"() {
        given: "A mock success response"
        def responseData = """{
            "encrypt_str": "encrypted_string_12345",
            "expire_time": 1640995200
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetLoginEncryptStrRequest request = GetLoginEncryptStrRequest.builder()
                .companyId("company_001")
                .phone("13800138000")
                .appType("h5")
                .productType(1)
                .build()

        when: "Call API"
        GetLoginEncryptStrApiReply response = apiClient.login().v1().getLoginEncryptStr(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Login/getLoginEncryptStr")
        recordedRequest.method == "GET"
        verifyRequiredHeaders(recordedRequest)

        and: "Query params should contain required fields"
        def params = getQueryParams(recordedRequest)
        params["company_id"] == "company_001"
        params["phone"] == "13800138000"
        params["app_type"] == "h5"
        params["product_type"] == "1"
    }

    def "getLoginEncryptStr with email"() {
        given: "A mock success response"
        enqueueSuccess(createSuccessResponse("""{
            "encrypt_str": "encrypted_string_12345",
            "expire_time": 1640995200
        }"""))

        and: "Create request with email"
        GetLoginEncryptStrRequest request = GetLoginEncryptStrRequest.builder()
                .companyId("company_001")
                .email("test@example.com")
                .appType("h5")
                .productType(1)
                .build()

        when: "Call API"
        GetLoginEncryptStrApiReply response = apiClient.login().v1().getLoginEncryptStr(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Query params should contain email"
        RecordedRequest recordedRequest = getLastRequest()
        def params = getQueryParams(recordedRequest)
        params["email"] != null && (params["email"].contains("@") || params["email"].contains("example.com"))
    }

    def "getLoginEncryptStr with employee number"() {
        given: "A mock success response"
        enqueueSuccess(createSuccessResponse("""{
            "encrypt_str": "encrypted_string_12345",
            "expire_time": 1640995200
        }"""))

        and: "Create request with employee number"
        GetLoginEncryptStrRequest request = GetLoginEncryptStrRequest.builder()
                .companyId("company_001")
                .employeeNumber("EMP001")
                .appType("pc")
                .productType(2)
                .build()

        when: "Call API"
        GetLoginEncryptStrApiReply response = apiClient.login().v1().getLoginEncryptStr(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Query params should contain employee_number"
        RecordedRequest recordedRequest = getLastRequest()
        def params = getQueryParams(recordedRequest)
        params["employee_number"] == "EMP001"
        params["app_type"] == "pc"
    }

    def "getLoginEncryptStr should validate all parameters"() {
        given: "A mock success response"
        enqueueSuccess(createSuccessResponse("""{
            "encrypt_str": "encrypted_string_12345",
            "expire_time": 1640995200
        }"""))

        and: "Create request with all parameters"
        GetLoginEncryptStrRequest request = GetLoginEncryptStrRequest.builder()
                .companyId("company_001")
                .phone("13800138000")
                .email("test@example.com")
                .employeeNumber("EMP001")
                .appType("h5")
                .productType(1)
                .build()

        when: "Call API"
        GetLoginEncryptStrApiReply response = apiClient.login().v1().getLoginEncryptStr(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Query params should contain all fields"
        RecordedRequest recordedRequest = getLastRequest()
        def params = getQueryParams(recordedRequest)
        params["phone"] == "13800138000"
        params["email"] != null && params["email"].contains("example.com")
        params["employee_number"] == "EMP001"
    }

    def "getLoginEncryptStr should handle different app types"() {
        given: "A mock success response"
        enqueueSuccess(createSuccessResponse("""{
            "encrypt_str": "encrypted_string_12345",
            "expire_time": 1640995200
        }"""))

        and: "Create request with different app type"
        GetLoginEncryptStrRequest request = GetLoginEncryptStrRequest.builder()
                .companyId("company_001")
                .phone("13800138000")
                .appType("pc")
                .productType(1)
                .build()

        when: "Call API"
        GetLoginEncryptStrApiReply response = apiClient.login().v1().getLoginEncryptStr(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Query params should contain app_type"
        RecordedRequest recordedRequest = getLastRequest()
        def params = getQueryParams(recordedRequest)
        params["app_type"] == "pc"
    }

    def "getLoginEncryptStr should handle error response"() {
        given: "A mock error response"
        enqueueSuccess(createErrorResponse(400, "Invalid parameters"))

        and: "Create request"
        GetLoginEncryptStrRequest request = GetLoginEncryptStrRequest.builder()
                .companyId("invalid_company")
                .phone("13800138000")
                .build()

        when: "Call API"
        GetLoginEncryptStrApiReply response = apiClient.login().v1().getLoginEncryptStr(request)

        then: "Response should contain error information"
        response != null
        response.errno == 400
        response.errmsg == "Invalid parameters"
    }
}
