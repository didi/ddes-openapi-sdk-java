package com.xiaoju.open.sdk.didies.service.bill.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;



@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionOfWangYCItem  {

    /**
     * 资金流水id
     * 
     */
    @JsonProperty("transaction_id")
    private Long transactionId;
    /**
     * 资金操作类型
     * 
     */
    @JsonProperty("type")
    private String type;
    /**
     * 操作金额 - 支出
     * 
     */
    @JsonProperty("out_money")
    private BigDecimal outMoney;
    /**
     * 操作金额 - 收入
     * 
     */
    @JsonProperty("in_money")
    private BigDecimal inMoney;
    /**
     * 创建时间
     * 
     */
    @JsonProperty("create_time_date")
    private String createTimeDate;
    /**
     * 订单号
     * 
     */
    @JsonProperty("order_id")
    private Long orderId;
    /**
     * 备注
     * 
     */
    @JsonProperty("remark")
    private String remark;
    /**
     * 所属账期
     * 
     */
    @JsonProperty("is_current_term")
    private String isCurrentTerm;
    /**
     * 企业订单号
     * 
     */
    @JsonProperty("company_order_id")
    private Long companyOrderId;
    /**
     * 专快订单号
     * 
     */
    @JsonProperty("out_order_id")
    private Long outOrderId;
    /**
     * 订单来源
     * 
     */
    @JsonProperty("order_source")
    private String orderSource;
    /**
     * 订单状态
     * 
     */
    @JsonProperty("status")
    private String status;
    /**
     * 用车类型
     * 
     */
    @JsonProperty("use_car_type")
    private String useCarType;
    /**
     * 用车类型(明细)
     * 
     */
    @JsonProperty("require_level")
    private String requireLevel;
    /**
     * 下单人姓名
     * 
     */
    @JsonProperty("member_name")
    private String memberName;
    /**
     * 下单人员工ID
     * 
     */
    @JsonProperty("employee_number")
    private String employeeNumber;
    /**
     * 企业邮箱
     * 
     */
    @JsonProperty("member_email")
    private String memberEmail;
    /**
     * 下单人电话
     * 
     */
    @JsonProperty("call_phone")
    private String callPhone;
    /**
     * 所在部门(新)
     * 
     */
    @JsonProperty("department_name")
    private String departmentName;
    /**
     * 所在部门(新)编号
     * 
     */
    @JsonProperty("out_budget_id")
    private String outBudgetId;
    /**
     * 下单人分公司(旧)
     * 
     */
    @JsonProperty("branch_name")
    private String branchName;
    /**
     * 下单人部门(旧)
     * 
     */
    @JsonProperty("department")
    private String department;
    /**
     * 乘车人姓名
     * 
     */
    @JsonProperty("passenger_name")
    private String passengerName;
    /**
     * 乘车人电话
     * 
     */
    @JsonProperty("passenger_phone")
    private String passengerPhone;
    /**
     * 支付方式
     * 
     */
    @JsonProperty("pay_type")
    private String payType;
    /**
     * 订单总金额
     * 
     */
    @JsonProperty("total_price")
    private BigDecimal totalPrice;
    /**
     * 企业实付金额
     * 
     */
    @JsonProperty("company_real_pay")
    private BigDecimal companyRealPay;
    /**
     * 个人实付金额
     * 
     */
    @JsonProperty("personal_real_pay")
    private BigDecimal personalRealPay;
    /**
     * 用券抵扣金额
     * 
     */
    @JsonProperty("voucher_pay")
    private BigDecimal voucherPay;
    /**
     * 车费金额
     * 
     */
    @JsonProperty("cost")
    private BigDecimal cost;
    /**
     * 平台使用费金额
     * 
     */
    @JsonProperty("discount_after_price")
    private BigDecimal discountAfterPrice;
    /**
     * 企业实退金额
     * 
     */
    @JsonProperty("company_real_refund")
    private BigDecimal companyRealRefund;
    /**
     * 订单类型
     * 
     */
    @JsonProperty("order_type")
    private String orderType;
    /**
     * 下单时间
     * 
     */
    @JsonProperty("create_time")
    private String createTime;
    /**
     * 计划用车时间
     * 
     */
    @JsonProperty("departure_time")
    private String departureTime;
    /**
     * 司机接单时间
     * 
     */
    @JsonProperty("meet_time")
    private String meetTime;
    /**
     * 开始计费时间
     * 
     */
    @JsonProperty("begin_charge_time")
    private String beginChargeTime;
    /**
     * 结束计费时间
     * 
     */
    @JsonProperty("finish_time")
    private String finishTime;
    /**
     * 支付时间
     * 
     */
    @JsonProperty("pay_time")
    private String payTime;
    /**
     * 退款时间
     * 
     */
    @JsonProperty("refund_time")
    private String refundTime;
    /**
     * 用车城市
     * 
     */
    @JsonProperty("city")
    private String city;
    /**
     * 到达城市
     * 
     */
    @JsonProperty("destination_city")
    private String destinationCity;
    /**
     * 用车行驶距离
     * 
     */
    @JsonProperty("normal_distance")
    private BigDecimal normalDistance;
    /**
     * 出发地地址
     * 
     */
    @JsonProperty("start_address")
    private String startAddress;
    /**
     * 出发地名称
     * 
     */
    @JsonProperty("start_name")
    private String startName;
    /**
     * 目的地地址
     * 
     */
    @JsonProperty("end_address")
    private String endAddress;
    /**
     * 目的地名称
     * 
     */
    @JsonProperty("end_name")
    private String endName;
    /**
     * 实际出发地
     * 
     */
    @JsonProperty("actual_start_name")
    private String actualStartName;
    /**
     * 实际目的地
     * 
     */
    @JsonProperty("actual_end_name")
    private String actualEndName;
    /**
     * 用车权限
     * 
     */
    @JsonProperty("rule_name")
    private String ruleName;
    /**
     * 用车方式
     * 
     */
    @JsonProperty("use_car_srv")
    private String useCarSrv;
    /**
     * 成本中心名称
     * 
     */
    @JsonProperty("budget_center_name")
    private String budgetCenterName;
    /**
     * 成本中心id
     * 
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * 用车备注
     * 
     */
    @JsonProperty("use_car_remark")
    private String useCarRemark;
    /**
     * 补充说明
     * 
     */
    @JsonProperty("order_additional_remark")
    private String orderAdditionalRemark;
    /**
     * 申请备注
     * 
     */
    @JsonProperty("approval_reason")
    private String approvalReason;
    /**
     * 申请提交时间
     * 
     */
    @JsonProperty("approval_create_time")
    private String approvalCreateTime;
    /**
     * 审批人1|审批时间
     * 
     */
    @JsonProperty("approval_logs")
    private String approvalLogs;
    /**
     * 外部审批单ID
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
    /**
     * 是否自费升舱
     * 
     */
    @JsonProperty("upgrade_type")
    private String upgradeType;
    /**
     * 是否一口价
     * 
     */
    @JsonProperty("is_fixed_price")
    private String isFixedPrice;
    /**
     * 是否自驾同行
     * 
     */
    @JsonProperty("is_self_drive")
    private String isSelfDrive;
    /**
     * 是否折扣订单
     * 
     */
    @JsonProperty("is_discount_order")
    private String isDiscountOrder;
    /**
     * 是否拼车
     * 
     */
    @JsonProperty("is_carpool")
    private String isCarpool;
    /**
     * 是否改派
     * 
     */
    @JsonProperty("is_reassignment")
    private String isReassignment;
    /**
     * API企业自定义
     * 
     */
    @JsonProperty("callback_info")
    private String callbackInfo;
    /**
     * 行后审批结果
     * 
     */
    @JsonProperty("after_approval_result")
    private String afterApprovalResult;
    /**
     * 审批历史
     * 
     */
    @JsonProperty("after_approval_content")
    private String afterApprovalContent;
    /**
     * 审批单自定义
     * 
     */
    @JsonProperty("approval_extra_info")
    private String approvalExtraInfo;
    /**
     * 用车场景细分
     * 
     */
    @JsonProperty("use_car_type_name")
    private String useCarTypeName;
    /**
     * 用车场景
     * 
     */
    @JsonProperty("use_car_type_v2")
    private String useCarTypeV2;
    /**
     * 用户支付类型
     * 
     */
    @JsonProperty("user_pay_type")
    private String userPayType;
    /**
     * 附加字段
     * 
     */
    @JsonProperty("sub_use_car_srv")
    private String subUseCarSrv;
    /**
     * 所属公司主体ID
     * 
     */
    @JsonProperty("company_id")
    private Long companyId;
    /**
     * 公司名称
     * 
     */
    @JsonProperty("company_name")
    private String companyName;
    /**
     * 司机举牌接机服务费
     * 
     */
    @JsonProperty("sps_pick_up_service_fee")
    private BigDecimal spsPickUpServiceFee;
    /**
     * 是否异常
     * 
     */
    @JsonProperty("is_unusual")
    private String isUnusual;
    /**
     * 异常类型
     * 
     */
    @JsonProperty("unusual_type")
    private String unusualType;
    /**
     * 异常说明
     * 
     */
    @JsonProperty("unusual_content")
    private String unusualContent;
    /**
     * 职级
     * 
     */
    @JsonProperty("position_name")
    private String positionName;
    /**
     * 用车制度
     * 
     */
    @JsonProperty("institution_name")
    private String institutionName;
    /**
     * 用车服务类型
     * 
     */
    @JsonProperty("use_car_service")
    private String useCarService;
    /**
     * 拓展字段1
     * 
     */
    @JsonProperty("ex_info_01")
    private String exInfo01;
    /**
     * 拓展字段2
     * 
     */
    @JsonProperty("ex_info_02")
    private String exInfo02;
    /**
     * 拓展字段3
     * 
     */
    @JsonProperty("ex_info_03")
    private String exInfo03;
    /**
     * 所属主体id
     * 
     */
    @JsonProperty("legal_entity_id")
    private Long legalEntityId;
    /**
     * 所属主体名称
     * 
     */
    @JsonProperty("legal_entity_name")
    private String legalEntityName;
    /**
     * 待支付审批历史
     * 
     */
    @JsonProperty("before_approval_content")
    private String beforeApprovalContent;
    /**
     * 原价
     * 
     */
    @JsonProperty("original_price")
    private BigDecimal originalPrice;
    /**
     * 尊享折扣
     * 
     */
    @JsonProperty("one_time_offer_subsidy")
    private BigDecimal oneTimeOfferSubsidy;
    /**
     * 补贴金额
     * 
     */
    @JsonProperty("subsidy_amount")
    private BigDecimal subsidyAmount;
    /**
     * 券抵扣类型
     * 
     */
    @JsonProperty("voucher_deduction_type_name")
    private String voucherDeductionTypeName;
    /**
     * 常驻城市
     * 
     */
    @JsonProperty("resident_city_names")
    private String residentCityNames;
    /**
     * 乘车人工号
     * 
     */
    @JsonProperty("passenger_member_number")
    private String passengerMemberNumber;
    /**
     * 乘车人id
     * 
     */
    @JsonProperty("passenger_member_id")
    private String passengerMemberId;
}

