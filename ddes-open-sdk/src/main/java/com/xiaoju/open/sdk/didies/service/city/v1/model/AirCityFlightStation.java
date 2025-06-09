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
public class AirCityFlightStation  {

    /**
     * 机场中文名
     * 
     */
    @JsonProperty("airport_name_cn")
    private String airportNameCn;
    /**
     * 机场英文名
     * 
     */
    @JsonProperty("airport_name_en")
    private String airportNameEn;
    /**
     * 机场三代
     * 
     */
    @JsonProperty("airport_code")
    private String airportCode;
}

