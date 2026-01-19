package com.xiaoju.open.sdk.didies.service.traveler.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.*
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for Traveler V1
 * Tests all Traveler APIs with proper request/response validation
 */
class TravelerV1ApiMockTest extends BaseMockTest {

    def "createTraveler - POST /open-apis/v1/traveler/create"() {
        given: "A mock success response"
        def responseData = """{
            "traveler_id": "traveler_12345",
            "phone": "13800138000",
            "name": "John Doe",
            "out_traveler_id": "out_traveler_001",
            "status": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with paramJsonObj"
        def travelerInfo = TravelerInfo.builder()
                .phone("13800138000")
                .name("John Doe")
                .build()
        CreateTravelerRequest request = CreateTravelerRequest.builder()
                .companyId("company_001")
                .paramJsonObj(travelerInfo)
                .build()

        when: "Call API"
        CreateTravelerApiReply response = apiClient.traveler().v1().createTraveler(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/open-apis/v1/traveler/create")
        recordedRequest.method == "POST"
        verifyRequiredHeaders(recordedRequest)

        and: "Request body should contain param_json"
        def body = getRequestBody(recordedRequest)
        body.contains("param_json")
        body.contains("phone")
        body.contains("13800138000")
    }

    def "delTraveler - POST /open-apis/v1/traveler/del"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with paramJsonObj"
        def travelerInfo = TravelerInfo.builder()
                .travelerId("traveler_12345")
                .build()
        DelTravelerRequest request = DelTravelerRequest.builder()
                .companyId("company_001")
                .paramJsonObj(travelerInfo)
                .build()

        when: "Call API"
        DelTravelerApiReply response = apiClient.traveler().v1().delTraveler(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/open-apis/v1/traveler/del")
        recordedRequest.method == "POST"

        and: "Request should contain traveler_id in param_json"
        def body = getRequestBody(recordedRequest)
        body.contains("param_json")
        body.contains("traveler_12345")
    }

    def "updateTraveler - POST /open-apis/v1/traveler/update"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with paramJsonObj"
        def travelerInfo = TravelerInfo.builder()
                .travelerId("traveler_12345")
                .name("Updated Name")
                .build()
        UpdateTravelerRequest request = UpdateTravelerRequest.builder()
                .companyId("company_001")
                .paramJsonObj(travelerInfo)
                .build()

        when: "Call API"
        UpdateTravelerApiReply response = apiClient.traveler().v1().updateTraveler(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/open-apis/v1/traveler/update")
        recordedRequest.method == "POST"

        and: "Request should contain updated name"
        def body = getRequestBody(recordedRequest)
        body.contains("param_json")
        body.contains("Updated Name")
    }

    def "createTraveler should accept all optional fields"() {
        given: "A mock success response"
        def responseData = """{
            "traveler_id": "traveler_12345",
            "phone": "13800138000",
            "name": "Jane Doe"
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with all fields"
        def travelerInfo = TravelerInfo.builder()
                .phone("13800138000")
                .name("Jane Doe")
                .outTravelerId("out_traveler_001")
                .build()
        CreateTravelerRequest request = CreateTravelerRequest.builder()
                .companyId("company_001")
                .paramJsonObj(travelerInfo)
                .build()

        when: "Call API"
        CreateTravelerApiReply response = apiClient.traveler().v1().createTraveler(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain all fields"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("param_json")
        body.contains("out_traveler_id")
    }

    def "delTraveler should handle error response"() {
        given: "A mock error response"
        enqueueSuccess(createErrorResponse(404, "Traveler not found"))

        and: "Create request"
        def travelerInfo = TravelerInfo.builder()
                .travelerId("invalid_id")
                .build()
        DelTravelerRequest request = DelTravelerRequest.builder()
                .companyId("company_001")
                .paramJsonObj(travelerInfo)
                .build()

        when: "Call API"
        DelTravelerApiReply response = apiClient.traveler().v1().delTraveler(request)

        then: "Response should contain error information"
        response != null
        response.errno == 404
        response.errmsg == "Traveler not found"
    }

    def "delTraveler should support deletion by out_traveler_id"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with out_traveler_id"
        def travelerInfo = TravelerInfo.builder()
                .outTravelerId("out_traveler_001")
                .build()
        DelTravelerRequest request = DelTravelerRequest.builder()
                .companyId("company_001")
                .paramJsonObj(travelerInfo)
                .build()

        when: "Call API"
        DelTravelerApiReply response = apiClient.traveler().v1().delTraveler(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain out_traveler_id"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("param_json")
        body.contains("out_traveler_001")
    }
}
