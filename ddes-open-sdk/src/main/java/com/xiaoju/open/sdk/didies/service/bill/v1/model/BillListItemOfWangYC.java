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
public class BillListItemOfWangYC  {

    /**
     * actualEndName
     * 
     */
    @JsonProperty("actual_end_name")
    private String actualEndName;
    /**
     * actualFromIsWorkPlace
     * 
     */
    @JsonProperty("actual_from_is_work_place")
    private String actualFromIsWorkPlace;
    /**
     * actualStartName
     * 
     */
    @JsonProperty("actual_start_name")
    private String actualStartName;
    /**
     * actualToIsWorkPlace
     * 
     */
    @JsonProperty("actual_to_is_work_place")
    private String actualToIsWorkPlace;
    /**
     * afterApprovalContent
     * 
     */
    @JsonProperty("after_approval_content")
    private String afterApprovalContent;
    /**
     * afterApprovalResult
     * 
     */
    @JsonProperty("after_approval_result")
    private String afterApprovalResult;
    /**
     * afterApproveMemberOne
     * 
     */
    @JsonProperty("after_approve_member_one")
    private String afterApproveMemberOne;
    /**
     * afterApproveMemberThree
     * 
     */
    @JsonProperty("after_approve_member_three")
    private String afterApproveMemberThree;
    /**
     * afterApproveMemberTwo
     * 
     */
    @JsonProperty("after_approve_member_two")
    private String afterApproveMemberTwo;
    /**
     * approvalCreateTime
     * 
     */
    @JsonProperty("approval_create_time")
    private String approvalCreateTime;
    /**
     * approvalExtraInfo
     * 
     */
    @JsonProperty("approval_extra_info")
    private String approvalExtraInfo;
    /**
     * approvalLogs
     * 
     */
    @JsonProperty("approval_logs")
    private String approvalLogs;
    /**
     * approvalReason
     * 
     */
    @JsonProperty("approval_reason")
    private String approvalReason;
    /**
     * beforeApprovalResult
     * 
     */
    @JsonProperty("before_approval_result")
    private String beforeApprovalResult;
    /**
     * beginChargeTime
     * 
     */
    @JsonProperty("begin_charge_time")
    private String beginChargeTime;
    /**
     * belongBudgetCenterName
     * 
     */
    @JsonProperty("belong_budget_center_name")
    private String belongBudgetCenterName;
    /**
     * belongOutBudgetId
     * 
     */
    @JsonProperty("belong_out_budget_id")
    private String belongOutBudgetId;
    /**
     * bookingDepCode
     * 
     */
    @JsonProperty("booking_dep_code")
    private String bookingDepCode;
    /**
     * bookingServiceFee
     * 
     */
    @JsonProperty("booking_service_fee")
    private BigDecimal bookingServiceFee;
    /**
     * branchName
     * 
     */
    @JsonProperty("branch_name")
    private String branchName;
    /**
     * bridgeFee
     * 
     */
    @JsonProperty("bridge_fee")
    private BigDecimal bridgeFee;
    /**
     * budgetCenterName
     * 
     */
    @JsonProperty("budget_center_name")
    private String budgetCenterName;
    /**
     * budgetId
     * 
     */
    @JsonProperty("budget_id")
    private String budgetId;
    /**
     * budgetItemName
     * 
     */
    @JsonProperty("budget_item_name")
    private String budgetItemName;
    /**
     * cWeight
     * 
     */
    @JsonProperty("c_weight")
    private String cWeight;
    /**
     * callPhone
     * 
     */
    @JsonProperty("call_phone")
    private String callPhone;
    /**
     * callPhoneCountryCode
     * 
     */
    @JsonProperty("call_phone_country_code")
    private String callPhoneCountryCode;
    /**
     * callbackInfo
     * 
     */
    @JsonProperty("callback_info")
    private String callbackInfo;
    /**
     * cancelTime
     * 
     */
    @JsonProperty("cancel_time")
    private String cancelTime;
    /**
     * carArriveProvince
     * 
     */
    @JsonProperty("car_arrive_province")
    private String carArriveProvince;
    /**
     * carDepartProvince
     * 
     */
    @JsonProperty("car_depart_province")
    private String carDepartProvince;
    /**
     * carTravelInfo
     * 
     */
    @JsonProperty("car_travel_info")
    private String carTravelInfo;
    /**
     * chargeTime
     * 
     */
    @JsonProperty("charge_time")
    private String chargeTime;
    /**
     * city
     * 
     */
    @JsonProperty("city")
    private String city;
    /**
     * cleanCarFee
     * 
     */
    @JsonProperty("clean_car_fee")
    private BigDecimal cleanCarFee;
    /**
     * co2Emissions
     * 
     */
    @JsonProperty("co2_emissions")
    private String co2Emissions;
    /**
     * companyCardRealPay
     * 
     */
    @JsonProperty("company_card_real_pay")
    private BigDecimal companyCardRealPay;
    /**
     * companyCardRealRefund
     * 
     */
    @JsonProperty("company_card_real_refund")
    private BigDecimal companyCardRealRefund;
    /**
     * companyId
     * 
     */
    @JsonProperty("company_id")
    private Long companyId;
    /**
     * companyName
     * 
     */
    @JsonProperty("company_name")
    private String companyName;
    /**
     * companyPayAble
     * 
     */
    @JsonProperty("company_pay_able")
    private BigDecimal companyPayAble;
    /**
     * companyRealPay
     * 
     */
    @JsonProperty("company_real_pay")
    private BigDecimal companyRealPay;
    /**
     * companyRealPreTaxPay
     * 
     */
    @JsonProperty("company_real_pre_tax_pay")
    private BigDecimal companyRealPreTaxPay;
    /**
     * companyRealRefund
     * 
     */
    @JsonProperty("company_real_refund")
    private BigDecimal companyRealRefund;
    /**
     * companyRealTaxPay
     * 
     */
    @JsonProperty("company_real_tax_pay")
    private BigDecimal companyRealTaxPay;
    /**
     * cost
     * 
     */
    @JsonProperty("cost")
    private BigDecimal cost;
    /**
     * createTime
     * 
     */
    @JsonProperty("create_time")
    private String createTime;
    /**
     * crossCityFee
     * 
     */
    @JsonProperty("cross_city_fee")
    private BigDecimal crossCityFee;
    /**
     * deductionTypeName
     * 
     */
    @JsonProperty("deduction_type_name")
    private String deductionTypeName;
    /**
     * department
     * 
     */
    @JsonProperty("department")
    private String department;
    /**
     * departmentName
     * 
     */
    @JsonProperty("department_name")
    private String departmentName;
    /**
     * departureDime
     * 
     */
    @JsonProperty("departure_dime")
    private String departureDime;
    /**
     * destinationCity
     * 
     */
    @JsonProperty("destination_city")
    private String destinationCity;
    /**
     * discountAfterPrice
     * 
     */
    @JsonProperty("discount_after_price")
    private BigDecimal discountAfterPrice;
    /**
     * dynamicPrice
     * 
     */
    @JsonProperty("dynamic_price")
    private BigDecimal dynamicPrice;
    /**
     * employeeNumber
     * 
     */
    @JsonProperty("employee_number")
    private String employeeNumber;
    /**
     * emptyFee
     * 
     */
    @JsonProperty("empty_fee")
    private BigDecimal emptyFee;
    /**
     * endAddress
     * 
     */
    @JsonProperty("end_address")
    private String endAddress;
    /**
     * endCountyId
     * 
     */
    @JsonProperty("end_county_id")
    private String endCountyId;
    /**
     * endCountyName
     * 
     */
    @JsonProperty("end_county_name")
    private String endCountyName;
    /**
     * endName
     * 
     */
    @JsonProperty("end_name")
    private String endName;
    /**
     * energyConsumeFee
     * 
     */
    @JsonProperty("energy_consume_fee")
    private BigDecimal energyConsumeFee;
    /**
     * enterpriseCouponBatch
     * 
     */
    @JsonProperty("enterprise_coupon_batch")
    private String enterpriseCouponBatch;
    /**
     * enterpriseCouponName
     * 
     */
    @JsonProperty("enterprise_coupon_name")
    private String enterpriseCouponName;
    /**
     * enterpriseInstantDiscount
     * 
     */
    @JsonProperty("enterprise_instant_discount")
    private BigDecimal enterpriseInstantDiscount;
    /**
     * estimatePrice
     * 
     */
    @JsonProperty("estimate_price")
    private BigDecimal estimatePrice;
    /**
     * estimatedDistance
     * 
     */
    @JsonProperty("estimated_distance")
    private String estimatedDistance;
    /**
     * exInfo01
     * 
     */
    @JsonProperty("ex_info_01")
    private String exInfo01;
    /**
     * exInfo01Code
     * 
     */
    @JsonProperty("ex_info_01_code")
    private String exInfo01Code;
    /**
     * exInfo02
     * 
     */
    @JsonProperty("ex_info_02")
    private String exInfo02;
    /**
     * exInfo02Code
     * 
     */
    @JsonProperty("ex_info_02_code")
    private String exInfo02Code;
    /**
     * exInfo03
     * 
     */
    @JsonProperty("ex_info_03")
    private String exInfo03;
    /**
     * exInfo03Code
     * 
     */
    @JsonProperty("ex_info_03_code")
    private String exInfo03Code;
    /**
     * exInfo04
     * 
     */
    @JsonProperty("ex_info_04")
    private String exInfo04;
    /**
     * exInfo04Code
     * 
     */
    @JsonProperty("ex_info_04_code")
    private String exInfo04Code;
    /**
     * exInfo05
     * 
     */
    @JsonProperty("ex_info_05")
    private String exInfo05;
    /**
     * exInfo05Code
     * 
     */
    @JsonProperty("ex_info_05_code")
    private String exInfo05Code;
    /**
     * exInfo06
     * 
     */
    @JsonProperty("ex_info_06")
    private String exInfo06;
    /**
     * exInfo06Code
     * 
     */
    @JsonProperty("ex_info_06_code")
    private String exInfo06Code;
    /**
     * exInfo07
     * 
     */
    @JsonProperty("ex_info_07")
    private String exInfo07;
    /**
     * exInfo07Code
     * 
     */
    @JsonProperty("ex_info_07_code")
    private String exInfo07Code;
    /**
     * exInfo08
     * 
     */
    @JsonProperty("ex_info_08")
    private String exInfo08;
    /**
     * exInfo08Code
     * 
     */
    @JsonProperty("ex_info_08_code")
    private String exInfo08Code;
    /**
     * excludingServiceFee
     * 
     */
    @JsonProperty("excluding_service_fee")
    private BigDecimal excludingServiceFee;
    /**
     * excludingTaxPayPrice
     * 
     */
    @JsonProperty("excluding_tax_pay_price")
    private BigDecimal excludingTaxPayPrice;
    /**
     * excludingTaxRefundPrice
     * 
     */
    @JsonProperty("excluding_tax_refund_price")
    private BigDecimal excludingTaxRefundPrice;
    /**
     * extendInfo
     * 
     */
    @JsonProperty("extend_info")
    private String extendInfo;
    /**
     * finishTime
     * 
     */
    @JsonProperty("finish_time")
    private String finishTime;
    /**
     * flagExt
     * 
     */
    @JsonProperty("flag_ext")
    private String flagExt;
    /**
     * fromIsWorkPlace
     * 
     */
    @JsonProperty("from_is_work_place")
    private String fromIsWorkPlace;
    /**
     * group1Code
     * 
     */
    @JsonProperty("group_1_code")
    private String group1Code;
    /**
     * group1Name
     * 
     */
    @JsonProperty("group_1_name")
    private String group1Name;
    /**
     * group2Code
     * 
     */
    @JsonProperty("group_2_code")
    private String group2Code;
    /**
     * group2Name
     * 
     */
    @JsonProperty("group_2_name")
    private String group2Name;
    /**
     * group3Code
     * 
     */
    @JsonProperty("group_3_code")
    private String group3Code;
    /**
     * group3Name
     * 
     */
    @JsonProperty("group_3_name")
    private String group3Name;
    /**
     * group4Code
     * 
     */
    @JsonProperty("group_4_code")
    private String group4Code;
    /**
     * group4Name
     * 
     */
    @JsonProperty("group_4_name")
    private String group4Name;
    /**
     * group5Code
     * 
     */
    @JsonProperty("group_5_code")
    private String group5Code;
    /**
     * group5Name
     * 
     */
    @JsonProperty("group_5_name")
    private String group5Name;
    /**
     * group6Code
     * 
     */
    @JsonProperty("group_6_code")
    private String group6Code;
    /**
     * group6Name
     * 
     */
    @JsonProperty("group_6_name")
    private String group6Name;
    /**
     * group7Code
     * 
     */
    @JsonProperty("group_7_code")
    private String group7Code;
    /**
     * group7Name
     * 
     */
    @JsonProperty("group_7_name")
    private String group7Name;
    /**
     * group8Code
     * 
     */
    @JsonProperty("group_8_code")
    private String group8Code;
    /**
     * group8Name
     * 
     */
    @JsonProperty("group_8_name")
    private String group8Name;
    /**
     * group9Code
     * 
     */
    @JsonProperty("group_9_code")
    private String group9Code;
    /**
     * group9Name
     * 
     */
    @JsonProperty("group_9_name")
    private String group9Name;
    /**
     * groupId
     * 
     */
    @JsonProperty("group_id")
    private String groupId;
    /**
     * groupName
     * 
     */
    @JsonProperty("group_name")
    private String groupName;
    /**
     * highwayFee
     * 
     */
    @JsonProperty("highway_fee")
    private BigDecimal highwayFee;
    /**
     * incentiveFee
     * 
     */
    @JsonProperty("incentive_fee")
    private BigDecimal incentiveFee;
    /**
     * institutionId
     * 
     */
    @JsonProperty("institution_id")
    private BigDecimal institutionId;
    /**
     * institutionName
     * 
     */
    @JsonProperty("institution_name")
    private String institutionName;
    /**
     * invoiceEntityInfo
     * 
     */
    @JsonProperty("invoice_entity_info")
    private String invoiceEntityInfo;
    /**
     * isCarpool
     * 
     */
    @JsonProperty("is_carpool")
    private String isCarpool;
    /**
     * isCarpoolSuccess
     * 
     */
    @JsonProperty("is_carpool_success")
    private BigDecimal isCarpoolSuccess;
    /**
     * isCurrentTerm
     * 
     */
    @JsonProperty("is_current_term")
    private String isCurrentTerm;
    /**
     * isDiscountOrder
     * 
     */
    @JsonProperty("is_discount_order")
    private String isDiscountOrder;
    /**
     * isFixedPrice
     * 
     */
    @JsonProperty("is_fixed_price")
    private String isFixedPrice;
    /**
     * isReassignment
     * 
     */
    @JsonProperty("is_reassignment")
    private String isReassignment;
    /**
     * isSelfDrive
     * 
     */
    @JsonProperty("is_self_drive")
    private String isSelfDrive;
    /**
     * isSensitive
     * 
     */
    @JsonProperty("is_sensitive")
    private BigDecimal isSensitive;
    /**
     * isUnusual
     * 
     */
    @JsonProperty("is_unusual")
    private String isUnusual;
    /**
     * lastApprovalTime
     * 
     */
    @JsonProperty("last_approval_time")
    private String lastApprovalTime;
    /**
     * lastApproves
     * 
     */
    @JsonProperty("last_approves")
    private String lastApproves;
    /**
     * legalEntityId
     * 
     */
    @JsonProperty("legal_entity_id")
    private Long legalEntityId;
    /**
     * legalEntityName
     * 
     */
    @JsonProperty("legal_entity_name")
    private String legalEntityName;
    /**
     * limitFee
     * 
     */
    @JsonProperty("limit_fee")
    private BigDecimal limitFee;
    /**
     * limitPay
     * 
     */
    @JsonProperty("limit_pay")
    private BigDecimal limitPay;
    /**
     * lowSpeedFee
     * 
     */
    @JsonProperty("low_speed_fee")
    private BigDecimal lowSpeedFee;
    /**
     * meetTime
     * 
     */
    @JsonProperty("meetTime")
    private String meetTime;
    /**
     * memberId
     * 
     */
    @JsonProperty("member_id")
    private Long memberId;
    /**
     * memberMail
     * 
     */
    @JsonProperty("member_mail")
    private String memberMail;
    /**
     * memberName
     * 
     */
    @JsonProperty("member_name")
    private String memberName;
    /**
     * nightFee
     * 
     */
    @JsonProperty("night_fee")
    private BigDecimal nightFee;
    /**
     * normalDistance
     * 
     */
    @JsonProperty("normal_distance")
    private BigDecimal normalDistance;
    /**
     * normalFee
     * 
     */
    @JsonProperty("normal_fee")
    private BigDecimal normalFee;
    /**
     * normalTimeFee
     * 
     */
    @JsonProperty("normal_time_fee")
    private BigDecimal normalTimeFee;
    /**
     * oneTimeOfferSubsidy
     * 
     */
    @JsonProperty("one_time_offer_subsidy")
    private BigDecimal oneTimeOfferSubsidy;
    /**
     * orderAdditionalRemark
     * 
     */
    @JsonProperty("order_additional_remark")
    private String orderAdditionalRemark;
    /**
     * orderId
     * 
     */
    @JsonProperty("order_id")
    private Long orderId;
    /**
     * orderSource
     * 
     */
    @JsonProperty("order_source")
    private String orderSource;
    /**
     * originalEndAddress
     * 
     */
    @JsonProperty("original_end_address")
    private String originalEndAddress;
    /**
     * originalEndName
     * 
     */
    @JsonProperty("original_end_name")
    private String originalEndName;
    /**
     * originalPrice
     * 
     */
    @JsonProperty("original_price")
    private BigDecimal originalPrice;
    /**
     * otherFee
     * 
     */
    @JsonProperty("other_fee")
    private BigDecimal otherFee;
    /**
     * outApprovalId
     * 
     */
    @JsonProperty("out_approval_id")
    private String outApprovalId;
    /**
     * outBudgetId
     * 
     */
    @JsonProperty("out_budget_id")
    private String outBudgetId;
    /**
     * outLegalEntityId
     * 
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
    /**
     * outOrderId
     * 
     */
    @JsonProperty("out_order_id")
    private Long outOrderId;
    /**
     * parkFee
     * 
     */
    @JsonProperty("park_fee")
    private BigDecimal parkFee;
    /**
     * passengerMemberId
     * 
     */
    @JsonProperty("passenger_member_id")
    private Long passengerMemberId;
    /**
     * passengerMemberNumber
     * 
     */
    @JsonProperty("passenger_member_number")
    private String passengerMemberNumber;
    /**
     * passengerName
     * 
     */
    @JsonProperty("passenger_name")
    private String passengerName;
    /**
     * passengerPhone
     * 
     */
    @JsonProperty("passenger_phone")
    private String passengerPhone;
    /**
     * passengerPhoneCountryCode
     * 
     */
    @JsonProperty("passenger_phone_country_code")
    private String passengerPhoneCountryCode;
    /**
     * payChannel
     * 
     */
    @JsonProperty("pay_channel")
    private String payChannel;
    /**
     * payTime
     * 
     */
    @JsonProperty("pay_time")
    private String payTime;
    /**
     * payType
     * 
     */
    @JsonProperty("pay_type")
    private String payType;
    /**
     * period
     * 
     */
    @JsonProperty("period")
    private String period;
    /**
     * personalInstantDiscount
     * 
     */
    @JsonProperty("personal_instant_discount")
    private BigDecimal personalInstantDiscount;
    /**
     * personalRealPay
     * 
     */
    @JsonProperty("personal_real_pay")
    private BigDecimal personalRealPay;
    /**
     * positionName
     * 
     */
    @JsonProperty("position_name")
    private String positionName;
    /**
     * projectExtInfo
     * 
     */
    @JsonProperty("project_ext_info")
    private String projectExtInfo;
    /**
     * realVoucherPay
     * 
     */
    @JsonProperty("real_voucher_pay")
    private BigDecimal realVoucherPay;
    /**
     * redPacket
     * 
     */
    @JsonProperty("red_packet")
    private BigDecimal redPacket;
    /**
     * refundPrice
     * 
     */
    @JsonProperty("refund_price")
    private BigDecimal refundPrice;
    /**
     * refundTime
     * 
     */
    @JsonProperty("refund_time")
    private String refundTime;
    /**
     * remark
     * 
     */
    @JsonProperty("remark")
    private String remark;
    /**
     * remoteAreaFee
     * 
     */
    @JsonProperty("remote_area_fee")
    private BigDecimal remoteAreaFee;
    /**
     * requireLevel
     * 
     */
    @JsonProperty("require_level")
    private String requireLevel;
    /**
     * requisitionId
     * 
     */
    @JsonProperty("requisition_id")
    private String requisitionId;
    /**
     * residentCityNames
     * 
     */
    @JsonProperty("resident_city_names")
    private String residentCityNames;
    /**
     * responsibleCancelFee
     * 
     */
    @JsonProperty("responsible_cancel_fee")
    private BigDecimal responsibleCancelFee;
    /**
     * rule
     * 
     */
    @JsonProperty("rule")
    private String rule;
    /**
     * ruleName
     * 
     */
    @JsonProperty("rule_name")
    private String ruleName;
    /**
     * sensitiveReason
     * 
     */
    @JsonProperty("sensitive_reason")
    private String sensitiveReason;
    /**
     * serviceType
     * 
     */
    @JsonProperty("service_type")
    private String serviceType;
    /**
     * settleType
     * 
     */
    @JsonProperty("settle_type")
    private String settleType;
    /**
     * spsPickUpServiceFee
     * 
     */
    @JsonProperty("sps_pick_up_service_fee")
    private BigDecimal spsPickUpServiceFee;
    /**
     * startAddress
     * 
     */
    @JsonProperty("start_address")
    private String startAddress;
    /**
     * startCountyId
     * 
     */
    @JsonProperty("start_county_id")
    private String startCountyId;
    /**
     * startCountyName
     * 
     */
    @JsonProperty("start_county_name")
    private String startCountyName;
    /**
     * startName
     * 
     */
    @JsonProperty("start_name")
    private String startName;
    /**
     * startPrice
     * 
     */
    @JsonProperty("start_price")
    private BigDecimal startPrice;
    /**
     * status
     * 
     */
    @JsonProperty("status")
    private String status;
    /**
     * striveTime
     * 
     */
    @JsonProperty("strive_time")
    private String striveTime;
    /**
     * subAccountCompanyName
     * 
     */
    @JsonProperty("sub_account_company_name")
    private String subAccountCompanyName;
    /**
     * subAccountName
     * 
     */
    @JsonProperty("sub_account_name")
    private String subAccountName;
    /**
     * subUseCarSrv
     * 
     */
    @JsonProperty("sub_use_car_srv")
    private String subUseCarSrv;
    /**
     * subsidyAmount
     * 
     */
    @JsonProperty("subsidy_amount")
    private BigDecimal subsidyAmount;
    /**
     * supplierCarName
     * 
     */
    @JsonProperty("supplier_car_name")
    private String supplierCarName;
    /**
     * supplierName
     * 
     */
    @JsonProperty("supplier_name")
    private String supplierName;
    /**
     * supplierType
     * 
     */
    @JsonProperty("supplier_type")
    private String supplierType;
    /**
     * taxPayPrice
     * 
     */
    @JsonProperty("tax_pay_price")
    private BigDecimal taxPayPrice;
    /**
     * taxRefundPrice
     * 
     */
    @JsonProperty("tax_refund_price")
    private BigDecimal taxRefundPrice;
    /**
     * timeSlotDiscount
     * 
     */
    @JsonProperty("time_slot_discount")
    private BigDecimal timeSlotDiscount;
    /**
     * tipFee
     * 
     */
    @JsonProperty("tip_fee")
    private BigDecimal tipFee;
    /**
     * toIsWorkPlace
     * 
     */
    @JsonProperty("to_is_work_place")
    private String toIsWorkPlace;
    /**
     * totalPrice
     * 
     */
    @JsonProperty("total_price")
    private BigDecimal totalPrice;
    /**
     * type
     * 
     */
    @JsonProperty("type")
    private String type;
    /**
     * unusualContent
     * 
     */
    @JsonProperty("unusual_content")
    private String unusualContent;
    /**
     * unusualType
     * 
     */
    @JsonProperty("unusual_type")
    private String unusualType;
    /**
     * upgradeBaseRequireLevel
     * 
     */
    @JsonProperty("upgrade_base_require_level")
    private String upgradeBaseRequireLevel;
    /**
     * upgradeCompanyPayQuota
     * 
     */
    @JsonProperty("upgrade_company_pay_quota")
    private BigDecimal upgradeCompanyPayQuota;
    /**
     * upgradeType
     * 
     */
    @JsonProperty("upgrade_type")
    private String upgradeType;
    /**
     * useCarService
     * 
     */
    @JsonProperty("use_car_service")
    private String useCarService;
    /**
     * useCarSrv
     * 
     */
    @JsonProperty("use_car_srv")
    private String useCarSrv;
    /**
     * useCarTypeName
     * 
     */
    @JsonProperty("use_car_type_name")
    private String useCarTypeName;
    /**
     * useCarTypeV2
     * 
     */
    @JsonProperty("use_car_type_v2")
    private String useCarTypeV2;
    /**
     * useType
     * 
     */
    @JsonProperty("use_type")
    private String useType;
    /**
     * userPayTime
     * 
     */
    @JsonProperty("user_pay_time")
    private String userPayTime;
    /**
     * userPayType
     * 
     */
    @JsonProperty("user_pay_type")
    private String userPayType;
    /**
     * voucherDeductionTypeName
     * 
     */
    @JsonProperty("voucher_deduction_type_name")
    private String voucherDeductionTypeName;
    /**
     * waitFee
     * 
     */
    @JsonProperty("wait_fee")
    private BigDecimal waitFee;
}

