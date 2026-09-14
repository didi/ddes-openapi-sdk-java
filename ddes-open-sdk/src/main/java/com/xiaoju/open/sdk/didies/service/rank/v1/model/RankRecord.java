package com.xiaoju.open.sdk.didies.service.rank.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RankRecord  {

    /**
     * 滴滴侧职级 ID
     *
     */
    @JsonProperty("id")
    private String id;
    /**
     * 职级名称
     *
     */
    @JsonProperty("name")
    private String name;
    /**
     * 外部职级编号（实测补充字段，文档暂未声明）
     *
     */
    @JsonProperty("out_rank_id")
    private String outRankId;
}
