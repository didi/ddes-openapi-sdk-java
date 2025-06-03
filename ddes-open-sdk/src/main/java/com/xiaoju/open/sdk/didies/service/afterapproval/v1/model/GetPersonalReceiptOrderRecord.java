package com.xiaoju.open.sdk.didies.service.afterapproval.v1.model;

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
public class GetPersonalReceiptOrderRecord  {

    /**
     * 订单号
     * 
     */
    @JsonProperty("order_id")
    private String orderId;
    /**
     * 审批单号
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
}

