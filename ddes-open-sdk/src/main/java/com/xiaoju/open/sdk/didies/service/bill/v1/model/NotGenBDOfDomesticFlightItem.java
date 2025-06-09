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
public class NotGenBDOfDomesticFlightItem  {

    /**
     * 原票id
     * 
     */
    @JsonProperty("origin_ticket_id")
    private String originTicketId;
    /**
     * 改签票id
     * 
     */
    @JsonProperty("ticket_id_text")
    private String ticketIdText;
    /**
     * 乘机人姓名
     * 
     */
    @JsonProperty("passenger_member_name")
    private String passengerMemberName;
    /**
     * 乘机人工号
     * 
     */
    @JsonProperty("passenger_member_number")
    private String passengerMemberNumber;
    /**
     * 乘机人部门
     * 
     */
    @JsonProperty("passenger_dep_name")
    private String passengerDepName;
    /**
     * 乘机人所在部门 示例：\&quot;机票测试专用751&gt;优秀部门\&quot;
     * 
     */
    @JsonProperty("passenger_parent_path_dep_name")
    private String passengerParentPathDepName;
    /**
     * 乘机人部门编号
     * 
     */
    @JsonProperty("passenger_dep_code")
    private String passengerDepCode;
    /**
     * 完单时间 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-06-16 15:58:49\&quot;
     * 
     */
    @JsonProperty("settle_time")
    private String settleTime;
    /**
     * 乘机人员工ID
     * 
     */
    @JsonProperty("member_id")
    private String memberId;
    /**
     * 订单补偿类型 枚举【0：非补偿单，1：补偿单】 该字段滴滴内部使用，外部可不用关注该字段
     * 
     */
    @JsonProperty("order_fix_type")
    private Integer orderFixType;
    /**
     * 补偿单的结算时间 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-05-27 22:00:47\&quot;
     * 
     */
    @JsonProperty("order_fix_settle_time")
    private String orderFixSettleTime;
    /**
     * 乘机人姓名（冗余字段）
     * 
     */
    @JsonProperty("passenger_name")
    private String passengerName;
    /**
     * 乘机人部门（冗余字段）
     * 
     */
    @JsonProperty("department")
    private String department;
    /**
     * 成本中心名称
     * 
     */
    @JsonProperty("budget_center_name")
    private String budgetCenterName;
    /**
     * 所在成本中心 示例：\&quot;机票测试专用751&gt;高优项目\&quot;
     * 
     */
    @JsonProperty("budget_center_parent_path_name")
    private String budgetCenterParentPathName;
    /**
     * 成本中心ID
     * 
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * 预订人姓名
     * 
     */
    @JsonProperty("booking_member_name")
    private String bookingMemberName;
    /**
     * 预订人工号
     * 
     */
    @JsonProperty("booking_member_number")
    private String bookingMemberNumber;
    /**
     * 预订人部门
     * 
     */
    @JsonProperty("booking_dep_name")
    private String bookingDepName;
    /**
     * 预订人所在部门 示例：\&quot;机票测试专用751&gt;优秀部门\&quot;
     * 
     */
    @JsonProperty("booking_parent_path_dep_name")
    private String bookingParentPathDepName;
    /**
     * 预订人部门编号
     * 
     */
    @JsonProperty("booking_dep_code")
    private String bookingDepCode;
    /**
     * 出差申请单号
     * 
     */
    @JsonProperty("requisition_id")
    private String requisitionId;
    /**
     * 外部审批单ID
     * 
     */
    @JsonProperty("out_requisition_id")
    private String outRequisitionId;
    /**
     * 改签订单号 如：A改成B，则改签订单号为B
     * 
     */
    @JsonProperty("order_id")
    private String orderId;
    /**
     * 改签前订单号 如：A改成B，则改签前订单号为A
     * 
     */
    @JsonProperty("pre_order_id")
    private String preOrderId;
    /**
     * 交易类型 枚举【0：出票，1：改签，2：退票，3：线下改签，4：线下退票】
     * 
     */
    @JsonProperty("transaction_type")
    private Integer transactionType;
    /**
     * 供应商订单号 示例：若供应商票号为\&quot;999-9744643597\&quot;，则供应商订单号为\&quot;9999744643597\&quot;
     * 
     */
    @JsonProperty("supplier_order_id")
    private String supplierOrderId;
    /**
     * 航段
     * 
     */
    @JsonProperty("flight_segment_travel")
    private String flightSegmentTravel;
    /**
     * 航段数量
     * 
     */
    @JsonProperty("flight_segment_number")
    private Integer flightSegmentNumber;
    /**
     * 预定日期 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-06-13 15:58:49\&quot;
     * 
     */
    @JsonProperty("booking_date")
    private String bookingDate;
    /**
     * 完单时间 (冗余字段) 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-06-16 15:58:49\&quot;
     * 
     */
    @JsonProperty("settlement_time")
    private String settlementTime;
    /**
     * 下单时间（冗余字段）格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-06-13 15:58:49\&quot;
     * 
     */
    @JsonProperty("create_time")
    private String createTime;
    /**
     * 起飞时间 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-06-16 10:58:49\&quot;
     * 
     */
    @JsonProperty("departure_time")
    private String departureTime;
    /**
     * 支付方式 枚举【\&quot;企业支付\&quot;、\&quot;个人支付\&quot;、\&quot;混合支付\&quot;、\&quot;企业钱包支付\&quot;】
     * 
     */
    @JsonProperty("pay_type")
    private String payType;
    /**
     * 企业实付(单位：元)
     * 
     */
    @JsonProperty("company_real_pay")
    private String companyRealPay;
    /**
     * 订单总金额(单位：元) 当前订单支付的总金额，订单总金额&#x3D;企业实付金额+个人实付金额（异步收取平台使用费情况下，订单总金额不包含平台使用费，即订单总金额＜企业实付金额+个人实付金额）
     * 
     */
    @JsonProperty("total_fee")
    private String totalFee;
    /**
     * 票面费用(单位：元)
     * 
     */
    @JsonProperty("ticket_fee")
    private String ticketFee;
    /**
     * 机建费(单位：元)
     * 
     */
    @JsonProperty("construction_cost")
    private String constructionCost;
    /**
     * 燃油费(单位：元)
     * 
     */
    @JsonProperty("fuelCost")
    private String fuelCost;
    /**
     * 改签差价(单位：元)
     * 
     */
    @JsonProperty("upgrade_cost")
    private String upgradeCost;
    /**
     * 改签手续费(单位：元)
     * 
     */
    @JsonProperty("change_handle_cost")
    private String changeHandleCost;
    /**
     * 退款手续费(单位：元)
     * 
     */
    @JsonProperty("refund_handle_cost")
    private String refundHandleCost;
    /**
     * 平台使用费(单位：元)
     * 
     */
    @JsonProperty("service_fee")
    private String serviceFee;
    /**
     * 行程单金额(单位：元)
     * 
     */
    @JsonProperty("travel_itinerary_fee")
    private String travelItineraryFee;
    /**
     * 发票金额(单位：元)
     * 
     */
    @JsonProperty("invoice_fee")
    private String invoiceFee;
    /**
     * 退改签原因
     * 
     */
    @JsonProperty("reason")
    private String reason;
    /**
     * PNR
     * 
     */
    @JsonProperty("pnr_number")
    private String pnrNumber;
    /**
     * 航司简称
     * 
     */
    @JsonProperty("airline_simple_name")
    private String airlineSimpleName;
    /**
     * 航班号
     * 
     */
    @JsonProperty("flight_number")
    private String flightNumber;
    /**
     * 出发城市名称
     * 
     */
    @JsonProperty("departure_city_name")
    private String departureCityName;
    /**
     * 达到城市名称
     * 
     */
    @JsonProperty("arrival_city_name")
    private String arrivalCityName;
    /**
     * 出发机场三字码
     * 
     */
    @JsonProperty("departure_airport_code")
    private String departureAirportCode;
    /**
     * 达到城市三字码
     * 
     */
    @JsonProperty("arrival_airport_code")
    private String arrivalAirportCode;
    /**
     * 出发机场名称
     * 
     */
    @JsonProperty("departure_airport_name")
    private String departureAirportName;
    /**
     * 达到机场名称
     * 
     */
    @JsonProperty("arrival_airport_name")
    private String arrivalAirportName;
    /**
     * 舱位名称
     * 
     */
    @JsonProperty("cabin_name")
    private String cabinName;
    /**
     * 舱位类型 枚举【0：未配置；1：头等舱；2：超值头等舱；3：商务舱；4：经济舱；5：经济舱精选；6：经济舱Y舱】
     * 
     */
    @JsonProperty("cabin_type")
    private Integer cabinType;
    /**
     * 子舱位代码
     * 
     */
    @JsonProperty("cabin_code")
    private String cabinCode;
    /**
     * 出差申请单号（冗余字段）
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
    /**
     * 公司主体代码（6位），仅滴滴账单展示
     * 
     */
    @JsonProperty("sub_company_no")
    private String subCompanyNo;
    /**
     * 航程类别，枚举【0：国内大陆；1：国际+港澳台】
     * 
     */
    @JsonProperty("flight_travel_type")
    private Integer flightTravelType;
    /**
     * 审批单自定义
     * 
     */
    @JsonProperty("extra_info")
    private String extraInfo;
    /**
     * 终票异常状态
     * 
     */
    @JsonProperty("final_offline_status")
    private String finalOfflineStatus;
    /**
     * 供应商票号
     * 
     */
    @JsonProperty("supplier_ticket_number")
    private String supplierTicketNumber;
    /**
     * 机票提前预定天数RC
     * 
     */
    @JsonProperty("rc_book")
    private String rcBook;
    /**
     * 机票舱等RC
     * 
     */
    @JsonProperty("rc_level")
    private String rcLevel;
    /**
     * 机票低价RC
     * 
     */
    @JsonProperty("rc_lowPrice")
    private String rcLowPrice;
    /**
     * 机票时间范围预订RC
     * 
     */
    @JsonProperty("rc_time_period")
    private String rcTimePeriod;
    /**
     * 审批历史
     * 
     */
    @JsonProperty("approval_history")
    private String approvalHistory;
    /**
     * 是否协议价 “是”或“否”
     * 
     */
    @JsonProperty("is_agreement")
    private String isAgreement;
    /**
     * 折扣 示例：”全价”、“8.8折”
     * 
     */
    @JsonProperty("discount")
    private String discount;
    /**
     * 出行目的
     * 
     */
    @JsonProperty("travel_purpose")
    private String travelPurpose;
    /**
     * 出行描述
     * 
     */
    @JsonProperty("trip_description")
    private String tripDescription;
    /**
     * 出差事由
     * 
     */
    @JsonProperty("trip_reason")
    private String tripReason;
    /**
     * 手工单产品类型
     * 
     */
    @JsonProperty("added_goods_name")
    private String addedGoodsName;
    /**
     * 备注
     * 
     */
    @JsonProperty("remark")
    private String remark;
    /**
     * 唯一键 此条明细的唯一键
     * 
     */
    @JsonProperty("unique_key")
    private String uniqueKey;
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
     * 乘车人开票子公司id
     * 
     */
    @JsonProperty("passenger_legal_entity_id")
    private Long passengerLegalEntityId;
    /**
     * 乘车人开票子公司名称
     * 
     */
    @JsonProperty("passenger_legal_entity_name")
    private String passengerLegalEntityName;
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
     * 用户自定义拓展字段5
     * 
     */
    @JsonProperty("ex_info_05")
    private String exInfo05;
    /**
     * 用户自定义拓展字段6
     * 
     */
    @JsonProperty("ex_info_06")
    private String exInfo06;
    /**
     * 用户自定义拓展字段7
     * 
     */
    @JsonProperty("ex_info_07")
    private String exInfo07;
    /**
     * 用户自定义拓展字段8
     * 
     */
    @JsonProperty("ex_info_08")
    private String exInfo08;
    /**
     * 制度名称
     * 
     */
    @JsonProperty("institution_name")
    private String institutionName;
    /**
     * 成本中心code 外部成本中心id
     * 
     */
    @JsonProperty("budget_center_code")
    private String budgetCenterCode;
    /**
     * 原订单号 如：\&quot;9999744643597\&quot;
     * 
     */
    @JsonProperty("origin_order_id")
    private String originOrderId;
    /**
     * 到达时间 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-06-16 10:58:49\&quot;
     * 
     */
    @JsonProperty("arrival_time")
    private String arrivalTime;
    /**
     * Y舱全价 如：\&quot;168.80\&quot; 保留两位小数
     * 
     */
    @JsonProperty("economy_original_cost")
    private String economyOriginalCost;
    /**
     * 终票状态 枚举【-1, \&quot;起飞未到终态/预定口径\&quot; 0, \&quot;特殊-私退私改\&quot; 1, \&quot;终态-已使用\&quot; 2, \&quot;终态-已退票\&quot;】
     * 
     */
    @JsonProperty("upgrade_final_status")
    private Integer upgradeFinalStatus;
    /**
     * 机票订单异常信息 如：\&quot;张三-单程-北京至上海：行程冲突；李四-返程-上海至北京：行程冲突、行程重复\&quot;
     * 
     */
    @JsonProperty("exception_info")
    private String exceptionInfo;
    /**
     * 乘车人ID，如：123432
     * 
     */
    @JsonProperty("passengerMemberId")
    private String passengerMemberId;
    /**
     * 成本中心编码，如：3899
     * 
     */
    @JsonProperty("budgetCenterCode__REPEAT__2")
    private String budgetCenterCodeREPEAT2;
    /**
     * 退改类型 自愿/非自愿
     * 
     */
    @JsonProperty("rebook")
    private String rebook;
    /**
     * 预订人员工ID 如：1111233
     * 
     */
    @JsonProperty("bookingMemberId")
    private String bookingMemberId;
    /**
     * 共享航班号 如：CU8282
     * 
     */
    @JsonProperty("mainFlightNumber")
    private String mainFlightNumber;
    /**
     * 机票全价 如：2000
     * 
     */
    @JsonProperty("baseFee")
    private String baseFee;
    /**
     * 改签审批明细
     * 
     */
    @JsonProperty("approval_change_history")
    private String approvalChangeHistory;
    /**
     * 职级 如：\&quot;员工\&quot;
     * 
     */
    @JsonProperty("rank_name")
    private String rankName;
    /**
     * 出发城市id
     * 
     */
    @JsonProperty("departure_city_id")
    private String departureCityId;
    /**
     * 到达城市id
     * 
     */
    @JsonProperty("arrival_city_id")
    private String arrivalCityId;
    /**
     * 外部公司主体编号
     * 
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
    /**
     * 滴滴订立减 如：10.00
     * 
     */
    @JsonProperty("reduction_fee")
    private BigDecimal reductionFee;
    /**
     * 个人实付
     * 
     */
    @JsonProperty("personal_real_pay")
    private String personalRealPay;
    /**
     * 企业改签手续费
     * 
     */
    @JsonProperty("company_change_service_cost")
    private String companyChangeServiceCost;
    /**
     * 个人改签手续费
     * 
     */
    @JsonProperty("personal_change_service_cost")
    private String personalChangeServiceCost;
    /**
     * 企业改签差价
     * 
     */
    @JsonProperty("company_upgrade_cost")
    private String companyUpgradeCost;
    /**
     * 个人改签差价
     * 
     */
    @JsonProperty("personal_upgrade_cost")
    private String personalUpgradeCost;
    /**
     * 企业票面价
     * 
     */
    @JsonProperty("company_ticket_cost")
    private String companyTicketCost;
    /**
     * 个人票面价
     * 
     */
    @JsonProperty("personal_ticket_cost")
    private String personalTicketCost;
    /**
     * 制度ID
     * 
     */
    @JsonProperty("institution_id")
    private Long institutionId;
    /**
     * 最后更新时间
     * 
     */
    @JsonProperty("lastupdate_time")
    private String lastupdateTime;
    /**
     * 超出机票里程范围的超标原因
     * 
     */
    @JsonProperty("rc_distance_period")
    private String rcDistancePeriod;
    /**
     * 企业实付（不包含平台使用费）
     * 
     */
    @JsonProperty("excluding_service_fee")
    private BigDecimal excludingServiceFee;
    /**
     * 自定义（开票主体等信息)
     * 
     */
    @JsonProperty("extend_info")
    private String extendInfo;
    /**
     * 退票申请时间
     * 
     */
    @JsonProperty("apply_refund_time")
    private String applyRefundTime;
    /**
     * 改签申请时间
     * 
     */
    @JsonProperty("apply_change_time")
    private String applyChangeTime;
    /**
     * 是否折扣机票
     * 
     */
    @JsonProperty("is_discount_ticket")
    private String isDiscountTicket;
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
    @JsonProperty("parent_instiution_id")
    private Long parentInstiutionId;
    /**
     * 票面价 (单位：元) 出票时为出票的票面价；改签时为 0；当（出 - 退）退票时为原票面价票的负数，当（出 - 改 - 退）退票时为（原票面价 + 改签差价）的负数 (白名单客户字段，其他客户不提供)
     * 
     */
    @JsonProperty("ticket_fee_sp")
    private String ticketFeeSp;
    /**
     * 机建费 (单位：元) 出票时为出票的机建费；改签时为 0；退票时为原机建费票的负数 (白名单客户字段，其他客户不提供)
     * 
     */
    @JsonProperty("construction_cost_sp")
    private String constructionCostSp;
    /**
     * 燃油费 (单位：元) 出票时为出票的燃油费；改签为 0；退票为原燃油费的负数 (白名单客户字段，其他客户不提供)
     * 
     */
    @JsonProperty("fuelCost_sp")
    private String fuelCostSp;
    /**
     * 豁免类型
     * 
     */
    @JsonProperty("exempt_type")
    private String exemptType;
    /**
     * 豁免原因
     * 
     */
    @JsonProperty("exempt_reason")
    private String exemptReason;
}

