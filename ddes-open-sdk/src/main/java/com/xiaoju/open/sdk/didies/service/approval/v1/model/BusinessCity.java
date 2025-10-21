package com.xiaoju.open.sdk.didies.service.approval.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessCity  {

    /**
     * 城市ID
     * 
     */
    @JsonProperty("city_id")
    private Integer cityId;
    /**
     * 城市名称
     * 
     */
    @JsonProperty("city")
    private String city;
}

