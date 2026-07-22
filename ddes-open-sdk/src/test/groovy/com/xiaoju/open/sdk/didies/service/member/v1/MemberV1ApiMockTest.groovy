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

    def "listMember should deserialize new MemberRecord fields and pass new query params"() {
        given: "A mock success response with new nested fields"
        def responseData = """{
            "records": [{
                "id": "mem_001",
                "realname": "John Doe",
                "phone": "13800138000",
                "status": 1,
                "third_user_id": "ext_user_001",
                "guest_car_right": 0,
                "month_quota": "1000.00",
                "cert_realname": "张三",
                "cert_english_surname": "Zhang",
                "cert_english_name": "San",
                "residents_list": [{"id": 100, "name": "北京", "adcode": "110000"}],
                "limit_rule_list": [{
                    "rule_name": "月度限额",
                    "budget_cycle": 1,
                    "is_accumulative": 1,
                    "total_quota": 1000.00,
                    "available_quota": 800.00,
                    "freeze_quota": 50.00,
                    "limit_management_scope": 1
                }],
                "home_address": [{
                    "city": "北京",
                    "city_id": 1,
                    "city_adcode": "110100",
                    "address_name": "海淀区xx路"
                }]
            }],
            "total": 1,
            "last_id": "cursor_001"
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with new group-account and pagination query params"
        ListMemberRequest request = ListMemberRequest.builder()
                .companyId("company_001")
                .offset(0)
                .length(100)
                .belongEnterpriseName("enterprise_001")
                .taxpayerNo("tax_001")
                .querySubCompany("1")
                .nextToken("next_token_001")
                .build()

        when: "Call API"
        ListMemberApiReply response = apiClient.member().v1().listMember(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "New query params should be passed"
        RecordedRequest recordedRequest = getLastRequest()
        def params = getQueryParams(recordedRequest)
        params["belong_enterprise_name"] == "enterprise_001"
        params["taxpayer_no"] == "tax_001"
        params["query_sub_company"] == "1"
        params["next_token"] == "next_token_001"

        and: "New MemberRecord fields should be deserialized"
        def data = response.data
        data != null
        data.lastId == "cursor_001"
        data.records != null
        data.records.size() == 1
        def record = data.records[0]
        record.status == 1
        record.thirdUserId == "ext_user_001"
        record.guestCarRight == 0
        record.monthQuota == "1000.00"
        record.certRealname == "张三"
        record.certEnglishSurname == "Zhang"
        record.certEnglishName == "San"

        and: "Nested residents_list should be deserialized"
        record.residentsList != null
        record.residentsList.size() == 1
        record.residentsList[0].id == 100L
        record.residentsList[0].name == "北京"
        record.residentsList[0].adcode == "110000"

        and: "Nested limit_rule_list should be deserialized"
        record.limitRuleList != null
        record.limitRuleList.size() == 1
        def rule = record.limitRuleList[0]
        rule.ruleName == "月度限额"
        rule.budgetCycle == 1
        rule.isAccumulative == 1
        rule.totalQuota == 1000.00d
        rule.availableQuota == 800.00d
        rule.freezeQuota == 50.00d
        rule.limitManagementScope == 1

        and: "Nested home_address should be deserialized"
        record.homeAddress != null
        record.homeAddress.size() == 1
        record.homeAddress[0].city == "北京"
        record.homeAddress[0].cityId == 1
        record.homeAddress[0].cityAdcode == "110100"
        record.homeAddress[0].addressName == "海淀区xx路"
    }

    def "getMemberDetail should deserialize new nested fields and pass new query params"() {
        given: "A mock success response with new nested fields"
        def responseData = """{
            "member_id": "mem_001",
            "realname": "John Doe",
            "phone": "13800138000",
            "status": 1,
            "cert_realname": "张三",
            "cert_english_surname": "Zhang",
            "cert_english_name": "San",
            "residents_list": [{"id": 100, "name": "北京", "adcode": "110000"}],
            "limit_rule_list": [{
                "rule_name": "月度限额",
                "budget_cycle": 1,
                "is_accumulative": 1,
                "total_quota": 1000.00,
                "available_quota": 800.00,
                "freeze_quota": 50.00,
                "limit_management_scope": 1
            }],
            "home_address": [{
                "city": "北京",
                "city_id": 1,
                "city_adcode": "110100",
                "address_name": "海淀区xx路"
            }]
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with new group-account query params"
        GetMemberDetailRequest request = GetMemberDetailRequest.builder()
                .companyId("company_001")
                .phone("13800138000")
                .belongEnterpriseName("enterprise_001")
                .taxpayerNo("tax_001")
                .build()

        when: "Call API"
        GetMemberDetailApiReply response = apiClient.member().v1().getMemberDetail(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "New query params should be passed"
        RecordedRequest recordedRequest = getLastRequest()
        def params = getQueryParams(recordedRequest)
        params["belong_enterprise_name"] == "enterprise_001"
        params["taxpayer_no"] == "tax_001"

        and: "New detail fields should be deserialized"
        def data = response.data
        data != null
        data.status == 1
        data.certRealname == "张三"
        data.certEnglishSurname == "Zhang"
        data.certEnglishName == "San"

        and: "Nested residents_list should be deserialized (id is Long)"
        data.residentsList != null
        data.residentsList.size() == 1
        data.residentsList[0].id == 100L
        data.residentsList[0].name == "北京"
        data.residentsList[0].adcode == "110000"

        and: "Nested limit_rule_list should be deserialized with Double quota fields"
        data.limitRuleList != null
        data.limitRuleList.size() == 1
        def rule = data.limitRuleList[0]
        rule.ruleName == "月度限额"
        rule.budgetCycle == 1
        rule.isAccumulative == 1
        rule.totalQuota == 1000.00d
        rule.availableQuota == 800.00d
        rule.freezeQuota == 50.00d
        rule.limitManagementScope == 1

        and: "Nested home_address should be deserialized (city_id is Integer)"
        data.homeAddress != null
        data.homeAddress.size() == 1
        data.homeAddress[0].city == "北京"
        data.homeAddress[0].cityId == 1
        data.homeAddress[0].cityAdcode == "110100"
        data.homeAddress[0].addressName == "海淀区xx路"
    }

    def "getMemberDetail should handle null and empty nested lists without error"() {
        given: "A mock response with null/empty nested lists"
        def responseData = """{
            "member_id": "mem_001",
            "realname": "John Doe",
            "status": 4,
            "residents_list": null,
            "limit_rule_list": [],
            "home_address": []
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetMemberDetailRequest request = GetMemberDetailRequest.builder()
                .companyId("company_001")
                .memberId("mem_001")
                .build()

        when: "Call API"
        GetMemberDetailApiReply response = apiClient.member().v1().getMemberDetail(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Null/empty lists should not cause errors"
        def data = response.data
        data != null
        data.status == 4
        data.residentsList == null
        data.limitRuleList != null
        data.limitRuleList.isEmpty()
        data.homeAddress != null
        data.homeAddress.isEmpty()
    }

    def "listMember should handle empty records array"() {
        given: "A mock success response with empty records"
        def responseData = """{
            "records": [],
            "total": 0,
            "last_id": ""
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

        then: "Response should be successful with empty records"
        response != null
        response.errno == 0
        def data = response.data
        data != null
        data.records != null
        data.records.isEmpty()
        data.total == 0
    }
}
