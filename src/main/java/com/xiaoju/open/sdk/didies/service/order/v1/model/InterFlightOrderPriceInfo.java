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
public class InterFlightOrderPriceInfo  {

    /**
     * 订单总价，预订时的价格，包含机票立减优惠，不包含退改，金额不会更改，不包含异步平台服务服务费。 定义预订出票时订单总花费&#x3D;order_amount+asynchronous_service_fee
     * 
     */
    @JsonProperty("order_amount")
    private Integer orderAmount;
    /**
     * 公司支付金额，预订时订单总价内公司支付的金额 定义预订出票时公司支付金额&#x3D;company_pay
     * 
     */
    @JsonProperty("company_pay")
    private Integer companyPay;
    /**
     * 个人支付金额，预订时订单总价内个人支付的金额
     * 
     */
    @JsonProperty("personal_pay")
    private Integer personalPay;
    /**
     * 平台使用费，不包含异步平台使用费
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
     * 订单公司支付金额，单位：分 逻辑金额。跟随收费配置和退票改签，订单的公司支付金额会变更。按照钱支出方向累计
     * 
     */
    @JsonProperty("company_real_pay")
    private Integer companyRealPay;
    /**
     * 订单个人支付金额，单位：分 逻辑金额。跟随收费配置和退票改签，订单的个人支付金额会变更。按照钱支出方向累计
     * 
     */
    @JsonProperty("personal_real_pay")
    private Integer personalRealPay;
    /**
     * 订单公司收入金额，单位：分 逻辑金额。跟随收费配置和退票改签，订单的公司收入金额会变更。按照钱收入方向累计
     * 
     */
    @JsonProperty("company_real_refund")
    private Integer companyRealRefund;
    /**
     * 订单个人收入金额，单位：分 逻辑金额。跟随收费配置和退票改签，订单的个人收入付金额会变更。按照钱收入方向累计
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
    /**
     * 员工支付金额明细
     * 
     */
    @JsonProperty("personal_pay_detail")
    private PersonalPayDetail personalPayDetail;
    /**
     * personalRealPayDetail
     * 
     */
    @JsonProperty("personal_real_pay_detail")
    private PersonalRealPayDetail personalRealPayDetail;
    /**
     * personalRealRefundDetail
     * 
     */
    @JsonProperty("personal_real_refund_detail")
    private PersonalRealRefundDetail personalRealRefundDetail;
    /**
     * 服务包企业实付金额 单位：分，退服务包时，金额会变
     * 
     */
    @JsonProperty("srv_pack_company_real_pay")
    private Integer srvPackCompanyRealPay;
    /**
     * 机票订立减优惠
     * 
     */
    @JsonProperty("cut_fee")
    private Integer cutFee;
}

