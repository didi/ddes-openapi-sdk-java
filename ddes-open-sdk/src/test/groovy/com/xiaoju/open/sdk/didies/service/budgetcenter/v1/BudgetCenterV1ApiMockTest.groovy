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
            "records": [{
                "id": "bc_12345",
                "name": "Test Budget Center",
                "status": "1"
            }],
            "total": "1"
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
        response.data != null
        response.data.total == "1"
        response.data.records != null
        response.data.records.size() == 1
        response.data.records[0].id == "bc_12345"
        response.data.records[0].name == "Test Budget Center"

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

    def "updateBudgetCenter should serialize out_travelers__obj__ and pass operate_type"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with out_travelers__obj__ and operate_type"
        def outTraveler = OutTravelerItem.builder()
                .outTravelerId("out_traveler_002")
                .build()
        UpdateBudgetCenterRequest request = UpdateBudgetCenterRequest.builder()
                .companyId("company_001")
                .id("bc_12345")
                .type(2)
                .outTravelersObj(Arrays.asList(outTraveler))
                .operateType("append")
                .build()

        when: "Call API"
        UpdateBudgetCenterApiReply response = apiClient.budgetcenter().v1().updateBudgetCenter(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "out_travelers__obj__ should be serialized and operate_type present"
        RecordedRequest recordedRequest = getLastRequest()
        def json = parseJsonBody(getRequestBody(recordedRequest))
        json.containsKey("out_travelers")
        !json.containsKey("out_travelers__obj__")
        (json["out_travelers"] as String).contains("out_traveler_002")
        json["operate_type"] == "append"
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
            "records": [
                {"id": "bc_1", "name": "Center 1"},
                {"id": "bc_2", "name": "Center 2"}
            ],
            "total": "10"
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
        response.data != null
        response.data.total == "10"
        response.data.records != null
        response.data.records.size() == 2
        response.data.records[0].id == "bc_1"
        response.data.records[1].name == "Center 2"

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

    def "createBudgetCenter should serialize out_travelers__obj__ to out_travelers json string"() {
        given: "A mock success response"
        def responseData = """{
            "budget_center_id": "bc_12345",
            "company_id": "company_001",
            "name": "Test Project",
            "type": 2
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with out_travelers__obj__ and belong_enterprise_name"
        def outTraveler = OutTravelerItem.builder()
                .outTravelerId("out_traveler_001")
                .id(1001L)
                .relatedEmployees(Arrays.asList(
                        RelatedEmployeeItem.builder()
                                .relatedEmployeeId("emp_001")
                                .employeeNumber("EMP001")
                                .build()
                ))
                .build()
        def extendField = ExtendFieldItem.builder()
                .id(100)
                .code("ext_code_001")
                .value("ext_value_001")
                .build()
        def poi = PoiItem.builder()
                .city("北京")
                .cityId(1)
                .build()
        CreateBudgetCenterRequest request = CreateBudgetCenterRequest.builder()
                .companyId("company_001")
                .name("Test Project")
                .type(2)
                .outTravelersObj(Arrays.asList(outTraveler))
                .extendFieldObj(Arrays.asList(extendField))
                .poiListObj(Arrays.asList(poi))
                .belongEnterpriseName("enterprise_001")
                .taxpayerNo("tax_001")
                .outLegalEntityId("legal_001")
                .build()

        when: "Call API"
        CreateBudgetCenterApiReply response = apiClient.budgetcenter().v1().createBudgetCenter(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "out_travelers__obj__ should be serialized to out_travelers json string"
        RecordedRequest recordedRequest = getLastRequest()
        def json = parseJsonBody(getRequestBody(recordedRequest))
        json.containsKey("out_travelers")
        !json.containsKey("out_travelers__obj__")
        def outTravelersStr = json["out_travelers"] as String
        outTravelersStr.contains("out_traveler_001")
        outTravelersStr.contains("related_employees")
        outTravelersStr.contains("emp_001")

        and: "extend_field__obj__ should be serialized to extend_field json string"
        json.containsKey("extend_field")
        !json.containsKey("extend_field__obj__")
        def extendFieldStr = json["extend_field"] as String
        extendFieldStr.contains("ext_code_001")
        extendFieldStr.contains("ext_value_001")

        and: "poi_list__obj__ should be serialized to poi_list json string"
        json.containsKey("poi_list")
        !json.containsKey("poi_list__obj__")
        def poiListStr = json["poi_list"] as String
        poiListStr.contains("ext_code_001") == false
        poiListStr.contains("city")

        and: "new group-account fields should be present"
        json["belong_enterprise_name"] == "enterprise_001"
        json["taxpayer_no"] == "tax_001"
        json["out_legal_entity_id"] == "legal_001"
    }

    def "delBudgetCenter should pass belong_enterprise_name/taxpayer_no/out_legal_entity_id"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with group-account fields"
        DelBudgetCenterRequest request = DelBudgetCenterRequest.builder()
                .companyId("company_001")
                .type(1)
                .id("1125904357323169")
                .belongEnterpriseName("测试企业")
                .taxpayerNo("91110000MA001")
                .outLegalEntityId("LE001")
                .build()

        when: "Call API"
        DelBudgetCenterApiReply response = apiClient.budgetcenter().v1().delBudgetCenter(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should contain group-account fields"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/BudgetCenter/del")
        recordedRequest.method == "POST"
        def json = parseJsonBody(getRequestBody(recordedRequest))
        json["company_id"] == "company_001"
        json["type"] == 1
        json["id"] == "1125904357323169"
        json["belong_enterprise_name"] == "测试企业"
        json["taxpayer_no"] == "91110000MA001"
        json["out_legal_entity_id"] == "LE001"
    }

    def "delBudgetCenter should not send null group-account fields"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with only required fields"
        DelBudgetCenterRequest request = DelBudgetCenterRequest.builder()
                .companyId("company_001")
                .id("bc_12345")
                .build()

        when: "Call API"
        DelBudgetCenterApiReply response = apiClient.budgetcenter().v1().delBudgetCenter(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Null group-account fields should be absent from body"
        RecordedRequest recordedRequest = getLastRequest()
        def json = parseJsonBody(getRequestBody(recordedRequest))
        !json.containsKey("belong_enterprise_name")
        !json.containsKey("taxpayer_no")
        !json.containsKey("out_legal_entity_id")
    }

    def "createBudgetCenter should pass department_id/out_department_id/scope and group-account fields"() {
        given: "A mock success response"
        def responseData = """{
            "budget_center_id": "bc_12345",
            "company_id": "company_001",
            "name": "Group Project",
            "type": 2
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with department + group-account fields"
        CreateBudgetCenterRequest request = CreateBudgetCenterRequest.builder()
                .companyId("company_001")
                .name("Group Project")
                .type(2)
                .memberUsed(2)
                .departmentId("dept_001,dept_002")
                .outDepartmentId("out_dept_001,out_dept_002")
                .scope("include_sub")
                .belongEnterpriseName("enterprise_001")
                .taxpayerNo("tax_001")
                .outLegalEntityId("legal_001")
                .build()

        when: "Call API"
        CreateBudgetCenterApiReply response = apiClient.budgetcenter().v1().createBudgetCenter(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request body should contain department and group-account fields"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/BudgetCenter/add")
        recordedRequest.method == "POST"
        def json = parseJsonBody(getRequestBody(recordedRequest))
        json["department_id"] == "dept_001,dept_002"
        json["out_department_id"] == "out_dept_001,out_dept_002"
        json["scope"] == "include_sub"
        json["member_used"] == 2
        json["belong_enterprise_name"] == "enterprise_001"
        json["taxpayer_no"] == "tax_001"
        json["out_legal_entity_id"] == "legal_001"
    }

    def "createBudgetCenter should keep original extend_field when both extendField and extendFieldObj set"() {
        given: "A mock success response"
        enqueueSuccess(createSuccessResponse("""{"budget_center_id":"bc_x"}"""))

        and: "Create request where extend_field is explicitly set AND extendFieldObj is set"
        def extendField = ExtendFieldItem.builder()
                .id(2)
                .code("obj_code")
                .value("obj_value")
                .build()
        CreateBudgetCenterRequest request = CreateBudgetCenterRequest.builder()
                .companyId("company_001")
                .name("Priority Project")
                .type(2)
                .extendField("[{\"id\":1}]")
                .extendFieldObj(Arrays.asList(extendField))
                .build()

        when: "Call API"
        apiClient.budgetcenter().v1().createBudgetCenter(request)

        then: "extend_field keeps the explicit value (not overwritten by __obj__)"
        RecordedRequest recordedRequest = getLastRequest()
        def json = parseJsonBody(getRequestBody(recordedRequest))
        json.containsKey("extend_field")
        json["extend_field"] == "[{\"id\":1}]"
        (json["extend_field"] as String).contains("obj_code") == false
        (json["extend_field"] as String).contains("obj_value") == false
    }

    def "createBudgetCenter should keep original poi_list when both poiList and poiListObj set"() {
        given: "A mock success response"
        enqueueSuccess(createSuccessResponse("""{"budget_center_id":"bc_x"}"""))

        and: "Create request where poi_list is explicitly set AND poiListObj is set"
        def poi = PoiItem.builder()
                .city("北京")
                .cityId(1)
                .build()
        CreateBudgetCenterRequest request = CreateBudgetCenterRequest.builder()
                .companyId("company_001")
                .name("Poi Priority Project")
                .type(2)
                .poiList("[{\"city\":\"上海\"}]")
                .poiListObj(Arrays.asList(poi))
                .build()

        when: "Call API"
        apiClient.budgetcenter().v1().createBudgetCenter(request)

        then: "poi_list keeps the explicit value (not overwritten by __obj__)"
        RecordedRequest recordedRequest = getLastRequest()
        def json = parseJsonBody(getRequestBody(recordedRequest))
        json.containsKey("poi_list")
        json["poi_list"] == "[{\"city\":\"上海\"}]"
        (json["poi_list"] as String).contains("北京") == false
    }

    def "createBudgetCenter should keep original out_travelers when both outTravelers and outTravelersObj set"() {
        given: "A mock success response"
        enqueueSuccess(createSuccessResponse("""{"budget_center_id":"bc_x"}"""))

        and: "Create request where out_travelers is explicitly set AND outTravelersObj is set"
        def outTraveler = OutTravelerItem.builder()
                .outTravelerId("obj_traveler_001")
                .build()
        CreateBudgetCenterRequest request = CreateBudgetCenterRequest.builder()
                .companyId("company_001")
                .name("Traveler Priority Project")
                .type(2)
                .outTravelers("[{\"out_traveler_id\":\"raw_traveler_001\"}]")
                .outTravelersObj(Arrays.asList(outTraveler))
                .build()

        when: "Call API"
        apiClient.budgetcenter().v1().createBudgetCenter(request)

        then: "out_travelers keeps the explicit value (not overwritten by __obj__)"
        RecordedRequest recordedRequest = getLastRequest()
        def json = parseJsonBody(getRequestBody(recordedRequest))
        json.containsKey("out_travelers")
        json["out_travelers"] == "[{\"out_traveler_id\":\"raw_traveler_001\"}]"
        (json["out_travelers"] as String).contains("obj_traveler_001") == false
    }

    def "updateBudgetCenter should keep original extend_field when both extendField and extendFieldObj set"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request where extend_field is explicitly set AND extendFieldObj is set"
        def extendField = ExtendFieldItem.builder()
                .id(2)
                .code("obj_code")
                .value("obj_value")
                .build()
        UpdateBudgetCenterRequest request = UpdateBudgetCenterRequest.builder()
                .companyId("company_001")
                .id("bc_12345")
                .type(2)
                .extendField("[{\"id\":1}]")
                .extendFieldObj(Arrays.asList(extendField))
                .build()

        when: "Call API"
        apiClient.budgetcenter().v1().updateBudgetCenter(request)

        then: "extend_field keeps the explicit value (not overwritten by __obj__)"
        RecordedRequest recordedRequest = getLastRequest()
        def json = parseJsonBody(getRequestBody(recordedRequest))
        json.containsKey("extend_field")
        json["extend_field"] == "[{\"id\":1}]"
        (json["extend_field"] as String).contains("obj_code") == false
        (json["extend_field"] as String).contains("obj_value") == false
    }

    def "createBudgetCenter should not send __obj__ fields when only plain fields set"() {
        given: "A mock success response"
        enqueueSuccess(createSuccessResponse("""{"budget_center_id":"bc_x"}"""))

        and: "Create request with plain json-string fields but no __obj__ fields"
        CreateBudgetCenterRequest request = CreateBudgetCenterRequest.builder()
                .companyId("company_001")
                .name("Plain Project")
                .type(2)
                .extendField("[{\"id\":1,\"code\":\"c1\"}]")
                .poiList("[{\"city\":\"北京\"}]")
                .outTravelers("[{\"out_traveler_id\":\"t1\"}]")
                .build()

        when: "Call API"
        apiClient.budgetcenter().v1().createBudgetCenter(request)

        then: "body should not contain any __obj__ suffix fields"
        RecordedRequest recordedRequest = getLastRequest()
        def json = parseJsonBody(getRequestBody(recordedRequest))
        json["extend_field"] == "[{\"id\":1,\"code\":\"c1\"}]"
        json["poi_list"] == "[{\"city\":\"北京\"}]"
        json["out_travelers"] == "[{\"out_traveler_id\":\"t1\"}]"
        !json.containsKey("extend_field__obj__")
        !json.containsKey("poi_list__obj__")
        !json.containsKey("out_travelers__obj__")
    }

    def "createBudgetCenter should not send null optional new fields when only required set"() {
        given: "A mock success response"
        enqueueSuccess(createSuccessResponse("""{"budget_center_id":"bc_min"}"""))

        and: "Create request with only required fields"
        CreateBudgetCenterRequest request = CreateBudgetCenterRequest.builder()
                .companyId("company_001")
                .name("Min Project")
                .type(2)
                .build()

        when: "Call API"
        apiClient.budgetcenter().v1().createBudgetCenter(request)

        then: "new optional fields should be absent from body"
        RecordedRequest recordedRequest = getLastRequest()
        def json = parseJsonBody(getRequestBody(recordedRequest))
        json["company_id"] == "company_001"
        json["name"] == "Min Project"
        json["type"] == 2
        !json.containsKey("department_id")
        !json.containsKey("out_department_id")
        !json.containsKey("scope")
        !json.containsKey("extend_field")
        !json.containsKey("extend_field__obj__")
        !json.containsKey("poi_list")
        !json.containsKey("poi_list__obj__")
        !json.containsKey("out_travelers")
        !json.containsKey("out_travelers__obj__")
        !json.containsKey("belong_enterprise_name")
        !json.containsKey("taxpayer_no")
        !json.containsKey("out_legal_entity_id")
    }

    def "updateBudgetCenter should serialize poi_list__obj__ and extend_field__obj__ and pass department fields"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with __obj__ fields + department + operate_type"
        def poi = PoiItem.builder()
                .city("深圳")
                .cityId(2)
                .cityAdcode("440300")
                .build()
        def extendField = ExtendFieldItem.builder()
                .id(5)
                .code("up_code")
                .value("up_value")
                .build()
        UpdateBudgetCenterRequest request = UpdateBudgetCenterRequest.builder()
                .companyId("company_001")
                .id("bc_12345")
                .type(2)
                .memberUsed(2)
                .departmentId("dept_a")
                .outDepartmentId("out_dept_a")
                .scope("current_only")
                .poiListObj(Arrays.asList(poi))
                .extendFieldObj(Arrays.asList(extendField))
                .operateType("cover")
                .build()

        when: "Call API"
        apiClient.budgetcenter().v1().updateBudgetCenter(request)

        then: "__obj__ fields serialized, department + operate_type present"
        RecordedRequest recordedRequest = getLastRequest()
        def json = parseJsonBody(getRequestBody(recordedRequest))
        json["department_id"] == "dept_a"
        json["out_department_id"] == "out_dept_a"
        json["scope"] == "current_only"
        json["operate_type"] == "cover"

        and: "poi_list__obj__ serialized to poi_list json string"
        json.containsKey("poi_list")
        !json.containsKey("poi_list__obj__")
        (json["poi_list"] as String).contains("深圳")
        (json["poi_list"] as String).contains("440300")

        and: "extend_field__obj__ serialized to extend_field json string"
        json.containsKey("extend_field")
        !json.containsKey("extend_field__obj__")
        (json["extend_field"] as String).contains("up_code")
        (json["extend_field"] as String).contains("up_value")
    }
}
