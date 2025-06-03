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
public class TrainOrderPriceInfo  {

    /**
     * 订单总价，单位：分  金额字段下同 ，预订时的价格，不包含异步服务费，包含实时服务费，会变更到实际预订支付价格。 出票完成时订单总花费&#x3D;order_amount+asynchronous_service_fee
     * 
     */
    @JsonProperty("order_amount")
    private Integer orderAmount;
    /**
     * 公司支付金额，单位：分预订时的价格，不包含异步服务费，会变更到实际预订支付价格。 出票完成时公司支付金额&#x3D;company_pay
     * 
     */
    @JsonProperty("company_pay")
    private Integer companyPay;
    /**
     * 个人支付金额，单位：分预订时的价格，不包含异步服务费，会变更到实际预订支付价格。
     * 
     */
    @JsonProperty("personal_pay")
    private Integer personalPay;
    /**
     * 平台使用费，单位：实时收取的服务费
     * 
     */
    @JsonProperty("service_fee")
    private Integer serviceFee;
    /**
     * 出票平台使用费（异步），单位：分
     * 
     */
    @JsonProperty("asynchronous_service_fee")
    private Integer asynchronousServiceFee;
    /**
     * 抢票服务费，单位：抢票成功后收取的抢票服务费
     * 
     */
    @JsonProperty("grab_service_fee")
    private Integer grabServiceFee;
    /**
     * 订单公司支付金额，单位：分 ，订单的公司支付金额会变更。
     * 
     */
    @JsonProperty("company_real_pay")
    private Integer companyRealPay;
    /**
     * 订单个人支付金额，单位：分 ，订单的个人支付金额会变更。
     * 
     */
    @JsonProperty("personal_real_pay")
    private Integer personalRealPay;
    /**
     * 企业实退
     * 
     */
    @JsonProperty("company_real_refund")
    private Integer companyRealRefund;
    /**
     * 个人实退
     * 
     */
    @JsonProperty("personal_real_refund")
    private Integer personalRealRefund;
    /**
     * 币种，默认 CNY
     * 
     */
    @JsonProperty("currency")
    private String currency;
}

