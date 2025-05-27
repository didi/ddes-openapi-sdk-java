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
public class TrainOrderRefundInfo  {

    /**
     * 火车票ID，滴滴火车票内部唯一主键，退票成功的信息
     * 
     */
    @JsonProperty("ticket_unique_key")
    private String ticketUniqueKey;
    /**
     * 退票手续费，单位：分
     * 
     */
    @JsonProperty("refund_handle_fee")
    private Integer refundHandleFee;
    /**
     * 退还用户金额，单位：分
     * 
     */
    @JsonProperty("user_refund")
    private Integer userRefund;
    /**
     * 退票平台使用费，单位：分
     * 
     */
    @JsonProperty("refund_service_fee")
    private Integer refundServiceFee;
    /**
     * 退票成功时间，格式：yyyy-MM-dd HH:mm:ss
     * 
     */
    @JsonProperty("refunded_time")
    private String refundedTime;
    /**
     * 退票原因
     * 
     */
    @JsonProperty("reason_for_refund")
    private String reasonForRefund;
    /**
     * 企业退款金额，单位：分
     * 
     */
    @JsonProperty("company_refund")
    private Integer companyRefund;
    /**
     * 个人退款金额，单位：分
     * 
     */
    @JsonProperty("personal_refund")
    private Integer personalRefund;
}

