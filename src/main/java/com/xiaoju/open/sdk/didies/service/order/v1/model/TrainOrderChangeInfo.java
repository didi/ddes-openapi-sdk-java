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
public class TrainOrderChangeInfo  {

    /**
     * 火车票ID，滴滴火车票内部唯一主键，改签新票 改签成功的信息，包含0元改签
     * 
     */
    @JsonProperty("ticket_unique_key")
    private String ticketUniqueKey;
    /**
     * 乘客ID，滴滴ID或travelerId用于关联乘客信息
     * 
     */
    @JsonProperty("passenger_traveler_id")
    private String passengerTravelerId;
    /**
     * 改签前火车票ID，被改签的火车票ID
     * 
     */
    @JsonProperty("pre_ticket_unique_key")
    private String preTicketUniqueKey;
    /**
     * 改签处理订单号，滴滴内部的改签订单号
     * 
     */
    @JsonProperty("change_order_id")
    private String changeOrderId;
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
     * 预计发车时间，格式：yyyy-MM-dd HH:mm:ss
     * 
     */
    @JsonProperty("start_time")
    private String startTime;
    /**
     * 预计到达时间，格式：yyyy-MM-dd HH:mm:ss
     * 
     */
    @JsonProperty("arrive_time")
    private String arriveTime;
    /**
     * 车次编号
     * 
     */
    @JsonProperty("train_code")
    private String trainCode;
    /**
     * 车票状态，枚举英文code：Holding 占座中；Held 占座成功；Cancelled 已取消；Ticketing 出票中；Openforuse 待乘车；Outbound 已出站；refunding 退票中；Refunded 已退票；Changing 改签中；Changed 已改签；Waitforapproval 待审批；Refoundedother 其它平台退票；Chagnedother 其它平台改签；Refoundedafterchagnedother 其它平台退改；Unknow 未知
     * 
     */
    @JsonProperty("ticket_status")
    private String ticketStatus;
    /**
     * 座位席别，展示中文名，无返回时，显示“其他”
     * 
     */
    @JsonProperty("seat_type")
    private String seatType;
    /**
     * 车厢号，示例：09车厢
     * 
     */
    @JsonProperty("coach_number")
    private String coachNumber;
    /**
     * 座位号，车票座位号，示例：03D号
     * 
     */
    @JsonProperty("seat_no")
    private String seatNo;
    /**
     * 出发城市名称，城市中文名
     * 
     */
    @JsonProperty("departure_city_name")
    private String departureCityName;
    /**
     * 出发城市ID，滴滴城市ID
     * 
     */
    @JsonProperty("departure_city_id")
    private String departureCityId;
    /**
     * 到达城市名称，城市中文名
     * 
     */
    @JsonProperty("arrival_city_name")
    private String arrivalCityName;
    /**
     * 到达城市ID，滴滴城市ID
     * 
     */
    @JsonProperty("arrival_city_id")
    private String arrivalCityId;
    /**
     * 出发车站名称
     * 
     */
    @JsonProperty("departure_station_name")
    private String departureStationName;
    /**
     * 到达车站名称
     * 
     */
    @JsonProperty("arrival_station_name")
    private String arrivalStationName;
    /**
     * 改签手续费，单位：分 改签总手续费包含改签费和退票差价费
     * 
     */
    @JsonProperty("change_handing_fee")
    private Integer changeHandingFee;
    /**
     * 改签新票票款，单位：分
     * 
     */
    @JsonProperty("change_ticket_price")
    private Integer changeTicketPrice;
    /**
     * 改签平台使用费，单位：分
     * 
     */
    @JsonProperty("change_service_fee")
    private Integer changeServiceFee;
    /**
     * 改签企业支付金额，单位：分 改签车票公司支付部分
     * 
     */
    @JsonProperty("change_company_pay")
    private Integer changeCompanyPay;
    /**
     * 改签个人支付金额，单位：分 改签车票个人支付部分
     * 
     */
    @JsonProperty("change_personal_pay")
    private Integer changePersonalPay;
}

