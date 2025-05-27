package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.order.v1.model.PersonalPayDetail;
import com.xiaoju.open.sdk.didies.service.order.v1.model.PersonalRealPayDetail;
import com.xiaoju.open.sdk.didies.service.order.v1.model.PersonalRealRefundDetail;
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
public class InterHotelOrderPriceInfo  {

    /**
     * 订单总价，酒店预订时的费用，不包含离店后的结算信息  &#x3D;公司支付金额+个人支付金额&#x3D;房费总额+平台使用费（实时） ，不包含立减优惠，税点服务费
     * 
     */
    @JsonProperty("order_amount")
    private Integer orderAmount;
    /**
     * 公司应付支付金额，单位：分
     * 
     */
    @JsonProperty("company_pay")
    private Integer companyPay;
    /**
     * 员工应付支付金额，单位：分
     * 
     */
    @JsonProperty("personal_pay")
    private Integer personalPay;
    /**
     * personalPayDetail
     * 
     */
    @JsonProperty("personal_pay_detail")
    private PersonalPayDetail personalPayDetail;
    /**
     * 立减金，单位：分
     * 
     */
    @JsonProperty("cut_fee")
    private Integer cutFee;
    /**
     * 公司优惠券，单位：分 退款时，该字段不更新
     * 
     */
    @JsonProperty("company_coupon")
    private Integer companyCoupon;
    /**
     * 个人优惠券，单位：分 退款时，该字段不更新
     * 
     */
    @JsonProperty("personal_coupon")
    private Integer personalCoupon;
    /**
     * 平台使用费，单位：分 实时随单收取平台使用费
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
     * 税点服务费，单位：分 发生退款时，会变更为最终值金额
     * 
     */
    @JsonProperty("difftax_fee")
    private Integer difftaxFee;
    /**
     * 房费总额，单位：分
     * 
     */
    @JsonProperty("room_amount")
    private Integer roomAmount;
    /**
     * 订单公司实际支付金额，单位：分
     * 
     */
    @JsonProperty("company_real_pay")
    private Integer companyRealPay;
    /**
     * 订单个人实际支付金额，单位：分
     * 
     */
    @JsonProperty("personal_real_pay")
    private Integer personalRealPay;
    /**
     * personalRealPayDetail
     * 
     */
    @JsonProperty("personal_real_pay_detail")
    private PersonalRealPayDetail personalRealPayDetail;
    /**
     * 公司实际退款金额，单位：分 发生退款款时有值
     * 
     */
    @JsonProperty("company_real_refund")
    private Integer companyRealRefund;
    /**
     * 员工实际退款金额，单位：分 发生退款款时有值
     * 
     */
    @JsonProperty("personal_real_refund")
    private Integer personalRealRefund;
    /**
     * personalRealRefundDetail
     * 
     */
    @JsonProperty("personal_real_refund_detail")
    private PersonalRealRefundDetail personalRealRefundDetail;
    /**
     * 币种，默认 CNY
     * 
     */
    @JsonProperty("currency")
    private String currency;
}

