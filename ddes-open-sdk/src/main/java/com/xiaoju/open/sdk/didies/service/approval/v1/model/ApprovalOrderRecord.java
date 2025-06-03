package com.xiaoju.open.sdk.didies.service.approval.v1.model;

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

import java.math.BigDecimal;



@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalOrderRecord  {

    /**
     * 订单ID
     * 
     */
    @JsonProperty("order_id")
    private String orderId;
    /**
     * 审批单ID
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
    /**
     * 企业主内部审批单ID
     * 
     */
    @JsonProperty("out_approval_id")
    private String outApprovalId;
    /**
     * 规则ID
     * 
     */
    @JsonProperty("rule_id")
    private String ruleId;
    /**
     * 制度ID
     * 
     */
    @JsonProperty("regulation_id")
    private String regulationId;
    /**
     * 因公出行场景（0-个人用车、1-商务出行、2-差旅、3-加班、4-办公地点通勤、91-代叫车、92-接送机）
     * 
     */
    @JsonProperty("scene_type")
    private String sceneType;
    /**
     * 订单创建时间，如：1675602713
     * 
     */
    @JsonProperty("order_create_time")
    private String orderCreateTime;
    /**
     * 订单开始计费时间，如：1675582413
     * 
     */
    @JsonProperty("begin_charge_time")
    private String beginChargeTime;
    /**
     * 订单结束计费时间，如：1675583857
     * 
     */
    @JsonProperty("finish_time")
    private String finishTime;
    /**
     * 预约上车时间，如：1675582103
     * 
     */
    @JsonProperty("departure_time")
    private String departureTime;
    /**
     * 用车方式（2:专车，3:快车）
     * 
     */
    @JsonProperty("use_car_type")
    private Integer useCarType;
    /**
     * 车型，如（100舒适型，400六座商务, 200行政级,600普通快车,900优享快车,1000豪华车,1100企业出租车,2000优选出租车）
     * 
     */
    @JsonProperty("car_level")
    private Integer carLevel;
    /**
     * 出发城市名称
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
     * 目的地名称
     * 
     */
    @JsonProperty("end_name")
    private String endName;
    /**
     * 实际出发地（司机点击开始的位置）
     * 
     */
    @JsonProperty("actual_start_name")
    private String actualStartName;
    /**
     * 实际目的地（司机点击结束的位置）
     * 
     */
    @JsonProperty("actual_end_name")
    private String actualEndName;
    /**
     * 实际出发地纬度（司机点击开始的位置）
     * 
     */
    @JsonProperty("actual_flat")
    private String actualFlat;
    /**
     * 实际出发地经度（司机点击开始的位置）
     * 
     */
    @JsonProperty("actual_flng")
    private String actualFlng;
    /**
     * 实际目的地纬度（司机点击结束的位置）
     * 
     */
    @JsonProperty("actual_tlat")
    private String actualTlat;
    /**
     * 实际目的地经度（司机点击结束的位置）
     * 
     */
    @JsonProperty("actual_tlng")
    private String actualTlng;
    /**
     * 支付时间
     * 
     */
    @JsonProperty("pay_time")
    private String payTime;
    /**
     * 订单状态（1-发单失败、2-已支付、3-已退款、4-已取消、5-待支付、6-部分支付、7-部分退款）
     * 
     */
    @JsonProperty("order_status")
    private Integer orderStatus;
    /**
     * 支付方式（0-企业支付、1-个人支付需报销、2-混合支付（企业和个人各支付部分））
     * 
     */
    @JsonProperty("pay_type")
    private Integer payType;
    /**
     * 开票状态（0-未开、1-开过 ）
     * 
     */
    @JsonProperty("is_invoice")
    private Integer isInvoice;
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
     * 订单总金额
     * 
     */
    @JsonProperty("total_price")
    private String totalPrice;
    /**
     * 订单实付金额（总金额-券折扣金额）
     * 
     */
    @JsonProperty("actual_price")
    private BigDecimal actualPrice;
    /**
     * 订单总退款金额（企业支付退款+个人支付退款）
     * 
     */
    @JsonProperty("refund_price")
    private String refundPrice;
    /**
     * 企业支付应付金额
     * 
     */
    @JsonProperty("company_pay")
    private String companyPay;
    /**
     * 个人支付应付金额
     * 
     */
    @JsonProperty("personal_pay")
    private String personalPay;
    /**
     * 企业支付实付金额
     * 
     */
    @JsonProperty("company_real_pay")
    private String companyRealPay;
    /**
     * 个人支付实付金额
     * 
     */
    @JsonProperty("personal_real_pay")
    private String personalRealPay;
    /**
     * 企业支付退款金额
     * 
     */
    @JsonProperty("company_refund")
    private String companyRefund;
    /**
     * 个人支付退款金额
     * 
     */
    @JsonProperty("personal_refund")
    private String personalRefund;
    /**
     * 成本中心ID
     * 
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * 扩展信息，自定义字段
     * 
     */
    @JsonProperty("extra_info")
    private String extraInfo;
    /**
     * 场景ID，101 申请单模式差旅；102 申请用车；103 自驾同行
     * 
     */
    @JsonProperty("scene_id")
    private String sceneId;
    /**
     * 特惠快车原价金额 单位元
     * 
     */
    @JsonProperty("pre_total_fee")
    private String preTotalFee;
    /**
     * 特惠快车尊享折扣金额 单位元
     * 
     */
    @JsonProperty("fixed_discount_fee")
    private String fixedDiscountFee;
    /**
     * 补贴金额 单位元 在使用企业券时，补贴金额 &#x3D; 尊享折扣 + 券金额，其他情况直接等于尊享折扣
     * 
     */
    @JsonProperty("discount_fee")
    private String discountFee;
    /**
     * 多成本中心
     * 
     */
    @JsonProperty("budget_center_list")
    private List<BudgetCenterListItem> budgetCenterList;
}

