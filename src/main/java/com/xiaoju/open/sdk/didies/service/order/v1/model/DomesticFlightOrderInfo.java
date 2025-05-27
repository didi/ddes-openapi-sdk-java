package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.BudgetCenterListItem;
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
public class DomesticFlightOrderInfo  {

    /**
     * 订单号，主单号
     * 
     */
    @JsonProperty("order_id")
    private String orderId;
    /**
     * 企业名称，在滴滴注册的企业名称
     * 
     */
    @JsonProperty("company_name")
    private String companyName;
    /**
     * 企业ID，滴滴企业ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 预订人姓名，下单人
     * 
     */
    @JsonProperty("booker_name")
    private String bookerName;
    /**
     * 预订人员工工号，客户维护或者外部对接的数据
     * 
     */
    @JsonProperty("booker_employee_id")
    private String bookerEmployeeId;
    /**
     * 预订人滴滴ID，内部员工
     * 
     */
    @JsonProperty("booker_member_id")
    private String bookerMemberId;
    /**
     * 预订人手机号，脱敏展示
     * 
     */
    @JsonProperty("booker_phone")
    private String bookerPhone;
    /**
     * 预订人部门名称，部门链路
     * 
     */
    @JsonProperty("department_name")
    private String departmentName;
    /**
     * 预订人部门ID，滴滴末级部门ID
     * 
     */
    @JsonProperty("department_id")
    private String departmentId;
    /**
     * 制度名称，滴滴制度名称
     * 
     */
    @JsonProperty("institution_name")
    private String institutionName;
    /**
     * 制度ID
     * 
     */
    @JsonProperty("institution_id")
    private String institutionId;
    /**
     * 差旅申请单ID，滴滴申请单ID
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
    /**
     * 外部申请单ID，系统对接外部的申请单号
     * 
     */
    @JsonProperty("out_approval_id")
    private String outApprovalId;
    /**
     * 航程类别，枚举数字： 1 单程, 2 往返
     * 
     */
    @JsonProperty("flight_way")
    private Integer flightWay;
    /**
     * 订单状态，枚举英文code：Tobepaid 待支付；Waitforapproval 待审批；Ticketing 待出票；Ticketed 已出票；Accountingforchangefee 改签待核算；Changing 改签中；refunding 退票中；Completed 已完成；Refunded 已退票；Partialrefund 部分退票；Closed 订单关闭；Cancelled 已取消；Unknow 未知
     * 
     */
    @JsonProperty("order_status")
    private String orderStatus;
    /**
     * 订单创建时间，格式：yyyy-MM-dd HH:mm:ss
     * 
     */
    @JsonProperty("create_time")
    private String createTime;
    /**
     * 支付状态，枚举数字：0 未支付 1 已支付
     * 
     */
    @JsonProperty("is_pay")
    private Integer isPay;
    /**
     * 订单支付类型，枚举数字：0 企业支付 1 个人支付 2 混合支付
     * 
     */
    @JsonProperty("pay_type")
    private Integer payType;
    /**
     * 取消订单时间，格式：yyyy-MM-dd HH:mm:ss
     * 
     */
    @JsonProperty("cancel_time")
    private String cancelTime;
    /**
     * 订单更新时间，格式：yyyy-MM-dd HH:mm:ss 查询条件
     * 
     */
    @JsonProperty("change_time")
    private String changeTime;
    /**
     * 申请单基础信息
     * 
     */
    @JsonProperty("extra_info")
    private String extraInfo;
    /**
     * 多成本中心，参考budget_center_list对象
     * 
     */
    @JsonProperty("budget_center_list")
    private List<BudgetCenterListItem> budgetCenterList;
}

