package com.xiaoju.open.sdk.didies.service.city.v1;

import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListAirportCityApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListAirportCityRequest;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCarCityApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCarCityRequest;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCityApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCityRequest;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCountryApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCountryRequest;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListHotelCityApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListHotelCityRequest;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListTrainCityApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListTrainCityRequest;

public class V1 extends BaseService {

    public V1(ITokenHolder tokenHolder, Config config) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 机票城市
    * 说明： 本接口提供有机场的城市；【推荐使用使用全量接口】
    * @param listAirportCityRequest  (required)
    * @return ListAirportCityApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    * @deprecated
    */
    @Deprecated
    public ListAirportCityApiReply listAirportCity(ListAirportCityRequest listAirportCityRequest) throws Exception {
        
        return doPost(listAirportCityRequest, "/river/DemeterAres/AirportCity/index", ListAirportCityApiReply.class, 0);
    }
    /**
    * 用车城市
    * 说明： 提供用车城市；【推荐使用使用全量接口】
    * @param listCarCityRequest  (required)
    * @return ListCarCityApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    * @deprecated
    */
    @Deprecated
    public ListCarCityApiReply listCarCity(ListCarCityRequest listCarCityRequest) throws Exception {
        return doGet(listCarCityRequest, "/river/City/get", ListCarCityApiReply.class, 0);
        
    }
    /**
    * 全量开城城市列表查询
    * 说明： 该接口用于查询全量城市信息，用于展示滴滴企业级品类开城数据； - 使用接口前需要先通过国家查询接口获取对应的国家ID; - 查询条件给的值查询不到时，会直接返回空。  注意  - 由于当前接口返回数据量比较大，QPS目前最大不超过：8 - 此接口不能用于实时查询。地址服务需要本地做缓存，接口用于校对数据; - 建议一段时间更新本地城市库信息。建议更新周期：每半年。  param字段列表  | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | country_id | 国家ID | int | Y |  | | province_id | 省ID | int | N | country_id，province_id，city_id 请求的时候省和城市ID加入时作为条件查询返回。country_id+province_id 返回该省的数据；country_id+city_id 返回该城市的数据；city_id 优先级大于province_id | | city_id | 城市ID | int | N |  | | product_type | 可预订品类枚举 | string | Y | 枚举值：10: 用车；20: 机票；30: 酒店；40: 火车票。查询多个品类英文逗号隔开。举例：10,20,30 | 
    * @param listCityRequest  (required)
    * @return ListCityApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public ListCityApiReply listCity(ListCityRequest listCityRequest) throws Exception {
        
        return doPost(listCityRequest, "/open-apis/v1/city/list", ListCityApiReply.class, 0);
    }
    /**
    * 国家
    * 说明： 全量获取国际ID；【推荐使用使用全量接口】
    * @param listCountryRequest  (required)
    * @return ListCountryApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    * @deprecated
    */
    @Deprecated
    public ListCountryApiReply listCountry(ListCountryRequest listCountryRequest) throws Exception {
        
        return doPost(listCountryRequest, "/river/DemeterAres/Country/index", ListCountryApiReply.class, 0);
    }
    /**
    * 酒店城市
    * 说明： 本接口提供有酒店的城市；【推荐使用使用全量接口】
    * @param listHotelCityRequest  (required)
    * @return ListHotelCityApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    * @deprecated
    */
    @Deprecated
    public ListHotelCityApiReply listHotelCity(ListHotelCityRequest listHotelCityRequest) throws Exception {
        
        return doPost(listHotelCityRequest, "/river/DemeterAres/HotelCity/index", ListHotelCityApiReply.class, 0);
    }
    /**
    * 火车票城市
    * 说明： 本接口提供有火车票的城市；【推荐使用使用全量接口】
    * @param listTrainCityRequest  (required)
    * @return ListTrainCityApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    * @deprecated
    */
    @Deprecated
    public ListTrainCityApiReply listTrainCity(ListTrainCityRequest listTrainCityRequest) throws Exception {
        
        return doPost(listTrainCityRequest, "/river/DemeterAres/TrainCity", ListTrainCityApiReply.class, 0);
    }
}

