package com.xiaoju.open.sdk.didies.service.rank.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.rank.v1.model.*
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for Rank V1
 * Tests all Rank APIs with proper request/response validation
 */
class RankV1ApiMockTest extends BaseMockTest {

    def "createRank - POST /open-apis/v1/rank/create"() {
        given: "A mock success response"
        def responseData = """{
            "rank_id": "rank_12345",
            "out_rank_id": "out_rank_001",
            "name": "Test Rank",
            "status": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with paramJsonObj"
        def rankInfo = RankInfo.builder()
                .name("Test Rank")
                .outRankId("out_rank_001")
                .build()
        CreateRankRequest request = CreateRankRequest.builder()
                .companyId("company_001")
                .paramJsonObj(rankInfo)
                .build()

        when: "Call API"
        CreateRankApiReply response = apiClient.rank().v1().createRank(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/open-apis/v1/rank/create")
        recordedRequest.method == "POST"
        verifyRequiredHeaders(recordedRequest)

        and: "Request body should contain required fields"
        def body = getRequestBody(recordedRequest)
        body.contains("param_json")
        body.contains("Test Rank")
        body.contains("out_rank_id")
    }

    def "delRank - POST /open-apis/v1/rank/del"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with rank_id in paramJsonObj"
        def rankInfo = RankInfo.builder()
                .rankId("rank_12345")
                .build()
        DelRankRequest request = DelRankRequest.builder()
                .companyId("company_001")
                .paramJsonObj(rankInfo)
                .build()

        when: "Call API"
        DelRankApiReply response = apiClient.rank().v1().delRank(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/open-apis/v1/rank/del")
        recordedRequest.method == "POST"

        and: "Request should contain rank_id"
        def body = getRequestBody(recordedRequest)
        body.contains("param_json")
        body.contains("rank_12345")
    }

    def "listRank - GET /river/Rank/getRanks"() {
        given: "A mock success response"
        def responseData = """{
            "rank_list": [
                {
                    "rank_id": "rank_001",
                    "name": "Manager",
                    "out_rank_id": "out_001",
                    "status": 1
                },
                {
                    "rank_id": "rank_002",
                    "name": "Director",
                    "out_rank_id": "out_002",
                    "status": 1
                }
            ],
            "total": 2
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        ListRankRequest request = ListRankRequest.builder()
                .companyId("company_001")
                .build()

        when: "Call API"
        ListRankApiReply response = apiClient.rank().v1().listRank(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/Rank/getRanks")
        recordedRequest.method == "GET"
        verifyRequiredHeaders(recordedRequest)
    }

    def "updateRank - POST /open-apis/v1/rank/update"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with rank_id and name"
        def rankInfo = RankInfo.builder()
                .rankId("rank_12345")
                .name("Updated Rank")
                .build()
        UpdateRankRequest request = UpdateRankRequest.builder()
                .companyId("company_001")
                .paramJsonObj(rankInfo)
                .build()

        when: "Call API"
        UpdateRankApiReply response = apiClient.rank().v1().updateRank(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/open-apis/v1/rank/update")
        recordedRequest.method == "POST"

        and: "Request should contain rank_id"
        def body = getRequestBody(recordedRequest)
        body.contains("param_json")
        body.contains("rank_12345")
        body.contains("Updated Rank")
    }

    def "delRank should support deletion by out_rank_id"() {
        given: "A mock success response"
        enqueueSuccess(createBaseResponse(0, "success"))

        and: "Create request with out_rank_id"
        def rankInfo = RankInfo.builder()
                .outRankId("out_rank_001")
                .build()
        DelRankRequest request = DelRankRequest.builder()
                .companyId("company_001")
                .paramJsonObj(rankInfo)
                .build()

        when: "Call API"
        DelRankApiReply response = apiClient.rank().v1().delRank(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain out_rank_id"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("param_json")
        body.contains("out_rank_001")
    }

    def "listRank should handle pagination"() {
        given: "A mock success response"
        def responseData = """{
            "rank_list": [
                {
                    "rank_id": "rank_001",
                    "name": "Manager"
                }
            ],
            "total": 10
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with offset and length"
        ListRankRequest request = ListRankRequest.builder()
                .companyId("company_001")
                .offset(0)
                .length(10)
                .build()

        when: "Call API"
        ListRankApiReply response = apiClient.rank().v1().listRank(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Query params should contain offset and length"
        RecordedRequest recordedRequest = getLastRequest()
        def params = getQueryParams(recordedRequest)
        params["offset"] == "0"
        params["length"] == "10"
    }

    def "listRank should handle error response"() {
        given: "A mock error response"
        enqueueSuccess(createErrorResponse(400, "Invalid company_id"))

        and: "Create request"
        ListRankRequest request = ListRankRequest.builder()
                .companyId("invalid_company")
                .build()

        when: "Call API"
        ListRankApiReply response = apiClient.rank().v1().listRank(request)

        then: "Response should contain error information"
        response != null
        response.errno == 400
        response.errmsg == "Invalid company_id"
    }
}
