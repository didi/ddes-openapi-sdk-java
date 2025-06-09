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
public class NotGenBDOfManualOrderItem  {

    /**
     * 订单号
     * 
     */
    @JsonProperty("order_id")
    private String orderId;
    /**
     * 主订单号
     * 
     */
    @JsonProperty("main_order_id")
    private String mainOrderId;
    /**
     * 关联订单号
     * 
     */
    @JsonProperty("es_order_id")
    private String esOrderId;
    /**
     * 票号
     * 
     */
    @JsonProperty("supplier_ticket_number")
    private String supplierTicketNumber;
    /**
     * 预订人姓名
     * 
     */
    @JsonProperty("booking_member_name")
    private String bookingMemberName;
    /**
     * 预订人工号
     * 
     */
    @JsonProperty("booking_member_number")
    private String bookingMemberNumber;
    /**
     * 使用人工号
     * 
     */
    @JsonProperty("passenger_member_number")
    private String passengerMemberNumber;
    /**
     * 使用人姓名
     * 
     */
    @JsonProperty("passenger_member_name")
    private String passengerMemberName;
    /**
     * 成本中心
     * 
     */
    @JsonProperty("budget_center_name")
    private String budgetCenterName;
    /**
     * 成本中心id
     * 
     */
    @JsonProperty("budget_center_code")
    private String budgetCenterCode;
    /**
     * 产品名称
     * 
     */
    @JsonProperty("good_name")
    private String goodName;
    /**
     * 单价
     * 
     */
    @JsonProperty("company_real_pay")
    private BigDecimal companyRealPay;
    /**
     * 描述
     * 
     */
    @JsonProperty("desc")
    private String desc;
    /**
     * 订单来源
     * 
     */
    @JsonProperty("order_source")
    private String orderSource;
    /**
     * 平台使用费
     * 
     */
    @JsonProperty("service_fee")
    private BigDecimal serviceFee;
    /**
     * 平台使用费（立减前）
     * 
     */
    @JsonProperty("before_cut_service_fee")
    private BigDecimal beforeCutServiceFee;
    /**
     * 立减金额
     * 
     */
    @JsonProperty("added_es_cut_fee")
    private BigDecimal addedEsCutFee;
    /**
     * 立减原因
     * 
     */
    @JsonProperty("added_cut_reason")
    private String addedCutReason;
}

