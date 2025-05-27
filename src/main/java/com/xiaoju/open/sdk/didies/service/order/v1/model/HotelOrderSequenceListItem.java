package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
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
public class HotelOrderSequenceListItem  {

    /**
     * 房间序号，分房在订单下标记房间的唯一性
     * 
     */
    @JsonProperty("sequence")
    private String sequence;
    /**
     * 入住人唯一标记，入住人关联信息
     * 
     */
    @JsonProperty("passenger_traveler_id")
    private List<String> passengerTravelerId;
    /**
     * 实际入住时间，格式：yyyy-MM-dd HH:mm:ss
     * 
     */
    @JsonProperty("real_checkin_time")
    private String realCheckinTime;
    /**
     * 实际离店时间，格式：yyyy-MM-dd HH:mm:ss
     * 
     */
    @JsonProperty("real_checkout_time")
    private String realCheckoutTime;
    /**
     * * 酒店、国际机票订单字段
     * 
     */
    @JsonProperty("sequence_id")
    private String sequenceId;
}

