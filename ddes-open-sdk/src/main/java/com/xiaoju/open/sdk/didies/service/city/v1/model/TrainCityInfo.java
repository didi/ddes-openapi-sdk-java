package com.xiaoju.open.sdk.didies.service.city.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TrainCityInfo  {

    /**
     * 滴滴城市ID
     * 
     */
    @JsonProperty("city_id")
    private String cityId;
    /**
     * 城市中文名
     * 
     */
    @JsonProperty("city_name_cn")
    private String cityNameCn;
    /**
     * 城市英文名
     * 
     */
    @JsonProperty("city_name_en")
    private String cityNameEn;
    /**
     * 省ID
     * 
     */
    @JsonProperty("province_id")
    private String provinceId;
    /**
     * 省中文名
     * 
     */
    @JsonProperty("province_name_cn")
    private String provinceNameCn;
    /**
     * 省英文文名
     * 
     */
    @JsonProperty("province_name_en")
    private String provinceNameEn;
    /**
     * 国家ID
     * 
     */
    @JsonProperty("country_id")
    private String countryId;
    /**
     * 国家二字代码
     * 
     */
    @JsonProperty("canonical_country_code")
    private String canonicalCountryCode;
    /**
     * 国家三字代码
     * 
     */
    @JsonProperty("country_code")
    private String countryCode;
    /**
     * 国家中文名
     * 
     */
    @JsonProperty("country_name_cn")
    private String countryNameCn;
    /**
     * 火车站信息
     * 
     */
    @JsonProperty("train_station")
    private List<TrainStation> trainStation;
}

