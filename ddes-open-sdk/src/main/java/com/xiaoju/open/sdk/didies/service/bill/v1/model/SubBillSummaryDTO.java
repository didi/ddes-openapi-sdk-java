package com.xiaoju.open.sdk.didies.service.bill.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SubBillSummaryDTO  {

    /**
     * 业务类型 201:国内酒店 202:国内机票 203:火车票 204:海外酒店 205:国际机票 531:增值服务
     * 
     */
    @JsonProperty("business_type")
    private Integer businessType;
    /**
     * 消耗金额（单位：元）
     * 
     */
    @JsonProperty("consume_amount")
    private String consumeAmount;
    /**
     * 退款金额（单位：元）
     * 
     */
    @JsonProperty("refund_amount")
    private String refundAmount;
    /**
     * 往期退款金额（单位：元）
     * 
     */
    @JsonProperty("previous_refund_amount")
    private String previousRefundAmount;
    /**
     * 结算金额（单位：元）
     * 
     */
    @JsonProperty("amount_money")
    private String amountMoney;
}

