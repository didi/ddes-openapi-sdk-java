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
public class FlightRoutePrice  {

    /**
     * 航班号，直飞航班可以不关注。中转航班时，与routes数组里的route对象内的airline_info.flight_number 关联，确定每一个中转段对应的价格。
     * 
     */
    @JsonProperty("flight_number")
    private String flightNumber;
    /**
     * 头等舱预估价，单位分，0表示该航班此舱售罄
     * 
     */
    @JsonProperty("estimate_first")
    private Integer estimateFirst;
    /**
     * 公务舱预估价，单位分，0表示该航班此舱售罄
     * 
     */
    @JsonProperty("estimate_biz")
    private Integer estimateBiz;
    /**
     * 经济舱预估价，单位分，0表示该航班此舱售罄
     * 
     */
    @JsonProperty("estimate_eco")
    private Integer estimateEco;
}

