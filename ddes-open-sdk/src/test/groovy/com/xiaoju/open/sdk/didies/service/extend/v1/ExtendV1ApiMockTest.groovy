package com.xiaoju.open.sdk.didies.service.extend.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.extend.v1.model.*
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for Extend V1
 * Tests all Extend APIs with proper request/response validation
 */
class ExtendV1ApiMockTest extends BaseMockTest {

    def "createExtendBatch - POST /river/ExtendInfo/BatchSync"() {
        given: "A mock success response"
        def responseData = """{
            "root_code": "root_001",
            "root_name": "Test Archive",
            "created_count": 2,
            "failed_count": 0
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with itemListObj"
        def extendInfo1 = ExtendInfo.builder()
                .code("child_001")
                .name("Child 1")
                .build()
        def extendInfo2 = ExtendInfo.builder()
                .code("child_002")
                .name("Child 2")
                .build()
        CreateExtendBatchRequest request = CreateExtendBatchRequest.builder()
                .companyId("company_001")
                .rootCode("root_001")
                .rootName("Test Archive")
                .itemListObj([extendInfo1, extendInfo2])
                .build()

        when: "Call API"
        CreateExtendBatchApiReply response = apiClient.extend().v1().createExtendBatch(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/ExtendInfo/BatchSync")
        recordedRequest.method == "POST"
        verifyRequiredHeaders(recordedRequest)

        and: "Request body should contain item_list"
        def body = getRequestBody(recordedRequest)
        body.contains("item_list")
        body.contains("root_code")
        body.contains("child_001")
    }

    def "listExtend - GET /river/ExtendInfo/Get"() {
        given: "A mock success response"
        def responseData = """{
            "root_code": "root_001",
            "root_name": "Test Archive",
            "root_status": 1,
            "extend_info": {
                "id": "ext_001",
                "code": "child_001",
                "name": "Child 1",
                "status": 1,
                "children": [{
                    "id": "ext_002",
                    "code": "child_002",
                    "name": "Child 2",
                    "status": 1
                }]
            }
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        ListExtendRequest request = ListExtendRequest.builder()
                .companyId("company_001")
                .rootCode("root_001")
                .build()

        when: "Call API"
        ListExtendApiReply response = apiClient.extend().v1().listExtend(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/ExtendInfo/Get")
        recordedRequest.method == "GET"
        verifyRequiredHeaders(recordedRequest)

        and: "Query params should contain required fields"
        def params = getQueryParams(recordedRequest)
        params["company_id"] == "company_001"
        params["root_code"] == "root_001"
    }

    def "updateExtendStatus - POST /river/ExtendInfo/Status"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with itemListObj"
        def extendInfo1 = ExtendInfo.builder()
                .code("child_001")
                .status(3)
                .build()
        def extendInfo2 = ExtendInfo.builder()
                .code("child_002")
                .status(3)
                .build()
        UpdateExtendStatusRequest request = UpdateExtendStatusRequest.builder()
                .companyId("company_001")
                .rootCode("root_001")
                .rootStatus(1)
                .itemListObj([extendInfo1, extendInfo2])
                .build()

        when: "Call API"
        UpdateExtendStatusApiReply response = apiClient.extend().v1().updateExtendStatus(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/ExtendInfo/Status")
        recordedRequest.method == "POST"

        and: "Request body should contain item_list with status"
        def body = getRequestBody(recordedRequest)
        body.contains("item_list")
        body.contains("root_code")
        body.contains("status")
        body.contains("3")
    }

    def "createExtendBatch should handle hierarchical structure"() {
        given: "A mock success response"
        def responseData = """{
            "root_code": "root_002",
            "root_name": "Hierarchical Archive",
            "created_count": 3
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with nested children"
        def level2 = ExtendInfo.builder()
                .code("level2")
                .name("Level 2")
                .build()
        def level3 = ExtendInfo.builder()
                .code("level3")
                .name("Level 3")
                .build()
        def level1 = ExtendInfo.builder()
                .code("level1")
                .name("Level 1")
                .children([level2, level3])
                .build()
        CreateExtendBatchRequest request = CreateExtendBatchRequest.builder()
                .companyId("company_001")
                .rootCode("root_002")
                .rootName("Hierarchical Archive")
                .itemListObj([level1])
                .build()

        when: "Call API"
        CreateExtendBatchApiReply response = apiClient.extend().v1().createExtendBatch(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain children"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("children")
        body.contains("level1")
        body.contains("level2")
    }

    def "updateExtendStatus should handle deletion"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request for deletion (status=3)"
        def extendInfo = ExtendInfo.builder()
                .code("child_001")
                .status(3)
                .build()
        UpdateExtendStatusRequest request = UpdateExtendStatusRequest.builder()
                .companyId("company_001")
                .rootCode("root_001")
                .itemListObj([extendInfo])
                .build()

        when: "Call API"
        UpdateExtendStatusApiReply response = apiClient.extend().v1().updateExtendStatus(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain deletion status"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("status")
        body.contains("3")
    }

    def "listExtend should handle archive not found"() {
        given: "A mock error response"
        enqueueSuccess(createErrorResponse(404, "Archive not found"))

        and: "Create request with non-existent root"
        ListExtendRequest request = ListExtendRequest.builder()
                .companyId("company_001")
                .rootCode("nonexistent_root")
                .build()

        when: "Call API"
        ListExtendApiReply response = apiClient.extend().v1().listExtend(request)

        then: "Response should contain error information"
        response != null
        response.errno == 404
        response.errmsg == "Archive not found"
    }

    def "createExtendBatch should handle errors in response"() {
        given: "A mock success response with errors"
        def responseData = """{
            "root_code": "root_001",
            "root_name": "Test Archive",
            "created_count": 1,
            "failed_count": 1,
            "err_list": [{
                "code": "child_002",
                "message": "Invalid parent code"
            }]
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        def extendInfo = ExtendInfo.builder()
                .code("child_001")
                .name("Child 1")
                .build()
        CreateExtendBatchRequest request = CreateExtendBatchRequest.builder()
                .companyId("company_001")
                .rootCode("root_001")
                .rootName("Test Archive")
                .itemListObj([extendInfo])
                .build()

        when: "Call API"
        CreateExtendBatchApiReply response = apiClient.extend().v1().createExtendBatch(request)

        then: "Response should be successful with error information"
        response.errno == 0
        response.data.errList != null
    }
}
