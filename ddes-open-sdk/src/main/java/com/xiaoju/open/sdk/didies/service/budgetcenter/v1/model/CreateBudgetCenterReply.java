package com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBudgetCenterReply  {

    /**
     * 部门或项目ID
     * 
     */
    @JsonProperty("id")
    private String id;
}

