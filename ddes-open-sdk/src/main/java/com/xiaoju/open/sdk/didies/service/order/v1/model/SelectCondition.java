package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SelectCondition  {

    /**
     * 中台城市列表
     * 
     */
    @JsonProperty("transfer_city_list")
    private List<String> transferCityList;
    /**
     * 到达站点列表
     * 
     */
    @JsonProperty("to_station_list")
    private List<String> toStationList;
    /**
     * 到达站点列表
     * 
     */
    @JsonProperty("from_station_list")
    private List<String> fromStationList;
    /**
     * isShowCross
     * 
     */
    @JsonProperty("is_show_cross")
    private Integer isShowCross;
    /**
     * isShowLocal
     * 
     */
    @JsonProperty("is_show_local")
    private Integer isShowLocal;
}

