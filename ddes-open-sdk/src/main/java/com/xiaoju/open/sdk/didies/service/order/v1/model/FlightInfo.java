package com.xiaoju.open.sdk.didies.service.order.v1.model;

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
public class FlightInfo  {

    /**
     * 航班信息，可为直飞或中转。该数组长度为1，表示直飞；长度为2表示中转
     * 
     */
    @JsonProperty("routes")
    private List<Routes> routes;
}

