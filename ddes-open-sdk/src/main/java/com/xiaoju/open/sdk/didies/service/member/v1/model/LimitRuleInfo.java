package com.xiaoju.open.sdk.didies.service.member.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;




@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LimitRuleInfo  {

    /**
     * 限额规则名称
     *
     */
    @JsonProperty("rule_name")
    private String ruleName;
    /**
     * 预算周期，枚举值数字：0 不限额 1 自然月 2 自然季度 3 自然年 4 一次性 5 自然日 6 自定义 7 使用原部门的周期
     *
     */
    @JsonProperty("budget_cycle")
    private Integer budgetCycle;
    /**
     * 是否累计，枚举值数字：0 不可累计 1 可累计
     *
     */
    @JsonProperty("is_accumulative")
    private Integer isAccumulative;
    /**
     * 限额，单位元，精确到两位小数，0表示不限额度
     *
     */
    @JsonProperty("total_quota")
    private Double totalQuota;
    /**
     * 剩余额度，单位元，精确到两位小数
     *
     */
    @JsonProperty("available_quota")
    private Double availableQuota;
    /**
     * 冻结金额，单位元，精确到两位小数
     *
     */
    @JsonProperty("freeze_quota")
    private Double freezeQuota;
    /**
     * 限额管理范围
     *
     */
    @JsonProperty("limit_management_scope")
    private Integer limitManagementScope;
}
