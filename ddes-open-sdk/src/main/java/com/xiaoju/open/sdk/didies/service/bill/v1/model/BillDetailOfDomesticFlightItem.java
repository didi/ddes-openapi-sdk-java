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
public class BillDetailOfDomesticFlightItem  {

    /**
     * addedCutReason
     * 
     */
    @JsonProperty("added_cut_reason")
    private String addedCutReason;
    /**
     * addedEsCutFee
     * 
     */
    @JsonProperty("added_es_cut_fee")
    private BigDecimal addedEsCutFee;
    /**
     * addedGoodsName
     * 
     */
    @JsonProperty("added_goods_name")
    private String addedGoodsName;
    /**
     * adjustment
     * 
     */
    @JsonProperty("adjustment")
    private String adjustment;
    /**
     * airlineSimpleName
     * 
     */
    @JsonProperty("airline_simple_name")
    private String airlineSimpleName;
    /**
     * applyChangeTime
     * 
     */
    @JsonProperty("apply_change_time")
    private String applyChangeTime;
    /**
     * applyRefundTime
     * 
     */
    @JsonProperty("apply_refund_time")
    private String applyRefundTime;
    /**
     * approvalChangeHistory
     * 
     */
    @JsonProperty("approval_change_history")
    private String approvalChangeHistory;
    /**
     * approvalFirst
     * 
     */
    @JsonProperty("approval_first")
    private String approvalFirst;
    /**
     * approvalHistory
     * 
     */
    @JsonProperty("approval_history")
    private String approvalHistory;
    /**
     * approvalId
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
    /**
     * approvalNormalHistory
     * 
     */
    @JsonProperty("approval_normal_history")
    private String approvalNormalHistory;
    /**
     * approvalSecond
     * 
     */
    @JsonProperty("approval_second")
    private String approvalSecond;
    /**
     * approvalThird
     * 
     */
    @JsonProperty("approval_third")
    private String approvalThird;
    /**
     * arrivalAirportCode
     * 
     */
    @JsonProperty("arrival_airport_code")
    private String arrivalAirportCode;
    /**
     * arrivalAirportName
     * 
     */
    @JsonProperty("arrival_airport_name")
    private String arrivalAirportName;
    /**
     * arrivalCityId
     * 
     */
    @JsonProperty("arrival_city_id")
    private String arrivalCityId;
    /**
     * arrivalCityName
     * 
     */
    @JsonProperty("arrival_city_name")
    private String arrivalCityName;
    /**
     * arrivalTime
     * 
     */
    @JsonProperty("arrival_time")
    private String arrivalTime;
    /**
     * baseFee
     * 
     */
    @JsonProperty("base_fee")
    private BigDecimal baseFee;
    /**
     * beforeCutServiceFee
     * 
     */
    @JsonProperty("before_cut_service_fee")
    private BigDecimal beforeCutServiceFee;
    /**
     * billId
     * 
     */
    @JsonProperty("bill_id")
    private Long billId;
    /**
     * bookingDate
     * 
     */
    @JsonProperty("booking_date")
    private String bookingDate;
    /**
     * bookingDepCode
     * 
     */
    @JsonProperty("booking_dep_code")
    private String bookingDepCode;
    /**
     * bookingDepName
     * 
     */
    @JsonProperty("booking_dep_name")
    private String bookingDepName;
    /**
     * bookingMemberId
     * 
     */
    @JsonProperty("booking_member_id")
    private Long bookingMemberId;
    /**
     * bookingMemberName
     * 
     */
    @JsonProperty("booking_member_name")
    private String bookingMemberName;
    /**
     * bookingMemberNumber
     * 
     */
    @JsonProperty("booking_member_number")
    private String bookingMemberNumber;
    /**
     * bookingParentPathDepName
     * 
     */
    @JsonProperty("booking_parent_path_dep_name")
    private String bookingParentPathDepName;
    /**
     * budgetCenterCode
     * 
     */
    @JsonProperty("budget_center_code")
    private String budgetCenterCode;
    /**
     * budgetCenterId
     * 
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * budgetCenterName
     * 
     */
    @JsonProperty("budget_center_name")
    private String budgetCenterName;
    /**
     * budgetCenterParentPathName
     * 
     */
    @JsonProperty("budget_center_parent_path_name")
    private String budgetCenterParentPathName;
    /**
     * cabinCode
     * 
     */
    @JsonProperty("cabin_code")
    private String cabinCode;
    /**
     * cabinName
     * 
     */
    @JsonProperty("cabin_name")
    private String cabinName;
    /**
     * cabinType
     * 
     */
    @JsonProperty("cabin_type")
    private Integer cabinType;
    /**
     * changeHandleCost
     * 
     */
    @JsonProperty("change_handle_cost")
    private String changeHandleCost;
    /**
     * companyChangeServiceCost
     * 
     */
    @JsonProperty("company_change_service_cost")
    private String companyChangeServiceCost;
    /**
     * companyRealPay
     * 
     */
    @JsonProperty("company_real_pay")
    private String companyRealPay;
    /**
     * companyTicketCost
     * 
     */
    @JsonProperty("company_ticket_cost")
    private String companyTicketCost;
    /**
     * companyUpgradeCost
     * 
     */
    @JsonProperty("company_upgrade_cost")
    private String companyUpgradeCost;
    /**
     * constructionCost
     * 
     */
    @JsonProperty("construction_cost")
    private String constructionCost;
    /**
     * createTime
     * 
     */
    @JsonProperty("create_time")
    private String createTime;
    /**
     * currentCarbonEmission
     * 
     */
    @JsonProperty("current_carbon_emission")
    private String currentCarbonEmission;
    /**
     * daysInAdvance
     * 
     */
    @JsonProperty("days_in_advance")
    private Integer daysInAdvance;
    /**
     * department
     * 
     */
    @JsonProperty("department")
    private String department;
    /**
     * departmentId
     * 
     */
    @JsonProperty("department_id")
    private String departmentId;
    /**
     * departureAirportCode
     * 
     */
    @JsonProperty("departure_airport_code")
    private String departureAirportCode;
    /**
     * departureAirportName
     * 
     */
    @JsonProperty("departure_airport_name")
    private String departureAirportName;
    /**
     * departureCityId
     * 
     */
    @JsonProperty("departure_city_id")
    private String departureCityId;
    /**
     * departureCityName
     * 
     */
    @JsonProperty("departure_city_name")
    private String departureCityName;
    /**
     * departureTime
     * 
     */
    @JsonProperty("departure_time")
    private String departureTime;
    /**
     * discount
     * 
     */
    @JsonProperty("discount")
    private String discount;
    /**
     * economyOriginalCost
     * 
     */
    @JsonProperty("economy_original_cost")
    private String economyOriginalCost;
    /**
     * employeeNumber
     * 
     */
    @JsonProperty("employee_number")
    private String employeeNumber;
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
     * exceptionInfo
     * 
     */
    @JsonProperty("exception_info")
    private String exceptionInfo;
    /**
     * excludingServiceFee
     * 
     */
    @JsonProperty("excluding_service_fee")
    private BigDecimal excludingServiceFee;
    /**
     * exemptReason
     * 
     */
    @JsonProperty("exempt_reason")
    private String exemptReason;
    /**
     * exemptType
     * 
     */
    @JsonProperty("exempt_type")
    private String exemptType;
    /**
     * extendInfo
     * 
     */
    @JsonProperty("extend_info")
    private String extendInfo;
    /**
     * extraInfo
     * 
     */
    @JsonProperty("extra_info")
    private String extraInfo;
    /**
     * finalDepartureTime
     * 
     */
    @JsonProperty("final_departure_time")
    private String finalDepartureTime;
    /**
     * finalOfflineStatus
     * 
     */
    @JsonProperty("final_offline_status")
    private String finalOfflineStatus;
    /**
     * flightDistance
     * 
     */
    @JsonProperty("flight_distance")
    private String flightDistance;
    /**
     * flightNumber
     * 
     */
    @JsonProperty("flight_number")
    private String flightNumber;
    /**
     * flightSegmentNumber
     * 
     */
    @JsonProperty("flight_segment_number")
    private Integer flightSegmentNumber;
    /**
     * flightSegmentTravel
     * 
     */
    @JsonProperty("flight_segment_travel")
    private String flightSegmentTravel;
    /**
     * flightTravelType
     * 
     */
    @JsonProperty("flight_travel_type")
    private Integer flightTravelType;
    /**
     * fuelCost
     * 
     */
    @JsonProperty("fuelCost")
    private String fuelCost;
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
     * institutionId
     * 
     */
    @JsonProperty("institution_id")
    private Long institutionId;
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
     * invoiceFee
     * 
     */
    @JsonProperty("invoice_fee")
    private String invoiceFee;
    /**
     * isAdded
     * 
     */
    @JsonProperty("is_added")
    private Integer isAdded;
    /**
     * isAgreement
     * 
     */
    @JsonProperty("is_agreement")
    private String isAgreement;
    /**
     * isDiscountTicket
     * 
     */
    @JsonProperty("is_discount_ticket")
    private String isDiscountTicket;
    /**
     * isSensitive
     * 
     */
    @JsonProperty("is_sensitive")
    private String isSensitive;
    /**
     * isTraveler
     * 
     */
    @JsonProperty("is_traveler")
    private String isTraveler;
    /**
     * lastupdateTime
     * 
     */
    @JsonProperty("lastupdate_time")
    private String lastupdateTime;
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
     * mainFlightNumber
     * 
     */
    @JsonProperty("main_flight_number")
    private String mainFlightNumber;
    /**
     * memberId
     * 
     */
    @JsonProperty("member_id")
    private String memberId;
    /**
     * orderFixSettleTime
     * 
     */
    @JsonProperty("order_fix_settle_time")
    private String orderFixSettleTime;
    /**
     * orderFixType
     * 
     */
    @JsonProperty("order_fix_type")
    private Integer orderFixType;
    /**
     * orderId
     * 
     */
    @JsonProperty("order_id")
    private String orderId;
    /**
     * originOrderId
     * 
     */
    @JsonProperty("origin_order_id")
    private String originOrderId;
    /**
     * originTicketId
     * 
     */
    @JsonProperty("origin_ticket_id")
    private String originTicketId;
    /**
     * outLegalEntityId
     * 
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
    /**
     * outRequisitionId
     * 
     */
    @JsonProperty("out_requisition_id")
    private String outRequisitionId;
    /**
     * parentInstitutionId
     * 
     */
    @JsonProperty("parent_institution_id")
    private Long parentInstitutionId;
    /**
     * parentInstitutionName
     * 
     */
    @JsonProperty("parent_institution_name")
    private String parentInstitutionName;
    /**
     * passengerDepCode
     * 
     */
    @JsonProperty("passenger_dep_code")
    private String passengerDepCode;
    /**
     * passengerDepName
     * 
     */
    @JsonProperty("passenger_dep_name")
    private String passengerDepName;
    /**
     * passengerGroup1Code
     * 
     */
    @JsonProperty("passenger_group_1_code")
    private String passengerGroup1Code;
    /**
     * passengerGroup1Name
     * 
     */
    @JsonProperty("passenger_group_1_name")
    private String passengerGroup1Name;
    /**
     * passengerGroup2Code
     * 
     */
    @JsonProperty("passenger_group_2_code")
    private String passengerGroup2Code;
    /**
     * passengerGroup2Name
     * 
     */
    @JsonProperty("passenger_group_2_name")
    private String passengerGroup2Name;
    /**
     * passengerGroup3Code
     * 
     */
    @JsonProperty("passenger_group_3_code")
    private String passengerGroup3Code;
    /**
     * passengerGroup3Name
     * 
     */
    @JsonProperty("passenger_group_3_name")
    private String passengerGroup3Name;
    /**
     * passengerGroup4Code
     * 
     */
    @JsonProperty("passenger_group_4_code")
    private String passengerGroup4Code;
    /**
     * passengerGroup4Name
     * 
     */
    @JsonProperty("passenger_group_4_name")
    private String passengerGroup4Name;
    /**
     * passengerGroup5Code
     * 
     */
    @JsonProperty("passenger_group_5_code")
    private String passengerGroup5Code;
    /**
     * passengerGroup5Name
     * 
     */
    @JsonProperty("passenger_group_5_name")
    private String passengerGroup5Name;
    /**
     * passengerGroup6Code
     * 
     */
    @JsonProperty("passenger_group_6_code")
    private String passengerGroup6Code;
    /**
     * passengerGroup6Name
     * 
     */
    @JsonProperty("passenger_group_6_name")
    private String passengerGroup6Name;
    /**
     * passengerGroup7Code
     * 
     */
    @JsonProperty("passenger_group_7_code")
    private String passengerGroup7Code;
    /**
     * passengerGroup7Name
     * 
     */
    @JsonProperty("passenger_group_7_name")
    private String passengerGroup7Name;
    /**
     * passengerGroup8Code
     * 
     */
    @JsonProperty("passenger_group_8_code")
    private String passengerGroup8Code;
    /**
     * passengerGroup8Name
     * 
     */
    @JsonProperty("passenger_group_8_name")
    private String passengerGroup8Name;
    /**
     * passengerGroup9Code
     * 
     */
    @JsonProperty("passenger_group_9_code")
    private String passengerGroup9Code;
    /**
     * passengerGroup9Name
     * 
     */
    @JsonProperty("passenger_group_9_name")
    private String passengerGroup9Name;
    /**
     * passengerLegalEntityId
     * 
     */
    @JsonProperty("passenger_legal_entity_id")
    private Long passengerLegalEntityId;
    /**
     * passengerLegalEntityName
     * 
     */
    @JsonProperty("passenger_legal_entity_name")
    private String passengerLegalEntityName;
    /**
     * passengerMemberId
     * 
     */
    @JsonProperty("passenger_member_id")
    private Long passengerMemberId;
    /**
     * passengerMemberName
     * 
     */
    @JsonProperty("passenger_member_name")
    private String passengerMemberName;
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
     * passengerParentPathDepName
     * 
     */
    @JsonProperty("passenger_parent_path_dep_name")
    private String passengerParentPathDepName;
    /**
     * payChannel
     * 
     */
    @JsonProperty("pay_channel")
    private String payChannel;
    /**
     * payType
     * 
     */
    @JsonProperty("pay_type")
    private String payType;
    /**
     * personalChangeServiceCost
     * 
     */
    @JsonProperty("personal_change_service_cost")
    private String personalChangeServiceCost;
    /**
     * personalRealPay
     * 
     */
    @JsonProperty("personal_real_pay")
    private String personalRealPay;
    /**
     * personalTicketCost
     * 
     */
    @JsonProperty("personal_ticket_cost")
    private String personalTicketCost;
    /**
     * personalUpgradeCost
     * 
     */
    @JsonProperty("personal_upgrade_cost")
    private String personalUpgradeCost;
    /**
     * pnrNumber
     * 
     */
    @JsonProperty("pnr_number")
    private String pnrNumber;
    /**
     * preOrderId
     * 
     */
    @JsonProperty("pre_order_id")
    private String preOrderId;
    /**
     * projectExtInfo
     * 
     */
    @JsonProperty("project_ext_info")
    private String projectExtInfo;
    /**
     * rankName
     * 
     */
    @JsonProperty("rank_name")
    private String rankName;
    /**
     * rcBook
     * 
     */
    @JsonProperty("rc_book")
    private String rcBook;
    /**
     * rcDistancePeriod
     * 
     */
    @JsonProperty("rc_distance_period")
    private String rcDistancePeriod;
    /**
     * rcLevel
     * 
     */
    @JsonProperty("rc_level")
    private String rcLevel;
    /**
     * rcLowPrice
     * 
     */
    @JsonProperty("rc_lowPrice")
    private String rcLowPrice;
    /**
     * rcTimePeriod
     * 
     */
    @JsonProperty("rc_time_period")
    private String rcTimePeriod;
    /**
     * reason
     * 
     */
    @JsonProperty("reason")
    private String reason;
    /**
     * rebook
     * 
     */
    @JsonProperty("rebook")
    private String rebook;
    /**
     * reductionCarbonEmission
     * 
     */
    @JsonProperty("reduction_carbon_emission")
    private String reductionCarbonEmission;
    /**
     * reductionFee
     * 
     */
    @JsonProperty("reduction_fee")
    private BigDecimal reductionFee;
    /**
     * refundHandleCost
     * 
     */
    @JsonProperty("refund_handle_cost")
    private String refundHandleCost;
    /**
     * remark
     * 
     */
    @JsonProperty("remark")
    private String remark;
    /**
     * requisitionId
     * 
     */
    @JsonProperty("requisition_id")
    private String requisitionId;
    /**
     * serviceFee
     * 
     */
    @JsonProperty("service_fee")
    private String serviceFee;
    /**
     * settleTime
     * 
     */
    @JsonProperty("settle_time")
    private String settleTime;
    /**
     * settlementTime
     * 
     */
    @JsonProperty("settlement_time")
    private String settlementTime;
    /**
     * subAccountCompanyName
     * 
     */
    @JsonProperty("sub_account_company_name")
    private String subAccountCompanyName;
    /**
     * subCompanyNo
     * 
     */
    @JsonProperty("sub_company_no")
    private String subCompanyNo;
    /**
     * supplierOrderId
     * 
     */
    @JsonProperty("supplier_order_id")
    private String supplierOrderId;
    /**
     * supplierTicketNumber
     * 
     */
    @JsonProperty("supplier_ticket_number")
    private String supplierTicketNumber;
    /**
     * ticketFee
     * 
     */
    @JsonProperty("ticket_fee")
    private String ticketFee;
    /**
     * ticketIdText
     * 
     */
    @JsonProperty("ticket_id_text")
    private String ticketIdText;
    /**
     * totalFee
     * 
     */
    @JsonProperty("total_fee")
    private String totalFee;
    /**
     * trainComparePrice
     * 
     */
    @JsonProperty("train_compare_price")
    private BigDecimal trainComparePrice;
    /**
     * transactionType
     * 
     */
    @JsonProperty("transaction_type")
    private Integer transactionType;
    /**
     * travelItineraryFee
     * 
     */
    @JsonProperty("travel_itinerary_fee")
    private String travelItineraryFee;
    /**
     * travelPurpose
     * 
     */
    @JsonProperty("travel_purpose")
    private String travelPurpose;
    /**
     * tripDescription
     * 
     */
    @JsonProperty("trip_description")
    private String tripDescription;
    /**
     * tripReason
     * 
     */
    @JsonProperty("trip_reason")
    private String tripReason;
    /**
     * uniqueKey
     * 
     */
    @JsonProperty("unique_key")
    private String uniqueKey;
    /**
     * unusualContent
     * 
     */
    @JsonProperty("unusual_content")
    private String unusualContent;
    /**
     * unusualReason
     * 
     */
    @JsonProperty("unusual_reason")
    private String unusualReason;
    /**
     * unusualRemark
     * 
     */
    @JsonProperty("unusual_remark")
    private String unusualRemark;
    /**
     * unusualType
     * 
     */
    @JsonProperty("unusual_type")
    private String unusualType;
    /**
     * upgradeCost
     * 
     */
    @JsonProperty("upgrade_cost")
    private String upgradeCost;
    /**
     * upgradeFinalStatus
     * 
     */
    @JsonProperty("upgrade_final_status")
    private Integer upgradeFinalStatus;
}

