package com.xiaoju.open.sdk.didies.service.project.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.project.v1.model.*
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for Project V1
 * Tests all Project APIs with proper request/response validation
 */
class ProjectV1ApiMockTest extends BaseMockTest {

    def "getProjectDetail - GET /river/Project/detail"() {
        given: "A mock success response"
        def responseData = """[{
            "member_id": "mem_001",
            "phone": "13800138000",
            "employee_number": "EMP001",
            "email": "john@example.com"
        }]"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetProjectDetailRequest request = GetProjectDetailRequest.builder()
                .companyId("company_001")
                .projectId("1125904357323169")
                .offset(0)
                .lenth(20)
                .build()

        when: "Call API"
        GetProjectDetailApiReply response = apiClient.project().v1().getProjectDetail(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Project/detail")
        recordedRequest.method == "GET"

        and: "Query params should contain required fields"
        def params = getQueryParams(recordedRequest)
        params["company_id"] == "company_001"
        params["project_id"] == "1125904357323169"
        params["offset"] == "0"
        params["lenth"] == "20"

        and: "Data should be parsed"
        response.data != null
        response.data.size() == 1
        response.data[0].memberId == "mem_001"
        response.data[0].email == "john@example.com"
    }

    def "outTravelerList - GET /open-apis/v2/project/outTravelerList"() {
        given: "A mock success response"
        def responseData = """{
            "out_travelers": [{
                "traveler_id": "4503599690839935",
                "out_traveler_id": "out_traveler_id_11",
                "phone": "+852 000****8060",
                "name": "TYPE_3_外部_11",
                "english_surname": "Wai",
                "english_name": "BuCuXingRen",
                "remark": "备注",
                "sex": 1,
                "birth_date": "2000-01-01",
                "card_list": [{
                    "card_no": "110101199001011234",
                    "card_type": 1,
                    "expire_date": "2030-12-31"
                }],
                "related_employees": [{
                    "related_employee_id": "emp_001",
                    "related_employee_phone": "13800138000",
                    "related_employee_employee_number": "E001",
                    "related_employee_email": "emp@test.com"
                }],
                "project_id": "4503600193081934",
                "project_name": "项目_test_8",
                "out_budget_id": "xm_test_8"
            }],
            "total": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        OutTravelerListRequest request = OutTravelerListRequest.builder()
                .companyId("company_001")
                .projectId("1125904357323169")
                .outBudgetId("budget_001")
                .page(1)
                .pageSize(20)
                .build()

        when: "Call API"
        OutTravelerListApiReply response = apiClient.project().v1().outTravelerList(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/open-apis/v2/project/outTravelerList")
        recordedRequest.method == "GET"

        and: "Query params should contain required fields"
        def params = getQueryParams(recordedRequest)
        params["company_id"] == "company_001"
        params["project_id"] == "1125904357323169"
        params["out_budget_id"] == "budget_001"
        params["page"] == "1"
        params["page_size"] == "20"

        and: "Data should be parsed"
        response.data != null
        response.data.total == 1L
        response.data.outTravelers != null
        response.data.outTravelers.size() == 1
        def traveler = response.data.outTravelers[0]
        traveler.travelerId == "4503599690839935"
        traveler.name == "TYPE_3_外部_11"
        traveler.sex == 1
        traveler.cardList != null
        traveler.cardList[0].cardType == 1
        traveler.relatedEmployees != null
        traveler.relatedEmployees[0].relatedEmployeeEmail == "emp@test.com"
    }

    def "updateMember - POST /river/Project/updateMember"() {
        given: "A mock success response"
        def responseData = """{
            "success_data": ["mem_001", "mem_002"],
            "error_data": [{
                "error_msg": "员工不存在",
                "error_member_ids": ["mem_003"],
                "error_member_values": ["mem_value_003"]
            }],
            "success_member_values": ["mem_value_001", "mem_value_002"]
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        UpdateMemberRequest request = UpdateMemberRequest.builder()
                .companyId("company_001")
                .projectId("1125904357323169")
                .memberType(0)
                .memberValues("mem_value_001,mem_value_002")
                .build()

        when: "Call API"
        UpdateMemberApiReply response = apiClient.project().v1().updateMember(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Project/updateMember")
        recordedRequest.method == "POST"

        and: "Body should contain required fields"
        def json = parseJsonBody(getRequestBody(recordedRequest))
        json["company_id"] == "company_001"
        json["project_id"] == "1125904357323169"
        json["member_type"] == 0
        json["member_values"] == "mem_value_001,mem_value_002"

        and: "Data should be parsed"
        response.data != null
        response.data.successData != null
        response.data.successData.size() == 2
        response.data.errorData != null
        response.data.errorData[0].errorMsg == "员工不存在"
        response.data.successMemberValues.size() == 2
    }

    def "delMember - POST /river/Project/delMember"() {
        given: "A mock success response"
        def responseData = """{
            "success_data": ["mem_001"],
            "error_data": [{
                "error_msg": "员工不存在",
                "error_member_ids": ["mem_004"]
            }],
            "success_member_values": []
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        DelMemberRequest request = DelMemberRequest.builder()
                .companyId("company_001")
                .projectId("1125904357323169")
                .type(2)
                .memberIds("mem_001,mem_004")
                .build()

        when: "Call API"
        DelMemberApiReply response = apiClient.project().v1().delMember(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Project/delMember")
        recordedRequest.method == "POST"

        and: "Body should contain required fields"
        def json = parseJsonBody(getRequestBody(recordedRequest))
        json["company_id"] == "company_001"
        json["project_id"] == "1125904357323169"
        json["type"] == 2
        json["member_ids"] == "mem_001,mem_004"

        and: "Data should be parsed"
        response.data != null
        response.data.successData != null
        response.data.successData.size() == 1
        response.data.errorData != null
        response.data.errorData[0].errorMsg == "员工不存在"
    }

    def "outTravelerList - 完整反序列化全部14个字段及嵌套结构"() {
        given: "A mock success response with full traveler data"
        def responseData = """{
            "out_travelers": [{
                "traveler_id": "4503599690839935",
                "out_traveler_id": "out_traveler_id_11",
                "phone": "+852 000****8060",
                "name": "TYPE_3_外部_11",
                "english_surname": "Wai",
                "english_name": "BuCuXingRen",
                "remark": "备注信息",
                "sex": 1,
                "birth_date": "2000-01-01",
                "card_list": [{
                    "card_no": "110101199001011234",
                    "card_type": 1,
                    "expire_date": "2030-12-31"
                }],
                "related_employees": [{
                    "related_employee_id": "emp_001",
                    "related_employee_phone": "13800138000",
                    "related_employee_employee_number": "E001",
                    "related_employee_email": "emp@test.com"
                }],
                "project_id": "4503600193081934",
                "project_name": "项目_test_8",
                "out_budget_id": "xm_test_8"
            }],
            "total": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with only required params"
        OutTravelerListRequest request = OutTravelerListRequest.builder()
                .companyId("company_001")
                .projectId("1125904357323169")
                .build()

        when: "Call API"
        OutTravelerListApiReply response = apiClient.project().v1().outTravelerList(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Total parsed"
        response.data != null
        response.data.total == 1L
        response.data.outTravelers != null
        response.data.outTravelers.size() == 1

        and: "All 14 fields of OutTravelerInfo parsed"
        def traveler = response.data.outTravelers[0]
        traveler.travelerId == "4503599690839935"
        traveler.outTravelerId == "out_traveler_id_11"
        traveler.phone == "+852 000****8060"
        traveler.name == "TYPE_3_外部_11"
        traveler.englishSurname == "Wai"
        traveler.englishName == "BuCuXingRen"
        traveler.remark == "备注信息"
        traveler.sex == 1
        traveler.birthDate == "2000-01-01"
        traveler.projectId == "4503600193081934"
        traveler.projectName == "项目_test_8"
        traveler.outBudgetId == "xm_test_8"

        and: "Nested card_list parsed (CardInfo 3 fields)"
        traveler.cardList != null
        traveler.cardList.size() == 1
        def card = traveler.cardList[0]
        card.cardNo == "110101199001011234"
        card.cardType == 1
        card.expireDate == "2030-12-31"

        and: "Nested related_employees parsed (RelatedEmployeeInfo 4 fields)"
        traveler.relatedEmployees != null
        traveler.relatedEmployees.size() == 1
        def emp = traveler.relatedEmployees[0]
        emp.relatedEmployeeId == "emp_001"
        emp.relatedEmployeePhone == "13800138000"
        emp.relatedEmployeeEmployeeNumber == "E001"
        emp.relatedEmployeeEmail == "emp@test.com"
    }

    def "getProjectDetail - 多条记录反序列化 member_id/phone/employee_number/email"() {
        given: "A mock success response with multiple members"
        def responseData = """[
            {"member_id": "mem_001", "phone": "13800000001", "employee_number": "D0001", "email": "a@test.com"},
            {"member_id": "mem_002", "phone": "13800000002", "employee_number": "D0002", "email": "b@test.com"},
            {"member_id": "mem_003", "phone": "13800000003"}
        ]"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetProjectDetailRequest request = GetProjectDetailRequest.builder()
                .companyId("company_001")
                .projectId("1125904357323169")
                .build()

        when: "Call API"
        GetProjectDetailApiReply response = apiClient.project().v1().getProjectDetail(request)

        then: "All members parsed"
        response.data != null
        response.data.size() == 3

        and: "First member full fields"
        response.data[0].memberId == "mem_001"
        response.data[0].phone == "13800000001"
        response.data[0].employeeNumber == "D0001"
        response.data[0].email == "a@test.com"

        and: "Second member full fields"
        response.data[1].memberId == "mem_002"
        response.data[1].phone == "13800000002"
        response.data[1].employeeNumber == "D0002"
        response.data[1].email == "b@test.com"

        and: "Third member missing optional fields are null"
        response.data[2].memberId == "mem_003"
        response.data[2].phone == "13800000003"
        response.data[2].employeeNumber == null
        response.data[2].email == null
    }

    def "updateMember - 多条 error_data 的 UpdateMemberErrorInfo 反序列化"() {
        given: "A mock success response with multiple error items"
        def responseData = """{
            "success_data": ["mem_001", "mem_002", "mem_003"],
            "error_data": [
                {
                    "error_msg": "员工不在该企业中",
                    "error_member_ids": ["mem_004", "mem_005"],
                    "error_member_values": ["val_004", "val_005"]
                },
                {
                    "error_msg": "该员工已经在这个项目中",
                    "error_member_ids": ["mem_006"],
                    "error_member_values": ["val_006"]
                }
            ],
            "success_member_values": ["val_001", "val_002", "val_003"]
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        UpdateMemberRequest request = UpdateMemberRequest.builder()
                .companyId("company_001")
                .projectId("1125904357323169")
                .memberType(0)
                .memberValues("val_001,val_002,val_003,val_004,val_005,val_006")
                .build()

        when: "Call API"
        UpdateMemberApiReply response = apiClient.project().v1().updateMember(request)

        then: "success_data parsed"
        response.data != null
        response.data.successData != null
        response.data.successData.size() == 3
        response.data.successData == ["mem_001", "mem_002", "mem_003"]

        and: "success_member_values parsed"
        response.data.successMemberValues != null
        response.data.successMemberValues.size() == 3
        response.data.successMemberValues == ["val_001", "val_002", "val_003"]

        and: "error_data parsed with UpdateMemberErrorInfo fields"
        response.data.errorData != null
        response.data.errorData.size() == 2
        response.data.errorData[0].errorMsg == "员工不在该企业中"
        response.data.errorData[0].errorMemberIds == ["mem_004", "mem_005"]
        response.data.errorData[0].errorMemberValues == ["val_004", "val_005"]
        response.data.errorData[1].errorMsg == "该员工已经在这个项目中"
        response.data.errorData[1].errorMemberIds == ["mem_006"]
        response.data.errorData[1].errorMemberValues == ["val_006"]
    }

    def "delMember - DelMemberErrorInfo 含 error_member_values 反序列化"() {
        given: "A mock success response with error data"
        def responseData = """{
            "success_data": ["mem_001"],
            "error_data": [{
                "error_msg": "查询不到员工信息",
                "error_member_ids": ["mem_004"],
                "error_member_values": ["val_004"]
            }],
            "success_member_values": ["val_001"]
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        DelMemberRequest request = DelMemberRequest.builder()
                .companyId("company_001")
                .projectId("1125904357323169")
                .type(2)
                .memberIds("mem_001,mem_004")
                .build()

        when: "Call API"
        DelMemberApiReply response = apiClient.project().v1().delMember(request)

        then: "Response parsed"
        response.data != null
        response.data.successData == ["mem_001"]
        response.data.successMemberValues == ["val_001"]

        and: "DelMemberErrorInfo fields parsed"
        response.data.errorData != null
        response.data.errorData.size() == 1
        response.data.errorData[0].errorMsg == "查询不到员工信息"
        response.data.errorData[0].errorMemberIds == ["mem_004"]
        response.data.errorData[0].errorMemberValues == ["val_004"]
    }

    def "getProjectDetail - 空数组响应 data:[]"() {
        given: "A mock success response with empty data array"
        def responseData = "[]"
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetProjectDetailRequest request = GetProjectDetailRequest.builder()
                .companyId("company_001")
                .projectId("1125904357323169")
                .build()

        when: "Call API"
        GetProjectDetailApiReply response = apiClient.project().v1().getProjectDetail(request)

        then: "Empty data parsed without error"
        response != null
        response.errno == 0
        response.data != null
        response.data.size() == 0
    }

    def "outTravelerList - 空列表 out_travelers:[]"() {
        given: "A mock success response with empty traveler list"
        def responseData = """{"out_travelers": [], "total": 0}"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        OutTravelerListRequest request = OutTravelerListRequest.builder()
                .companyId("company_001")
                .projectId("1125904357323169")
                .build()

        when: "Call API"
        OutTravelerListApiReply response = apiClient.project().v1().outTravelerList(request)

        then: "Empty list parsed without error"
        response != null
        response.errno == 0
        response.data != null
        response.data.total == 0L
        response.data.outTravelers != null
        response.data.outTravelers.size() == 0
    }

    def "delMember - type=1 全删除时 data 为 null"() {
        given: "A mock success response with data null (type=1 全删除)"
        def responseData = "null"
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with type=1"
        DelMemberRequest request = DelMemberRequest.builder()
                .companyId("company_001")
                .projectId("1125904357323169")
                .type(1)
                .build()

        when: "Call API"
        DelMemberApiReply response = apiClient.project().v1().delMember(request)

        then: "Response parsed, data is null"
        response != null
        response.errno == 0
        response.errmsg == "success"
        response.data == null
    }

    def "getProjectDetail - errno!=0 错误响应不抛异常"() {
        given: "A mock error response without data"
        enqueueSuccess(createBaseResponse(10003, "param error"))

        and: "Create request"
        GetProjectDetailRequest request = GetProjectDetailRequest.builder()
                .companyId("company_001")
                .build()

        when: "Call API"
        GetProjectDetailApiReply response = apiClient.project().v1().getProjectDetail(request)

        then: "Error response parsed, errno preserved, data null"
        response != null
        response.errno == 10003
        response.errmsg == "param error"
        response.data == null
    }

    def "updateMember - errno!=0 错误响应不抛异常"() {
        given: "A mock error response"
        enqueueSuccess(createBaseResponse(70000, "project 非项目 id"))

        and: "Create request"
        UpdateMemberRequest request = UpdateMemberRequest.builder()
                .companyId("company_001")
                .projectId("1125904357323169")
                .memberValues("val_001")
                .build()

        when: "Call API"
        UpdateMemberApiReply response = apiClient.project().v1().updateMember(request)

        then: "Error response parsed without exception"
        response != null
        response.errno == 70000
        response.errmsg == "project 非项目 id"
        response.data == null
    }

    def "delMember - errno!=0 错误响应不抛异常"() {
        given: "A mock error response"
        enqueueSuccess(createBaseResponse(70001, "project not found"))

        and: "Create request"
        DelMemberRequest request = DelMemberRequest.builder()
                .companyId("company_001")
                .projectId("1125904357323169")
                .type(1)
                .build()

        when: "Call API"
        DelMemberApiReply response = apiClient.project().v1().delMember(request)

        then: "Error response parsed without exception"
        response != null
        response.errno == 70001
        response.errmsg == "project not found"
        response.data == null
    }

    def "getProjectDetail - 全部 query 参数传递正确且未设置的不出现"() {
        given: "A mock success response"
        enqueueSuccess(createSuccessResponse("[]"))

        and: "Create request with all params"
        GetProjectDetailRequest request = GetProjectDetailRequest.builder()
                .companyId("company_001")
                .projectId("1125904357323169")
                .projectName("测试项目")
                .projectCode("CODE001")
                .offset(0)
                .lenth(20)
                .belongEnterpriseName("子公司A")
                .taxpayerNo("91110000xxx")
                .build()

        when: "Call API"
        apiClient.project().v1().getProjectDetail(request)

        then: "All query params passed correctly"
        def params = getQueryParams(getLastRequest())
        params["company_id"] == "company_001"
        params["project_id"] == "1125904357323169"
        params["project_name"] == enc("测试项目")
        params["project_code"] == "CODE001"
        params["offset"] == "0"
        params["lenth"] == "20"
        params["belong_enterprise_name"] == enc("子公司A")
        params["taxpayer_no"] == "91110000xxx"
    }

    def "getProjectDetail - 仅部分参数时未设置的不出现在 query"() {
        given: "A mock success response"
        enqueueSuccess(createSuccessResponse("[]"))

        and: "Create request with only partial params"
        GetProjectDetailRequest request = GetProjectDetailRequest.builder()
                .companyId("company_001")
                .projectId("1125904357323169")
                .offset(0)
                .build()

        when: "Call API"
        apiClient.project().v1().getProjectDetail(request)

        then: "Set params present"
        def params = getQueryParams(getLastRequest())
        params["company_id"] == "company_001"
        params["project_id"] == "1125904357323169"
        params["offset"] == "0"

        and: "Unset params absent from query"
        !params.containsKey("project_name")
        !params.containsKey("project_code")
        !params.containsKey("lenth")
        !params.containsKey("belong_enterprise_name")
        !params.containsKey("taxpayer_no")
    }

    def "outTravelerList - page/page_size/out_budget_id 传递正确且未设置的不出现"() {
        given: "A mock success response"
        enqueueSuccess(createSuccessResponse("""{"out_travelers": [], "total": 0}"""))

        and: "Create request with page/page_size/out_budget_id"
        OutTravelerListRequest request = OutTravelerListRequest.builder()
                .companyId("company_001")
                .projectId("1125904357323169")
                .outBudgetId("budget_001")
                .page(1)
                .pageSize(20)
                .build()

        when: "Call API"
        apiClient.project().v1().outTravelerList(request)

        then: "Page params passed correctly"
        def params = getQueryParams(getLastRequest())
        params["company_id"] == "company_001"
        params["project_id"] == "1125904357323169"
        params["out_budget_id"] == "budget_001"
        params["page"] == "1"
        params["page_size"] == "20"
    }

    def "outTravelerList - 仅必填参数时 page/page_size/out_budget_id 不出现"() {
        given: "A mock success response"
        enqueueSuccess(createSuccessResponse("""{"out_travelers": [], "total": 0}"""))

        and: "Create request with only company_id/project_id"
        OutTravelerListRequest request = OutTravelerListRequest.builder()
                .companyId("company_001")
                .projectId("1125904357323169")
                .build()

        when: "Call API"
        apiClient.project().v1().outTravelerList(request)

        then: "Required params present"
        def params = getQueryParams(getLastRequest())
        params["company_id"] == "company_001"
        params["project_id"] == "1125904357323169"

        and: "Optional params absent"
        !params.containsKey("page")
        !params.containsKey("page_size")
        !params.containsKey("out_budget_id")
    }

    private static String enc(String s) {
        return java.net.URLEncoder.encode(s, "UTF-8")
    }
}
