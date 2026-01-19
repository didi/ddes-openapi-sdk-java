package com.xiaoju.open.sdk.didies.service.member.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.member.v1.model.*
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for Member V1
 * Tests all Member APIs with proper request/response validation
 */
class MemberV1ApiMockTest extends BaseMockTest {

    def "listMember - GET /river/Member/get"() {
        given: "A mock success response"
        def responseData = """{
            "members": [{
                "member_id": "mem_001",
                "realname": "John Doe",
                "phone": "13800138000",
                "employee_number": "EMP001"
            }],
            "total": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        ListMemberRequest request = ListMemberRequest.builder()
                .companyId("company_001")
                .length(100)
                .offset(0)
                .build()

        when: "Call API"
        ListMemberApiReply response = apiClient.member().v1().listMember(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Member/get")
        recordedRequest.method == "GET"
        verifyRequiredHeaders(recordedRequest)

        and: "Query params should contain required fields"
        def params = getQueryParams(recordedRequest)
        params["company_id"] == "company_001"
        params["length"] == "100"
        params["offset"] == "0"
    }

    def "getMemberDetail - GET /river/Member/detail"() {
        given: "A mock success response"
        def responseData = """{
            "member_id": "mem_001",
            "realname": "John Doe",
            "phone": "13800138000",
            "email": "john@example.com",
            "employee_number": "EMP001",
            "status": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetMemberDetailRequest request = GetMemberDetailRequest.builder()
                .companyId("company_001")
                .phone("13800138000")
                .build()

        when: "Call API"
        GetMemberDetailApiReply response = apiClient.member().v1().getMemberDetail(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Member/detail")
        recordedRequest.method == "GET"

        and: "Query params should contain phone"
        def params = getQueryParams(recordedRequest)
        params["company_id"] == "company_001"
        params["phone"] == "13800138000"
    }

    def "createMember - POST /river/Member/single"() {
        given: "A mock success response"
        def responseData = """{
            "member_id": "mem_001",
            "phone": "13800138000",
            "realname": "John Doe"
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with dataObj"
        def memberInfo = MemberInfo.builder()
                .phone("13800138000")
                .realname("John Doe")
                .employeeNumber("EMP001")
                .memberType(0)
                .build()
        CreateMemberRequest request = CreateMemberRequest.builder()
                .companyId("company_001")
                .dataObj(memberInfo)
                .build()

        when: "Call API"
        CreateMemberApiReply response = apiClient.member().v1().createMember(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Member/single")
        recordedRequest.method == "POST"

        and: "Request body should contain data"
        def body = getRequestBody(recordedRequest)
        body.contains("data")
        body.contains("phone")
        body.contains("realname")
        body.contains("employee_number")
    }

    def "updateMember - POST /river/Member/edit"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with dataObj and memberId"
        def memberInfo = MemberInfo.builder()
                .realname("Updated Name")
                .build()
        UpdateMemberRequest request = UpdateMemberRequest.builder()
                .companyId("company_001")
                .memberId(12345L)
                .dataObj(memberInfo)
                .build()

        when: "Call API"
        UpdateMemberApiReply response = apiClient.member().v1().updateMember(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Member/edit")
        recordedRequest.method == "POST"

        and: "Request should contain member_id and updated data"
        def body = getRequestBody(recordedRequest)
        body.contains("member_id")
        body.contains("data")
    }

    def "delMember - POST /river/Member/del"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with memberId"
        DelMemberRequest request = DelMemberRequest.builder()
                .companyId("company_001")
                .memberId("12345")
                .build()

        when: "Call API"
        DelMemberApiReply response = apiClient.member().v1().delMember(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Member/del")
        recordedRequest.method == "POST"

        and: "Request should contain member_id"
        def body = getRequestBody(recordedRequest)
        body.contains("member_id")
        body.contains("12345")
    }

    def "getMemberQuota - GET /river/Member/getQuota"() {
        given: "A mock success response"
        def responseData = """{
            "12345": [{
                "quota_type": 1,
                "quota_amount": 1000.00,
                "used_amount": 500.00
            }]
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetMemberQuotaRequest request = GetMemberQuotaRequest.builder()
                .companyId("company_001")
                .memberIds("12345,12346")
                .startDate("2024-01-01")
                .endDate("2024-01-31")
                .build()

        when: "Call API"
        GetMemberQuotaApiReply response = apiClient.member().v1().getMemberQuota(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Member/getQuota")
        recordedRequest.method == "GET"

        and: "Query params should contain required fields"
        def params = getQueryParams(recordedRequest)
        params["member_ids"].contains("12345")
        params["start_date"] == "2024-01-01"
        params["end_date"] == "2024-01-31"
    }

    def "listMember should support pagination"() {
        given: "A mock success response"
        def responseData = """{
            "members": [
                {"member_id": "mem_001", "realname": "John"},
                {"member_id": "mem_002", "realname": "Jane"}
            ],
            "total": 10,
            "length": 2,
            "offset": 0
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with pagination"
        ListMemberRequest request = ListMemberRequest.builder()
                .companyId("company_001")
                .length(2)
                .offset(0)
                .build()

        when: "Call API"
        ListMemberApiReply response = apiClient.member().v1().listMember(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain pagination parameters"
        RecordedRequest recordedRequest = getLastRequest()
        def params = getQueryParams(recordedRequest)
        params["length"] == "2"
        params["offset"] == "0"
    }

    def "createMember should handle email as unique identifier"() {
        given: "A mock success response"
        def responseData = """{
            "member_id": "mem_002",
            "email": "jane@example.com",
            "realname": "Jane Doe"
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with email"
        def memberInfo = MemberInfo.builder()
                .email("jane@example.com")
                .realname("Jane Doe")
                .memberType(2)
                .build()
        CreateMemberRequest request = CreateMemberRequest.builder()
                .companyId("company_001")
                .dataObj(memberInfo)
                .build()

        when: "Call API"
        CreateMemberApiReply response = apiClient.member().v1().createMember(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain email"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("data")
        body.contains("email")
    }

    def "delMember should support deletion by employeeNumber"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with employee_number"
        DelMemberRequest request = DelMemberRequest.builder()
                .companyId("company_001")
                .employeeNumber("EMP001")
                .build()

        when: "Call API"
        DelMemberApiReply response = apiClient.member().v1().delMember(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain employee_number"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("employee_number")
        body.contains("EMP001")
    }

    def "getMemberDetail should handle error response"() {
        given: "A mock error response"
        enqueueSuccess(createErrorResponse(404, "Member not found"))

        and: "Create request with non-existent phone"
        GetMemberDetailRequest request = GetMemberDetailRequest.builder()
                .companyId("company_001")
                .phone("99999999999")
                .build()

        when: "Call API"
        GetMemberDetailApiReply response = apiClient.member().v1().getMemberDetail(request)

        then: "Response should contain error information"
        response != null
        response.errno == 404
        response.errmsg == "Member not found"
    }
}
