package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.order.v1.model.DomesticHotelOrderBaseInfo;
import com.xiaoju.open.sdk.didies.service.order.v1.model.DomesticHotelOrderPriceInfo;
import com.xiaoju.open.sdk.didies.service.order.v1.model.HotelOrder;
import com.xiaoju.open.sdk.didies.service.order.v1.model.HotelOrderPassengerListItem;
import com.xiaoju.open.sdk.didies.service.order.v1.model.HotelOrderRcInfo;
import com.xiaoju.open.sdk.didies.service.order.v1.model.HotelOrderSequenceListItem;
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
public class DomesticHotelOrderListItem  {

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
    private DomesticHotelOrderPriceInfo priceInfo;
    /**
     * baseInfo
     * 
     */
    @JsonProperty("base_info")
    private DomesticHotelOrderBaseInfo baseInfo;
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

