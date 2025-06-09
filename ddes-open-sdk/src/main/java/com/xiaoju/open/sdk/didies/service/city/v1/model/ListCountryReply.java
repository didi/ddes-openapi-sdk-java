package com.xiaoju.open.sdk.didies.service.city.v1.model;

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
public class ListCountryReply  {

    /**
     * 国家id
     * 
     */
    @JsonProperty("country_id")
    private Integer countryId;
    /**
     * 国家二次码
     * 
     */
    @JsonProperty("canonical_country_code")
    private String canonicalCountryCode;
    /**
     * 国家三字码
     * 
     */
    @JsonProperty("country_code")
    private String countryCode;
    /**
     * 国家中文名
     * 
     */
    @JsonProperty("country_name_cn")
    private String countryNameCn;
    /**
     * 国家英文名
     * 
     */
    @JsonProperty("country_name_en")
    private String countryNameEn;
    /**
     * 大洲id
     * 
     */
    @JsonProperty("continent_id")
    private Integer continentId;
    /**
     * 大洲中文名
     * 
     */
    @JsonProperty("continent_name_cn")
    private String continentNameCn;
    /**
     * 大洲英文名
     * 
     */
    @JsonProperty("continent_name_en")
    private String continentNameEn;
}

