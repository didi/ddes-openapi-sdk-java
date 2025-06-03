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
public class TrainStation  {

    /**
     * 火车站中文名
     * 
     */
    @JsonProperty("station_name_cn")
    private String stationNameCn;
    /**
     * 火车站英文名
     * 
     */
    @JsonProperty("station_name_en")
    private String stationNameEn;
    /**
     * 火车站名
     * 
     */
    @JsonProperty("station_name")
    private String stationName;
    /**
     * 火车站ID，滴滴主键
     * 
     */
    @JsonProperty("station_id")
    private Integer stationId;
}

