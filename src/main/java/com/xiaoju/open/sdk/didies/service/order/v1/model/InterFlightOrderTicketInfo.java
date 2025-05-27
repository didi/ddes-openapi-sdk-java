package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
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
public class InterFlightOrderTicketInfo  {

    /**
     * 机票唯一标记，非票号, 不包含改签票信息，预订时的票张信息
     * 
     */
    @JsonProperty("ticket_unique_key")
    private String ticketUniqueKey;
    /**
     * 票号，廉价航空直接给下游的票号，可以为空
     * 
     */
    @JsonProperty("ticket_number")
    private String ticketNumber;
    /**
     * 乘客ID，memberid或travelerid用于关联乘客信息
     * 
     */
    @JsonProperty("passenger_traveler_id")
    private String passengerTravelerId;
    /**
     * 票号状态，枚举英文code：OpenForUse 客票有效未使用,CheckedIn 已办理值机手续,Boarded     已登机,Used     已使用,Refunded 已退票,Exchanged 电子客票已换开为其他客票,Suspended 系统处理中或认为挂起禁止使用,Void      已作废,Airport CNTL 机场控制,CPN Note 机场控制,UnKnow      未知，起飞后票号才开始扫描获取最近的票号状态
     * 
     */
    @JsonProperty("ticket_status")
    private String ticketStatus;
    /**
     * 是否协议价，枚举数字 ：0 否 1 是
     * 
     */
    @JsonProperty("is_account_price")
    private Integer isAccountPrice;
    /**
     * 机票销售价，单位：分 包含立减金
     * 
     */
    @JsonProperty("sale_price")
    private Integer salePrice;
    /**
     * 机票订立减优惠，单位：分
     * 
     */
    @JsonProperty("cut_fee")
    private Integer cutFee;
    /**
     * 机票实际出票价格，单位：分
     * 
     */
    @JsonProperty("ticket_price")
    private Integer ticketPrice;
    /**
     * 机建费，单位：分
     * 
     */
    @JsonProperty("construction_fee")
    private Integer constructionFee;
    /**
     * 燃油费，单位：分
     * 
     */
    @JsonProperty("oil_fee")
    private Integer oilFee;
    /**
     * 出票平台使用费，单位：分
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
     * 航段信息
     * 
     */
    @JsonProperty("sequence_list")
    private List<FlightOrderSequenceListItem> sequenceList;
    /**
     * 税，单位：分
     * 
     */
    @JsonProperty("tax")
    private Integer tax;
}

