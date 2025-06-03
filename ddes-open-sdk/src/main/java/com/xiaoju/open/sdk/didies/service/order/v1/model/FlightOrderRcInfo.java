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
public class FlightOrderRcInfo  {

    /**
     * 票号唯一值
     * 
     */
    @JsonProperty("ticket_unique_key")
    private String ticketUniqueKey;
    /**
     * RC审批单ID
     * 
     */
    @JsonProperty("rc_id")
    private String rcId;
    /**
     * RC类型，枚举值文本：舱等RC，低价RC，提前预定RC，同行程火车耗时超标，同行程火车价格超标
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
}

