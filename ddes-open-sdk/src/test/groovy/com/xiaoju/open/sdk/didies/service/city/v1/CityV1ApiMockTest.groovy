package com.xiaoju.open.sdk.didies.service.city.v1

import com.xiaoju.open.sdk.didies.mock.BaseMockTest
import com.xiaoju.open.sdk.didies.service.city.v1.model.*
import okhttp3.mockwebserver.RecordedRequest

/**
 * Mock API tests for City V1
 * Tests all City APIs with proper request/response validation
 */
class CityV1ApiMockTest extends BaseMockTest {

    def "listCity - POST /open-apis/v1/city/list"() {
        given: "A mock success response"
        def responseData = """{
            "city_records": [{
                "city_id": 1,
                "city_name": "北京",
                "country_id": 1,
                "province_id": 1
            }],
            "total": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with paramJsonObj"
        def paramObj = ListCityParamObj.builder()
                .countryId(1)
                .productType("10")
                .build()
        ListCityRequest request = ListCityRequest.builder()
                .companyId("company_001")
                .paramJsonObj(paramObj)
                .build()

        when: "Call API"
        ListCityApiReply response = apiClient.city().v1().listCity(request)

        then: "Response should be successful"
        response != null
        response.errno == 0
        response.errmsg == "success"

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/open-apis/v1/city/list")
        recordedRequest.method == "POST"
        verifyRequiredHeaders(recordedRequest)

        and: "Request body should contain param_json"
        def body = getRequestBody(recordedRequest)
        body.contains("param_json")
        body.contains("country_id")
        body.contains("product_type")
    }

    def "listCarCity - GET /river/City/get"() {
        given: "A mock success response"
        def responseData = """[{
            "city_id": 1,
            "city_name": "北京",
            "province_id": 1
        }]"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        ListCarCityRequest request = ListCarCityRequest.builder()
                .companyId("company_001")
                .build()

        when: "Call API"
        ListCarCityApiReply response = apiClient.city().v1().listCarCity(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/City/get")
        recordedRequest.method == "GET"

        and: "Query params should contain company_id"
        def params = getQueryParams(recordedRequest)
        params["company_id"] == "company_001"
    }

    def "listAirportCity - POST /river/DemeterAres/AirportCity/index"() {
        given: "A mock success response"
        def responseData = """[{
            "city_id": 1,
            "city_name": "北京",
            "airports": [{
                "airport_code": "PEK",
                "airport_name": "首都国际机场"
            }]
        }]"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        ListAirportCityRequest request = ListAirportCityRequest.builder()
                .companyId("company_001")
                .build()

        when: "Call API"
        ListAirportCityApiReply response = apiClient.city().v1().listAirportCity(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/DemeterAres/AirportCity/index")
        recordedRequest.method == "POST"
    }

    def "listCountry - POST /river/DemeterAres/Country/index"() {
        given: "A mock success response"
        def responseData = """[{
            "country_id": 1,
            "country_name": "中国",
            "country_code": "CN"
        }]"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        ListCountryRequest request = ListCountryRequest.builder()
                .companyId("company_001")
                .build()

        when: "Call API"
        ListCountryApiReply response = apiClient.city().v1().listCountry(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/DemeterAres/Country/index")
        recordedRequest.method == "POST"
    }

    def "listHotelCity - POST /river/DemeterAres/HotelCity/index"() {
        given: "A mock success response"
        def responseData = """[{
            "city_id": 1,
            "city_name": "北京",
            "province_id": 1
        }]"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        ListHotelCityRequest request = ListHotelCityRequest.builder()
                .companyId("company_001")
                .build()

        when: "Call API"
        ListHotelCityApiReply response = apiClient.city().v1().listHotelCity(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/DemeterAres/HotelCity/index")
        recordedRequest.method == "POST"
    }

    def "listTrainCity - POST /river/DemeterAres/TrainCity"() {
        given: "A mock success response"
        def responseData = """[{
            "city_id": 1,
            "city_name": "北京",
            "stations": [{
                "station_name": "北京站",
                "station_code": "BJP"
            }]
        }]"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        ListTrainCityRequest request = ListTrainCityRequest.builder()
                .companyId("company_001")
                .build()

        when: "Call API"
        ListTrainCityApiReply response = apiClient.city().v1().listTrainCity(request)

        then: "Response should be successful"
        response != null
        response.errno == 0

        and: "Request should be correct"
        RecordedRequest recordedRequest = getLastRequest()
        verifyPath(recordedRequest, "/river/DemeterAres/TrainCity")
        recordedRequest.method == "POST"
    }

    def "listCity should support province and city filters"() {
        given: "A mock success response"
        def responseData = """{
            "city_records": [{
                "city_id": 2,
                "city_name": "上海",
                "province_id": 2
            }],
            "total": 1
        }"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request with filters"
        def paramObj = ListCityParamObj.builder()
                .countryId(1)
                .provinceId(2)
                .cityId(2)
                .productType("10,20,30")
                .build()
        ListCityRequest request = ListCityRequest.builder()
                .companyId("company_001")
                .paramJsonObj(paramObj)
                .build()

        when: "Call API"
        ListCityApiReply response = apiClient.city().v1().listCity(request)

        then: "Response should be successful"
        response.errno == 0

        and: "Request should contain all filters"
        RecordedRequest recordedRequest = getLastRequest()
        def body = getRequestBody(recordedRequest)
        body.contains("province_id")
        body.contains("city_id")
        body.contains("10,20,30")
    }

    def "listCarCity should handle empty response"() {
        given: "A mock empty response"
        def responseData = """[]"""
        enqueueSuccess(createSuccessResponse(responseData))

        and: "Create request"
        ListCarCityRequest request = ListCarCityRequest.builder()
                .companyId("company_001")
                .build()

        when: "Call API"
        ListCarCityApiReply response = apiClient.city().v1().listCarCity(request)

        then: "Response should be successful but empty"
        response != null
        response.errno == 0
    }
}
