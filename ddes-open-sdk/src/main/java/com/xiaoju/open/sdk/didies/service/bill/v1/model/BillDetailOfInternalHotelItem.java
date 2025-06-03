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
public class BillDetailOfInternalHotelItem  {

    /**
     * 账单id 根结点批次id
     * 
     */
    @JsonProperty("bill_id")
    private Long billId;
    /**
     * 结算时间 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-05-27 22:00:47\&quot; 入账时间（交易维度，支付或者退款）
     * 
     */
    @JsonProperty("settle_time")
    private String settleTime;
    /**
     * 入住人员工id
     * 
     */
    @JsonProperty("member_id")
    private String memberId;
    /**
     * 入住人工号
     * 
     */
    @JsonProperty("passenger_member_number")
    private String passengerMemberNumber;
    /**
     * 入住人员工姓名
     * 
     */
    @JsonProperty("passenger_name")
    private String passengerName;
    /**
     * 入住人部门名称
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
     * 成本中心ID
     * 
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * 所在成本中心 路径 示例：\&quot;白全岭测试公司01&gt;项目二测试\&quot;
     * 
     */
    @JsonProperty("budget_center_parent_path_name")
    private String budgetCenterParentPathName;
    /**
     * 订单号
     * 
     */
    @JsonProperty("order_id")
    private String orderId;
    /**
     * 订单类型 枚举【预订、退款】
     * 
     */
    @JsonProperty("order_type")
    private String orderType;
    /**
     * 订单状态 枚举【\&quot;已提交\&quot;、\&quot;已提交预订\&quot;、\&quot;商家审核中\&quot;、\&quot;预订成功\&quot;、\&quot;已入住\&quot;、\&quot;已完成\&quot;、\&quot;已取消订单\&quot;、\&quot;已取消预订\&quot;、\&quot;预订未到\&quot;】 部分退款对应的订单状态：已完成（提前离店）、已取消预订（取消有罚金）、预订未到（人没到收一天罚金）
     * 
     */
    @JsonProperty("order_status")
    private String orderStatus;
    /**
     * 订单来源 枚举【企业app、H5等】
     * 
     */
    @JsonProperty("order_source")
    private String orderSource;
    /**
     * 支付方式 枚举【\&quot;企业支付\&quot;、\&quot;个人支付\&quot;、\&quot;混合支付\&quot;、\&quot;企业钱包支付\&quot;】
     * 
     */
    @JsonProperty("pay_type")
    private String payType;
    /**
     * 预订人姓名
     * 
     */
    @JsonProperty("booking_member_name")
    private String bookingMemberName;
    /**
     * 预定人员工编号
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
     * 预订人所在部门 示例：\&quot;白全岭测试公司01\&quot;
     * 
     */
    @JsonProperty("booking_parent_path_dep_name")
    private String bookingParentPathDepName;
    /**
     * 预订人部门ID
     * 
     */
    @JsonProperty("booking_dep_id")
    private String bookingDepId;
    /**
     * 预订人部门编号
     * 
     */
    @JsonProperty("booking_dep_code")
    private String bookingDepCode;
    /**
     * 预订时间 格式：\&quot;yyyy-MM-dd HH:mm:ss\&quot; 示例： \&quot;2023-06-13 15:58:49\&quot;
     * 
     */
    @JsonProperty("booking_date")
    private String bookingDate;
    /**
     * 预订入住日期 格式：\&quot;yyyy-MM-dd\&quot; 示例：\&quot;2023-06-15\&quot;
     * 
     */
    @JsonProperty("check_in_date")
    private String checkInDate;
    /**
     * 预订离店日期 格式：\&quot;yyyy-MM-dd\&quot; 示例：\&quot;2023-06-18\&quot;
     * 
     */
    @JsonProperty("original_check_out_date")
    private String originalCheckOutDate;
    /**
     * 实际退房时间 格式：\&quot;yyyy-MM-dd\&quot; 示例：\&quot;2023-06-18\&quot;
     * 
     */
    @JsonProperty("check_out_date")
    private String checkOutDate;
    /**
     * 入住人姓名 (冗余字段)
     * 
     */
    @JsonProperty("check_in_names")
    private String checkInNames;
    /**
     * 入住此酒店订单的人员中文姓名（若多人入住，则使用逗号分隔）
     * 
     */
    @JsonProperty("checkin_names_cn")
    private String checkinNamesCn;
    /**
     * 入住人员工编号
     * 
     */
    @JsonProperty("check_in_member_numbers")
    private String checkInMemberNumbers;
    /**
     * 入住人部门名称 (冗余字段)
     * 
     */
    @JsonProperty("check_in_member_departments")
    private String checkInMemberDepartments;
    /**
     * 入住人部门 (冗余字段)
     * 
     */
    @JsonProperty("check_in_dep_name")
    private String checkInDepName;
    /**
     * 入住人所在部门 示例：\&quot;白全岭测试公司01\&quot;
     * 
     */
    @JsonProperty("check_in_path_dep_name")
    private String checkInPathDepName;
    /**
     * 入住人部门id
     * 
     */
    @JsonProperty("check_in_dep_id")
    private String checkInDepId;
    /**
     * 入住人部门编号
     * 
     */
    @JsonProperty("check_in_dep_code")
    private String checkInDepCode;
    /**
     * 城市名称
     * 
     */
    @JsonProperty("city_name")
    private String cityName;
    /**
     * 酒店类型 枚举【\&quot;酒店协议价\&quot;、\&quot;会员酒店\&quot;】
     * 
     */
    @JsonProperty("hotel_type")
    private String hotelType;
    /**
     * 酒店名称
     * 
     */
    @JsonProperty("hotel_name")
    private String hotelName;
    /**
     * 房型 示例：高级大床房、豪华双床房
     * 
     */
    @JsonProperty("rooms")
    private String rooms;
    /**
     * 预订房间数 1个人住:1 2个人住:0.5 3个人住:0.33、0.33、0.34
     * 
     */
    @JsonProperty("room_num")
    private BigDecimal roomNum;
    /**
     * 预订天数
     * 
     */
    @JsonProperty("book_day_number")
    private Integer bookDayNumber;
    /**
     * 合计间夜数（&#x3D;预订天数*预订房间数）
     * 
     */
    @JsonProperty("total_nights")
    private BigDecimal totalNights;
    /**
     * 企业实付金额（&#x3D;房费+平台使用费）
     * 
     */
    @JsonProperty("company_real_amount")
    private BigDecimal companyRealAmount;
    /**
     * 交易类型 枚举【”消费“、”退款“】
     * 
     */
    @JsonProperty("company_pay_type")
    private String companyPayType;
    /**
     * 个人实付金额（入住人包含预订人，个人费用挂到预订人；入住人不包含预订人，个人费用挂到订单的第一个人）
     * 
     */
    @JsonProperty("personal_real_pay")
    private BigDecimal personalRealPay;
    /**
     * 个人实际退款金额
     * 
     */
    @JsonProperty("personal_real_refund")
    private BigDecimal personalRealRefund;
    /**
     * 平台使用费
     * 
     */
    @JsonProperty("service_fee")
    private BigDecimal serviceFee;
    /**
     * 房费总价
     * 
     */
    @JsonProperty("cost_discount_before")
    private BigDecimal costDiscountBefore;
    /**
     * 订单总金额（平台使用费同步收，等于企业实付金额；平台使用费异步收，等于房费总价）
     * 
     */
    @JsonProperty("amount")
    private BigDecimal amount;
    /**
     * 酒店房费RC 房间费用超标原因，示例：为客户预订/招待客户
     * 
     */
    @JsonProperty("rc_low_price")
    private String rcLowPrice;
    /**
     * 酒店协议价RC 预订协议酒店超标原因
     * 
     */
    @JsonProperty("rc_agreed_price")
    private String rcAgreedPrice;
    /**
     * 酒店提前预订天数RC 预订天数超标原因
     * 
     */
    @JsonProperty("rc_book")
    private String rcBook;
    /**
     * 酒店星级RC 预订酒店星级超标原因
     * 
     */
    @JsonProperty("rc_level")
    private String rcLevel;
    /**
     * 出行人目的
     * 
     */
    @JsonProperty("travel_purpose")
    private String travelPurpose;
    /**
     * 出行人描述
     * 
     */
    @JsonProperty("travel_description")
    private String travelDescription;
    /**
     * 个人用券抵扣金额
     * 
     */
    @JsonProperty("personal_coupon_cost")
    private BigDecimal personalCouponCost;
    /**
     * 企业用券抵扣金额
     * 
     */
    @JsonProperty("company_coupon_cost")
    private BigDecimal companyCouponCost;
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
     * 预定/超标情况下的审批历史
     * 
     */
    @JsonProperty("approval_history")
    private String approvalHistory;
    /**
     * 出差申请单号
     * 
     */
    @JsonProperty("requisition_id")
    private String requisitionId;
    /**
     * 外部审批单id
     * 
     */
    @JsonProperty("out_requisition_id")
    private String outRequisitionId;
    /**
     * 是否增值税 枚举【“是”，“否”】
     * 
     */
    @JsonProperty("is_vat")
    private String isVat;
    /**
     * 税率
     * 
     */
    @JsonProperty("tax_ratio")
    private String taxRatio;
    /**
     * 审批单自定义
     * 
     */
    @JsonProperty("extra_info")
    private String extraInfo;
    /**
     * 备注
     * 
     */
    @JsonProperty("remark")
    private String remark;
    /**
     * 出差事由
     * 
     */
    @JsonProperty("trip_reason")
    private String tripReason;
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
     * 入住人开票子公司id
     * 
     */
    @JsonProperty("passenger_legal_entity_id")
    private Long passengerLegalEntityId;
    /**
     * 入住人开票子公司名称
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
     * 入住人ID 如：123432
     * 
     */
    @JsonProperty("passenger_member_id")
    private Long passengerMemberId;
    /**
     * 取消原因 如：临时取消
     * 
     */
    @JsonProperty("reason")
    private String reason;
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
     * 职级 如：\&quot;员工\&quot;
     * 
     */
    @JsonProperty("rank_name")
    private String rankName;
    /**
     * 入住城市id
     * 
     */
    @JsonProperty("city_id")
    private String cityId;
    /**
     * 税点服务费 如：1.00
     * 
     */
    @JsonProperty("es_diff_tax_fee")
    private BigDecimal esDiffTaxFee;
    /**
     * 发票税率 如：\&quot;1%\&quot;
     * 
     */
    @JsonProperty("invoice_tax_ratio")
    private String invoiceTaxRatio;
    /**
     * 发票类型 如：\&quot;普票\&quot;
     * 
     */
    @JsonProperty("invoice_type")
    private String invoiceType;
    /**
     * 外部公司主体编号
     * 
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
    /**
     * 国家
     * 
     */
    @JsonProperty("country_name_cn")
    private String countryNameCn;
    /**
     * 币种
     * 
     */
    @JsonProperty("currency")
    private String currency;
    /**
     * 补税服务费
     * 
     */
    @JsonProperty("tax_supplement_service_fee")
    private BigDecimal taxSupplementServiceFee;
    /**
     * 制度ID
     * 
     */
    @JsonProperty("institution_id")
    private Long institutionId;
    /**
     * 预定人ID
     * 
     */
    @JsonProperty("booking_member_id")
    private Long bookingMemberId;
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

