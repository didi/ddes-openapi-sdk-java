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

    def "createTraveler should serialize type for project-dimension traveler"() {
        given: "A mock success response"
        def responseData = """{"id": 12345}"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with type=3 (project dimension)"
        def travelerInfo = TravelerInfo.builder()
                .name("张三")
                .phone("13800138000")
                .type(3)
                .build()
        CreateTravelerRequest request = CreateTravelerRequest.builder()
                .companyId("company_001")
                .paramJsonObj(travelerInfo)
                .belongEnterpriseName("enterprise_001")
                .taxpayerNo("tax_001")
                .build()

        when: "Call API"
        CreateTravelerApiReply response = apiClient.traveler().v1().createTraveler(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "param_json should contain type and group params in body"
        def body = getRequestBody(getLastRequest())
        body.contains("belong_enterprise_name")
        body.contains("taxpayer_no")
        def json = groovy.json.JsonSlurper.newInstance().parseText(body)
        def paramJson = groovy.json.JsonSlurper.newInstance().parseText(json["param_json"])
        paramJson["type"] == 3
    }

    def "createTraveler should not serialize type when absent"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request without type"
        def travelerInfo = TravelerInfo.builder()
                .name("张三")
                .phone("13800138000")
                .build()
        CreateTravelerRequest request = CreateTravelerRequest.builder()
                .companyId("company_001")
                .paramJsonObj(travelerInfo)
                .build()

        when: "Call API"
        CreateTravelerApiReply response = apiClient.traveler().v1().createTraveler(request)

        then: "Response should be successful"
        response.errno == 0

        and: "param_json should not contain type field"
        def json = groovy.json.JsonSlurper.newInstance().parseText(getRequestBody(getLastRequest()))
        def paramJson = groovy.json.JsonSlurper.newInstance().parseText(json["param_json"])
        !paramJson.containsKey("type")
    }

    def "delTraveler should pass group account params"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Delete request with group params"
        def travelerInfo = TravelerInfo.builder()
                .travelerId("12345")
                .build()
        DelTravelerRequest request = DelTravelerRequest.builder()
                .companyId("company_001")
                .paramJsonObj(travelerInfo)
                .belongEnterpriseName("enterprise_001")
                .taxpayerNo("tax_001")
                .build()

        when: "Call API"
        DelTravelerApiReply response = apiClient.traveler().v1().delTraveler(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request body should contain group params"
        def body = getRequestBody(getLastRequest())
        body.contains("belong_enterprise_name")
        body.contains("taxpayer_no")
    }
}
