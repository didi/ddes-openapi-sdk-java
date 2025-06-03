package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.core.model.BaseReq;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class GetOrderRequest extends BaseReq  {

    /**
     * endDate
     * 
     */
    @JsonProperty("end_date")
    private String endDate;
    /**
     * callPhone
     * 
     */
    @JsonProperty("call_phone")
    private String callPhone;
    /**
     * companyId
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * offset
     * 
     */
    @JsonProperty("offset")
    private Integer offset;
    /**
     * needProjectInfo
     * 
     */
    @JsonProperty("need_project_info")
    private Integer needProjectInfo;
    /**
     * endTime
     * 
     */
    @JsonProperty("end_time")
    private String endTime;
    /**
     * length
     * 
     */
    @JsonProperty("length")
    private Integer length;
    /**
     * budgetCenterId
     * 
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * useCarType
     * 
     */
    @JsonProperty("use_car_type")
    private Integer useCarType;
    /**
     * needCallEmployeeNumber
     * 
     */
    @JsonProperty("need_call_employee_number")
    private Integer needCallEmployeeNumber;
    /**
     * startTime
     * 
     */
    @JsonProperty("start_time")
    private String startTime;
    /**
     * outBudgetId
     * 
     */
    @JsonProperty("out_budget_id")
    private String outBudgetId;
    /**
     * phone
     * 
     */
    @JsonProperty("phone")
    private String phone;
    /**
     * needAbnormalMsg
     * 
     */
    @JsonProperty("need_abnormal_msg")
    private Integer needAbnormalMsg;
    /**
     * name
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * payType
     * 
     */
    @JsonProperty("pay_type")
    private Integer payType;
    /**
     * isInvoice
     * 
     */
    @JsonProperty("is_invoice")
    private Integer isInvoice;
    /**
     * needApprovalId
     * 
     */
    @JsonProperty("need_approval_id")
    private Integer needApprovalId;
    /**
     * needRuleInfo
     * 
     */
    @JsonProperty("need_rule_info")
    private Integer needRuleInfo;
    /**
     * startDate
     * 
     */
    @JsonProperty("start_date")
    private String startDate;
}

