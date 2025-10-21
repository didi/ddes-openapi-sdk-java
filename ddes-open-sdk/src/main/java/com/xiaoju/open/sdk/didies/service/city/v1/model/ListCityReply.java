package com.xiaoju.open.sdk.didies.service.city.v1.model;

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
public class ListCityReply  {

    /**
     * 查询结果条数
     * 
     */
    @JsonProperty("total")
    private Integer total;
    /**
     * 返回具体的结果信息
     * 
     */
    @JsonProperty("records")
    private List<CityRecord> records;
}

