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
public class GetNotGenBillDetailOfFlightRequest extends BaseReq  {

    /**
     * endDate
     * 
     */
    @JsonProperty("end_date")
    private String endDate;
    /**
     * companyId
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
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
     * outRequisitionId
     * 
     */
    @JsonProperty("out_requisition_id")
    private String outRequisitionId;
    /**
     * bookingMemberId
     * 
     */
    @JsonProperty("booking_member_id")
    private String bookingMemberId;
    /**
     * dateQueryType
     * 
     */
    @JsonProperty("date_query_type")
    private String dateQueryType;
    /**
     * startDate
     * 
     */
    @JsonProperty("start_date")
    private String startDate;
}

