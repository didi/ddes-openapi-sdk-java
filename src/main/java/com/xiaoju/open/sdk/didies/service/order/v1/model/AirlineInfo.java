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
public class AirlineInfo  {

    /**
     * 航司名称，如 中国东方航空股份有限公司
     * 
     */
    @JsonProperty("airline_name")
    private String airlineName;
    /**
     * 航司简称，如 东方航空
     * 
     */
    @JsonProperty("airline_simple_name")
    private String airlineSimpleName;
    /**
     * 航司极简称，如 东航
     * 
     */
    @JsonProperty("airline_very_simple_name")
    private String airlineVerySimpleName;
    /**
     * 航班号，如 MU5100
     * 
     */
    @JsonProperty("flight_number")
    private String flightNumber;
}

