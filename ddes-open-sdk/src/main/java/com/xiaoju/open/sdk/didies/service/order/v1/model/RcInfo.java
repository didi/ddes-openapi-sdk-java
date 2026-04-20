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
public class RcInfo  {

    /**
     * 超标类型
     * 
     */
    @JsonProperty("rc_type")
    private String rcType;
    /**
     * 超标编码
     * 
     */
    @JsonProperty("rc_code")
    private String rcCode;
    /**
     * 超标原因
     * 
     */
    @JsonProperty("rc_reason")
    private String rcReason;
    /**
     * 超标备注
     * 
     */
    @JsonProperty("rc_remark")
    private String rcRemark;
}

