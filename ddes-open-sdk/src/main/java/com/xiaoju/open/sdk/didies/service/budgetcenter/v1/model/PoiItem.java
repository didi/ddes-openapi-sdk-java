package com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PoiItem  {

    /**
     * 城市名称
     *
     */
    @JsonProperty("city")
    private String city;
    /**
     * 城市滴滴侧ID
     *
     */
    @JsonProperty("city_id")
    private Integer cityId;
    /**
     * 城市行政区划编码
     *
     */
    @JsonProperty("city_adcode")
    private String cityAdcode;
    /**
     * 纬度
     *
     */
    @JsonProperty("flat")
    private Double flat;
    /**
     * 经度
     *
     */
    @JsonProperty("flng")
    private Double flng;
    /**
     * POI范围（米）
     *
     */
    @JsonProperty("poi_range")
    private Integer poiRange;
    /**
     * POI标签名称
     *
     */
    @JsonProperty("label")
    private String label;
}
