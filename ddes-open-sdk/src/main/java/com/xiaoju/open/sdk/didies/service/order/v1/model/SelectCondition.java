package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
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

