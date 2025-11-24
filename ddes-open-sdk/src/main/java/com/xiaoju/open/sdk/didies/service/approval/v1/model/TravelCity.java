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
public class TravelCity  {

    /**
     * 城市ID
     * 
     */
    @JsonProperty("id")
    private Integer id;
    /**
     * 城市名称
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 目的地维度 默认0; 1：国家；2：省；0：城市(包括县级市)
     * 
     */
    @JsonProperty("address_dimension")
    private Integer addressDimension;
    /**
     * 出发国家ID
     * 
     */
    @JsonProperty("country_id")
    private Integer countryId;
    /**
     * 出发国家名称
     * 
     */
    @JsonProperty("country_name")
    private String countryName;
    /**
     * 出发省ID
     * 
     */
    @JsonProperty("province_id")
    private Integer provinceId;
    /**
     * 出发省名称
     * 
     */
    @JsonProperty("province_name")
    private String provinceName;
}

