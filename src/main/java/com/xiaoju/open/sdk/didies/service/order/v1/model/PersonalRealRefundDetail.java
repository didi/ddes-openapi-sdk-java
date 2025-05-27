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
public class PersonalRealRefundDetail  {

    /**
     * 可报销金额
     * 
     */
    @JsonProperty("reimburse_fee")
    private Integer reimburseFee;
    /**
     * 不可报销金额
     * 
     */
    @JsonProperty("no_reimburse_fee")
    private Integer noReimburseFee;
    /**
     * 不可报销金额
     * 
     */
    @JsonProperty("company_card_real_refund")
    private Integer companyCardRealRefund;
}

