package com.xiaoju.open.sdk.didies.service.budgetcenter.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.*
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for BudgetCenter V1
 * Tests all BudgetCenter APIs with proper request/response validation
 */
class BudgetCenterV1ApiMockTest extends BaseMockTest {

    def "createBudgetCenter - POST /river/BudgetCenter/add"() {
        given: "A mock success response"
        def responseData = """{
            "budget_center_id": "bc_12345",
            "company_id": "company_001",
            "name": "Test Budget Center",
            "type": 1,
            "status": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        CreateBudgetCenterRequest request = CreateBudgetCenterRequest.builder()
                .companyId("company_001")
                .name("Test Budget Center")
                .type(1)
                .build()

        when: "Call API"
        CreateBudgetCenterApiReply response = apiClient.budgetcenter().v1().createBudgetCenter(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/BudgetCenter/add")
        recordedRequest.method == "POST"
        verifyRequiredHeaders(recordedRequest)

        and: "Request body should contain required fields"
        def body = getRequestBody(recordedRequest)
        body.contains("company_id")
        body.contains("company_001")
        body.contains("name")
        body.contains("Test Budget Center")
        body.contains("type")
    }

    def "getBudgetCenter - GET /river/BudgetCenter/get"() {
        given: "A mock success response"
        def responseData = """{
            "budget_centers": [{
                "budget_center_id": "bc_12345",
                "company_id": "company_001",
                "name": "Test Budget Center",
                "status": 1
            }],
            "total": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetBudgetCenterRequest request = GetBudgetCenterRequest.builder()
                .companyId("company_001")
                .id("bc_12345")
                .build()

        when: "Call API"
        GetBudgetCenterApiReply response = apiClient.budgetcenter().v1().getBudgetCenter(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/BudgetCenter/get")
        recordedRequest.method == "GET"

        and: "Query params should contain required fields"
        def params = getQueryParams(recordedRequest)
        params["company_id"] == "company_001"
        params["id"] == "bc_12345"
    }

    def "updateBudgetCenter - POST /river/BudgetCenter/edit"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request"
        UpdateBudgetCenterRequest request = UpdateBudgetCenterRequest.builder()
                .companyId("company_001")
                .id("bc_12345")
                .name("Updated Budget Center")
                .build()

        when: "Call API"
        UpdateBudgetCenterApiReply response = apiClient.budgetcenter().v1().updateBudgetCenter(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/BudgetCenter/edit")
        recordedRequest.method == "POST"

        and: "Request should contain id"
        def body = getRequestBody(recordedRequest)
        body.contains("id")
        body.contains("bc_12345")
    }

    def "delBudgetCenter - POST /river/BudgetCenter/del"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request"
        DelBudgetCenterRequest request = DelBudgetCenterRequest.builder()
                .companyId("company_001")
                .id("bc_12345")
                .build()

        when: "Call API"
        DelBudgetCenterApiReply response = apiClient.budgetcenter().v1().delBudgetCenter(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/BudgetCenter/del")
        recordedRequest.method == "POST"

        and: "Request should contain id"
        def body = getRequestBody(recordedRequest)
        body.contains("id")
        body.contains("bc_12345")
    }

    def "getBudgetCenter should support pagination"() {
        given: "A mock success response with pagination"
        def responseData = """{
            "budget_centers": [
                {"budget_center_id": "bc_1", "name": "Center 1"},
                {"budget_center_id": "bc_2", "name": "Center 2"}
            ],
            "total": 10,
            "length": 2,
            "offset": 0
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with pagination"
        GetBudgetCenterRequest request = GetBudgetCenterRequest.builder()
                .companyId("company_001")
                .length(2)
                .offset(0)
                .build()

        when: "Call API"
        GetBudgetCenterApiReply response = apiClient.budgetcenter().v1().getBudgetCenter(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain pagination parameters"
        RecordedRequest recordedRequest = getLastRequest()
        def params = getQueryParams(recordedRequest)
        params["length"] == "2"
        params["offset"] == "0"
    }

    def "getBudgetCenter should handle error response"() {
        given: "A mock error response"
        enqueueSuccess(createErrorResponse(404, "Budget center not found"))

        and: "Create request"
        GetBudgetCenterRequest request = GetBudgetCenterRequest.builder()
                .companyId("company_001")
                .id("invalid_id")
                .build()

        when: "Call API"
        GetBudgetCenterApiReply response = apiClient.budgetcenter().v1().getBudgetCenter(request)

        then: "Response should contain error information"
        response != null
        response.errno == 404
        response.errmsg == "Budget center not found"
    }

    def "delBudgetCenter should support deletion by out_budget_id and name"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with out_budget_id and name"
        DelBudgetCenterRequest request = DelBudgetCenterRequest.builder()
                .companyId("company_001")
                .type(2)
                .outBudgetId("out_bc_001")
                .name("Project Name")
                .build()

        when: "Call API"
        DelBudgetCenterApiReply response = apiClient.budgetcenter().v1().delBudgetCenter(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain out_budget_id and name"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("out_budget_id")
        body.contains("out_bc_001")
        body.contains("name")
        body.contains("Project Name")
    }
}
