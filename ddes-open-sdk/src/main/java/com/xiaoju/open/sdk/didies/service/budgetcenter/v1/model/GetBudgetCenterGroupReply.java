package com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaoju.open.sdk.didies.core.model.BaseGroupPageReply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;




@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GetBudgetCenterGroupReply extends BaseGroupPageReply  {

    /**
     * 成本中心/项目列表
     *
     */
    @JsonProperty("records")
    private List<BudgetCenterGroupRecord> records;
}
