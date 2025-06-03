package com.xiaoju.open.sdk.ddes.city;

import com.xiaoju.open.sdk.didies.ApiClient;
import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.service.city.enums.CityCountryLevelEnum;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListAirportCityApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListAirportCityRequest;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCarCityApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCarCityRequest;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCityApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCityParamObj;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCityRequest;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCountryApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCountryRequest;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListHotelCityApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListHotelCityRequest;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListTrainCityApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListTrainCityRequest;
import com.xiaoju.open.sdk.didies.utils.JacksonUtils;

public class CitySample {

  public static void main(String[] args) {
    Config config = Config.builder()
        .clientId("your_client_id")
        .clientSecret("your_client_secret")
        .signKey("your_sign_key")
        .build();

    ApiClient client = new ApiClient(config);
  }

  /**
   * 机票城市【此接口响应值文档和实际返回值待验证】
   * <p>
   * 说明： 本接口提供有机场的城市；
   */
  public static void listAirportCityTest(ApiClient client) throws Exception {
    ListAirportCityRequest request = ListAirportCityRequest.builder()
        .companyId("替换成自己的companyId")
        .countryLevel(CityCountryLevelEnum.ALL.getCode())
        .build();

    ListAirportCityApiReply response = client.city().v1().listAirportCity(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 用车城市
   */
  public static void listCarCityTest(ApiClient client) throws Exception {
    ListCarCityRequest request = ListCarCityRequest.builder()
        .companyId("替换成自己的companyId")
        .build();
    ListCarCityApiReply response = client.city().v1().listCarCity(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 全量开城城市列表查询
   * <p>
   * 说明： 该接口用于查询全量城市信息，用于展示滴滴企业级品类开城数据； - 使用接口前需要先通过国家查询接口获取对应的国家ID; - 查询条件给的值查询不到时，会直接返回空。  注意  - 由于当前接口返回数据量比较大，QPS目前最大不超过：8 -
   * 此接口不能用于实时查询。地址服务需要本地做缓存，接口用于校对数据; - 建议一段时间更新本地城市库信息。建议更新周期：每半年。  param字段列表  | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ----
   * | | country_id | 国家ID | int | Y |  | | province_id | 省ID | int | N | country_id，province_id，city_id
   * 请求的时候省和城市ID加入时作为条件查询返回。country_id+province_id 返回该省的数据；country_id+city_id 返回该城市的数据；city_id 优先级大于province_id | | city_id | 城市ID | int | N |  | |
   * product_type | 可预订品类枚举 | string | Y | 枚举值：10: 用车；20: 机票；30: 酒店；40: 火车票。查询多个品类英文逗号隔开。举例：10,20,30 |
   */
  public static void listCityTest(ApiClient client) throws Exception {

    ListCityRequest request = ListCityRequest.builder()
        .companyId("替换成自己的companyId")
        .paramJsonObj(ListCityParamObj.builder()
            .countryId(86)
            .build())
        .build();
    ListCityApiReply response = client.city().v1().listCity(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 国家
   */
  public static void listCountryTest(ApiClient client) throws Exception {
    ListCountryRequest request = ListCountryRequest.builder()
        .companyId("替换成自己的companyId")
        .build();
    ListCountryApiReply response = client.city().v1().listCountry(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 酒店城市
   */
  public static void listHotelCityTest(ApiClient client) throws Exception {
    ListHotelCityRequest request = ListHotelCityRequest.builder()
        .companyId("替换成自己的companyId")
        .countryId(86)
        .build();
    ListHotelCityApiReply response = client.city().v1().listHotelCity(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 火车票城市
   */
  public static void listTrainCityTest(ApiClient client) throws Exception {
    ListTrainCityRequest request = ListTrainCityRequest.builder()
        .companyId("替换成自己的companyId").build();
    ListTrainCityApiReply response = client.city().v1().listTrainCity(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }
}
