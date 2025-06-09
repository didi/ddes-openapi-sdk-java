package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.order.v1.model.DomesticFlightOrderPersonalPayDetail;
import com.xiaoju.open.sdk.didies.service.order.v1.model.FlightOrderSequenceListItem;
import java.util.ArrayList;
import java.util.List;
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
public class DomesticFlightOrderChangeInfo  {

    /**
     * 票号唯一值，展示成功的改签后的票，改签所有的过程数据，包含0元改签
     * 
     */
    @JsonProperty("ticket_unique_key")
    private String ticketUniqueKey;
    /**
     * 改签原票唯一值，原票，多次改签也是对应预订的原票
     * 
     */
    @JsonProperty("original_ticket_unique_key")
    private String originalTicketUniqueKey;
    /**
     * 改签前一次唯一值
     * 
     */
    @JsonProperty("pre_ticket_unique_key")
    private String preTicketUniqueKey;
    /**
     * 改签后票号，廉价航空直接给下游的票号，可以为空
     * 
     */
    @JsonProperty("changedticket_number")
    private String changedticketNumber;
    /**
     * 改签后票号状态，枚举英文code：OpenForUse 客票有效未使用,CheckedIn 已办理值机手续,Boarded     已登机,Used     已使用,Refunded 已退票,Exchanged 电子客票已换开为其他客票,Suspended 系统处理中或认为挂起禁止使用,Void      已作废,Airport CNTL 机场控制,CPN Note 机场控制,UnKnow      未知，起飞后票号才开始扫描获取最近的票号状态
     * 
     */
    @JsonProperty("changedticket_status")
    private String changedticketStatus;
    /**
     * 改签处理订单号，滴滴内部的改签订单号,预算推送时关联
     * 
     */
    @JsonProperty("change_order_id")
    private String changeOrderId;
    /**
     * 乘客唯一值
     * 
     */
    @JsonProperty("passenger_traveler_id")
    private String passengerTravelerId;
    /**
     * 改签原因
     * 
     */
    @JsonProperty("reason_for_change")
    private String reasonForChange;
    /**
     * 改签成功时间，格式：yyyy-MM-dd HH:mm:ss
     * 
     */
    @JsonProperty("changed_time")
    private String changedTime;
    /**
     * 改签手续费，单位：分
     * 
     */
    @JsonProperty("chang_handle_fee")
    private String changHandleFee;
    /**
     * 改签升舱费，单位：分
     * 
     */
    @JsonProperty("change_up_cabin_fee")
    private String changeUpCabinFee;
    /**
     * 改签总费用，单位：分 change_fee&#x3D;change_up_cabin_fee+chang_handle_fee
     * 
     */
    @JsonProperty("change_fee")
    private String changeFee;
    /**
     * 机票订立减优惠，单位：分 改签时回收
     * 
     */
    @JsonProperty("cut_fee")
    private Integer cutFee;
    /**
     * 改签企业支付金额，单位：分 改签时公司支付部分，包含平台使用费
     * 
     */
    @JsonProperty("change_company_pay")
    private Integer changeCompanyPay;
    /**
     * 改签员工支付金额，单位：分 改签时员工支付部分 明细参考personal_pay_detail
     * 
     */
    @JsonProperty("change_personal_pay")
    private Integer changePersonalPay;
    /**
     * personalPayDetail
     * 
     */
    @JsonProperty("personal_pay_detail")
    private DomesticFlightOrderPersonalPayDetail personalPayDetail;
    /**
     * 改签出票平台使用费，单位：分 实时收取的服务费
     * 
     */
    @JsonProperty("change_service_fee")
    private String changeServiceFee;
    /**
     * 改签出票异步平台使用费，单位：分 异步收取的服务费
     * 
     */
    @JsonProperty("change_asynchronous_service_fee")
    private String changeAsynchronousServiceFee;
    /**
     * 航段信息
     * 
     */
    @JsonProperty("sequence_list")
    private List<FlightOrderSequenceListItem> sequenceList;
}

