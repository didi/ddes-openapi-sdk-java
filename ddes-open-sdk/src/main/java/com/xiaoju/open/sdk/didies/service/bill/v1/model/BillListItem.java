package com.xiaoju.open.sdk.didies.service.bill.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;



@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BillListItem  {

    /**
     * 账单id
     * 
     */
    @JsonProperty("bill_id")
    private String billId;
    /**
     * 父级账单id
     * 
     */
    @JsonProperty("pid")
    private String pid;
    /**
     * 子集账单id集合
     * 
     */
    @JsonProperty("cid")
    private List<String> cid;
    /**
     * 主体id 未拆分账单为公司id，拆分账单为组id（groupId）
     * 
     */
    @JsonProperty("bill_entity_id")
    private String billEntityId;
    /**
     * 主体名称 未拆分账单为公司名称，拆分账单为组名称（groupName）
     * 
     */
    @JsonProperty("bill_entity")
    private String billEntity;
    /**
     * 部门id（不支持多维拆账）
     * 
     */
    @JsonProperty("department_id")
    private String departmentId;
    /**
     * 成本中心id（不支持多维拆账）
     * 
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * 外部成本中心id，根据本接口budget_center_id字段的值关联查询（不支持多维拆账）
     * 
     */
    @JsonProperty("out_budget_id")
    private String outBudgetId;
    /**
     * 账单状态（1：待确认；3：已确认）
     * 
     */
    @JsonProperty("bill_status")
    private Integer billStatus;
    /**
     * 应结算金额
     * 
     */
    @JsonProperty("bill_amount")
    private BigDecimal billAmount;
    /**
     * 消耗金额
     * 
     */
    @JsonProperty("bill_consumption")
    private BigDecimal billConsumption;
    /**
     * 退款金额
     * 
     */
    @JsonProperty("bill_refund")
    private BigDecimal billRefund;
    /**
     * 调整金额
     * 
     */
    @JsonProperty("bill_difference")
    private BigDecimal billDifference;
    /**
     * 拆帐类型 1&#x3D;按出行人部门拆分，2&#x3D;按预订人部门拆分，3&#x3D;按成本中心拆分，4&#x3D;按出行人所属公司拆分，5&#x3D;按预订人所属公司拆分，6&#x3D;按自定义字段拆分，7&#x3D;多维拆帐
     * 
     */
    @JsonProperty("bill_split_type")
    private Integer billSplitType;
    /**
     * 多维拆帐节点类型，支持网约车、代驾、出租车、商旅；1&#x3D;按部门拆分，2&#x3D;按项目拆分，4&#x3D;按公司拆分，6&#x3D;按自定义字段、用车制度、用车权限拆分，8&#x3D; 未知主体注：如果选择支持账单合并，合并的子账单的拆帐类型只取优先级第一个的拆帐类型
     * 
     */
    @JsonProperty("bill_split_group_type")
    private Integer billSplitGroupType;
    /**
     * 账单主体外部id或名称，支持网约车、代驾、出租车、商旅； 单维拆账时，bill_split_type为1~3时，根据部门id或成本中心id的值，来取外部成本中心（out_budget_id）；bill_split_type为4、5时，根据公司id的值，来取外部公司主体编号（out_legal_entity_id），bill_split_type为6时，填写自定义字段的值； 多维拆账单时，bill_split_group_type为1、2时，来取外部成本中心（out_budget_id）；bill_split_group_type为4时，来取外部公司主体编号（out_legal_entity_id）；bill_split_group_type为6时，值为滴滴生成的帐单主体名称，例如 按【自定义01】拆分的帐单主体为AAA则填写【AAA】，按 【自定义01】、【自定义02】拆分的帐单主体为AAA（自定义01）、BBB（自定义02）则填写【AAA&amp;BBB】；bill_split_group_type为8时，值为滴滴生成的帐单主体名称，例如 1级拆分的未知主体名称为“未知主体”，2级拆分的未知主体名称为“xxx部门-未知主体”
     * 
     */
    @JsonProperty("out_bill_split_group_key")
    private String outBillSplitGroupKey;
    /**
     * 账单集合
     * 
     */
    @JsonProperty("sub_bill_summary")
    private List<SubBillSummaryItem> subBillSummary;
}

