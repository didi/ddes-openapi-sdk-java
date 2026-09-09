package com.xiaoju.open.sdk.didies.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;




@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseV2PageReply  {

    /**
     * 下一页的token，集团账户【上级公司统一对接】分页使用，为空字符串或null说明没有下一页
     *
     */
    @JsonProperty("next_token")
    private String nextToken;
    /**
     * 公司总数（实测补充字段，文档暂未声明，语义以官方后续文档为准）
     *
     */
    @JsonProperty("company_total")
    private Integer companyTotal;
    /**
     * 公司列表是否有变化（实测补充字段，文档暂未声明，语义以官方后续文档为准）
     *
     */
    @JsonProperty("company_list_has_change")
    private Boolean companyListHasChange;
    /**
     * 进度标记（实测补充字段，文档暂未声明，语义以官方后续文档为准）
     *
     */
    @JsonProperty("progress")
    private Integer progress;
}
