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
public class StopoverPoint  {

    /**
     * 途经点城市id
     * 
     */
    @JsonProperty("cityid")
    private String cityid;
    /**
     * 详细地址，途经点的详细地址
     * 
     */
    @JsonProperty("address")
    private String address;
    /**
     * 途径点id
     * 
     */
    @JsonProperty("stop_id")
    private Integer stopId;
    /**
     * 途经点城市名称
     * 
     */
    @JsonProperty("city")
    private String city;
    /**
     * 途经点经度
     * 
     */
    @JsonProperty("lng")
    private String lng;
    /**
     * 途经点维度
     * 
     */
    @JsonProperty("lat")
    private String lat;
    /**
     * 途经点名称
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 途径点状态，状态分为0和1 , 0代表还未经过该途经点,1 代表已经经过该途经点
     * 
     */
    @JsonProperty("status")
    private Integer status;
}

