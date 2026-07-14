package com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model;

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
public class GetBudgetCenterRequest extends BaseReq  {

    /**
     * outBudgetId
     * 
     */
    @JsonProperty("out_budget_id")
    private String outBudgetId;
    /**
     * isExactName
     * 
     */
    @JsonProperty("is_exact_name")
    private Integer isExactName;
    /**
     * companyId
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * offset
     * 
     */
    @JsonProperty("offset")
    private Integer offset;
    /**
     * name
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * length
     * 
     */
    @JsonProperty("length")
    private Integer length;
    /**
     * id
     * 
     */
    @JsonProperty("id")
    private String id;
    /**
     * type
     *
     */
    @JsonProperty("type")
    private Integer type;
    /**
     * 是否返回部门/项目限额规则列表，枚举值数字：0=不返回，1=返回，默认1
     *
     */
    @JsonProperty("is_need_limit_rule")
    private Integer isNeedLimitRule;
    /**
     * 是否返回POI信息，枚举值数字：0=不返回，1=返回，默认0
     *
     */
    @JsonProperty("is_get_poi")
    private Integer isGetPoi;
    /**
     * 是否返回扩展字段，枚举值数字：0=不返回，1=返回，默认0
     *
     */
    @JsonProperty("is_get_extend_fields")
    private Integer isGetExtendFields;
}

