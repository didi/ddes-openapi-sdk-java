package com.xiaoju.open.sdk.didies.service.bill.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaoju.open.sdk.didies.core.model.BaseReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;




@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GetBillDetailOfWangYCRequest extends BaseReq  {

    /**
     * billId
     * 
     */
    @JsonProperty("bill_id")
    private String billId;
    /**
     * companyId
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * departmentId
     * 
     */
    @JsonProperty("department_id")
    private String departmentId;
    /**
     * length
     * 
     */
    @JsonProperty("length")
    private Integer length;
    /**
     * budgetCenterId
     * 
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * billSplitGroupKey
     * 
     */
    @JsonProperty("bill_split_group_key")
    private String billSplitGroupKey;
    /**
     * type
     * 
     */
    @JsonProperty("type")
    private Integer type;
    /**
     * bookingMemberId
     * 
     */
    @JsonProperty("booking_member_id")
    private String bookingMemberId;
    /**
     * billSplitGroupType
     * 
     */
    @JsonProperty("bill_split_group_type")
    private Integer billSplitGroupType;
    /**
     * lastId
     * 
     */
    @JsonProperty("last_id")
    private String lastId;
    /**
     * businessType
     * 
     */
    @JsonProperty("business_type")
    private Integer businessType;
    /**
     * paymentPeriod
     * 
     */
    @JsonProperty("payment_period")
    private String paymentPeriod;
    /**
     * outRequisitionId
     * 
     */
    @JsonProperty("out_requisition_id")
    private String outRequisitionId;
    /**
     * billSplitType
     * 
     */
    @JsonProperty("bill_split_type")
    private Integer billSplitType;
}

