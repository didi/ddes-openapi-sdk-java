package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.order.v1.model.TicketData;
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
public class TrainLeftTicketListItem  {

    /**
     * 全车次
     * 
     */
    @JsonProperty("train_no")
    private String trainNo;
    /**
     * 站车次
     * 
     */
    @JsonProperty("train_code")
    private String trainCode;
    /**
     * 上车站电报码
     * 
     */
    @JsonProperty("from_station_telecode")
    private String fromStationTelecode;
    /**
     * 上车站站名
     * 
     */
    @JsonProperty("from_station_name")
    private String fromStationName;
    /**
     * 下车站电报码
     * 
     */
    @JsonProperty("to_station_telecode")
    private String toStationTelecode;
    /**
     * 下车站站名
     * 
     */
    @JsonProperty("to_station_name")
    private String toStationName;
    /**
     * 始发站站名
     * 
     */
    @JsonProperty("start_station_name")
    private String startStationName;
    /**
     * 终到站站名
     * 
     */
    @JsonProperty("end_station_name")
    private String endStationName;
    /**
     * 上车时间，格式2021-01-01 12:00:00
     * 
     */
    @JsonProperty("start_time")
    private String startTime;
    /**
     * 下车时间，格式2021-01-01 14:23:43
     * 
     */
    @JsonProperty("arrive_time")
    private String arriveTime;
    /**
     * 历时，单位分钟
     * 
     */
    @JsonProperty("travel_time")
    private Integer travelTime;
    /**
     * 历时文案，如：历时0小时33分
     * 
     */
    @JsonProperty("travel_time_name")
    private String travelTimeName;
    /**
     * 是否放票0 表示正常售票; 1 表示不能发售(未到放票时间或暂停发售，不可购买); 2 表示进藏等特殊车辆，下单前需将 saleFlagMsg 信息明确提示给用户。
     * 
     */
    @JsonProperty("sale_flag")
    private Integer saleFlag;
    /**
     * 放票信息sale_flag &#x3D;1 时表示不能发售原因信息(前端控制车次的历时、票价等信息不显示)。 sale_flag &#x3D;2 时表示特殊提示信息，下单前需提示用户，用户确认后继续下单。
     * 
     */
    @JsonProperty("sale_flag_msg")
    private String saleFlagMsg;
    /**
     * 是否支持刷二代身份证乘车: 0 是不支持，1 是支持
     * 
     */
    @JsonProperty("is_support_card")
    private Integer isSupportCard;
    /**
     * 车次跨t天数，0 代表当天到达，1 代表第二天到达
     * 
     */
    @JsonProperty("day_difference")
    private Integer dayDifference;
    /**
     * 车次余票信息
     * 
     */
    @JsonProperty("ticket_data")
    private List<TicketData> ticketData;
    /**
     * 电子票乘车标识，0 是不支持，1 是支持
     * 
     */
    @JsonProperty("eticket_train_flag")
    private Integer eticketTrainFlag;
    /**
     * 是否有静音车厢，0 - 无，1 - 有
     * 
     */
    @JsonProperty("special_flag")
    private Integer specialFlag;
    /**
     * 是否为始发站，0 - 经过站，1 - 始发站
     * 
     */
    @JsonProperty("is_start_station")
    private Integer isStartStation;
    /**
     * 是否为终点站，0 - 经过站，1 - 站点站
     * 
     */
    @JsonProperty("is_end_station")
    private Integer isEndStation;
}

