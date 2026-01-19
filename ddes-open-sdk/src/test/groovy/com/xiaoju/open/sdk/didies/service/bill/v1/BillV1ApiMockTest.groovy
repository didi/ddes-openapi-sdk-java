package com.xiaoju.open.sdk.didies.service.bill.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.bill.v1.model.*
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for Bill V1
 * Tests key Bill APIs with proper request/response validation
 */
class BillV1ApiMockTest extends BaseMockTest {

    def "billConfirm - POST /river/Bill/confirm"() {
        given: "A mock success response"
        def responseData = """{
            "bill_id": "bill_001",
            "company_id": "company_001",
            "status": "confirmed"
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        BillConfirmRequest request = BillConfirmRequest.builder()
                .companyId("company_001")
                .billId("bill_001")
                .businessType(0)
                .build()

        when: "Call API"
        BillConfirmApiReply response = apiClient.bill().v1().billConfirm(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Bill/confirm")
        recordedRequest.method == "POST"
        verifyRequiredHeaders(recordedRequest)

        and: "Request body should contain required fields"
        def body = getRequestBody(recordedRequest)
        body.contains("company_id")
        body.contains("bill_id")
    }

    def "getBillDetailOfTaxi - GET /river/Bill/detail"() {
        given: "A mock success response"
        def responseData = """{
            "bill_id": "bill_001",
            "bill_period": "2024-01",
            "total_amount": 1000.00,
            "order_count": 50
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetBillDetailOfTaxiRequest request = GetBillDetailOfTaxiRequest.builder()
                .companyId("company_001")
                .billId("bill_001")
                .length(100)
                .build()

        when: "Call API"
        GetBillDetailOfTaxiApiReply response = apiClient.bill().v1().getBillDetailOfTaxi(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Bill/detail")
        recordedRequest.method == "GET"

        and: "Query params should contain bill_id"
        def params = getQueryParams(recordedRequest)
        params["bill_id"] == "bill_001"
    }

    def "getBillDetailOfDomesticFlight - GET /river/Bill/detail"() {
        given: "A mock success response"
        def responseData = """{
            "bill_id": "bill_002",
            "bill_period": "2024-01",
            "total_amount": 5000.00
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        GetBillDetailOfDomesticFlightRequest request = GetBillDetailOfDomesticFlightRequest.builder()
                .companyId("company_001")
                .billId("bill_002")
                .build()

        when: "Call API"
        GetBillDetailOfDomesticFlightApiReply response = apiClient.bill().v1().getBillDetailOfDomesticFlight(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Bill/detail")
        recordedRequest.method == "GET"
    }

    def "billConfirm should support payment period"() {
        given: "A mock success response"
        def responseData = """{
            "bill_id": "bill_003",
            "payment_period": "2024-01"
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with payment period"
        BillConfirmRequest request = BillConfirmRequest.builder()
                .companyId("company_001")
                .paymentPeriod("2024-01")
                .budgetCenterId("budget_001")
                .build()

        when: "Call API"
        BillConfirmApiReply response = apiClient.bill().v1().billConfirm(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain payment_period"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("payment_period")
    }
}
