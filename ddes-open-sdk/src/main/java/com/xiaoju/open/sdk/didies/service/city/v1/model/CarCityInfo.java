package com.xiaoju.open.sdk.didies.service.city.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.city.v1.model.CountyRecord;
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
public class CarCityInfo  {

    /**
     * 地级市ID（如：深圳ID为2）
     * 
     */
    @JsonProperty("city_id")
    private Integer cityId;
    /**
     * 地级市名称
     * 
     */
    @JsonProperty("city_name")
    private String cityName;
    /**
     * 区县列表
     * 
     */
    @JsonProperty("county_list")
    private List<CountyRecord> countyList;
}

