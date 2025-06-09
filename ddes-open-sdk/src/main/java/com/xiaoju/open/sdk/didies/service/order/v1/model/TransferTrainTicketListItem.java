package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.order.v1.model.SegmentItem;
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
public class TransferTrainTicketListItem  {

    /**
     * 渠道来源
     * 
     */
    @JsonProperty("supplier_id")
    private Integer supplierId;
    /**
     * 到达站点名称
     * 
     */
    @JsonProperty("to_station_name")
    private String toStationName;
    /**
     * 中转站点名称
     * 
     */
    @JsonProperty("transfer_station_name")
    private String transferStationName;
    /**
     * 中转站类型，1-同站换乘；2-跨站换乘
     * 
     */
    @JsonProperty("transfer_station_type")
    private Integer transferStationType;
    /**
     * 中转城市名称
     * 
     */
    @JsonProperty("transfer_city_name")
    private String transferCityName;
    /**
     * 两程总运行时长
     * 
     */
    @JsonProperty("total_runtime")
    private String totalRuntime;
    /**
     * 全程跨天数 如:0 代表当天到达，1 代表第二天到达
     * 
     */
    @JsonProperty("day_difference")
    private Integer dayDifference;
    /**
     * 出发站名称
     * 
     */
    @JsonProperty("from_station_name")
    private String fromStationName;
    /**
     * 中转停留时长
     * 
     */
    @JsonProperty("transfer_stop_time")
    private String transferStopTime;
    /**
     * 行程列表
     * 
     */
    @JsonProperty("segment_items")
    private List<SegmentItem> segmentItems;
}

