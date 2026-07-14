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
public class LimitRuleItem  {

    /**
     * 限额规则名称
     *
     */
    @JsonProperty("rule_name")
    private String ruleName;
    /**
     * 预算周期，枚举值数字：0=不限额，1=自然月，2=自然季度，3=自然年，4=一次性，5=自然日，6=自定义，7=使用原部门周期
     *
     */
    @JsonProperty("budget_cycle")
    private Integer budgetCycle;
    /**
     * 是否累计，枚举值数字：0=不可累计，1=可累计
     *
     */
    @JsonProperty("is_accumulative")
    private Integer isAccumulative;
    /**
     * 限额（元），0 表示不限额度，精确到两位小数
     *
     */
    @JsonProperty("total_quota")
    private String totalQuota;
    /**
     * 限额管理范围，枚举值数字：0=对当前部门/项目生效，1=对当前和下级部门/项目生效
     *
     */
    @JsonProperty("limit_management_scope")
    private Integer limitManagementScope;
    /**
     * 剩余额度（元），精确到两位小数
     *
     */
    @JsonProperty("available_quota")
    private String availableQuota;
    /**
     * 冻结金额（元），精确到两位小数
     *
     */
    @JsonProperty("freeze_quota")
    private String freezeQuota;
}
