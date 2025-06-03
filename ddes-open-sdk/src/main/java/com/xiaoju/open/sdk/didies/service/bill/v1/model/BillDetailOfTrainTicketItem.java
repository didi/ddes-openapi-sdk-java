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
public class BillDetailOfTrainTicketItem  {

    /**
     * 账单id 根结点批次id
     * 
     */
    @JsonProperty("bill_id")
    private Long billId;
    /**
     * 原票id 滴滴企业版app生成的原始票id
     * 
     */
    @JsonProperty("origin_ticket_id_text")
    private String originTicketIdText;
    /**
     * 改签票id 滴滴企业版app生成的改签票id
     * 
     */
    @JsonProperty("ticket_id_text")
    private String ticketIdText;
    /**
     * 当前订单号
     * 
     */
    @JsonProperty("order_id")
    private String orderId;
    /**
     * 改签订单号 滴滴企业版app生成的改签订单号
     * 
     */
    @JsonProperty("order_id_text")
    private String orderIdText;
    /**
     * 该笔订单的交易类型 枚举【\&quot;出票\&quot;、\&quot;改签\&quot;、\&quot;退票\&quot;】
     * 
     */
    @JsonProperty("transaction_type")
    private String transactionType;
    /**
     * 火车票发生线下退改的异常状态 枚举【\&quot;\&quot;、\&quot;线下已改签\&quot;、”线下已退票\&quot;、“线下已改签后线下退票”】
     * 
     */
    @JsonProperty("abnormal")
    private String abnormal;
    /**
     * 当前订单支付金额的方式，如：企业支付、混合支付（指企业支付和个人支付两种支付方式同时支付一笔订单）
     * 
     */
    @JsonProperty("pay_type")
    private String payType;
    /**
     * 预定人id
     * 
     */
    @JsonProperty("booking_member_id")
    private Long bookingMemberId;
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
     * 预定人部门id
     * 
     */
    @JsonProperty("booking_dep_id")
    private Long bookingDepId;
    /**
     * 预订人部门名称
     * 
     */
    @JsonProperty("booking_dep_name")
    private String bookingDepName;
    /**
     * 预定人部门编号（客户在ES后台输入的部门编号）
     * 
     */
    @JsonProperty("booking_dep_code")
    private String bookingDepCode;
    /**
     * 预订火车票订单的员工所在部门 示例：\&quot;江苏康缘药业股份有限公司&gt;江苏康缘药业股份有限公司&gt;康缘集团&gt;康昊公司&gt;营销事业部&gt;华南事业部&gt;南宁省公司&gt;南宁省公司(本部)\&quot;
     * 
     */
    @JsonProperty("booking_parent_path_dep_name")
    private String bookingParentPathDepName;
    /**
     * 乘车人id
     * 
     */
    @JsonProperty("passenger_member_id")
    private Long passengerMemberId;
    /**
     * 乘车人姓名
     * 
     */
    @JsonProperty("passenger_member_name")
    private String passengerMemberName;
    /**
     * 乘车人工号
     * 
     */
    @JsonProperty("passenger_member_number")
    private String passengerMemberNumber;
    /**
     * 乘车人部门id
     * 
     */
    @JsonProperty("passenger_dep_id")
    private Long passengerDepId;
    /**
     * 乘车人部门名称
     * 
     */
    @JsonProperty("passenger_dep_name")
    private String passengerDepName;
    /**
     * 乘车人部门编号
     * 
     */
    @JsonProperty("passenger_dep_code")
    private String passengerDepCode;
    /**
     * 当前火车票的乘车人所在部门 示例：\&quot;江苏康缘药业股份有限公司&gt;江苏康缘药业股份有限公司&gt;康缘集团&gt;康缘股份&gt;康昊公司&gt;营销事业部&gt;江苏事业部&gt;无锡省公司&gt;无锡省公司(本部)\&quot;
     * 
     */
    @JsonProperty("passenger_parent_path_dep_name")
    private String passengerParentPathDepName;
    /**
     * 成本中心id 管理员在ES后台差旅管控模块维护的成本中心（部门或项目）ID，同时可以设置员工下单时是否必填此字段
     * 
     */
    @JsonProperty("budget_center_id")
    private Long budgetCenterId;
    /**
     * 所在成本中心 管理员在ES后台差旅管控模块维护的所在成本中心（部门或项目）名称，同时可以设置员工下单时是否必填此字段
     * 
     */
    @JsonProperty("budget_center_parent_path_name")
    private String budgetCenterParentPathName;
    /**
     * 成本中心code 外部成本中心id
     * 
     */
    @JsonProperty("budget_center_code")
    private String budgetCenterCode;
    /**
     * 成本中心名称 管理员在ES后台差旅管控模块维护的成本中心（部门或项目）名称，同时可以设置员工下单时是否必填此字段
     * 
     */
    @JsonProperty("budget_center_name")
    private String budgetCenterName;
    /**
     * 预订时间 火车票订单的下单时间 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-05-27 22:00:47\&quot;
     * 
     */
    @JsonProperty("order_time")
    private String orderTime;
    /**
     * 出发时间 火车票展示的发车时间 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-06-08 14:41:00\&quot;
     * 
     */
    @JsonProperty("start_time")
    private String startTime;
    /**
     * 到达时间 火车票展示的到达时间 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-06-08 15:11:00\&quot;
     * 
     */
    @JsonProperty("end_time")
    private String endTime;
    /**
     * 出发站点 火车票展示的出发站点
     * 
     */
    @JsonProperty("from_station_name")
    private String fromStationName;
    /**
     * 到达站点 火车票展示的到达站点
     * 
     */
    @JsonProperty("to_station_name")
    private String toStationName;
    /**
     * 车次 火车票所展示的列车车次
     * 
     */
    @JsonProperty("train_code")
    private String trainCode;
    /**
     * 座位 当前火车票的座位号
     * 
     */
    @JsonProperty("seat_level")
    private String seatLevel;
    /**
     * 席别 火车席位的类别，如硬座、硬卧、一等座、二等座
     * 
     */
    @JsonProperty("seat_name")
    private String seatName;
    /**
     * 票价（单位：元） &#x3D;企业票价+个人票价
     * 
     */
    @JsonProperty("total_ticket_price")
    private BigDecimal totalTicketPrice;
    /**
     * 企业票价（单位：元） 当前票价通过企业账户支付金额部分
     * 
     */
    @JsonProperty("ticket_price")
    private BigDecimal ticketPrice;
    /**
     * 个人票价（单位：元） 当前票价通过个人账户支付金额部分
     * 
     */
    @JsonProperty("person_ticket_price")
    private BigDecimal personTicketPrice;
    /**
     * 退改手续费（单位：元） 退票和改签时所产生的手续费 &#x3D;企业退改手续费+个人退改手续费
     * 
     */
    @JsonProperty("total_handing_extra_fee")
    private BigDecimal totalHandingExtraFee;
    /**
     * 企业退改手续费（单位：元） 退票和改签时企业所支付的手续费
     * 
     */
    @JsonProperty("handing_extra_fee")
    private BigDecimal handingExtraFee;
    /**
     * 个人退改手续费（单位：元） 退票和改签时个人所支付的手续费
     * 
     */
    @JsonProperty("person_handing_extra_fee")
    private BigDecimal personHandingExtraFee;
    /**
     * 企业退票费（单位：元） 【火车票改版后 此字段已在excel账单下掉】
     * 
     */
    @JsonProperty("refund_fee")
    private BigDecimal refundFee;
    /**
     * 企业改签手续费（单位：元）【火车票改版后 此字段已在excel账单下掉】
     * 
     */
    @JsonProperty("change_extra_fee")
    private BigDecimal changeExtraFee;
    /**
     * 企业退票手续费（单位：元） 【火车票改版后 此字段已在excel账单下掉】
     * 
     */
    @JsonProperty("refund_extra_fee")
    private BigDecimal refundExtraFee;
    /**
     * 平台使用费（单位：元）
     * 
     */
    @JsonProperty("service_fee")
    private BigDecimal serviceFee;
    /**
     * 企业实付金额（单位：元）
     * 
     */
    @JsonProperty("company_real_pay")
    private BigDecimal companyRealPay;
    /**
     * 个人实付金额（单位：元）
     * 
     */
    @JsonProperty("person_real_pay")
    private BigDecimal personRealPay;
    /**
     * 订单金额（单位：元） 当前订单支付的总金额，订单总金额&#x3D;票价+退改手续费+平台使用费+抢票服务费。（异步收取平台使用费情况下，订单总金额不包含平台使用费，即订单总金额＜企业实付金额+个人实付金额）
     * 
     */
    @JsonProperty("order_pay")
    private BigDecimal orderPay;
    /**
     * 票根金额（单位：元） 票据的存根金额
     * 
     */
    @JsonProperty("stub_pay")
    private BigDecimal stubPay;
    /**
     * 是否改签 枚举：”是”、“否”
     * 
     */
    @JsonProperty("is_change")
    private String isChange;
    /**
     * 改签时间 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-06-08 15:11:00\&quot;
     * 
     */
    @JsonProperty("change_time")
    private String changeTime;
    /**
     * 是否退票 枚举：”是”、“否”
     * 
     */
    @JsonProperty("is_refund")
    private String isRefund;
    /**
     * 退票时间 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-06-08 15:11:00\&quot;
     * 
     */
    @JsonProperty("refund_time")
    private String refundTime;
    /**
     * 预订座席RC 超出预订规定坐席的超标原因
     * 
     */
    @JsonProperty("rc_normal_level")
    private String rcNormalLevel;
    /**
     * 改签座席RC 超出改签规定坐席的超标原因
     * 
     */
    @JsonProperty("rc_change_level")
    private String rcChangeLevel;
    /**
     * 出差申请单号 出差时所生成的单号
     * 
     */
    @JsonProperty("requisition_id")
    private String requisitionId;
    /**
     * 出行目的 出行人下单填写的出行目的
     * 
     */
    @JsonProperty("travel_purpose")
    private String travelPurpose;
    /**
     * 出行描述 出行人下单填写的出行描述
     * 
     */
    @JsonProperty("trip_description")
    private String tripDescription;
    /**
     * 出差事由 出行人下单填写的出行事由
     * 
     */
    @JsonProperty("trip_reason")
    private String tripReason;
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
     * 外部审批单ID
     * 
     */
    @JsonProperty("out_requisition_id")
    private String outRequisitionId;
    /**
     * 审批自定义
     * 
     */
    @JsonProperty("extra_info")
    private String extraInfo;
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
     * 出发城市名称
     * 
     */
    @JsonProperty("from_city_name")
    private String fromCityName;
    /**
     * 出发城市id
     * 
     */
    @JsonProperty("from_city_id")
    private Long fromCityId;
    /**
     * 到达城市名称
     * 
     */
    @JsonProperty("to_city_name")
    private String toCityName;
    /**
     * 到达城市id
     * 
     */
    @JsonProperty("to_city_id")
    private Long toCityId;
    /**
     * 结算时间 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-05-27 22:00:47\&quot;
     * 
     */
    @JsonProperty("settle_time")
    private String settleTime;
    /**
     * 退改手续费票根金额
     * 
     */
    @JsonProperty("train_ticket_refund_handle_fee")
    private BigDecimal trainTicketRefundHandleFee;
    /**
     * 退改签原因 如：临时取消
     * 
     */
    @JsonProperty("reason")
    private String reason;
    /**
     * 手工单产品类型 线下预订
     * 
     */
    @JsonProperty("added_goods_name")
    private String addedGoodsName;
    /**
     * 手工单立减原因 中文
     * 
     */
    @JsonProperty("added_cut_reason")
    private String addedCutReason;
    /**
     * 手工单 立减平台使用费
     * 
     */
    @JsonProperty("added_cut_service_fee")
    private BigDecimal addedCutServiceFee;
    /**
     * 手工单 立减前平台使用费
     * 
     */
    @JsonProperty("before_cut_service_fee")
    private BigDecimal beforeCutServiceFee;
    /**
     * 一级审批人
     * 
     */
    @JsonProperty("approval_first")
    private String approvalFirst;
    /**
     * 二级审批人
     * 
     */
    @JsonProperty("approval_second")
    private String approvalSecond;
    /**
     * 三级审批人
     * 
     */
    @JsonProperty("approval_third")
    private String approvalThird;
    /**
     * 项目自定义
     * 
     */
    @JsonProperty("project_ext_info")
    private String projectExtInfo;
    /**
     * 原始订单号 如：A改B改C，则原始订单号为A
     * 
     */
    @JsonProperty("origin_order_id")
    private String originOrderId;
    /**
     * 预定/超标情况下的审批历史
     * 
     */
    @JsonProperty("approval_history")
    private String approvalHistory;
    /**
     * 正常差旅申请的审批历史
     * 
     */
    @JsonProperty("approval_normal_history")
    private String approvalNormalHistory;
    /**
     * 出票类型 枚举：正常出票、抢票出票
     * 
     */
    @JsonProperty("purchase_type")
    private String purchaseType;
    /**
     * 抢票服务费（单位：元）
     * 
     */
    @JsonProperty("grab_service_fee")
    private BigDecimal grabServiceFee;
    /**
     * 职级 如：\&quot;员工\&quot;
     * 
     */
    @JsonProperty("rank_name")
    private String rankName;
    /**
     * 外部公司主体编号
     * 
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
    /**
     * 差价退票费(总)
     * 
     */
    @JsonProperty("total_difference_fee")
    private BigDecimal totalDifferenceFee;
    /**
     * 差价退票费(企业)
     * 
     */
    @JsonProperty("company_difference_fee")
    private BigDecimal companyDifferenceFee;
    /**
     * 差价退票费(个人)
     * 
     */
    @JsonProperty("person_difference_fee")
    private BigDecimal personDifferenceFee;
    /**
     * 差价退票费(票根)
     * 
     */
    @JsonProperty("difference_fee_stub")
    private BigDecimal differenceFeeStub;
    /**
     * 改签手续费(总)
     * 
     */
    @JsonProperty("total_change_fee")
    private BigDecimal totalChangeFee;
    /**
     * 改签手续费(企业)
     * 
     */
    @JsonProperty("company_change_fee")
    private BigDecimal companyChangeFee;
    /**
     * 改签手续费(个人)
     * 
     */
    @JsonProperty("person_change_fee")
    private BigDecimal personChangeFee;
    /**
     * 改签手续费(票根)
     * 
     */
    @JsonProperty("change_fee_stub")
    private BigDecimal changeFeeStub;
    /**
     * 制度ID
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
     * 自定义（开票主体等信息)
     * 
     */
    @JsonProperty("extend_info")
    private String extendInfo;
    /**
     * 子账户公司名称
     * 
     */
    @JsonProperty("sub_account_company_name")
    private String subAccountCompanyName;
    /**
     * 用户自定义拓展字段1编码
     * 
     */
    @JsonProperty("ex_info_01_code")
    private String exInfo01Code;
    /**
     * 用户自定义拓展字段2编码
     * 
     */
    @JsonProperty("ex_info_02_code")
    private String exInfo02Code;
    /**
     * 用户自定义拓展字段3编码
     * 
     */
    @JsonProperty("ex_info_03_code")
    private String exInfo03Code;
    /**
     * 用户自定义拓展字段4编码
     * 
     */
    @JsonProperty("ex_info_04_code")
    private String exInfo04Code;
    /**
     * 用户自定义拓展字段5编码
     * 
     */
    @JsonProperty("ex_info_05_code")
    private String exInfo05Code;
    /**
     * 用户自定义拓展字段6编码
     * 
     */
    @JsonProperty("ex_info_06_code")
    private String exInfo06Code;
    /**
     * 用户自定义拓展字段7编码
     * 
     */
    @JsonProperty("ex_info_07_code")
    private String exInfo07Code;
    /**
     * 用户自定义拓展字段8编码
     * 
     */
    @JsonProperty("ex_info_08_code")
    private String exInfo08Code;
}

