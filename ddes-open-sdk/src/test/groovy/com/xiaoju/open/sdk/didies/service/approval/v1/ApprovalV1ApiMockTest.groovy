package com.xiaoju.open.sdk.didies.service.approval.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.approval.v1.model.*
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for Approval V1
 * Tests key Approval APIs with proper request/response validation
 */
class ApprovalV1ApiMockTest extends BaseMockTest {

    def "createTravelApproval - POST /river/Approval/create"() {
        given: "A mock success response"
        def responseData = """{
            "approval_id": "approval_001",
            "out_approval_id": "TA_100001",
            "approval_status": 1,
            "create_time": "2024-01-01 12:00:00"
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        CreateApprovalRequest request = CreateApprovalRequest.builder()
                .companyId("company_001")
                .approvalType(1)
                .outApprovalId("TA_100001")
                .budgetCenterId("budget_001")
                .build()

        when: "Call API"
        CreateApprovalApiReply response = apiClient.approval().v1().createTravelApproval(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Approval/create")
        recordedRequest.method == "POST"
        verifyRequiredHeaders(recordedRequest)

        and: "Request body should contain required fields"
        def body = getRequestBody(recordedRequest)
        body.contains("company_id")
        body.contains("approval_type")
        body.contains("out_approval_id")
    }

    def "getApprovalDetail - GET /open-apis/v1/approval/detail"() {
        given: "A mock success response"
        def responseData = """{
            "approval_id": "approval_001",
            "out_approval_id": "TA_100001",
            "approval_type": 1,
            "approval_status": 2,
            "applicant_name": "John Doe"
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetApprovalDetailRequest request = GetApprovalDetailRequest.builder()
                .companyId("company_001")
                .outApprovalId("TA_100001")
                .build()

        when: "Call API"
        GetApprovalDetailApiReply response = apiClient.approval().v1().getApprovalDetail(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/open-apis/v1/approval/detail")
        recordedRequest.method == "GET"
        verifyRequiredHeaders(recordedRequest)

        and: "Query params should contain out_approval_id"
        def params = getQueryParams(recordedRequest)
        params["out_approval_id"] == "TA_100001"
    }

    def "cancelApproval - POST /river/Approval/cancel"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request"
        CancelApprovalRequest request = CancelApprovalRequest.builder()
                .companyId("company_001")
                .approvalId("approval_001")
                .isForce(0)
                .build()

        when: "Call API"
        CancelApprovalApiReply response = apiClient.approval().v1().cancelApproval(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Approval/cancel")
        recordedRequest.method == "POST"

        and: "Request body should contain approval_id"
        def body = getRequestBody(recordedRequest)
        body.contains("approval_id")
        body.contains("approval_001")
    }

    def "listApprovalOrder - GET /river/Approval/getOrder"() {
        given: "A mock success response"
        def responseData = """{
            "orders": [{
                "order_id": "order_001",
                "order_type": "car",
                "order_status": "completed"
            }],
            "total": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        ListApprovalOrderRequest request = ListApprovalOrderRequest.builder()
                .companyId("company_001")
                .approvalId("approval_001")
                .build()

        when: "Call API"
        ListApprovalOrderApiReply response = apiClient.approval().v1().listApprovalOrder(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Approval/getOrder")
        recordedRequest.method == "GET"

        and: "Query params should contain approval_id"
        def params = getQueryParams(recordedRequest)
        params["approval_id"] == "approval_001"
    }

    def "cancelApproval should support force cancel"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with force cancel"
        CancelApprovalRequest request = CancelApprovalRequest.builder()
                .companyId("company_001")
                .approvalId("approval_001")
                .isForce(1)
                .build()

        when: "Call API"
        CancelApprovalApiReply response = apiClient.approval().v1().cancelApproval(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain is_force"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("is_force")
        body.contains("1")
    }
}
