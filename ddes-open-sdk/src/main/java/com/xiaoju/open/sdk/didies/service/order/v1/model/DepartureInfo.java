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
public class DepartureInfo  {

    /**
     * 出发机场三字码，如PEK
     * 
     */
    @JsonProperty("departure_airport_code")
    private String departureAirportCode;
    /**
     * 出发机场名称，如 首都机场
     * 
     */
    @JsonProperty("departure_airport_name")
    private String departureAirportName;
    /**
     * 出发机场全称，如 北京首都国际机场
     * 
     */
    @JsonProperty("departure_airport_full_name")
    private String departureAirportFullName;
    /**
     * 出发机场简称，如 首都
     * 
     */
    @JsonProperty("departure_airport_simple_name")
    private String departureAirportSimpleName;
    /**
     * 出发城市名，如 北京
     * 
     */
    @JsonProperty("departure_city_name")
    private String departureCityName;
    /**
     * 出发机场航站楼，可为空。如 T2
     * 
     */
    @JsonProperty("departure_terminal")
    private String departureTerminal;
    /**
     * 出发日期时间，如 2024-11-25 07:00
     * 
     */
    @JsonProperty("departure_datetime")
    private String departureDatetime;
    /**
     * 出发城市id，如 1
     * 
     */
    @JsonProperty("departure_city_id")
    private String departureCityId;
}

