package com.xiaoju.open.sdk.didies.service.bill.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;



@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GetBillSummaryReply  {

    /**
     * 结算单号
     * 
     */
    @JsonProperty("bill_id")
    private String billId;
    /**
     * 企业名称
     * 
     */
    @JsonProperty("company_name")
    private String companyName;
    /**
     * 账期
     * 
     */
    @JsonProperty("bill_period")
    private String billPeriod;
    /**
     * 品类(网约车、代驾)
     * 
     */
    @JsonProperty("settle_type_name")
    private String settleTypeName;
    /**
     * 线上企业实付金额
     * 
     */
    @JsonProperty("consume_amount_online")
    private BigDecimal consumeAmountOnline;
    /**
     * 线下扣企业账户金额
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
     * 订单超期退款金额
     * 
     */
    @JsonProperty("out_date_refund_amount")
    private BigDecimal outDateRefundAmount;
    /**
     * 授信客户：本期应结算金额 预存客户：充值金额
     * 
     */
    @JsonProperty("amount_money")
    private BigDecimal amountMoney;
    /**
     * 期末余额
     * 
     */
    @JsonProperty("current_balance")
    private BigDecimal currentBalance;
    /**
     * 子账户汇总 【4.0账单返回】
     * 
     */
    @JsonProperty("sub_list")
    private List<SubListItem> subList;
    /**
     * 业务线 2:商旅
     * 
     */
    @JsonProperty("business_type")
    private Integer businessType;
    /**
     * 消耗金额（单位：元）
     * 
     */
    @JsonProperty("consume_total_amount")
    private String consumeTotalAmount;
    /**
     * 退款金额（单位：元）
     * 
     */
    @JsonProperty("refund_total_amount")
    private String refundTotalAmount;
    /**
     * 往期退款金额（单位：元）
     * 
     */
    @JsonProperty("previous_refund_total_amount")
    private String previousRefundTotalAmount;
    /**
     * 结算金额（单位：元）
     * 
     */
    @JsonProperty("amount_total_money")
    private String amountTotalMoney;
    /**
     * 子业务线汇总金额 SubBillSummaryDTO
     * 
     */
    @JsonProperty("sub_bill_summary")
    private List<SubBillSummaryDTO> subBillSummary;
}

