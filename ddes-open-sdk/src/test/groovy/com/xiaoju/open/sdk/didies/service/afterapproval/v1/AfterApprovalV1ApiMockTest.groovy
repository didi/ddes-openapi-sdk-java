package com.xiaoju.open.sdk.didies.service.afterapproval.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.CreatePersonalReceiptApiReply
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.CreatePersonalReceiptRequest
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.GetPersonalReceiptOrderApiReply
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.GetPersonalReceiptOrderRequest
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for AfterApproval V1
 * Tests all AfterApproval APIs with proper request/response validation
 */
class AfterApprovalV1ApiMockTest extends BaseMockTest {

    def "createPersonalReceipt - POST /river/AfterApproval/createPersonalReceipt"() {
        given: "A mock success response"
        def responseData = """{
            "receipt_id": "receipt_12345",
            "order_id": "order_001",
            "status": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        CreatePersonalReceiptRequest request = CreatePersonalReceiptRequest.builder()
                .companyId("company_001")
                .orderId("order_001")
                .isPass(1)
                .approverPhone("13800138000")
                .remark("Approved")
                .build()

        when: "Call API"
        CreatePersonalReceiptApiReply response = apiClient.afterapproval().v1().createPersonalReceipt(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/AfterApproval/createPersonalReceipt")
        recordedRequest.method == "POST"
        verifyRequiredHeaders(recordedRequest)

        and: "Request body should contain all required fields"
        def body = getRequestBody(recordedRequest)
        body.contains("company_id")
        body.contains("company_001")
        body.contains("order_id")
        body.contains("order_001")
        body.contains("is_pass")
    }

    def "getPersonalReceiptOrder - GET /river/AfterApproval/getPersonalReceiptOrder"() {
        given: "A mock success response"
        def responseData = """{
            "receipt_orders": [
                {
                    "receipt_id": "receipt_001",
                    "order_id": "order_001",
                    "status": 1,
                    "create_time": "2024-01-01 00:00:00"
                }
            ],
            "total": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetPersonalReceiptOrderRequest request = GetPersonalReceiptOrderRequest.builder()
                .companyId("company_001")
                .build()

        when: "Call API"
        GetPersonalReceiptOrderApiReply response = apiClient.afterapproval().v1().getPersonalReceiptOrder(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/AfterApproval/getPersonalReceiptOrder")
        recordedRequest.method == "GET"

        and: "Query params should contain company_id"
        def params = getQueryParams(recordedRequest)
        params["company_id"] == "company_001"
    }

    def "createPersonalReceipt with reject status"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with isPass = 0 (reject)"
        CreatePersonalReceiptRequest request = CreatePersonalReceiptRequest.builder()
                .companyId("company_001")
                .orderId("order_001")
                .isPass(0)
                .remark("Insufficient documentation")
                .build()

        when: "Call API"
        CreatePersonalReceiptApiReply response = apiClient.afterapproval().v1().createPersonalReceipt(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should contain reject reason"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("\"is_pass\":0")
        body.contains("remark")
        body.contains("Insufficient documentation")
    }

    def "getPersonalReceiptOrder should support pagination"() {
        given: "A mock success response"
        def responseData = """{
            "receipt_orders": [
                {"receipt_id": "receipt_1", "order_id": "order_1"},
                {"receipt_id": "receipt_2", "order_id": "order_2"}
            ],
            "total": 10,
            "length": 2,
            "offset": 0
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with pagination"
        GetPersonalReceiptOrderRequest request = GetPersonalReceiptOrderRequest.builder()
                .companyId("company_001")
                .length("2")
                .offset("0")
                .build()

        when: "Call API"
        GetPersonalReceiptOrderApiReply response = apiClient.afterapproval().v1().getPersonalReceiptOrder(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain pagination parameters"
        RecordedRequest recordedRequest = getLastRequest()
        def params = getQueryParams(recordedRequest)
        params["length"] == "2"
        params["offset"] == "0"
    }

    def "getPersonalReceiptOrder should support filtering"() {
        given: "A mock success response"
        enqueueSuccess(createSuccessResponse("""{"receipt_orders": [], "total": 0}"""))

        and: "Create request with filters"
        GetPersonalReceiptOrderRequest request = GetPersonalReceiptOrderRequest.builder()
                .companyId("company_001")
                .phone("13800138000")
                .status(1)
                .type(1)
                .startDate("2024-01-01")
                .endDate("2024-12-31")
                .queryTimeType(1)
                .build()

        when: "Call API"
        GetPersonalReceiptOrderApiReply response = apiClient.afterapproval().v1().getPersonalReceiptOrder(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain filter parameters"
        RecordedRequest recordedRequest = getLastRequest()
        def params = getQueryParams(recordedRequest)
        params["phone"] == "13800138000"
        params["status"] == "1"
        params["type"] == "1"
    }

    def "createPersonalReceipt should handle error response"() {
        given: "A mock error response"
        enqueueSuccess(createErrorResponse(404, "Order not found"))

        and: "Create request"
        CreatePersonalReceiptRequest request = CreatePersonalReceiptRequest.builder()
                .companyId("company_001")
                .orderId("invalid_order_id")
                .isPass(1)
                .build()

        when: "Call API"
        CreatePersonalReceiptApiReply response = apiClient.afterapproval().v1().createPersonalReceipt(request)

        then: "Response should contain error information"
        response != null
        response.errno == 404
        response.errmsg == "Order not found"
    }
}
