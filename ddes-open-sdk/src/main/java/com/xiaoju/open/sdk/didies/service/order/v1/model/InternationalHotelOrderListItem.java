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
public class InternationalHotelOrderListItem  {

    /**
     * orderInfo
     * 
     */
    @JsonProperty("order_info")
    private HotelOrder orderInfo;
    /**
     * priceInfo
     * 
     */
    @JsonProperty("price_info")
    private InterHotelOrderPriceInfo priceInfo;
    /**
     * baseInfo
     * 
     */
    @JsonProperty("base_info")
    private InterHotelOrderBaseInfo baseInfo;
    /**
     * 出行人信息
     * 
     */
    @JsonProperty("passenger_list")
    private List<HotelOrderPassengerListItem> passengerList;
    /**
     * 入住房间列表
     * 
     */
    @JsonProperty("sequence_list")
    private List<HotelOrderSequenceListItem> sequenceList;
    /**
     * 管控信息
     * 
     */
    @JsonProperty("rc_list")
    private List<HotelOrderRcInfo> rcList;
}

