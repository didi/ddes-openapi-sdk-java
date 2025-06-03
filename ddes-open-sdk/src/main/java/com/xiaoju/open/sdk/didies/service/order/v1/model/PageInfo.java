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
public class PageInfo  {

    /**
     * 查询页
     * 
     */
    @JsonProperty("cur_page")
    private Integer curPage;
    /**
     * 页大小
     * 
     */
    @JsonProperty("limit")
    private Integer limit;
    /**
     * 符合条件的数据总条数
     * 
     */
    @JsonProperty("total")
    private Integer total;
}

