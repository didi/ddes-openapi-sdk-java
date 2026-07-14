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
public class BudgetCenterRecord  {

    /**
     * 滴滴内部项目或部门的ID
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
     * 类型，枚举值 1 部门 2 项目
     * 
     */
    @JsonProperty("type")
    private String type;
    /**
     * 预算周期，枚举值数字 0 不限期 1 自然月 2 自然季度 3 自然年
     * 
     */
    @JsonProperty("budget_cycle")
    private Integer budgetCycle;
    /**
     * 外部成本中心id
     * 
     */
    @JsonProperty("out_budget_id")
    private String outBudgetId;
    /**
     * 总金额，单位元 0 表示不限额度 精确到两位小数
     * 
     */
    @JsonProperty("total_quota")
    private String totalQuota;
    /**
     * 是否限额，枚举值数字 0 不限制 1 限制
     * 
     */
    @JsonProperty("is_limit_quota")
    private Integer isLimitQuota;
    /**
     * 在使用人数
     * 
     */
    @JsonProperty("member_num")
    private Integer memberNum;
    /**
     * 可用金额，单位元 精确到两位小数
     * 
     */
    @JsonProperty("available_quota")
    private String availableQuota;
    /**
     * 冻结金额，单位元 精确到两位小数
     * 
     */
    @JsonProperty("freeze_quota")
    private String freezeQuota;
    /**
     * 主管
     * 
     */
    @JsonProperty("leader_id")
    private String leaderId;
    /**
     * 主管列表
     * 
     */
    @JsonProperty("leader_item_list")
    private List<LeaderItem> leaderItemList;
    /**
     * 上级部门或项目的id
     * 
     */
    @JsonProperty("parent_id")
    private String parentId;
    /**
     * 使用范围，枚举值数字 0 全员可见 1 项目成员可见 2 公司主体可见
     * 
     */
    @JsonProperty("member_used")
    private Integer memberUsed;
    /**
     * 项目开始日期，当类型为项目时，此参数有效 格式：yyyy-MM-dd
     * 
     */
    @JsonProperty("start_date")
    private String startDate;
    /**
     * 项目结束日期，当类型为项目时，此参数有效 格式：yyyy-MM-dd，0为长期有效
     * 
     */
    @JsonProperty("expiry_date")
    private String expiryDate;
    /**
     * 公司主体ID，多个英文逗号分开
     * 
     */
    @JsonProperty("legal_entity_id")
    private String legalEntityId;
    /**
     * 项目拓展字段，仅项目有数据时返回
     *
     */
    @JsonProperty("budget_extra_info")
    private String budgetExtraInfo;
    /**
     * 状态，枚举值数字：1=启用中，2=停用，3=删除
     *
     */
    @JsonProperty("status")
    private String status;
    /**
     * 上级部门/项目外部编码
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
     * 扩展字段列表，is_get_extend_fields=1时返回，仅type=2（项目）时有效
     *
     */
    @JsonProperty("extend_field")
    private List<ExtendFieldItem> extendField;
    /**
     * POI地点列表，is_get_poi=1时返回，仅type=2（项目）时有效
     *
     */
    @JsonProperty("poi_list")
    private List<PoiItem> poiList;
    /**
     * 项目所属公司主体外部编码，仅member_used=2时生效
     *
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
    /**
     * 滴滴侧部门ID，仅member_used=2时生效，多个部门用英文逗号分隔
     *
     */
    @JsonProperty("department_id")
    private String departmentId;
    /**
     * 部门编码，仅member_used=2时生效，多个部门用英文逗号分隔
     *
     */
    @JsonProperty("out_department_id")
    private String outDepartmentId;
    /**
     * 部门范围，枚举值英文：current_only=仅当前部门，include_sub=含下级部门，仅member_used=2时生效
     *
     */
    @JsonProperty("scope")
    private String scope;
}

