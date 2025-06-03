package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.BudgetCenterListItem;
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
public class OrderRecord  {

    /**
     * 订单id
     * 
     */
    @JsonProperty("order_id")
    private String orderId;
    /**
     * 叫车人手机号
     * 
     */
    @JsonProperty("call_phone")
    private String callPhone;
    /**
     * 乘车人手机号
     * 
     */
    @JsonProperty("passenger_phone")
    private String passengerPhone;
    /**
     * 乘车人名字
     * 
     */
    @JsonProperty("passenger_name")
    private String passengerName;
    /**
     * 叫车人员工在滴滴的id
     * 
     */
    @JsonProperty("member_id")
    private String memberId;
    /**
     * 城市id
     * 
     */
    @JsonProperty("city")
    private String city;
    /**
     * 城市名称
     * 
     */
    @JsonProperty("city_name")
    private String cityName;
    /**
     * 出发地名称
     * 
     */
    @JsonProperty("start_name")
    private String startName;
    /**
     * 实际出发地名称
     * 
     */
    @JsonProperty("actual_start_name")
    private String actualStartName;
    /**
     * 目的的名称
     * 
     */
    @JsonProperty("end_name")
    private String endName;
    /**
     * 实际目的地名称
     * 
     */
    @JsonProperty("actual_end_name")
    private String actualEndName;
    /**
     * 出发地纬度
     * 
     */
    @JsonProperty("actual_flat")
    private String actualFlat;
    /**
     * 出发地经度
     * 
     */
    @JsonProperty("actual_flng")
    private String actualFlng;
    /**
     * 目的地纬度
     * 
     */
    @JsonProperty("actual_tlat")
    private String actualTlat;
    /**
     * 目的地经度
     * 
     */
    @JsonProperty("actual_tlng")
    private String actualTlng;
    /**
     * 总里程
     * 
     */
    @JsonProperty("normal_distance")
    private String normalDistance;
    /**
     * 下单时间(订单生成时间)
     * 
     */
    @JsonProperty("create_time")
    private String createTime;
    /**
     * 出发时间(预约单为预约出发时间)
     * 
     */
    @JsonProperty("departure_time")
    private String departureTime;
    /**
     * 接单时间
     * 
     */
    @JsonProperty("strive_time")
    private String striveTime;
    /**
     * 接驾时间
     * 
     */
    @JsonProperty("meet_time")
    private String meetTime;
    /**
     * 开始计价时间
     * 
     */
    @JsonProperty("begin_charge_time")
    private String beginChargeTime;
    /**
     * 结束计价时间
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
     * 用车车型（100舒适型，400六座商务, 200行政级,600普通快车,900优享快车,1000豪华车,1100企业出租车,2000优选出租车，40600企业特价快车） 以上为常用枚举。全量请参考附录展示的枚举。
     * 
     */
    @JsonProperty("require_level")
    private String requireLevel;
    /**
     * 用车车型大类（2-专车、3-快车、5-豪华车）
     * 
     */
    @JsonProperty("use_car_type")
    private String useCarType;
    /**
     * 用车场景， 0 - 市内用车，1 - 接送机，2 - 接送站，3 - 接送汽车站，4 - 接送渡口
     * 
     */
    @JsonProperty("sub_use_car_type")
    private Integer subUseCarType;
    /**
     * 订单状态（2-已支付、3-已退款、4-已取消、7-部分退款）
     * 
     */
    @JsonProperty("status")
    private String status;
    /**
     * 支付类型（0-企业支付、1-个人支付、2-混合支付）
     * 
     */
    @JsonProperty("pay_type")
    private String payType;
    /**
     * 订单来源（0-Web、1-滴滴出行App、2-H5、3-OpenAPI、4-企业APP、5-邀约券、6-SDK、8-Webapp、10-企业app H5）
     * 
     */
    @JsonProperty("order_source")
    private String orderSource;
    /**
     * 枚举值 0自营 1API 2花小猪自营 3鸿鹄三方
     * 
     */
    @JsonProperty("supplier_type")
    private String supplierType;
    /**
     * 计价模型（0-实时计价、1-一口价、2-两口价(一口价变成实时计价)）
     * 
     */
    @JsonProperty("pricing_mode")
    private Integer pricingMode;
    /**
     * 是否为拼车（0-非拼车，1-拼车）
     * 
     */
    @JsonProperty("is_carpool")
    private String isCarpool;
    /**
     * 是否已开票（0-未开票、1-已开票）
     * 
     */
    @JsonProperty("is_invoice")
    private Integer isInvoice;
    /**
     * 预估金额，单位：元
     * 
     */
    @JsonProperty("estimate_price")
    private String estimatePrice;
    /**
     * 订单总金额，单位：元
     * 
     */
    @JsonProperty("total_price")
    private String totalPrice;
    /**
     * 实付金额（总金额-券抵扣金额），单位：元
     * 
     */
    @JsonProperty("actual_price")
    private String actualPrice;
    /**
     * 退款金额，单位：元
     * 
     */
    @JsonProperty("refund_price")
    private String refundPrice;
    /**
     * 公司支付金额，单位：元
     * 
     */
    @JsonProperty("company_pay")
    private String companyPay;
    /**
     * 公司出行卡支付金额，单位：元
     * 
     */
    @JsonProperty("company_card_pay")
    private String companyCardPay;
    /**
     * 个人支付金额，单位：元
     * 
     */
    @JsonProperty("personal_pay")
    private String personalPay;
    /**
     * 公司实付金额，单位：元
     * 
     */
    @JsonProperty("company_real_pay")
    private String companyRealPay;
    /**
     * 公司出行卡实付金额，单位：元
     * 
     */
    @JsonProperty("company_card_real_pay")
    private String companyCardRealPay;
    /**
     * 个人实付金额，单位：元
     * 
     */
    @JsonProperty("personal_real_pay")
    private String personalRealPay;
    /**
     * 公司实际退款金额，单位：元
     * 
     */
    @JsonProperty("company_real_refund")
    private String companyRealRefund;
    /**
     * 公司出行卡实际退款金额，单位：元
     * 
     */
    @JsonProperty("company_card_real_refund")
    private String companyCardRealRefund;
    /**
     * 个人实际退款金额
     * 
     */
    @JsonProperty("personal_real_refund")
    private String personalRealRefund;
    /**
     * 成本中心id
     * 
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * 用车规则id
     * 
     */
    @JsonProperty("use_car_config_id")
    private String useCarConfigId;
    /**
     * 是否为敏感订单（0-不是敏感订单、1-敏感订单）
     * 
     */
    @JsonProperty("is_sensitive")
    private Integer isSensitive;
    /**
     * 命中的敏感规则id
     * 
     */
    @JsonProperty("sensitive_rule_id")
    private Long sensitiveRuleId;
    /**
     * 滴滴内部审批单id
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
    /**
     * 接入方审批单id
     * 
     */
    @JsonProperty("out_approval_id")
    private String outApprovalId;
    /**
     * 下单时用户携带的callback_info
     * 
     */
    @JsonProperty("callback_info")
    private String callbackInfo;
    /**
     * 扩展信息，自定义字段(创建审批单的扩展信息)
     * 
     */
    @JsonProperty("extra_info")
    private String extraInfo;
    /**
     * 申请单基础信息, 拓展信息list,json 串
     * 
     */
    @JsonProperty("extend_field_list")
    private String extendFieldList;
    /**
     * 订单加密信息（可忽略）
     * 
     */
    @JsonProperty("encrypted_info")
    private String encryptedInfo;
    /**
     * 备注信息
     * 
     */
    @JsonProperty("remark")
    private String remark;
    /**
     * 是否为敏感订单(0-否，1-是) need_abnormal_msg&#x3D;1时返回
     * 
     */
    @JsonProperty("is_abnormal")
    private Integer isAbnormal;
    /**
     * 敏感订单员工说明文案；need_abnormal_msg&#x3D;1时返回
     * 
     */
    @JsonProperty("abnormal_explanation")
    private String abnormalExplanation;
    /**
     * 敏感订单类型；need_abnormal_msg&#x3D;1时返回
     * 
     */
    @JsonProperty("abnormal_type")
    private String abnormalType;
    /**
     * 敏感订单解释原因类型；need_abnormal_msg&#x3D;1时返回
     * 
     */
    @JsonProperty("reason_type")
    private String reasonType;
    /**
     * 0 、无，限仅开通敏感订单1.0 或 未开通敏感订单（含1.0+2.0） 1 、标记，（已开通敏感订单2.0，配置标记 or 智能） 3 、解释说明，（已开通敏感订单2.0，配置解释说明 or 智能） 4 、个人支付，（已开通配置敏感订单2.0，配置个人支付 or 智能）need_abnormal_msg为 1时返回
     * 
     */
    @JsonProperty("operation_type")
    private Integer operationType;
    /**
     * 制度名称（need_rule_info &#x3D; 1 时返回）
     * 
     */
    @JsonProperty("rule_name")
    private String ruleName;
    /**
     * 制度ID （need_rule_info &#x3D; 1 时返回
     * 
     */
    @JsonProperty("regulation_id")
    private Long regulationId;
    /**
     * 订单类型(0:实时、1:预约)
     * 
     */
    @JsonProperty("type")
    private String type;
    /**
     * 目的城市ID
     * 
     */
    @JsonProperty("dest_city")
    private String destCity;
    /**
     * 目的城市名称
     * 
     */
    @JsonProperty("dest_city_name")
    private String destCityName;
    /**
     * 部门ID
     * 
     */
    @JsonProperty("group_id")
    private String groupId;
    /**
     * 项目扩展信息的自定义字段；最长不大于 500 字符；(必须为json字符串，json解析后不能为空)；
     * 
     */
    @JsonProperty("budget_extra_info")
    private String budgetExtraInfo;
    /**
     * 叫车人工号
     * 
     */
    @JsonProperty("call_employee_number")
    private String callEmployeeNumber;
    /**
     * 参考budget_center_list对象
     * 
     */
    @JsonProperty("budget_center_list")
    private List<BudgetCenterListItem> budgetCenterList;
    /**
     * 实际出发地址
     * 
     */
    @JsonProperty("actual_start_address")
    private String actualStartAddress;
    /**
     * 实际到达地址
     * 
     */
    @JsonProperty("actual_end_address")
    private String actualEndAddress;
    /**
     * 出发区县 ID
     * 
     */
    @JsonProperty("departure_county_id")
    private Integer departureCountyId;
    /**
     * 出发区县名称
     * 
     */
    @JsonProperty("departure_county_name")
    private String departureCountyName;
    /**
     * 到达区县 ID
     * 
     */
    @JsonProperty("destination_county_id")
    private Integer destinationCountyId;
    /**
     * 到达区县 名称
     * 
     */
    @JsonProperty("destination_county_name")
    private String destinationCountyName;
    /**
     * 参考stopover_points对象
     * 
     */
    @JsonProperty("stopover_points")
    private List<StopoverPoint> stopoverPoints;
}

