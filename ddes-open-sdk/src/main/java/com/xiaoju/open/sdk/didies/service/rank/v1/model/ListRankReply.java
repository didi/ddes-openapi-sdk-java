package com.xiaoju.open.sdk.didies.service.rank.v1.model;

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
public class ListRankReply  {

    /**
     * 职级集合中的条数
     * 
     */
    @JsonProperty("total")
    private Integer total;
    /**
     * 职级数据集合
     * 
     */
    @JsonProperty("records")
    private List<RankInfo> records;
}

