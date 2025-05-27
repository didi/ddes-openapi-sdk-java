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
public class TrainOrderRcInfo  {

    /**
     * RC审批单ID
     * 
     */
    @JsonProperty("rc_id")
    private String rcId;
    /**
     * RC类型，枚举值文本：超标说明
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
     * 适用对应RC的车票号，空是全部适用
     * 
     */
    @JsonProperty("ticket_unique_key")
    private String ticketUniqueKey;
}

