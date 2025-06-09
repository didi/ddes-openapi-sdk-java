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
public class NotGenBDOfOverseasFlightItem  {

    /**
     * 原票id 滴滴企业版app生成的票id
     * 
     */
    @JsonProperty("origin_ticket_id")
    private String originTicketId;
    /**
     * 改签票id 滴滴企业版app生成的票id，改签票对应的票id
     * 
     */
    @JsonProperty("ticket_id_text")
    private String ticketIdText;
    /**
     * 当前机票的乘机人工号
     * 
     */
    @JsonProperty("passenger_member_number")
    private String passengerMemberNumber;
    /**
     * 当前机票的乘机人部门
     * 
     */
    @JsonProperty("passenger_dep_name")
    private String passengerDepName;
    /**
     * 乘机人所在部门（部门路径） 示例：\&quot;机票测试专用751&gt;优秀部门\&quot;
     * 
     */
    @JsonProperty("passenger_parent_path_dep_name")
    private String passengerParentPathDepName;
    /**
     * 当前机票的乘机人部门编号
     * 
     */
    @JsonProperty("passenger_dep_code")
    private String passengerDepCode;
    /**
     * 当前机票的乘机人员工id
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
     * 乘机人工号（冗余字段）
     * 
     */
    @JsonProperty("employee_number")
    private String employeeNumber;
    /**
     * 乘机人姓名（冗余字段）
     * 
     */
    @JsonProperty("passenger_name")
    private String passengerName;
    /**
     * 乘机人中文姓名
     * 
     */
    @JsonProperty("passenger_member_name")
    private String passengerMemberName;
    /**
     * 乘机人部门（冗余字段）
     * 
     */
    @JsonProperty("department")
    private String department;
    /**
     * 当前机票的乘机人部门id
     * 
     */
    @JsonProperty("department_id")
    private String departmentId;
    /**
     * 成本中心名称 管理员在ES后台差旅管控模块维护的成本中心（部门或项目）名称，同时可以设置员工下单时是否必填此字段
     * 
     */
    @JsonProperty("budget_center_name")
    private String budgetCenterName;
    /**
     * 指当前订单员工所在成本中心（部门或项目），示例：公司&gt;成本中心1&gt;成本中心2
     * 
     */
    @JsonProperty("budget_center_parent_path_name")
    private String budgetCenterParentPathName;
    /**
     * 成本中心ID 管理员在ES后台差旅管控模块维护的成本中心（部门或项目）ID，同时可以设置员工下单时是否必填此字段
     * 
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * 预订机票订单的员工姓名
     * 
     */
    @JsonProperty("booking_member_name")
    private String bookingMemberName;
    /**
     * 预订机票订单的员工编号
     * 
     */
    @JsonProperty("booking_member_number")
    private String bookingMemberNumber;
    /**
     * 预订机票订单的员工部门
     * 
     */
    @JsonProperty("booking_dep_name")
    private String bookingDepName;
    /**
     * 预订机票订单的员工所在部门，示例：公司&gt;部门1&gt;部门2
     * 
     */
    @JsonProperty("booking_parent_path_dep_name")
    private String bookingParentPathDepName;
    /**
     * 预订机票订单的员工部门编号（客户在ES后台输入的部门编号）
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
     * 外部审批单ID 开放平台API客户接差旅场景的外部审批单号，差旅API客户通过此字段可以和滴滴订单关联，方便查询和对账
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
     * 原始订单号 如：A改B改C，则原始订单号为A
     * 
     */
    @JsonProperty("origin_order_id")
    private String originOrderId;
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
     * 航段 当前机票的航段，包括出发地-目的地 示例：\&quot;上海-北京\&quot;
     * 
     */
    @JsonProperty("flight_segment_travel")
    private String flightSegmentTravel;
    /**
     * 当前机票的航段计数
     * 
     */
    @JsonProperty("flight_segment_number")
    private Integer flightSegmentNumber;
    /**
     * 机票预订时间 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-06-13 15:58:49\&quot;
     * 
     */
    @JsonProperty("booking_date")
    private String bookingDate;
    /**
     * 结算时间 国际机票结算入账的时间，以预订时间和退票完成时间（issue_time或refundTime，目前账单API无此字段）为准；若发生调整账单，则为账单调整时间 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-06-16 15:58:49\&quot;
     * 
     */
    @JsonProperty("settlement_time")
    private String settlementTime;
    /**
     * 机票预订时间（冗余字段）格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-06-13 15:58:49\&quot;
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
     * 终票起飞时间或退款时间(滴滴专用) 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-06-16 10:58:49\&quot;
     * 
     */
    @JsonProperty("final_departure_time")
    private String finalDepartureTime;
    /**
     * 企业实付(单位：元) 当前订单通过企业账户支付金额部分
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
     * 票面价(单位：元) 机票中的票面价格
     * 
     */
    @JsonProperty("ticket_fee")
    private String ticketFee;
    /**
     * 机建费(单位：元) 机票中的机建费价格
     * 
     */
    @JsonProperty("construction_cost")
    private String constructionCost;
    /**
     * 燃油费(单位：元) 机票中的燃油费价格
     * 
     */
    @JsonProperty("fuelCost")
    private String fuelCost;
    /**
     * 改签差价(单位：元) 机票改签产生的差价费用
     * 
     */
    @JsonProperty("upgrade_cost")
    private String upgradeCost;
    /**
     * 改签手续费(单位：元) 机票改签产生的手续费
     * 
     */
    @JsonProperty("change_handle_cost")
    private String changeHandleCost;
    /**
     * 退款手续费(单位：元) 机票退票产生的退票手续费
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
     * 购买机票过程中所产生的税费
     * 
     */
    @JsonProperty("tax")
    private String tax;
    /**
     * 退改签原因
     * 
     */
    @JsonProperty("reason")
    private String reason;
    /**
     * PNR 机票发生的旅客订座记录
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
     * 出发机场三字码，如PEK
     * 
     */
    @JsonProperty("departure_airport_code")
    private String departureAirportCode;
    /**
     * 达到城市三字码，如PEK
     * 
     */
    @JsonProperty("arrival_airport_code")
    private String arrivalAirportCode;
    /**
     * 出发机场名称，如北京首都国际机场
     * 
     */
    @JsonProperty("departure_airport_name")
    private String departureAirportName;
    /**
     * 到达机场名称，如北京首都国际机场
     * 
     */
    @JsonProperty("arrival_airport_name")
    private String arrivalAirportName;
    /**
     * 舱位名称，如经济舱
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
     * 供应商票号 示例：\&quot;999-9744643597\&quot;
     * 
     */
    @JsonProperty("supplier_ticket_number")
    private String supplierTicketNumber;
    /**
     * 机票提前预定的超标原因
     * 
     */
    @JsonProperty("rc_book")
    private String rcBook;
    /**
     * 未按照规定仓位预定的超标原因
     * 
     */
    @JsonProperty("rc_level")
    private String rcLevel;
    /**
     * 未按照机票最低价预定的超标原因
     * 
     */
    @JsonProperty("rc_lowPrice")
    private String rcLowPrice;
    /**
     * 超出机票预订时间范围的超标原因
     * 
     */
    @JsonProperty("rc_time_period")
    private String rcTimePeriod;
    /**
     * 审批历史记录，包括审批时间、审批人姓名、手机号、审批结果、不合规备注
     * 
     */
    @JsonProperty("approval_history")
    private String approvalHistory;
    /**
     * 是否协议价 “是”或“否” 机票是否协议价预订
     * 
     */
    @JsonProperty("is_agreement")
    private String isAgreement;
    /**
     * 出行目的 出行人下单填写的出行目的
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
     * 手工单产品类型 线下预订
     * 
     */
    @JsonProperty("added_goods_name")
    private String addedGoodsName;
    /**
     * 唯一键 此条明细的唯一键
     * 
     */
    @JsonProperty("unique_key")
    private String uniqueKey;
    /**
     * 是否为手工单机票 枚举【0/null：正常机票 1：手工单机票】
     * 
     */
    @JsonProperty("is_added")
    private Integer isAdded;
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
     * 手工单：立减前平台使用费 正常单：原平台使用费 （单位：元）
     * 
     */
    @JsonProperty("before_cut_service_fee")
    private BigDecimal beforeCutServiceFee;
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
     * 到达时间 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-06-16 10:58:49\&quot;
     * 
     */
    @JsonProperty("arrival_time")
    private String arrivalTime;
    /**
     * 乘机人ID，如：123432
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
     * 计划到达时间 如：2023-12-05 12:12:12
     * 
     */
    @JsonProperty("arrivalTime__REPEAT__2")
    private String arrivalTimeREPEAT2;
    /**
     * 项目自定义
     * 
     */
    @JsonProperty("project_ext_info")
    private String projectExtInfo;
    /**
     * 正常差旅申请的审批历史
     * 
     */
    @JsonProperty("approval_normal_history")
    private String approvalNormalHistory;
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
     * 出发国家名称
     * 
     */
    @JsonProperty("departure_country")
    private String departureCountry;
    /**
     * 到达国家名称
     * 
     */
    @JsonProperty("arrival_country")
    private String arrivalCountry;
    /**
     * 出发大洲名称
     * 
     */
    @JsonProperty("departure_continent")
    private String departureContinent;
    /**
     * 到达大洲名称
     * 
     */
    @JsonProperty("arrival_continent")
    private String arrivalContinent;
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

