package com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model;

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
public class GetBudgetCenterReply  {

    /**
     * 总数据条数
     * 
     */
    @JsonProperty("total")
    private String total;
    /**
     * 部门或者项目集合
     * 
     */
    @JsonProperty("records")
    private List<BudgetCenterRecord> records;
}

