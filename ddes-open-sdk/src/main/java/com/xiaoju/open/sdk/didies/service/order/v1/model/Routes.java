package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Routes  {

    /**
     * departureInfo
     * 
     */
    @JsonProperty("departure_info")
    private DepartureInfo departureInfo;
    /**
     * arrivalInfo
     * 
     */
    @JsonProperty("arrival_info")
    private ArrivalInfo arrivalInfo;
    /**
     * airlineInfo
     * 
     */
    @JsonProperty("airline_info")
    private AirlineInfo airlineInfo;
}

