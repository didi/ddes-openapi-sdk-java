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
    /**
     * 归属企业名称，集团账户【上级公司统一对接】场景使用，随 param_json 提交
     *
     */
    @JsonProperty("belong_enterprise_name")
    private String belongEnterpriseName;
    /**
     * 纳税人识别号，集团账户【上级公司统一对接】场景使用，与belong_enterprise_name二选一，随 param_json 提交
     *
     */
    @JsonProperty("taxpayer_no")
    private String taxpayerNo;
}

