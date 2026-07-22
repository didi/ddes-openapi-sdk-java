package com.xiaoju.open.sdk.didies.service.member.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;




@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class HomeAddressInfo  {

    /**
     * 城市名称
     *
     */
    @JsonProperty("city")
    private String city;
    /**
     * 滴滴城市ID
     *
     */
    @JsonProperty("city_id")
    private Integer cityId;
    /**
     * 国内城市行政区划代码
     *
     */
    @JsonProperty("city_adcode")
    private String cityAdcode;
    /**
     * 家庭住址详细名称
     *
     */
    @JsonProperty("address_name")
    private String addressName;
}
