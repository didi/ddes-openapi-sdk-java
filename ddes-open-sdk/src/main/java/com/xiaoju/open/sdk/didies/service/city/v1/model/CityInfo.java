package com.xiaoju.open.sdk.didies.service.city.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.city.v1.model.FlightStation;
import com.xiaoju.open.sdk.didies.service.city.v1.model.TrainStation;
import java.util.ArrayList;
import java.util.List;
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
public class CityInfo  {

    /**
     * 城市ID
     * 
     */
    @JsonProperty("city_id")
    private Integer cityId;
    /**
     * 可预订品类枚举，[10,20,30]表示可预定：用车/机票/酒店
     * 
     */
    @JsonProperty("product_type")
    private List<Integer> productType;
    /**
     * 城市中文名
     * 
     */
    @JsonProperty("city_name_cn")
    private String cityNameCn;
    /**
     * 城市短名
     * 
     */
    @JsonProperty("city_short_name")
    private String cityShortName;
    /**
     * 城市路径id，23-302
     * 
     */
    @JsonProperty("city_path_id")
    private String cityPathId;
    /**
     * 城市路径中文，库尔佩珀县 - 波士顿
     * 
     */
    @JsonProperty("city_path_cn")
    private String cityPathCn;
    /**
     * 城市路径英文，Culpeper County - Boston
     * 
     */
    @JsonProperty("city_path_en")
    private String cityPathEn;
    /**
     * 城市英文名
     * 
     */
    @JsonProperty("city_name_en")
    private String cityNameEn;
    /**
     * 机场信息
     * 
     */
    @JsonProperty("flight_station")
    private List<FlightStation> flightStation;
    /**
     * 火车站信息
     * 
     */
    @JsonProperty("train_station")
    private List<TrainStation> trainStation;
}

