package com.xiaoju.open.sdk.didies.service.bill.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaoju.open.sdk.didies.core.model.BaseReq;
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
public class BillConfirmRequest extends BaseReq  {

    /**
     * 企业ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 账单id
     * 
     */
    @JsonProperty("bill_id")
    private String billId;
    /**
     * 业务线（0：网约车；1：商旅）默认是0，不传默认网约车
     * 
     */
    @JsonProperty("business_type")
    private Integer businessType;
    /**
     * 账单周期(当不传bill_id时，payment_period和department_id必须填写 或 payment_period和budget_center_id必须填写 或 payment_period和bill_split_type和bill_split_group_key必须填写) 示例：\&quot;2020-01-01~2020-01-31\&quot;
     * 
     */
    @JsonProperty("payment_period")
    private String paymentPeriod;
    /**
     * 部门id(当按账单周期 + 部门查询时，department_id必须填写) 仅支持网约车
     * 
     */
    @JsonProperty("department_id")
    private String departmentId;
    /**
     * 成本中心id(当按账单周期 + 成本中心查询时，budget_center_id必须填写) 仅支持网约车
     * 
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * 拆分账单维度（仅支持 国内机票、国内酒店、火车票、国际机票、国际酒店、增值手工单）1&#x3D;按出行人部门拆分，2&#x3D;按预订人部门拆分，3&#x3D;按成本中心拆分，4&#x3D;按出行人所属公司拆分，5&#x3D;按预订人所属公司拆分，6&#x3D;按自定义字段拆分 注：bill_split_type和bill_split_group_key必须结合使用，且当传bill_id时按照拆分维度查不生效7&#x3D;多维拆帐 注：bill_split_type、bill_split_group_type和bill_split_group_key这3个字段必须结合使用，且当传bill_id时按照拆分维度查不生效
     * 
     */
    @JsonProperty("bill_split_type")
    private Integer billSplitType;
    /**
     * 多维拆帐节点类型（仅支持 国内机票、国内酒店、火车票、国际机票、国际酒店、增值手工单），1&#x3D;按部门拆分，2&#x3D;按项目拆分，4&#x3D;按公司拆分，6&#x3D;按自定义字段、用车制度、用车权限拆分，8&#x3D; 未知主体
     * 
     */
    @JsonProperty("bill_split_group_type")
    private Integer billSplitGroupType;
    /**
     * 拆分账单主体id或名称（仅支持 机票、酒店、火车票、国际机票、国际酒店、增值手工单） 1.单维拆账时，bill_split_type为1~5时，拆分账单主体id或名称请填写id；bill_split_type为6时，请填写自定义字段名称 注：bill_split_type和bill_split_group_key必须结合使用，且当传bill_id时按照拆分维度查不生效； 2.多维拆帐时，bill_split_group_type为1、2、4时，填写对应的id；bill_split_group_type为6时，值为滴滴生成的帐单主体名称；bill_split_group_type为8时，本字段为空。
     * 
     */
    @JsonProperty("bill_split_group_key")
    private String billSplitGroupKey;
}

