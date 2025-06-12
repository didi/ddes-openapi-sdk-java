package com.xiaoju.open.sdk.ddes.service.city

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum
import com.xiaoju.open.sdk.didies.service.city.City
import com.xiaoju.open.sdk.didies.service.city.v1.model.*
import com.xiaoju.open.sdk.didies.utils.JacksonUtils
import spock.lang.Ignore
import spock.lang.Specification

/**
 * API tests for City
 */
@Ignore
class CityTest extends Specification {

    private City api

    def setup() {
        Config config = new Config()
                .setClientId("your_client_id")
                .setClientSecret("your_client_secret")
                .setSignKey("your_sign_key")
        ApiClient client = new ApiClient(config)
        api = client.city()
    }

    /**
     * 机票城市【此接口响应值文档和实际返回值待验证】
     *
     * 说明： 本接口提供有机场的城市；
     */
    def listAirportCityTest() {
        ListAirportCityRequest listAirportCityRequest = new ListAirportCityRequest(
                companyId: "替换成自己的companyId",
                countryLevel: 2
        )

        ListAirportCityApiReply response = api.v1().listAirportCity(listAirportCityRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
        response.getErrno() == "0"
    }
    /**
     * 用车城市
     */
    def listCarCityTest() {
        ListCarCityRequest carCityRequest = new ListCarCityRequest(
                companyId: "替换成自己的companyId",
        )

        ListCarCityApiReply response = api.v1().listCarCity(carCityRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
        response.getErrno() == "0"
    }
    /**
     * 全量开城城市列表查询
     *
     * 说明： 该接口用于查询全量城市信息，用于展示滴滴企业级品类开城数据； - 使用接口前需要先通过国家查询接口获取对应的国家ID; - 查询条件给的值查询不到时，会直接返回空。  注意  - 由于当前接口返回数据量比较大，QPS目前最大不超过：8 - 此接口不能用于实时查询。地址服务需要本地做缓存，接口用于校对数据; - 建议一段时间更新本地城市库信息。建议更新周期：每半年。  param字段列表  | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | country_id | 国家ID | int | Y |  | | province_id | 省ID | int | N | country_id，province_id，city_id 请求的时候省和城市ID加入时作为条件查询返回。country_id+province_id 返回该省的数据；country_id+city_id 返回该城市的数据；city_id 优先级大于province_id | | city_id | 城市ID | int | N |  | | product_type | 可预订品类枚举 | string | Y | 枚举值：10: 用车；20: 机票；30: 酒店；40: 火车票。查询多个品类英文逗号隔开。举例：10,20,30 | 
     */
    def listCityTest() {
        ListCityRequest listCityRequest = new ListCityRequest(
                companyId: "替换成自己的companyId",
                paramJsonObj: new ListCityParamObj(
                        countryId: 86
                )
        )

        ListCityApiReply response = api.v1().listCity(listCityRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
        response.getErrno() == "0"
    }
    /**
     * 国家
     */
    def listCountryTest() {
        ListCountryRequest listCountryRequest = new ListCountryRequest(
                companyId: "替换成自己的companyId"
        )

        ListCountryApiReply response = api.v1().listCountry(listCountryRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
        response.getErrno() == "0"
    }
    /**
     * 酒店城市
     */
    def listHotelCityTest() {
        ListHotelCityRequest listHotelCityRequest = new ListHotelCityRequest(
                companyId: "替换成自己的companyId",
                countryId: 86
        )

        ListHotelCityApiReply response = api.v1().listHotelCity(listHotelCityRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
        response.getErrno() == "0"
    }
    /**
     * 火车票城市
     */
    def listTrainCityTest() {
        ListTrainCityRequest trainCityRequest = new ListTrainCityRequest(
                companyId: "替换成自己的companyId",
        )

        ListTrainCityApiReply response = api.v1().listTrainCity(trainCityRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
        response.getErrno() == "0"
    }

}