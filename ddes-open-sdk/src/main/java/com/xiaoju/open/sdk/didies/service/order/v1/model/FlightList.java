package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.order.v1.model.FlightInfo;
import com.xiaoju.open.sdk.didies.service.order.v1.model.FlightRoutePrice;
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
public class FlightList  {

    /**
     * flightInfo
     * 
     */
    @JsonProperty("flight_info")
    private FlightInfo flightInfo;
    /**
     * 航班的价格信息，设计为数组是应对中转航班时，按航班号返回每个航班的预估价格。该数组长度为1，表示直飞；长度为2表示中转
     * 
     */
    @JsonProperty("flight_route_price")
    private List<FlightRoutePrice> flightRoutePrice;
}

