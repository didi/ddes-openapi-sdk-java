package com.xiaoju.open.sdk.didies.service.approval.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TravelBudget  {

    /**
     * 申请单总预算金额 单位 分
     * 
     */
    @JsonProperty("budget_amount")
    private Integer budgetAmount;
    /**
     * 预算类型，1 申请单维度
     * 
     */
    @JsonProperty("budget_type")
    private Integer budgetType;
    /**
     * 需要申请单使用的制度内开启对应的品类。且最终取两者交集。使用数字，预算可使用品类：1 市内用车 2 接送场景 301 国内酒店 401 火车票 601 国内机票 701 国际机票 801 国际酒店
     * 
     */
    @JsonProperty("budget_share")
    private List<Integer> budgetShare;
}

