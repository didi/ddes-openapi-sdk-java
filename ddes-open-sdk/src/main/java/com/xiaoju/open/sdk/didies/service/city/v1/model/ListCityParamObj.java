package com.xiaoju.open.sdk.didies.service.city.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ListCityParamObj  {

    /**
     * 国家ID
     * 
     */
    @JsonProperty("country_id")
    private Integer countryId;
    /**
     * 省ID，country_id，province_id，city_id 请求的时候省和城市ID加入时作为条件查询返回。country_id+province_id 返回该省的数据country_id+city_id 返回该城市的数据city_id 优先级大于province_id
     * 
     */
    @JsonProperty("province_id")
    private Integer provinceId;
    /**
     * 城市ID，country_id，province_id，city_id 请求的时候省和城市ID加入时作为条件查询返回。country_id+province_id 返回该省的数据country_id+city_id 返回该城市的数据city_id 优先级大于province_id
     * 
     */
    @JsonProperty("city_id")
    private Integer cityId;
    /**
     * 可预订品类枚举，枚举值：10: 用车20: 机票30: 酒店40: 火车票 查询多个品类英文逗号隔开。举例：10,20,30
     * 
     */
    @JsonProperty("product_type")
    private String productType;
}

