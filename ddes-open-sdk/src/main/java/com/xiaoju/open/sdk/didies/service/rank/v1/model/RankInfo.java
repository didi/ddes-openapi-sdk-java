package com.xiaoju.open.sdk.didies.service.rank.v1.model;

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
public class RankInfo  {

    /**
     * 滴滴侧职级 ID；更新时和out_rank_id二选一
     * 
     */
    @JsonProperty("rank_id")
    private String rankId;
    /**
     * 外部职级编号
     * 
     */
    @JsonProperty("out_rank_id")
    private String outRankId;
    /**
     * 职级名称
     * 
     */
    @JsonProperty("name")
    private String name;
}

