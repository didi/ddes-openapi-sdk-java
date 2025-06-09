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
public class NotGenBDOfDaiJiaItem  {

    /**
     * 账期 枚举【本期、往期】
     * 
     */
    @JsonProperty("is_current_term")
    private String isCurrentTerm;
    /**
     * 订单id -企业级内部
     * 
     */
    @JsonProperty("order_id")
    private Long orderId;
    /**
     * 订单id -网约车
     * 
     */
    @JsonProperty("out_order_id")
    private Long outOrderId;
    /**
     * 订单来源 枚举【企业app、H5等】
     * 
     */
    @JsonProperty("order_source")
    private String orderSource;
    /**
     * 订单状态 枚举【全部支付、部分支付、超时取消扣费、部分退款、全部退款】
     * 
     */
    @JsonProperty("status")
    private String status;
    /**
     * 用车类型 枚举【出租车、专车、快车、代驾、豪华车、私车公用、同时呼叫】
     * 
     */
    @JsonProperty("rule")
    private String rule;
    /**
     * 车型等级 枚举【专车-舒适型、专车-豪华型、快车-普通型、豪华车-奔驰S级 等】
     * 
     */
    @JsonProperty("require_level")
    private String requireLevel;
    /**
     * 预定人姓名
     * 
     */
    @JsonProperty("member_name")
    private String memberName;
    /**
     * 预定人工号
     * 
     */
    @JsonProperty("employee_number")
    private String employeeNumber;
    /**
     * 预定人邮箱
     * 
     */
    @JsonProperty("member_mail")
    private String memberMail;
    /**
     * 预定人手机号
     * 
     */
    @JsonProperty("call_phone")
    private String callPhone;
    /**
     * 预定人部门路径 如：\&quot;jrm测试公司2023&gt;同一级\&quot;
     * 
     */
    @JsonProperty("department_name")
    private String departmentName;
    /**
     * 外部成本中心code
     * 
     */
    @JsonProperty("out_budget_id")
    private String outBudgetId;
    /**
     * 预定人员工部门 取member department 字段（旧）
     * 
     */
    @JsonProperty("department")
    private String department;
    /**
     * 预定人所在分公司名称
     * 
     */
    @JsonProperty("branch_name")
    private String branchName;
    /**
     * 乘车人工号
     * 
     */
    @JsonProperty("passenger_member_number")
    private String passengerMemberNumber;
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
     * 支付方式 枚举【\&quot;企业支付\&quot;、\&quot;个人支付\&quot;、\&quot;混合支付\&quot;、\&quot;企业钱包支付\&quot;】 当前订单支付金额的方式，如：企业支付、混合支付（指企业支付和个人支付两种支付方式同时支付一笔订单）
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
     * 代金券(实际使用金额)
     * 
     */
    @JsonProperty("real_voucher_pay")
    private BigDecimal realVoucherPay;
    /**
     * 专车订单金额
     * 
     */
    @JsonProperty("cost")
    private BigDecimal cost;
    /**
     * 服务费金额
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
     * 订单类型 枚举【实时、预约、调账：订单调增、调账：订单调减、调账：主体调增、调账：主体调减、订单计入下一期】
     * 
     */
    @JsonProperty("type")
    private String type;
    /**
     * 订单创建时间
     * 
     */
    @JsonProperty("create_time")
    private String createTime;
    /**
     * 出发时间
     * 
     */
    @JsonProperty("departure_dime")
    private String departureDime;
    /**
     * 接驾时间
     * 
     */
    @JsonProperty("meetTime")
    private String meetTime;
    /**
     * 开始计费时间
     * 
     */
    @JsonProperty("begin_charge_time")
    private String beginChargeTime;
    /**
     * 完单时间
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
     * 城市
     * 
     */
    @JsonProperty("city")
    private String city;
    /**
     * 订单到达城市
     * 
     */
    @JsonProperty("destination_city")
    private String destinationCity;
    /**
     * 实际用车里程
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
     * 目的地地址
     * 
     */
    @JsonProperty("end_address")
    private String endAddress;
    /**
     * 出发地名称
     * 
     */
    @JsonProperty("start_name")
    private String startName;
    /**
     * 目的地名称
     * 
     */
    @JsonProperty("end_name")
    private String endName;
    /**
     * 实际出发地名称
     * 
     */
    @JsonProperty("actual_start_name")
    private String actualStartName;
    /**
     * 实际目的地名称
     * 
     */
    @JsonProperty("actual_end_name")
    private String actualEndName;
    /**
     * 用车规则
     * 
     */
    @JsonProperty("rule_name")
    private String ruleName;
    /**
     * 用车类型 枚举【快车用车、专车用车、专车包车、豪华车送机 等】
     * 
     */
    @JsonProperty("use_car_srv")
    private String useCarSrv;
    /**
     * 成本中心名称 管理员在ES后台差旅管控模块维护的成本中心（部门或项目）名称，同时可以设置员工下单时是否必填此字段
     * 
     */
    @JsonProperty("budget_center_name")
    private String budgetCenterName;
    /**
     * 成本中心ID 管理员在ES后台差旅管控模块维护的成本中心（部门或项目）ID，同时可以设置员工下单时是否必填此字段
     * 
     */
    @JsonProperty("budget_id")
    private String budgetId;
    /**
     * 备注
     * 
     */
    @JsonProperty("remark")
    private String remark;
    /**
     * 补充说明
     * 
     */
    @JsonProperty("order_additional_remark")
    private String orderAdditionalRemark;
    /**
     * 审批备注
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
     * 审批历史-审批时间
     * 
     */
    @JsonProperty("approval_logs")
    private String approvalLogs;
    /**
     * 外部申请单id
     * 
     */
    @JsonProperty("out_approval_id")
    private String outApprovalId;
    /**
     * 升舱类型 枚举【非升舱单、升舱、专车拼车、降舱】
     * 
     */
    @JsonProperty("upgrade_type")
    private String upgradeType;
    /**
     * 是否一口价 枚举【是、否】
     * 
     */
    @JsonProperty("is_fixed_price")
    private String isFixedPrice;
    /**
     * 是否是私车同行 枚举【是、否】
     * 
     */
    @JsonProperty("is_self_drive")
    private String isSelfDrive;
    /**
     * 是否有折扣 枚举【是、否】
     * 
     */
    @JsonProperty("is_discount_order")
    private String isDiscountOrder;
    /**
     * 是否拼车 枚举【是、否】
     * 
     */
    @JsonProperty("is_carpool")
    private String isCarpool;
    /**
     * 是否改派 枚举【是、否】
     * 
     */
    @JsonProperty("is_reassignment")
    private String isReassignment;
    /**
     * 用户自定义字段
     * 
     */
    @JsonProperty("callback_info")
    private String callbackInfo;
    /**
     * 审批单自定义
     * 
     */
    @JsonProperty("approval_extra_info")
    private String approvalExtraInfo;
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
     * 公司id
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
     * 预定人开票子公司id
     * 
     */
    @JsonProperty("legal_entity_id")
    private Long legalEntityId;
    /**
     * 预定人开票子公司名称
     * 
     */
    @JsonProperty("legal_entity_name")
    private String legalEntityName;
    /**
     * 企业钱包实付金额
     * 
     */
    @JsonProperty("company_card_real_pay")
    private BigDecimal companyCardRealPay;
    /**
     * 用车场景 枚举【加班、日常出勤、接送机 等】
     * 
     */
    @JsonProperty("use_car_type_v2")
    private String useCarTypeV2;
    /**
     * 科目费用
     * 
     */
    @JsonProperty("budget_item_name")
    private String budgetItemName;
    /**
     * 是否代叫车 枚举【代客户叫车、员工自己用车】
     * 
     */
    @JsonProperty("use_type")
    private String useType;
    /**
     * 起步价
     * 
     */
    @JsonProperty("start_price")
    private BigDecimal startPrice;
    /**
     * 里程费
     * 
     */
    @JsonProperty("normal_fee")
    private BigDecimal normalFee;
    /**
     * 低速费
     * 
     */
    @JsonProperty("low_speed_fee")
    private BigDecimal lowSpeedFee;
    /**
     * 远途费
     * 
     */
    @JsonProperty("empty_fee")
    private BigDecimal emptyFee;
    /**
     * 夜间费
     * 
     */
    @JsonProperty("night_fee")
    private BigDecimal nightFee;
    /**
     * 有责取消费
     * 
     */
    @JsonProperty("responsible_cancel_fee")
    private BigDecimal responsibleCancelFee;
    /**
     * 基础费
     * 
     */
    @JsonProperty("limit_fee")
    private BigDecimal limitFee;
    /**
     * 基础费补足金额
     * 
     */
    @JsonProperty("limit_pay")
    private BigDecimal limitPay;
    /**
     * 时长费
     * 
     */
    @JsonProperty("normal_time_fee")
    private BigDecimal normalTimeFee;
    /**
     * 动态调价
     * 
     */
    @JsonProperty("dynamic_price")
    private BigDecimal dynamicPrice;
    /**
     * 小费
     * 
     */
    @JsonProperty("tip_fee")
    private BigDecimal tipFee;
    /**
     * 路桥费
     * 
     */
    @JsonProperty("bridge_fee")
    private BigDecimal bridgeFee;
    /**
     * 高速费
     * 
     */
    @JsonProperty("highway_fee")
    private BigDecimal highwayFee;
    /**
     * 停车费
     * 
     */
    @JsonProperty("park_fee")
    private BigDecimal parkFee;
    /**
     * 等待费
     * 
     */
    @JsonProperty("wait_fee")
    private BigDecimal waitFee;
    /**
     * 调度费
     * 
     */
    @JsonProperty("incentive_fee")
    private BigDecimal incentiveFee;
    /**
     * 春节加价费
     * 
     */
    @JsonProperty("red_packet")
    private BigDecimal redPacket;
    /**
     * 其他费用
     * 
     */
    @JsonProperty("other_fee")
    private BigDecimal otherFee;
    /**
     * 预定人id
     * 
     */
    @JsonProperty("member_id")
    private BigDecimal memberId;
    /**
     * 退款金额
     * 
     */
    @JsonProperty("refund_price")
    private BigDecimal refundPrice;
    /**
     * 预定人部门名称（新）
     * 
     */
    @JsonProperty("group_name")
    private String groupName;
    /**
     * 预定人部门id
     * 
     */
    @JsonProperty("group_id")
    private String groupId;
    /**
     * 不含税实付金额 &#x3D;企业实付金额*（1-税率）
     * 
     */
    @JsonProperty("company_real_pre_tax_pay")
    private BigDecimal companyRealPreTaxPay;
    /**
     * 税额 &#x3D;企业实付金额*税率
     * 
     */
    @JsonProperty("company_real_tax_pay")
    private BigDecimal companyRealTaxPay;
    /**
     * 用户首次确认支付时间
     * 
     */
    @JsonProperty("user_pay_time")
    private String userPayTime;
    /**
     * 用户支付类型 枚举【用户主动支付、系统自动支付、系统自动支付后用户主动支付】
     * 
     */
    @JsonProperty("user_pay_type")
    private String userPayType;
    /**
     * 业务线名称 网约车
     * 
     */
    @JsonProperty("settle_type")
    private String settleType;
    /**
     * 所属子账户
     * 
     */
    @JsonProperty("sub_account_name")
    private String subAccountName;
    /**
     * 恒为空 可忽略
     * 
     */
    @JsonProperty("belong_budget_center_name")
    private String belongBudgetCenterName;
    /**
     * 恒为空 可忽略
     * 
     */
    @JsonProperty("belong_out_budget_id")
    private String belongOutBudgetId;
    /**
     * 是否拼成 1:是 0:否
     * 
     */
    @JsonProperty("is_carpool_success")
    private Integer isCarpoolSuccess;
    /**
     * 企业应付金额
     * 
     */
    @JsonProperty("company_pay_able")
    private BigDecimal companyPayAble;
    /**
     * 包车套餐
     * 
     */
    @JsonProperty("service_type")
    private String serviceType;
    /**
     * 行前审批
     * 
     */
    @JsonProperty("before_approval_result")
    private String beforeApprovalResult;
    /**
     * 时段单单惠
     * 
     */
    @JsonProperty("time_slot_discount")
    private BigDecimal timeSlotDiscount;
    /**
     * 附加信息（开票主体信息） 对应用户invoice_info信息
     * 
     */
    @JsonProperty("extend_info")
    private String extendInfo;
    /**
     * 支付账期
     * 
     */
    @JsonProperty("period")
    private String period;
    /**
     * 不含税实付金额 &#x3D;企业实付金额*（1-税率） 同company_real_pre_tax_pay 冗余字段
     * 
     */
    @JsonProperty("excluding_tax_pay_price")
    private BigDecimal excludingTaxPayPrice;
    /**
     * 实付税额 &#x3D;企业实付金额*税率 同company_real_tax_pay 冗余字段
     * 
     */
    @JsonProperty("tax_pay_price")
    private BigDecimal taxPayPrice;
    /**
     * 不含税实退金额 &#x3D;企业实退金额*（1-税率）
     * 
     */
    @JsonProperty("excluding_tax_refund_price")
    private BigDecimal excludingTaxRefundPrice;
    /**
     * 实退税额 &#x3D;企业实退金额*税率
     * 
     */
    @JsonProperty("tax_refund_price")
    private BigDecimal taxRefundPrice;
    /**
     * 是否敏感订单 1:是 0:否
     * 
     */
    @JsonProperty("is_sensitive")
    private Integer isSensitive;
    /**
     * 敏感订单原因
     * 
     */
    @JsonProperty("sensitive_reason")
    private String sensitiveReason;
    /**
     * 企业出行卡实退金额
     * 
     */
    @JsonProperty("company_card_real_refund")
    private BigDecimal companyCardRealRefund;
    /**
     * 取消时间
     * 
     */
    @JsonProperty("cancel_time")
    private String cancelTime;
    /**
     * 跨城费
     * 
     */
    @JsonProperty("cross_city_fee")
    private BigDecimal crossCityFee;
    /**
     * 偏远地区接驾费
     * 
     */
    @JsonProperty("remote_area_fee")
    private BigDecimal remoteAreaFee;
    /**
     * 用车场景细分 枚举【日常用车、加班用车、办公地通勤 等】
     * 
     */
    @JsonProperty("use_car_type_name")
    private String useCarTypeName;
    /**
     * 使用场景 枚举【市内用车、接送机、接送火车站、接送汽车站、接送渡口】
     * 
     */
    @JsonProperty("sub_use_car_srv")
    private String subUseCarSrv;
    /**
     * 综合能耗费
     * 
     */
    @JsonProperty("energy_consume_fee")
    private BigDecimal energyConsumeFee;
    /**
     * 是否异常 枚举【是、否】
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
     * 用车服务 枚举【接送服务、出差市内用车】
     * 
     */
    @JsonProperty("use_car_service")
    private String useCarService;
    /**
     * 用户自定义拓展字段1
     * 
     */
    @JsonProperty("ex_info_01")
    private String exInfo01;
    /**
     * 用户自定义拓展字段2
     * 
     */
    @JsonProperty("ex_info_02")
    private String exInfo02;
    /**
     * 用户自定义拓展字段3
     * 
     */
    @JsonProperty("ex_info_03")
    private String exInfo03;
    /**
     * 用户自定义拓展字段4
     * 
     */
    @JsonProperty("ex_info_04")
    private String exInfo04;
    /**
     * 用户自定义拓展字段 5
     * 
     */
    @JsonProperty("ex_info_05")
    private String exInfo05;
    /**
     * 用户自定义拓展字段 6
     * 
     */
    @JsonProperty("ex_info_06")
    private String exInfo06;
    /**
     * 用户自定义拓展字段 7
     * 
     */
    @JsonProperty("ex_info_07")
    private String exInfo07;
    /**
     * 用户自定义拓展字段 8
     * 
     */
    @JsonProperty("ex_info_08")
    private String exInfo08;
    /**
     * 司机举牌接机服务费
     * 
     */
    @JsonProperty("sps_pick_up_service_fee")
    private BigDecimal spsPickUpServiceFee;
    /**
     * 交易类型 枚举：订单企业支付扣款、订单企业支付后退款、企业支付转个人支付退款、行后审批驳回后退款、个人支付转企业支付扣款、线下企业支付扣款、企业支付转个人支付充值、行后审批驳回后充值
     * 
     */
    @JsonProperty("deduction_type_name")
    private String deductionTypeName;
    /**
     * 结算方式 枚举：银行卡、德付通、预存、返现、授信、试用金、电子账户
     * 
     */
    @JsonProperty("pay_channel")
    private String payChannel;
    /**
     * 常驻城市
     * 
     */
    @JsonProperty("resident_city_names")
    private String residentCityNames;
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
     * 乘车人员工 id
     * 
     */
    @JsonProperty("passenger_member_id")
    private Long passengerMemberId;
    /**
     * 项目自定义
     * 
     */
    @JsonProperty("project_ext_info")
    private String projectExtInfo;
    /**
     * 外部公司主体编号
     * 
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
    /**
     * 途经点地址 如：丰台区 - 大红门街道 1 号；多个途经点用｜连接，丰台区 - 大红门街道 1 号｜朝阳区 - 国贸 5 号楼
     * 
     */
    @JsonProperty("car_travel_Info")
    private String carTravelInfo;
    /**
     * 制度 ID
     * 
     */
    @JsonProperty("institution_id")
    private Long institutionId;
    /**
     * 企业实付（不包含平台使用费）
     * 
     */
    @JsonProperty("excluding_service_fee")
    private BigDecimal excludingServiceFee;
    /**
     * 预估金额
     * 
     */
    @JsonProperty("estimate_price")
    private BigDecimal estimatePrice;
    /**
     * 子账户公司名称
     * 
     */
    @JsonProperty("sub_account_company_name")
    private String subAccountCompanyName;
    /**
     * 用户自定义拓展字段 1 编码
     * 
     */
    @JsonProperty("ex_info_01_code")
    private String exInfo01Code;
    /**
     * 用户自定义拓展字段 2 编码
     * 
     */
    @JsonProperty("ex_info_02_code")
    private String exInfo02Code;
    /**
     * 用户自定义拓展字段 3 编码
     * 
     */
    @JsonProperty("ex_info_03_code")
    private String exInfo03Code;
    /**
     * 用户自定义拓展字段 4 编码
     * 
     */
    @JsonProperty("ex_info_04_code")
    private String exInfo04Code;
    /**
     * 用户自定义拓展字段 5 编码
     * 
     */
    @JsonProperty("ex_info_05_code")
    private String exInfo05Code;
    /**
     * 用户自定义拓展字段 6 编码
     * 
     */
    @JsonProperty("ex_info_06_code")
    private String exInfo06Code;
    /**
     * 用户自定义拓展字段 7 编码
     * 
     */
    @JsonProperty("ex_info_07_code")
    private String exInfo07Code;
    /**
     * 用户自定义拓展字段 8 编码
     * 
     */
    @JsonProperty("ex_info_08_code")
    private String exInfo08Code;
    /**
     * 父制度 ID
     * 
     */
    @JsonProperty("parent_institution_id")
    private Long parentInstitutionId;
}

