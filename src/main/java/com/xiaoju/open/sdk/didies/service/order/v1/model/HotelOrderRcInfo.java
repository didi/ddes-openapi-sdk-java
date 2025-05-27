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
public class HotelOrderRcInfo  {

    /**
     * RC审批单ID
     * 
     */
    @JsonProperty("rc_id")
    private String rcId;
    /**
     * RC类型，枚举值文本：房费RC，星级RC，提前预定RC,协议价RC
     * 
     */
    @JsonProperty("rc_type")
    private String rcType;
    /**
     * RCcode
     * 
     */
    @JsonProperty("rc_code")
    private String rcCode;
    /**
     * RC原因
     * 
     */
    @JsonProperty("rc_reason")
    private String rcReason;
    /**
     * 房间序号，分房在订单下标记房间的唯一性
     * 
     */
    @JsonProperty("sequences")
    private List<String> sequences;
}

