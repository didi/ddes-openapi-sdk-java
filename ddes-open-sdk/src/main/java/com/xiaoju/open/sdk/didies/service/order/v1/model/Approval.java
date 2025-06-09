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
public class Approval  {

    /**
     * 申请单号类型，枚举值数字，1 out_approval_id（外部申请单单号），2 approval_id（滴滴内部申请单号）
     * 
     */
    @JsonProperty("type")
    private Integer type;
    /**
     * 单号信息
     * 
     */
    @JsonProperty("value")
    private String value;
}

