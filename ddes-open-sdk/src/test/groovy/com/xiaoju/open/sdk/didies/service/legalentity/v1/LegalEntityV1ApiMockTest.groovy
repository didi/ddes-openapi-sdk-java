package com.xiaoju.open.sdk.didies.service.legalentity.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.*
import java.net.URLDecoder
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for LegalEntity V1
 * Tests all LegalEntity APIs with proper request/response validation
 */
class LegalEntityV1ApiMockTest extends BaseMockTest {

    def "createLegalEntity - POST /river/LegalEntity/add"() {
        given: "A mock success response"
        def responseData = """{
            "legal_entity_id": "le_001",
            "company_id": "company_001",
            "name": "Test Company",
            "status": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        CreateLegalEntityRequest request = CreateLegalEntityRequest.builder()
                .companyId("company_001")
                .name("Test Company")
                .outLegalEntityId("out_le_001")
                .build()

        when: "Call API"
        CreateLegalEntityApiReply response = apiClient.legalentity().v1().createLegalEntity(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/LegalEntity/add")
        recordedRequest.method == "POST"
        verifyRequiredHeaders(recordedRequest)

        and: "Request body should contain required fields"
        def body = getRequestBody(recordedRequest)
        body.contains("company_id")
        body.contains("name")
        body.contains("out_legal_entity_id")
    }

    def "getLegalEntity - GET /river/LegalEntity/get"() {
        given: "A mock success response"
        def responseData = """{
            "legal_entity_id": "le_001",
            "company_id": "company_001",
            "name": "Test Company",
            "status": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetLegalEntityRequest request = GetLegalEntityRequest.builder()
                .companyId("company_001")
                .legalEntityId("le_001")
                .build()

        when: "Call API"
        GetLegalEntityApiReply response = apiClient.legalentity().v1().getLegalEntity(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/LegalEntity/get")
        recordedRequest.method == "GET"

        and: "Query params should contain required fields"
        def params = getQueryParams(recordedRequest)
        params["company_id"] == "company_001"
        params["legal_entity_id"] == "le_001"
    }

    def "updateLegalEntity - POST /river/LegalEntity/edit"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request"
        UpdateLegalEntityRequest request = UpdateLegalEntityRequest.builder()
                .companyId("company_001")
                .legalEntityId("le_001")
                .name("Updated Company Name")
                .build()

        when: "Call API"
        UpdateLegalEntityApiReply response = apiClient.legalentity().v1().updateLegalEntity(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/LegalEntity/edit")
        recordedRequest.method == "POST"

        and: "Request should contain legal_entity_id and updated name"
        def body = getRequestBody(recordedRequest)
        body.contains("legal_entity_id")
        body.contains("le_001")
        body.contains("Updated Company Name")
    }

    def "delLegalEntity - POST /river/LegalEntity/del"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request"
        DelLegalEntityRequest request = DelLegalEntityRequest.builder()
                .companyId("company_001")
                .legalEntityId("le_001")
                .build()

        when: "Call API"
        DelLegalEntityApiReply response = apiClient.legalentity().v1().delLegalEntity(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/LegalEntity/del")
        recordedRequest.method == "POST"

        and: "Request should contain legal_entity_id"
        def body = getRequestBody(recordedRequest)
        body.contains("legal_entity_id")
        body.contains("le_001")
    }

    def "createLegalEntity should handle all optional fields"() {
        given: "A mock success response"
        def responseData = """{
            "legal_entity_id": "le_002",
            "company_id": "company_001",
            "name": "Full Company"
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with all fields"
        CreateLegalEntityRequest request = CreateLegalEntityRequest.builder()
                .companyId("company_001")
                .name("Full Company")
                .outLegalEntityId("out_le_002")
                .address("Test Address")
                .taxpayerNo("123456789")
                .build()

        when: "Call API"
        CreateLegalEntityApiReply response = apiClient.legalentity().v1().createLegalEntity(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain all fields"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("taxpayer_no")
        body.contains("address")
    }

    def "delLegalEntity should support deletion by outLegalEntityId"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with out_legal_entity_id"
        DelLegalEntityRequest request = DelLegalEntityRequest.builder()
                .companyId("company_001")
                .outLegalEntityId("out_le_001")
                .build()

        when: "Call API"
        DelLegalEntityApiReply response = apiClient.legalentity().v1().delLegalEntity(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Query params should contain out_legal_entity_id"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("out_legal_entity_id")
        body.contains("out_le_001")
    }

    def "getLegalEntity should deserialize out_parent_id and pass group params"() {
        given: "A mock success response with 2025.06 new fields"
        def responseData = """{
            "total": 1,
            "records": [{
                "legal_entity_id": 123456,
                "name": "测试主体",
                "parent_id": 112689,
                "out_parent_id": "parent_out_001",
                "out_legal_entity_id": "out_le_001"
            }]
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with group account params"
        GetLegalEntityRequest request = GetLegalEntityRequest.builder()
                .companyId("company_001")
                .offset(0)
                .length(10)
                .belongEnterpriseName("enterprise_001")
                .taxpayerNo("tax_001")
                .build()

        when: "Call API"
        GetLegalEntityApiReply response = apiClient.legalentity().v1().getLegalEntity(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Group query params should be passed"
        def params = getQueryParams(getLastRequest())
        params["belong_enterprise_name"] == "enterprise_001"
        params["taxpayer_no"] == "tax_001"

        and: "Response records should contain out_parent_id"
        def data = response.data
        data != null
        data.records.size() == 1
        data.records[0].outParentId == "parent_out_001"
    }

    def "createLegalEntity should serialize out_parent_id and belong_enterprise_name"() {
        given: "A mock success response"
        def responseData = """{"legal_entity_id": 123456}"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with outParentId and group param"
        CreateLegalEntityRequest request = CreateLegalEntityRequest.builder()
                .companyId("company_001")
                .name("测试主体")
                .outParentId("parent_out_001")
                .belongEnterpriseName("enterprise_001")
                .build()

        when: "Call API"
        CreateLegalEntityApiReply response = apiClient.legalentity().v1().createLegalEntity(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request body should contain new fields"
        def body = getRequestBody(getLastRequest())
        body.contains("out_parent_id")
        body.contains("parent_out_001")
        body.contains("belong_enterprise_name")
    }

    def "updateLegalEntity should serialize out_parent_id"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Update request with outParentId"
        UpdateLegalEntityRequest request = UpdateLegalEntityRequest.builder()
                .companyId("company_001")
                .legalEntityId("123456")
                .outParentId("parent_out_002")
                .build()

        when: "Call API"
        UpdateLegalEntityApiReply response = apiClient.legalentity().v1().updateLegalEntity(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request body should contain out_parent_id"
        def body = getRequestBody(getLastRequest())
        body.contains("out_parent_id")
        body.contains("parent_out_002")
    }

    def "delLegalEntity should pass group account params"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Delete request with group params"
        DelLegalEntityRequest request = DelLegalEntityRequest.builder()
                .companyId("company_001")
                .legalEntityId("123456")
                .belongEnterpriseName("enterprise_001")
                .taxpayerNo("tax_001")
                .build()

        when: "Call API"
        DelLegalEntityApiReply response = apiClient.legalentity().v1().delLegalEntity(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request body should contain group params"
        def body = getRequestBody(getLastRequest())
        body.contains("belong_enterprise_name")
        body.contains("taxpayer_no")
    }

    def "getLegalEntityV2 - GET /open-apis/v2/legalEntity/get"() {
        given: "A mock group-envelope success response"
        def responseData = """{
            "records": [{
                "legal_entity_id": "4503599682991516",
                "name": "集团子公司A",
                "belong_enterprise_name": "集团企业名称",
                "out_legal_entity_id": "out_le_001",
                "parent_id": 0,
                "out_parent_id": "",
                "status": 1
            }],
            "next_token": "v1:cursor_abc",
            "company_total": 1,
            "company_list_has_change": false,
            "progress": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create group request with group params and pagination"
        GetLegalEntityV2Request request = GetLegalEntityV2Request.builder()
                .companyId("company_001")
                .offset(0)
                .length(10)
                .belongEnterpriseName("集团企业名称")
                .querySubCompany("1")
                .build()

        when: "Call group API"
        GetLegalEntityV2ApiReply response = apiClient.legalentity().v1().getLegalEntityV2(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should hit group path with group params"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/open-apis/v2/legalEntity/get")
        def params = getQueryParams(recordedRequest)
        URLDecoder.decode(params["belong_enterprise_name"], "UTF-8") == "集团企业名称"
        params["query_sub_company"] == "1"
        params["offset"] == "0"
        params["length"] == "10"

        and: "Envelope fields should be deserialized"
        response.data.nextToken == "v1:cursor_abc"
        response.data.companyTotal == 1
        response.data.companyListHasChange == false
        response.data.progress == 1

        and: "Record should use String legal_entity_id without precision loss"
        response.data.records.size() == 1
        def record = response.data.records[0]
        record.legalEntityId == "4503599682991516"
        record.legalEntityId instanceof String
        record.belongEnterpriseName == "集团企业名称"
    }

    def "getLegalEntityV2 should support next_token pagination and empty token means no more"() {
        given: "A mock group response with empty next_token"
        def responseData = """{
            "records": [],
            "next_token": "",
            "company_total": 0,
            "progress": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create group request with next_token from previous page"
        GetLegalEntityV2Request request = GetLegalEntityV2Request.builder()
                .companyId("company_001")
                .offset(10)
                .length(10)
                .taxpayerNo("tax_001")
                .nextToken("v1:cursor_prev")
                .build()

        when: "Call group API"
        GetLegalEntityV2ApiReply response = apiClient.legalentity().v1().getLegalEntityV2(request)

        then: "Response should be successful with empty next_token"
        response != null
        response.errno == 0
        response.data.nextToken == ""
        response.data.records.isEmpty()

        and: "next_token and taxpayer_no should be passed as query params"
        def params = getQueryParams(getLastRequest())
        URLDecoder.decode(params["next_token"], "UTF-8") == "v1:cursor_prev"
        params["taxpayer_no"] == "tax_001"
    }
}
