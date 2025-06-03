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
public class PriceInfo  {

    /**
     * 费用的名称
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 费用的金额，单位为元
     * 
     */
    @JsonProperty("amount")
    private String amount;
    /**
     * 费用的类型
     * 
     */
    @JsonProperty("type")
    private String type;
}

