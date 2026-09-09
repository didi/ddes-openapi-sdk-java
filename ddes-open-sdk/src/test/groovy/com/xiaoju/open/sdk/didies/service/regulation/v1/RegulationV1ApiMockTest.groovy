package com.xiaoju.open.sdk.didies.service.regulation.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.GetRegulationApiReply
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.GetRegulationRequest
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.ListRegulationApiReply
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.ListRegulationRequest
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for Regulation V1
 * Tests all Regulation APIs with proper request/response validation
 */
class RegulationV1ApiMockTest extends BaseMockTest {

    def "getRegulation - GET /river/Regulation/detail"() {
        given: "A mock success response"
        def responseData = """{
            "regulation_id": "reg_12345",
            "regulation_name": "商务出行制度",
            "regulation_status": "1",
            "source": 1,
            "scene_type": "1",
            "is_use_quota": 0,
            "is_approve": 0,
            "institution_id": "inst_001",
            "city_type": 1,
            "approval_type": 0
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetRegulationRequest request = GetRegulationRequest.builder()
                .companyId("company_001")
                .regulationId("reg_12345")
                .build()

        when: "Call API"
        GetRegulationApiReply response = apiClient.regulation().v1().getRegulation(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Regulation/detail")
        recordedRequest.method == "GET"
        verifyRequiredHeaders(recordedRequest)

        and: "Query params should contain required fields"
        def params = getQueryParams(recordedRequest)
        params["company_id"] == "company_001"
        params["regulation_id"] == "reg_12345"
    }

    def "listRegulation - GET /river/Regulation/get"() {
        given: "A mock success response with array data"
        def responseData = """[
            {
                "regulation_id": "reg_001",
                "regulation_name": "商务出行制度",
                "regulation_status": "1",
                "source": 1
            },
            {
                "regulation_id": "reg_002",
                "regulation_name": "差旅制度",
                "regulation_status": "1",
                "source": 3
            }
        ]"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        ListRegulationRequest request = ListRegulationRequest.builder()
                .companyId("company_001")
                .build()

        when: "Call API"
        ListRegulationApiReply response = apiClient.regulation().v1().listRegulation(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Regulation/get")
        recordedRequest.method == "GET"

        and: "Query params should contain company_id"
        def params = getQueryParams(recordedRequest)
        params["company_id"] == "company_001"

        and: "Response should contain data array"
        response.data != null
        response.data.size() == 2
    }

    def "getRegulation should handle different source types"() {
        given: "A mock success response"
        def responseData = """{
            "regulation_id": "reg_12345",
            "regulation_name": "行前审批制度",
            "regulation_status": "1",
            "source": 2,
            "scene_type": "1",
            "is_approve": 2
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetRegulationRequest request = GetRegulationRequest.builder()
                .companyId("company_001")
                .regulationId("reg_12345")
                .build()

        when: "Call API"
        GetRegulationApiReply response = apiClient.regulation().v1().getRegulation(request)

        then: "Response should contain correct source type"
        response.errno == 0
        response.data.source == 2
        response.data.isApprove == 2
    }

    def "listRegulation should handle empty response"() {
        given: "A mock empty array response"
        def responseData = """[]"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        ListRegulationRequest request = ListRegulationRequest.builder()
                .companyId("company_001")
                .build()

        when: "Call API"
        ListRegulationApiReply response = apiClient.regulation().v1().listRegulation(request)

        then: "Response should be successful but empty"
        response != null
        response.errno == 0
        response.data != null
        response.data.isEmpty()
    }

    def "listRegulation should handle single regulation"() {
        given: "A mock success response with single item"
        def responseData = """[
            {
                "regulation_id": "reg_001",
                "regulation_name": "商务出行制度"
            }
        ]"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        ListRegulationRequest request = ListRegulationRequest.builder()
                .companyId("company_001")
                .build()

        when: "Call API"
        ListRegulationApiReply response = apiClient.regulation().v1().listRegulation(request)

        then: "Response should be successful"
        response.errno == 0
        response.data.size() == 1
        response.data[0].regulationId == "reg_001"
    }

    def "getRegulation should handle error response"() {
        given: "A mock error response"
        enqueueSuccess(createErrorResponse(404, "Regulation not found"))

        and: "Create request"
        GetRegulationRequest request = GetRegulationRequest.builder()
                .companyId("company_001")
                .regulationId("invalid_id")
                .build()

        when: "Call API"
        GetRegulationApiReply response = apiClient.regulation().v1().getRegulation(request)

        then: "Response should contain error information"
        response != null
        response.errno == 404
        response.errmsg == "Regulation not found"
    }

    def "getRegulation should deserialize car_rule nested structure"() {
        given: "A mock success response with car_rule"
        def responseData = """{
            "regulation_id": "reg_001",
            "regulation_name": "用车制度",
            "regulation_status": "0",
            "car_rule": {
                "call_type": [1, 2],
                "use_scene": [1, 2]
            },
            "regulation_employee_name": "全员",
            "regulation_employee_description": "适用于全体员工"
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with group account params"
        GetRegulationRequest request = GetRegulationRequest.builder()
                .companyId("company_001")
                .regulationId("reg_001")
                .belongEnterpriseName("enterprise_001")
                .taxpayerNo("tax_001")
                .build()

        when: "Call API"
        GetRegulationApiReply response = apiClient.regulation().v1().getRegulation(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Group query params should be passed"
        def params = getQueryParams(getLastRequest())
        params["belong_enterprise_name"] == "enterprise_001"
        params["taxpayer_no"] == "tax_001"

        and: "car_rule should be deserialized"
        def data = response.data
        data != null
        data.carRule != null
        data.carRule.callType == [1, 2]
        data.carRule.useScene == [1, 2]
        data.regulationEmployeeName == "全员"
        data.regulationEmployeeDescription == "适用于全体员工"
    }

    def "getRegulation should not fail when car_rule absent"() {
        given: "A mock success response without car_rule"
        def responseData = """{
            "regulation_id": "reg_002",
            "regulation_name": "无规则制度"
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetRegulationRequest request = GetRegulationRequest.builder()
                .companyId("company_001")
                .regulationId("reg_002")
                .build()

        when: "Call API"
        GetRegulationApiReply response = apiClient.regulation().v1().getRegulation(request)

        then: "Response should be successful and carRule null"
        response != null
        response.errno == 0
        response.data != null
        response.data.carRule == null
    }

    def "listRegulation should pass group account params"() {
        given: "A mock success response with array data"
        def responseData = """[
            {"regulation_id": "reg_001", "regulation_name": "制度一"}
        ]"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with group params"
        ListRegulationRequest request = ListRegulationRequest.builder()
                .companyId("company_001")
                .belongEnterpriseName("enterprise_001")
                .taxpayerNo("tax_001")
                .build()

        when: "Call API"
        ListRegulationApiReply response = apiClient.regulation().v1().listRegulation(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.data != null
        response.data.size() == 1

        and: "Group query params should be passed"
        def params = getQueryParams(getLastRequest())
        params["belong_enterprise_name"] == "enterprise_001"
        params["taxpayer_no"] == "tax_001"
    }
}
