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

    def "getBudgetCenter should deserialize limit_rule_list, extend_field and poi_list"() {
        given: "A mock success response with full fields"
        def responseData = """{
            "total": 1,
            "records": [{
                "id": "6388733755640532997",
                "name": "openapi_test",
                "type": "2",
                "status": "1",
                "out_parent_id": "out_parent_001",
                "out_legal_entity_id": "out_le_001",
                "department_id": "dept_001,dept_002",
                "out_department_id": "out_dept_001,out_dept_002",
                "scope": "include_sub",
                "budget_cycle": 4,
                "out_budget_id": "out_bc_001",
                "total_quota": "1000.00",
                "is_limit_quota": 1,
                "member_num": 10,
                "available_quota": "800.00",
                "freeze_quota": "200.00",
                "leader_id": "leader_001",
                "leader_item_list": [
                    {"leader_id": "leader_001", "leader_name": "Zhang San", "leader_type": "major"}
                ],
                "parent_id": "parent_001",
                "member_used": 2,
                "start_date": "2026-01-01",
                "expiry_date": "2026-12-31",
                "legal_entity_id": "le_001",
                "budget_extra_info": "{\\"test\\":\\"val\\"}",
                "limit_rule_list": [
                    {
                        "rule_name": "成本中心限额（默认）",
                        "budget_cycle": 4,
                        "is_accumulative": 0,
                        "total_quota": "100.99",
                        "limit_management_scope": 0,
                        "available_quota": "100.99",
                        "freeze_quota": "0.00"
                    }
                ],
                "extend_field": [
                    {"id": 1, "code": "custom_field", "value": "custom_value"}
                ],
                "poi_list": [
                    {"city": "北京", "city_id": 1, "city_adcode": "110000", "flat": 39.9, "flng": 116.4, "poi_range": 500, "label": "Office"}
                ]
            }]
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with new query params"
        GetBudgetCenterRequest request = GetBudgetCenterRequest.builder()
                .companyId("company_001")
                .offset(0)
                .length(100)
                .isNeedLimitRule(1)
                .isGetPoi(1)
                .isGetExtendFields(1)
                .build()

        when: "Call API"
        GetBudgetCenterApiReply response = apiClient.budgetcenter().v1().getBudgetCenter(request)

        then: "Response should be successful"
        response.errno == 0
        response.data != null
        response.data.total == "1"
        response.data.records != null
        response.data.records.size() == 1

        and: "New simple fields should be deserialized"
        def record = response.data.records[0]
        record.status == "1"
        record.outParentId == "out_parent_001"
        record.outLegalEntityId == "out_le_001"
        record.departmentId == "dept_001,dept_002"
        record.outDepartmentId == "out_dept_001,out_dept_002"
        record.scope == "include_sub"

        and: "limit_rule_list should be deserialized"
        record.limitRuleList != null
        record.limitRuleList.size() == 1
        record.limitRuleList[0].ruleName == "成本中心限额（默认）"
        record.limitRuleList[0].budgetCycle == 4
        record.limitRuleList[0].isAccumulative == 0
        record.limitRuleList[0].totalQuota == "100.99"
        record.limitRuleList[0].limitManagementScope == 0
        record.limitRuleList[0].availableQuota == "100.99"
        record.limitRuleList[0].freezeQuota == "0.00"

        and: "extend_field should be deserialized"
        record.extendField != null
        record.extendField.size() == 1
        record.extendField[0].id == 1L
        record.extendField[0].code == "custom_field"
        record.extendField[0].value == "custom_value"

        and: "poi_list should be deserialized"
        record.poiList != null
        record.poiList.size() == 1
        record.poiList[0].city == "北京"
        record.poiList[0].cityId == 1
        record.poiList[0].cityAdcode == "110000"
        record.poiList[0].flat == 39.9
        record.poiList[0].flng == 116.4
        record.poiList[0].poiRange == 500
        record.poiList[0].label == "Office"
    }

    def "getBudgetCenter should pass new query params correctly"() {
        given: "A mock success response"
        def responseData = """{"total": 0, "records": []}"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with new query params"
        GetBudgetCenterRequest request = GetBudgetCenterRequest.builder()
                .companyId("company_001")
                .offset(0)
                .length(100)
                .isNeedLimitRule(1)
                .isGetPoi(1)
                .isGetExtendFields(1)
                .build()

        when: "Call API"
        GetBudgetCenterApiReply response = apiClient.budgetcenter().v1().getBudgetCenter(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Query params should contain new fields"
        RecordedRequest recordedRequest = getLastRequest()
        def params = getQueryParams(recordedRequest)
        params["is_need_limit_rule"] == "1"
        params["is_get_poi"] == "1"
        params["is_get_extend_fields"] == "1"
    }

    def "getBudgetCenter should not send null new query params"() {
        given: "A mock success response"
        def responseData = """{"total": 0, "records": []}"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request without new query params"
        GetBudgetCenterRequest request = GetBudgetCenterRequest.builder()
                .companyId("company_001")
                .offset(0)
                .length(100)
                .build()

        when: "Call API"
        GetBudgetCenterApiReply response = apiClient.budgetcenter().v1().getBudgetCenter(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Query params should not contain new fields when not set"
        RecordedRequest recordedRequest = getLastRequest()
        def params = getQueryParams(recordedRequest)
        !params.containsKey("is_need_limit_rule")
        !params.containsKey("is_get_poi")
        !params.containsKey("is_get_extend_fields")
    }
}
