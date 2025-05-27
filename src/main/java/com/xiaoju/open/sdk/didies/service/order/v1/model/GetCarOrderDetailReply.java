package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.BudgetCenterListItem;
import com.xiaoju.open.sdk.didies.service.order.v1.model.PriceInfo;
import com.xiaoju.open.sdk.didies.service.order.v1.model.StopoverPoint;
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
public class GetCarOrderDetailReply  {

    /**
     * 订单的唯一标识
     * 
     */
    @JsonProperty("order_id")
    private String orderId;
    /**
     * 所属公司的唯一标识
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 叫车人的手机号码
     * 
     */
    @JsonProperty("call_phone")
    private String callPhone;
    /**
     * 叫车人的员工编号
     * 
     */
    @JsonProperty("call_employee_number")
    private String callEmployeeNumber;
    /**
     * 乘车人的手机号码
     * 
     */
    @JsonProperty("passenger_phone")
    private String passengerPhone;
    /**
     * 乘车人的姓名
     * 
     */
    @JsonProperty("passenger_name")
    private String passengerName;
    /**
     * 出发地所在城市的标识
     * 
     */
    @JsonProperty("city")
    private String city;
    /**
     * 出发地所在城市的名称
     * 
     */
    @JsonProperty("city_name")
    private String cityName;
    /**
     * 出发地的名称
     * 
     */
    @JsonProperty("start_name")
    private String startName;
    /**
     * 出发地的纬度
     * 
     */
    @JsonProperty("flat")
    private String flat;
    /**
     * 出发地的经度
     * 
     */
    @JsonProperty("flng")
    private String flng;
    /**
     * 司机实际开始行程的地点名称
     * 
     */
    @JsonProperty("actual_start_name")
    private String actualStartName;
    /**
     * 司机实际开始行程的地点地址
     * 
     */
    @JsonProperty("actual_start_address")
    private String actualStartAddress;
    /**
     * 司机实际结束行程的地点地址
     * 
     */
    @JsonProperty("actual_end_address")
    private String actualEndAddress;
    /**
     * 出发地所在区县的标识
     * 
     */
    @JsonProperty("departure_county_id")
    private Integer departureCountyId;
    /**
     * 出发地所在区县的名称
     * 
     */
    @JsonProperty("departure_county_name")
    private String departureCountyName;
    /**
     * 目的地所在区县的标识
     * 
     */
    @JsonProperty("destination_county_id")
    private Integer destinationCountyId;
    /**
     * 目的地所在区县的名称
     * 
     */
    @JsonProperty("destination_county_name")
    private String destinationCountyName;
    /**
     * 司机实际开始行程地点的纬度
     * 
     */
    @JsonProperty("actual_flat")
    private String actualFlat;
    /**
     * 司机实际开始行程地点的经度
     * 
     */
    @JsonProperty("actual_flng")
    private String actualFlng;
    /**
     * 目的地所在城市的标识
     * 
     */
    @JsonProperty("dest_city")
    private Integer destCity;
    /**
     * 目的地所在城市的名称
     * 
     */
    @JsonProperty("dest_city_name")
    private String destCityName;
    /**
     * 目的地的名称
     * 
     */
    @JsonProperty("end_name")
    private String endName;
    /**
     * 目的地的纬度
     * 
     */
    @JsonProperty("tlat")
    private String tlat;
    /**
     * 目的地的经度
     * 
     */
    @JsonProperty("tlng")
    private String tlng;
    /**
     * 司机实际结束行程的地点名称
     * 
     */
    @JsonProperty("actual_end_name")
    private String actualEndName;
    /**
     * 司机实际结束行程地点的纬度
     * 
     */
    @JsonProperty("actual_tlat")
    private String actualTlat;
    /**
     * 司机实际结束行程地点的经度
     * 
     */
    @JsonProperty("actual_tlng")
    private String actualTlng;
    /**
     * 订单创建的时间，格式可能为标准时间格式
     * 
     */
    @JsonProperty("create_time")
    private String createTime;
    /**
     * 出发时间，预约单为预约出发时间
     * 
     */
    @JsonProperty("departure_time")
    private String departureTime;
    /**
     * 接单的时间
     * 
     */
    @JsonProperty("strive_time")
    private String striveTime;
    /**
     * 接驾的时间
     * 
     */
    @JsonProperty("meet_time")
    private String meetTime;
    /**
     * 开始计价的时间
     * 
     */
    @JsonProperty("begin_charge_time")
    private String beginChargeTime;
    /**
     * 结束计价的时间
     * 
     */
    @JsonProperty("finish_time")
    private String finishTime;
    /**
     * 支付的时间
     * 
     */
    @JsonProperty("pay_time")
    private String payTime;
    /**
     * 退款的时间
     * 
     */
    @JsonProperty("refund_time")
    private String refundTime;
    /**
     * 用车的车型，如100-专车舒适型等
     * 
     */
    @JsonProperty("require_level")
    private String requireLevel;
    /**
     * 计价的类型，如101-出租车等
     * 
     */
    @JsonProperty("use_car_srv")
    private String useCarSrv;
    /**
     * 用车车型的大类，如2-专车等
     * 
     */
    @JsonProperty("use_car_type")
    private String useCarType;
    /**
     * 用车的场景，如0 - 市内用车等
     * 
     */
    @JsonProperty("sub_use_car_type")
    private Integer subUseCarType;
    /**
     * 订单的状态，如0-行程中、1-下单失败等
     * 
     */
    @JsonProperty("status")
    private String status;
    /**
     * 订单的类型，如0-实时、1-预约
     * 
     */
    @JsonProperty("type")
    private String type;
    /**
     * 支付的类型，如0-企业支付等
     * 
     */
    @JsonProperty("pay_type")
    private String payType;
    /**
     * 订单的来源，如0-Web等
     * 
     */
    @JsonProperty("order_source")
    private String orderSource;
    /**
     * 运力的来源，如0自营等
     * 
     */
    @JsonProperty("supplier_type")
    private Integer supplierType;
    /**
     * 计价的模型，如0-实时计价等
     * 
     */
    @JsonProperty("pricing_mode")
    private Integer pricingMode;
    /**
     * 是否为拼车，0-非拼车，1-拼车
     * 
     */
    @JsonProperty("is_carpool")
    private String isCarpool;
    /**
     * 是否已开票，0-未开票，1-已开票
     * 
     */
    @JsonProperty("is_invoice")
    private Integer isInvoice;
    /**
     * 订单的预估金额，单位为元
     * 
     */
    @JsonProperty("estimate_price")
    private String estimatePrice;
    /**
     * 是否为个人垫付订单，0-非个人垫付订单，1-个人订单
     * 
     */
    @JsonProperty("reimbursement_flag")
    private Integer reimbursementFlag;
    /**
     * 订单的总金额，单位为元，包含呼返立减，不包含尊享折扣
     * 
     */
    @JsonProperty("total_price")
    private String totalPrice;
    /**
     * 订单的实付金额，单位为元，总金额减去券抵扣金额
     * 
     */
    @JsonProperty("actual_price")
    private String actualPrice;
    /**
     * 券抵扣的金额，单位为元
     * 
     */
    @JsonProperty("voucher_pay")
    private String voucherPay;
    /**
     * 公司支付的金额，单位为元
     * 
     */
    @JsonProperty("company_pay")
    private String companyPay;
    /**
     * 公司出行卡支付的金额，单位为元
     * 
     */
    @JsonProperty("company_card_pay")
    private String companyCardPay;
    /**
     * 个人支付的金额，单位为元
     * 
     */
    @JsonProperty("personal_pay")
    private String personalPay;
    /**
     * 公司实际支付的金额，单位为元
     * 
     */
    @JsonProperty("company_real_pay")
    private String companyRealPay;
    /**
     * 公司出行卡实际支付的金额，单位为元
     * 
     */
    @JsonProperty("company_card_real_pay")
    private String companyCardRealPay;
    /**
     * 个人实际支付的金额，单位为元
     * 
     */
    @JsonProperty("personal_real_pay")
    private String personalRealPay;
    /**
     * 公司实际退款的金额，单位为元
     * 
     */
    @JsonProperty("company_real_refund")
    private String companyRealRefund;
    /**
     * 公司出行卡实际退款的金额，单位为元
     * 
     */
    @JsonProperty("company_card_real_refund")
    private String companyCardRealRefund;
    /**
     * 个人实际退款的金额，单位为元
     * 
     */
    @JsonProperty("personal_real_refund")
    private String personalRealRefund;
    /**
     * 费用的明细，返回值大于0的订单金额信息
     * 
     */
    @JsonProperty("price")
    private List<PriceInfo> price;
    /**
     * 订单的总里程，单位为千米
     * 
     */
    @JsonProperty("normal_distance")
    private String normalDistance;
    /**
     * 订单的预估里程，单位为千米
     * 
     */
    @JsonProperty("estimated_distance")
    private String estimatedDistance;
    /**
     * 成本中心的标识，可对应budget_center_list中的字段
     * 
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * 用车规则的标识
     * 
     */
    @JsonProperty("use_car_config_id")
    private String useCarConfigId;
    /**
     * 是否为敏感订单，0-不是，1-是，1.0方案，新用户可忽略
     * 
     */
    @JsonProperty("is_sensitive")
    private Integer isSensitive;
    /**
     * 敏感订单的解释，1.0方案，新用户可忽略
     * 
     */
    @JsonProperty("sensitive_explanation")
    private String sensitiveExplanation;
    /**
     * 命中的敏感规则的标识，1.0方案，新用户可忽略
     * 
     */
    @JsonProperty("sensitive_rule_id")
    private String sensitiveRuleId;
    /**
     * 敏感订单的原因，多个原因用英文分号隔开，1.0方案，新用户可忽略
     * 
     */
    @JsonProperty("sensitive_reason")
    private String sensitiveReason;
    /**
     * 滴滴内部审批单的标识
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
    /**
     * 接入方审批单的标识
     * 
     */
    @JsonProperty("out_approval_id")
    private String outApprovalId;
    /**
     * 下单时用户携带的额外信息
     * 
     */
    @JsonProperty("callback_info")
    private String callbackInfo;
    /**
     * 订单的扩展信息，如创建审批单的扩展信息
     * 
     */
    @JsonProperty("extra_info")
    private String extraInfo;
    /**
     * 订单的加密信息，可忽略
     * 
     */
    @JsonProperty("encrypted_info")
    private String encryptedInfo;
    /**
     * 部门的标识
     * 
     */
    @JsonProperty("group_id")
    private String groupId;
    /**
     * 是否为敏感订单，0-否，1-是
     * 
     */
    @JsonProperty("is_abnormal")
    private Integer isAbnormal;
    /**
     * 敏感订单员工的说明文案，need_abnormal_msg为1时返回
     * 
     */
    @JsonProperty("abnormal_explanation")
    private String abnormalExplanation;
    /**
     * 敏感订单的类型，need_abnormal_msg为1时返回
     * 
     */
    @JsonProperty("abnormal_type")
    private String abnormalType;
    /**
     * 敏感订单解释的原因类型，need_abnormal_msg为1时返回
     * 
     */
    @JsonProperty("reason_type")
    private String reasonType;
    /**
     * 敏感订单的干预方式，如0 - 无等，need_abnormal_msg为1时返回
     * 
     */
    @JsonProperty("operation_type")
    private Integer operationType;
    /**
     * 员工的标识
     * 
     */
    @JsonProperty("member_id")
    private Long memberId;
    /**
     * 制度的名称，need_rule_info为1时返回
     * 
     */
    @JsonProperty("rule_name")
    private String ruleName;
    /**
     * 制度的标识，need_rule_info为1时返回
     * 
     */
    @JsonProperty("regulation_id")
    private Long regulationId;
    /**
     * 申请单的基础信息，拓展信息列表
     * 
     */
    @JsonProperty("extend_field_list")
    private String extendFieldList;
    /**
     * 升舱的类型，如0非升舱等
     * 
     */
    @JsonProperty("upgrade_type")
    private Integer upgradeType;
    /**
     * 是否为特快，0 非特快，1 特快
     * 
     */
    @JsonProperty("level_type")
    private Integer levelType;
    /**
     * 快车的计价类型，如4 拼车等
     * 
     */
    @JsonProperty("combo_type")
    private Integer comboType;
    /**
     * 修改目的地的次数
     * 
     */
    @JsonProperty("change_end_count")
    private Integer changeEndCount;
    /**
     * 用车的备注信息
     * 
     */
    @JsonProperty("remark")
    private String remark;
    /**
     * 折后的车费与折后的服务费之和，单位为元
     * 
     */
    @JsonProperty("total_cost")
    private String totalCost;
    /**
     * 退款的金额，单位为元
     * 
     */
    @JsonProperty("refund_price")
    private String refundPrice;
    /**
     * 特惠快车的原价金额，单位为元，包含尊享折扣+呼返立减
     * 
     */
    @JsonProperty("pre_total_fee")
    private String preTotalFee;
    /**
     * 特惠快车尊享折扣金额，单位为元，尊享折扣金额+呼返立减金额
     * 
     */
    @JsonProperty("fixed_discount_fee")
    private String fixedDiscountFee;
    /**
     * 补贴金额，单位为元，在使用企业券时，补贴金额 &#x3D; 尊享折扣 + 券金额，其他情况直接等于尊享折扣，企业节省金额。
     * 
     */
    @JsonProperty("discount_fee")
    private String discountFee;
    /**
     * 尊享企业立减，单位为元，尊享折扣+呼返立减&#x3D;尊享企业支付+尊享个人支付
     * 
     */
    @JsonProperty("cut_company_cost")
    private String cutCompanyCost;
    /**
     * 尊享个人立减，单位为元
     * 
     */
    @JsonProperty("cut_personal_cost")
    private String cutPersonalCost;
    /**
     * 多成本中心信息，参考BudgetCenter对象
     * 
     */
    @JsonProperty("budget_center_list")
    private List<BudgetCenterListItem> budgetCenterList;
    /**
     * 途径点信息，参考StopoverPoint对象
     * 
     */
    @JsonProperty("stopover_points")
    private List<StopoverPoint> stopoverPoints;
}

