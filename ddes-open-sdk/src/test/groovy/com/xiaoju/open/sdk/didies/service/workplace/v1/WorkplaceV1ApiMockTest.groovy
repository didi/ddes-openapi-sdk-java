package com.xiaoju.open.sdk.didies.service.workplace.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.workplace.v1.model.*
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for Workplace V1
 * Tests all Workplace APIs with proper request/response validation
 */
class WorkplaceV1ApiMockTest extends BaseMockTest {

    def "createWorkplace - POST /open-apis/v1/workplace/create"() {
        given: "A mock success response"
        def responseData = """{
            "id": "wp_12345",
            "city_id": 1,
            "address": "Test Address",
            "lng": "116.397128",
            "lat": "39.916527",
            "point_range": 500
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with paramJsonObj"
        def workplaceInfo = WorkplaceInfo.builder()
                .cityId(1)
                .address("Test Address")
                .lng("116.397128")
                .lat("39.916527")
                .pointRange(500)
                .build()
        CreateWorkplaceRequest request = CreateWorkplaceRequest.builder()
                .companyId("company_001")
                .paramJsonObj(workplaceInfo)
                .build()

        when: "Call API"
        CreateWorkplaceApiReply response = apiClient.workplace().v1().createWorkplace(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/open-apis/v1/workplace/create")
        recordedRequest.method == "POST"
        verifyRequiredHeaders(recordedRequest)

        and: "Request body should contain all required fields"
        def body = getRequestBody(recordedRequest)
        body.contains("param_json")
        body.contains("city_id")
        body.contains("address")
    }

    def "deleteWorkplace - POST /open-apis/v1/workplace/del"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with id in paramJsonObj"
        def workplaceInfo = WorkplaceInfo.builder()
                .id("wp_12345")
                .build()
        DeleteWorkplaceRequest request = DeleteWorkplaceRequest.builder()
                .companyId("company_001")
                .paramJsonObj(workplaceInfo)
                .build()

        when: "Call API"
        DeleteWorkplaceApiReply response = apiClient.workplace().v1().deleteWorkplace(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/open-apis/v1/workplace/del")
        recordedRequest.method == "POST"

        and: "Request should contain id"
        def body = getRequestBody(recordedRequest)
        body.contains("param_json")
        body.contains("wp_12345")
    }

    def "updateWorkplace - POST /open-apis/v1/workplace/update"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with id and updated fields"
        def workplaceInfo = WorkplaceInfo.builder()
                .id("wp_12345")
                .cityId(1)
                .address("Updated Address")
                .lng("116.397128")
                .lat("39.916527")
                .pointRange(500)
                .build()
        UpdateWorkplaceRequest request = UpdateWorkplaceRequest.builder()
                .companyId("company_001")
                .paramJsonObj(workplaceInfo)
                .build()

        when: "Call API"
        UpdateWorkplaceApiReply response = apiClient.workplace().v1().updateWorkplace(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/open-apis/v1/workplace/update")
        recordedRequest.method == "POST"

        and: "Request should contain id and updated fields"
        def body = getRequestBody(recordedRequest)
        body.contains("param_json")
        body.contains("wp_12345")
        body.contains("Updated Address")
    }

    def "createWorkplace should validate all parameters"() {
        given: "A mock success response"
        def responseData = """{
            "id": "wp_12345",
            "city_id": 1,
            "address": "Test Address"
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with all parameters"
        def workplaceInfo = WorkplaceInfo.builder()
                .cityId(1)
                .outAddressId("out_addr_001")
                .address("Test Address")
                .lng("116.397128")
                .lat("39.916527")
                .pointRange(500)
                .isWorkplace(1)
                .remark("Test remark")
                .build()
        CreateWorkplaceRequest request = CreateWorkplaceRequest.builder()
                .companyId("company_001")
                .paramJsonObj(workplaceInfo)
                .build()

        when: "Call API"
        CreateWorkplaceApiReply response = apiClient.workplace().v1().createWorkplace(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain all fields"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("param_json")
        body.contains("out_address_id")
        body.contains("remark")
        body.contains("is_workplace")
    }

    def "deleteWorkplace should support deletion by out_address_id"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with out_address_id"
        def workplaceInfo = WorkplaceInfo.builder()
                .outAddressId("out_addr_001")
                .build()
        DeleteWorkplaceRequest request = DeleteWorkplaceRequest.builder()
                .companyId("company_001")
                .paramJsonObj(workplaceInfo)
                .build()

        when: "Call API"
        DeleteWorkplaceApiReply response = apiClient.workplace().v1().deleteWorkplace(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain out_address_id"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("param_json")
        body.contains("out_addr_001")
    }

    def "updateWorkplace should handle error response"() {
        given: "A mock error response"
        enqueueSuccess(createErrorResponse(404, "Workplace not found"))

        and: "Create request"
        def workplaceInfo = WorkplaceInfo.builder()
                .id("invalid_id")
                .build()
        UpdateWorkplaceRequest request = UpdateWorkplaceRequest.builder()
                .companyId("company_001")
                .paramJsonObj(workplaceInfo)
                .build()

        when: "Call API"
        UpdateWorkplaceApiReply response = apiClient.workplace().v1().updateWorkplace(request)

        then: "Response should contain error information"
        response != null
        response.errno == 404
        response.errmsg == "Workplace not found"
    }

    def "createWorkplace should handle coordinates and range"() {
        given: "A mock success response"
        enqueueSuccess(createSuccessResponse("""{
            "id": "wp_12345",
            "lng": "116.397128",
            "lat": "39.916527",
            "point_range": 1000
        }"""))

        and: "Create request with specific range"
        def workplaceInfo = WorkplaceInfo.builder()
                .cityId(1)
                .address("Beijing Office")
                .lng("116.397128")
                .lat("39.916527")
                .pointRange(1000)
                .isWorkplace(1)
                .build()
        CreateWorkplaceRequest request = CreateWorkplaceRequest.builder()
                .companyId("company_001")
                .paramJsonObj(workplaceInfo)
                .build()

        when: "Call API"
        CreateWorkplaceApiReply response = apiClient.workplace().v1().createWorkplace(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain coordinates and range"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("116.397128")
        body.contains("39.916527")
        body.contains("1000")
    }
}
