package com.xiaoju.open.sdk.didies.service.city.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.city.v1.model.CityInfo;
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
public class CityRecord  {

    /**
     * 省ID，国家下一层级，滴滴企业级内部主键
     * 
     */
    @JsonProperty("province_id")
    private Integer provinceId;
    /**
     * 省中文名
     * 
     */
    @JsonProperty("province_name_cn")
    private String provinceNameCn;
    /**
     * 省英文名
     * 
     */
    @JsonProperty("province_name_en")
    private String provinceNameEn;
    /**
     * 城市列表
     * 
     */
    @JsonProperty("city_list")
    private List<CityInfo> cityList;
}

