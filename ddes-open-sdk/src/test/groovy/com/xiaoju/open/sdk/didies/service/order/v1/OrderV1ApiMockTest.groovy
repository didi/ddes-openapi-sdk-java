package com.xiaoju.open.sdk.didies.service.order.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.order.v1.model.*
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for Order V1
 * Tests key Order APIs with proper request/response validation
 */
class OrderV1ApiMockTest extends BaseMockTest {

    def "getOrder - GET /river/Order/get"() {
        given: "A mock success response"
        def responseData = """{
            "orders": [{
                "order_id": "order_001",
                "order_status": 1,
                "create_time": "2024-01-01 12:00:00"
            }],
            "total": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetOrderRequest request = GetOrderRequest.builder()
                .companyId("company_001")
                .startDate("2024-01-01")
                .endDate("2024-01-31")
                .offset(0)
                .length(100)
                .build()

        when: "Call API"
        GetOrderApiReply response = apiClient.order().v1().getOrder(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Order/get")
        recordedRequest.method == "GET"
        verifyRequiredHeaders(recordedRequest)

        and: "Query params should contain date range"
        def params = getQueryParams(recordedRequest)
        params["start_date"] == "2024-01-01"
        params["end_date"] == "2024-01-31"
    }

    def "listOrder - POST /open-apis/v1/order/list"() {
        given: "A mock success response"
        def responseData = """{
            "order_list": [{
                "order_id": "order_001",
                "order_type": "car",
                "status": "completed"
            }],
            "total": 1,
            "cur_page": 1,
            "limit": 100
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with paramJsonObj"
        def searchTime = SearchTime.builder()
                .startTime("2024-01-01 00:00:00")
                .endTime("2024-01-31 23:59:59")
                .build()
        def paramObj = ParamJsonObj.builder()
                .orderType("all")
                .searchTime(searchTime)
                .curPage(1)
                .limit(100)
                .build()
        ListOrderRequest request = ListOrderRequest.builder()
                .companyId("company_001")
                .paramJsonObj(paramObj)
                .build()

        when: "Call API"
        ListOrderApiReply response = apiClient.order().v1().listOrder(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/open-apis/v1/order/list")
        recordedRequest.method == "POST"

        and: "Request body should contain param_json"
        def body = getRequestBody(recordedRequest)
        body.contains("param_json")
        body.contains("order_type")
    }

    def "getCarOrderDetail - GET /river/Order/detail"() {
        given: "A mock success response"
        def responseData = """{
            "order_id": "order_001",
            "order_status": "completed",
            "start_time": "2024-01-01 12:00:00",
            "real_fee": 48.50
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetCarOrderDetailRequest request = GetCarOrderDetailRequest.builder()
                .companyId("company_001")
                .orderId("order_001")
                .build()

        when: "Call API"
        GetCarOrderDetailApiReply response = apiClient.order().v1().getCarOrderDetail(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Order/detail")
        recordedRequest.method == "GET"
    }

    def "listOrder should support pagination"() {
        given: "A mock success response"
        def responseData = """{
            "order_list": [],
            "total": 0,
            "cur_page": 2,
            "limit": 100
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with page 2"
        def paramObj = ParamJsonObj.builder()
                .orderType("car")
                .curPage(2)
                .limit(100)
                .build()
        ListOrderRequest request = ListOrderRequest.builder()
                .companyId("company_001")
                .paramJsonObj(paramObj)
                .build()

        when: "Call API"
        ListOrderApiReply response = apiClient.order().v1().listOrder(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain cur_page"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("cur_page")
        body.contains("2")
    }
}
