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
}

