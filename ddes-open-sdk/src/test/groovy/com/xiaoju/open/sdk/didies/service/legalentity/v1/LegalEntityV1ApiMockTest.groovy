package com.xiaoju.open.sdk.didies.service.legalentity.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.*
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
}
