package com.xiaoju.open.sdk.didies.service.outapproval.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.outapproval.v1.model.UpdateOutApprovalStatusApiReply
import com.xiaoju.open.sdk.didies.service.outapproval.v1.model.UpdateOutApprovalStatusRequest
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for OutApproval V1
 * Tests all OutApproval APIs with proper request/response validation
 */
class OutApprovalV1ApiMockTest extends BaseMockTest {

    def "updateOutApprovalStatus - POST /river/OutApproval/Status"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request"
        UpdateOutApprovalStatusRequest request = UpdateOutApprovalStatusRequest.builder()
                .companyId("company_001")
                .outId("out_approval_001")
                .status(1)
                .approvalType(2)
                .build()

        when: "Call API"
        UpdateOutApprovalStatusApiReply response = apiClient.outapproval().v1().updateOutApprovalStatus(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/OutApproval/Status")
        recordedRequest.method == "POST"
        verifyRequiredHeaders(recordedRequest)

        and: "Request body should contain all required fields"
        def body = getRequestBody(recordedRequest)
        body.contains("company_id")
        body.contains("company_001")
        body.contains("out_id")
        body.contains("out_approval_001")
        body.contains("status")
        body.contains("approval_type")
    }

    def "updateOutApprovalStatus with approval status pass"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with status = 1 (pass)"
        UpdateOutApprovalStatusRequest request = UpdateOutApprovalStatusRequest.builder()
                .companyId("company_001")
                .outId("out_approval_001")
                .status(1)
                .approvalType(1)
                .build()

        when: "Call API"
        UpdateOutApprovalStatusApiReply response = apiClient.outapproval().v1().updateOutApprovalStatus(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should contain status=1"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("\"status\":1")
    }

    def "updateOutApprovalStatus with approval status reject"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with status = 0 (reject)"
        UpdateOutApprovalStatusRequest request = UpdateOutApprovalStatusRequest.builder()
                .companyId("company_001")
                .outId("out_approval_001")
                .status(0)
                .approvalType(2)
                .build()

        when: "Call API"
        UpdateOutApprovalStatusApiReply response = apiClient.outapproval().v1().updateOutApprovalStatus(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should contain status=0"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("\"status\":0")
    }

    def "updateOutApprovalStatus should validate different approval types"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with different approval types"
        UpdateOutApprovalStatusRequest request = UpdateOutApprovalStatusRequest.builder()
                .companyId("company_001")
                .outId("out_approval_001")
                .status(1)
                .approvalType(3)
                .build()

        when: "Call API"
        UpdateOutApprovalStatusApiReply response = apiClient.outapproval().v1().updateOutApprovalStatus(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain approval_type"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("\"approval_type\":3")
    }

    def "updateOutApprovalStatus should handle error response"() {
        given: "A mock error response"
        enqueueSuccess(createErrorResponse(404, "Approval not found"))

        and: "Create request"
        UpdateOutApprovalStatusRequest request = UpdateOutApprovalStatusRequest.builder()
                .companyId("company_001")
                .outId("invalid_out_id")
                .status(1)
                .approvalType(2)
                .build()

        when: "Call API"
        UpdateOutApprovalStatusApiReply response = apiClient.outapproval().v1().updateOutApprovalStatus(request)

        then: "Response should contain error information"
        response != null
        response.errno == 404
        response.errmsg == "Approval not found"
    }
}
