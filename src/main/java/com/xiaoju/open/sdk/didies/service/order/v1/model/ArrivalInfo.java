package com.xiaoju.open.sdk.didies.service.order.v1.model;

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
public class ArrivalInfo  {

    /**
     * 到达机场三字码
     * 
     */
    @JsonProperty("arrival_airport_code")
    private String arrivalAirportCode;
    /**
     * 到达机场名称
     * 
     */
    @JsonProperty("arrival_airport_name")
    private String arrivalAirportName;
    /**
     * 到达机场全称
     * 
     */
    @JsonProperty("arrival_airport_full_name")
    private String arrivalAirportFullName;
    /**
     * 到达机场简称
     * 
     */
    @JsonProperty("arrival_airport_simple_name")
    private String arrivalAirportSimpleName;
    /**
     * 到达城市名
     * 
     */
    @JsonProperty("arrival_city_name")
    private String arrivalCityName;
    /**
     * 到达机场航站楼
     * 
     */
    @JsonProperty("arrival_terminal")
    private String arrivalTerminal;
    /**
     * 到达日期时间
     * 
     */
    @JsonProperty("arrival_datetime")
    private String arrivalDatetime;
    /**
     * 到达城市id
     * 
     */
    @JsonProperty("arrival_city_id")
    private String arrivalCityId;
}

