package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.order.v1.model.PersonalRefundDetail;
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
public class InterFlightOrderRefundInfo  {

    /**
     * 票号唯一值，退票成功的信息
     * 
     */
    @JsonProperty("ticket_unique_key")
    private String ticketUniqueKey;
    /**
     * 退票手续费，单位：分 票价（包含改签手续费），不包含平台使用费
     * 
     */
    @JsonProperty("refund_handle_fee")
    private Integer refundHandleFee;
    /**
     * 机票订立减优惠，单位：分 退票时回收金额
     * 
     */
    @JsonProperty("cut_fee")
    private Integer cutFee;
    /**
     * 退票平台使用费，单位：分
     * 
     */
    @JsonProperty("refund_service_fee")
    private Integer refundServiceFee;
    /**
     * 退票异步平台使用费，单位：分
     * 
     */
    @JsonProperty("refund_asynchronous_service_fee")
    private Integer refundAsynchronousServiceFee;
    /**
     * 退票原因
     * 
     */
    @JsonProperty("reason_for_refund")
    private String reasonForRefund;
    /**
     * 退还用户金额，单位：分 refund_user_fee&#x3D;company_refund+personal_refund
     * 
     */
    @JsonProperty("refund_user_fee")
    private Integer refundUserFee;
    /**
     * 企业支付退款金额，单位：分 目前包含服务费
     * 
     */
    @JsonProperty("company_refund")
    private Integer companyRefund;
    /**
     * 员工支付退款金额，单位：分
     * 
     */
    @JsonProperty("personal_refund")
    private Integer personalRefund;
    /**
     * personalRefundDetail
     * 
     */
    @JsonProperty("personal_refund_detail")
    private PersonalRefundDetail personalRefundDetail;
    /**
     * 退票成功时间，格式：yyyy-MM-dd HH:mm:ss
     * 
     */
    @JsonProperty("refunded_time")
    private String refundedTime;
}

