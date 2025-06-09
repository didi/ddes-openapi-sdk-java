package com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.core.model.BaseReq;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class DelBudgetCenterRequest extends BaseReq  {

    /**
     * 企业ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 类型，推测为 1 代表部门，2 代表项目，未传时可根据业务规则处理
     * 
     */
    @JsonProperty("type")
    private Integer type;
    /**
     * 需要删除的部门或者项目的id，删除部门时，id和out_budget_id优先处理id；删除项目时，id和out_budget_id与name组合唯一值时，优先处理id
     * 
     */
    @JsonProperty("id")
    private String id;
    /**
     * 部门/项目名称，不大于 200 字符，使用out_budget_id删除项目时，项目名称需要一起提供
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 编号，type &#x3D; 1 时必填；type &#x3D; 2 非必填；长度限制：≤ 64 字符
     * 
     */
    @JsonProperty("out_budget_id")
    private String outBudgetId;
}

