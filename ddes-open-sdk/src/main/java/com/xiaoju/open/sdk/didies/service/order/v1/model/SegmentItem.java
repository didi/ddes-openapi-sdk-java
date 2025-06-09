package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.order.v1.model.TransferTrainTicketData;
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
public class SegmentItem  {

    /**
     * 出发站点名称
     * 
     */
    @JsonProperty("start_station_name")
    private String startStationName;
    /**
     * 到达时间，eg: 2025-01-10 10:23
     * 
     */
    @JsonProperty("arrive_time")
    private String arriveTime;
    /**
     * 第一程和到二程跨天的天数
     * 
     */
    @JsonProperty("day_difference")
    private Integer dayDifference;
    /**
     * 是否是终点站，1：是 0：否
     * 
     */
    @JsonProperty("is_end_station")
    private Integer isEndStation;
    /**
     * 出发城市ID
     * 
     */
    @JsonProperty("from_city_id")
    private String fromCityId;
    /**
     * 车站点电报码
     * 
     */
    @JsonProperty("from_station_telecode")
    private String fromStationTelecode;
    /**
     * 到达时间时间戳，eg： 1736475780
     * 
     */
    @JsonProperty("arrive_timestamp")
    private Integer arriveTimestamp;
    /**
     * 是否开启售卖，1：是 0：否
     * 
     */
    @JsonProperty("sale_flag_msg")
    private String saleFlagMsg;
    /**
     * 电子票乘车标识 0 是不支持，1 是支持
     * 
     */
    @JsonProperty("eticket_train_flag")
    private String eticketTrainFlag;
    /**
     * 车次类型
     * 
     */
    @JsonProperty("train_type")
    private String trainType;
    /**
     * 车次号
     * 
     */
    @JsonProperty("train_no")
    private String trainNo;
    /**
     * 车次号长码
     * 
     */
    @JsonProperty("train_code")
    private String trainCode;
    /**
     * 发车时间
     * 
     */
    @JsonProperty("start_time")
    private String startTime;
    /**
     * 出发站点
     * 
     */
    @JsonProperty("from_station_no")
    private String fromStationNo;
    /**
     * 到达城市
     * 
     */
    @JsonProperty("to_city_id")
    private String toCityId;
    /**
     * 是否放票 0表示正常售票;1表示不能发售(未到放票时间或暂停发售，不可购买);2表示进藏等特殊车辆
     * 
     */
    @JsonProperty("sale_flag")
    private String saleFlag;
    /**
     * 是否支持刷卡，1：是 0：否
     * 
     */
    @JsonProperty("is_support_card")
    private String isSupportCard;
    /**
     * 车票维度系统唯一标识（内部数据流转使用）
     * 
     */
    @JsonProperty("train_secrets")
    private String trainSecrets;
    /**
     * 格式化行驶时长，eg: 历史4小时15分
     * 
     */
    @JsonProperty("travel_time_name")
    private String travelTimeName;
    /**
     * 发车时间时间戳
     * 
     */
    @JsonProperty("start_timestamp")
    private Integer startTimestamp;
    /**
     * 到达站点
     * 
     */
    @JsonProperty("to_station_no")
    private String toStationNo;
    /**
     * 第几程，第一程：1，第二程：2
     * 
     */
    @JsonProperty("sequence")
    private Integer sequence;
    /**
     * 到达站点电报码
     * 
     */
    @JsonProperty("to_station_telecode")
    private String toStationTelecode;
    /**
     * 到达站点名称
     * 
     */
    @JsonProperty("to_station_name")
    private String toStationName;
    /**
     * 车次类型编码
     * 
     */
    @JsonProperty("train_type_code")
    private String trainTypeCode;
    /**
     * 出发站点名称
     * 
     */
    @JsonProperty("from_station_name")
    private String fromStationName;
    /**
     * 坐席类型
     * 
     */
    @JsonProperty("seat_types")
    private String seatTypes;
    /**
     * 行驶时长，单位：分钟
     * 
     */
    @JsonProperty("travel_time")
    private Integer travelTime;
    /**
     * 是否存在静音，1：是 0：否
     * 
     */
    @JsonProperty("special_flag")
    private Integer specialFlag;
    /**
     * 是否始发站，1：是 0：否
     * 
     */
    @JsonProperty("is_start_station")
    private Integer isStartStation;
    /**
     * 到达站点名称
     * 
     */
    @JsonProperty("end_station_name")
    private String endStationName;
    /**
     * 票信息
     * 
     */
    @JsonProperty("ticket_data")
    private List<TransferTrainTicketData> ticketData;
}

