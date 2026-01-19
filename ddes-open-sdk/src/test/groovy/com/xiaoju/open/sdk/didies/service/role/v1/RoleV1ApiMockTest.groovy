package com.xiaoju.open.sdk.didies.service.role.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.role.v1.model.ListRoleApiReply
import com.xiaoju.open.sdk.didies.service.role.v1.model.ListRoleRequest
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for Role V1
 * Tests all Role APIs with proper request/response validation
 */
class RoleV1ApiMockTest extends BaseMockTest {

    def "listRole - GET /river/Role/get"() {
        given: "A mock success response"
        def responseData = """[
            {
                "id": "role_001",
                "name": "管理员",
                "alias": "admin"
            },
            {
                "id": "role_002",
                "name": "普通员工",
                "alias": "employee"
            }
        ]"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        ListRoleRequest request = ListRoleRequest.builder()
                .companyId("company_001")
                .build()

        when: "Call API"
        ListRoleApiReply response = apiClient.role().v1().listRole(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Role/get")
        recordedRequest.method == "GET"
        verifyRequiredHeaders(recordedRequest)

        and: "Query params should contain company_id"
        def params = getQueryParams(recordedRequest)
        params["company_id"] == "company_001"
    }

    def "listRole should handle empty response"() {
        given: "A mock empty response"
        enqueueSuccess(createSuccessResponse("[]"))

        and: "Create request"
        ListRoleRequest request = ListRoleRequest.builder()
                .companyId("company_001")
                .build()

        when: "Call API"
        ListRoleApiReply response = apiClient.role().v1().listRole(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.data != null
        response.data.isEmpty()
    }

    def "listRole should handle single role"() {
        given: "A mock success response with single role"
        def responseData = """[
            {
                "id": "role_001",
                "name": "管理员",
                "alias": "admin"
            }
        ]"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        ListRoleRequest request = ListRoleRequest.builder()
                .companyId("company_001")
                .build()

        when: "Call API"
        ListRoleApiReply response = apiClient.role().v1().listRole(request)

        then: "Response should be successful"
        response.errno == 0
        response.data.size() == 1
        response.data[0].id == "role_001"
        response.data[0].name == "管理员"
    }

    def "listRole should validate all role fields"() {
        given: "A mock success response"
        def responseData = """[
            {
                "id": "role_001",
                "name": "超级管理员",
                "alias": "super_admin"
            }
        ]"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        ListRoleRequest request = ListRoleRequest.builder()
                .companyId("company_001")
                .build()

        when: "Call API"
        ListRoleApiReply response = apiClient.role().v1().listRole(request)

        then: "Response should contain all fields"
        response.errno == 0
        response.data[0].id == "role_001"
        response.data[0].name == "超级管理员"
        response.data[0].alias == "super_admin"
    }

    def "listRole should handle error response"() {
        given: "A mock error response"
        enqueueSuccess(createErrorResponse(400, "Invalid company_id"))

        and: "Create request"
        ListRoleRequest request = ListRoleRequest.builder()
                .companyId("invalid_company")
                .build()

        when: "Call API"
        ListRoleApiReply response = apiClient.role().v1().listRole(request)

        then: "Response should contain error information"
        response != null
        response.errno == 400
        response.errmsg == "Invalid company_id"
    }
}
