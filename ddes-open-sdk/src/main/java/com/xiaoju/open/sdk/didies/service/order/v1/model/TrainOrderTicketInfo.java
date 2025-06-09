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
public class TrainOrderTicketInfo  {

    /**
     * 火车票ID，非票号, 不包含改签票信息，预订时的票张信息
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
     * 车票状态，枚举英文code：Holding 占座中 Held 占座成功 Cancelled 已取消 Ticketing 出票中 Openforuse 待乘车 Outbound 已出站 refunding 退票中 Refunded 已退票 Changing 改签中 Changed 已改签 Waitforapproval 待审批 Refoundedother 其它平台退票 Chagnedother 其它平台改签 Refoundedafterchagnedother 其它平台退改 Unknow 未知
     * 
     */
    @JsonProperty("ticket_status")
    private String ticketStatus;
    /**
     * 座位席别，展示中文名，无返回时，显示“其他”，参考坐席列表
     * 
     */
    @JsonProperty("seat_type")
    private String seatType;
    /**
     * 车厢号，车厢号，示例：09车厢
     * 
     */
    @JsonProperty("coach_number")
    private String coachNumber;
    /**
     * 车票座位号，示例：03D号
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
     * 车票票面价，单位：分 票面销售费用 ，实际出票价格
     * 
     */
    @JsonProperty("sale_price")
    private Integer salePrice;
    /**
     * 出票平台使用费，单位：分 实时收取的服务费
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
     * 抢票服务费，单位：分 抢票成功时收取的服务费
     * 
     */
    @JsonProperty("grab_service_fee")
    private Integer grabServiceFee;
    /**
     * 车票企业支付金额，单位：分 车票公司支付部分
     * 
     */
    @JsonProperty("company_pay")
    private Integer companyPay;
    /**
     * 车票个人支付金额，单位：分 车票个人支付部分
     * 
     */
    @JsonProperty("personal_pay")
    private Integer personalPay;
    /**
     * 出票时间，格式：yyyy-MM-dd HH:mm:ss
     * 
     */
    @JsonProperty("print_ticket_time")
    private String printTicketTime;
}

