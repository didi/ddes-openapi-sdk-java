package com.xiaoju.open.sdk.didies.service.project.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaoju.open.sdk.didies.core.model.BaseReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;




@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OutTravelerListRequest extends BaseReq  {

    /**
     * 企业ID
     *
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 项目ID
     *
     */
    @JsonProperty("project_id")
    private String projectId;
    /**
     * 所属项目编码
     *
     */
    @JsonProperty("out_budget_id")
    private String outBudgetId;
    /**
     * 页码
     *
     */
    @JsonProperty("page")
    private Integer page;
    /**
     * 每页大小
     *
     */
    @JsonProperty("page_size")
    private Integer pageSize;
}
