package com.xiaoju.open.sdk.didies.service.bill.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;



@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SubListItem  {

    /**
     * 结算方式
     * 
     */
    @JsonProperty("pay_channel")
    private String payChannel;
    /**
     * 线上企业实付金额
     * 
     */
    @JsonProperty("consume_amount_online")
    private BigDecimal consumeAmountOnline;
    /**
     * 线下扣企业账户余额
     * 
     */
    @JsonProperty("consume_amount_offline")
    private BigDecimal consumeAmountOffline;
    /**
     * 企业实退金额
     * 
     */
    @JsonProperty("refund_amount")
    private BigDecimal refundAmount;
    /**
     * 调整金额
     * 
     */
    @JsonProperty("adjust_amount")
    private BigDecimal adjustAmount;
    /**
     * 账单金额
     * 
     */
    @JsonProperty("bill_amount")
    private BigDecimal billAmount;
    /**
     * 期末余额
     * 
     */
    @JsonProperty("current_balance")
    private BigDecimal currentBalance;
}

