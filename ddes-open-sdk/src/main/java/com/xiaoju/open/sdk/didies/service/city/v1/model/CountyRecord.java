package com.xiaoju.open.sdk.didies.service.city.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CountyRecord  {

    /**
     * 区县ID
     * 
     */
    @JsonProperty("county_id")
    private Integer countyId;
    /**
     * 区县名称
     * 
     */
    @JsonProperty("county_name")
    private String countyName;
}

