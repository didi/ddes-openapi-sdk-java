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
public class BudgetCenterV2Record  {

    /**
     * 成本中心/项目 ID
     *
     */
    @JsonProperty("id")
    private String id;
    /**
     * 名称
     *
     */
    @JsonProperty("name")
    private String name;
    /**
     * 归属企业名称（集团路径返回字段）
     *
     */
    @JsonProperty("belong_enterprise_name")
    private String belongEnterpriseName;
    /**
     * 公司 ID（集团路径返回字段，ID 字符串化口径，服务端 IDL 佐证）
     *
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 类型（2 项目，3 部门）
     *
     */
    @JsonProperty("type")
    private String type;
    /**
     * 预算周期
     *
     */
    @JsonProperty("budget_cycle")
    private Integer budgetCycle;
    /**
     * 外部成本中心/项目编号
     *
     */
    @JsonProperty("out_budget_id")
    private String outBudgetId;
    /**
     * 总限额
     *
     */
    @JsonProperty("total_quota")
    private String totalQuota;
    /**
     * 是否限制限额
     *
     */
    @JsonProperty("is_limit_quota")
    private Integer isLimitQuota;
    /**
     * 成员数
     *
     */
    @JsonProperty("member_num")
    private Integer memberNum;
    /**
     * 可用限额
     *
     */
    @JsonProperty("available_quota")
    private String availableQuota;
    /**
     * 冻结限额
     *
     */
    @JsonProperty("freeze_quota")
    private String freezeQuota;
    /**
     * 组长 ID
     *
     */
    @JsonProperty("leader_id")
    private String leaderId;
    /**
     * 组长信息列表
     *
     */
    @JsonProperty("leader_item_list")
    private List<LeaderItem> leaderItemList;
    /**
     * 上级成本中心/项目 ID
     *
     */
    @JsonProperty("parent_id")
    private String parentId;
    /**
     * 已用成员数
     *
     */
    @JsonProperty("member_used")
    private Integer memberUsed;
    /**
     * 开始日期
     *
     */
    @JsonProperty("start_date")
    private String startDate;
    /**
     * 失效日期
     *
     */
    @JsonProperty("expiry_date")
    private String expiryDate;
    /**
     * 所在公司主体 id
     *
     */
    @JsonProperty("legal_entity_id")
    private String legalEntityId;
    /**
     * 预算扩展信息
     *
     */
    @JsonProperty("budget_extra_info")
    private String budgetExtraInfo;
    /**
     * 状态
     *
     */
    @JsonProperty("status")
    private String status;
    /**
     * 上级外部编号
     *
     */
    @JsonProperty("out_parent_id")
    private String outParentId;
    /**
     * 限额规则列表
     *
     */
    @JsonProperty("limit_rule_list")
    private List<LimitRuleItem> limitRuleList;
    /**
     * 外部公司主体编号
     *
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
    /**
     * 创建时间（实测补充字段，文档暂未声明）
     *
     */
    @JsonProperty("create_time")
    private String createTime;
    /**
     * 更新时间（实测补充字段，文档暂未声明）
     *
     */
    @JsonProperty("update_time")
    private String updateTime;
    /**
     * 第三方外部编号（实测补充字段，文档暂未声明）
     *
     */
    @JsonProperty("third_out_id")
    private String thirdOutId;
}
