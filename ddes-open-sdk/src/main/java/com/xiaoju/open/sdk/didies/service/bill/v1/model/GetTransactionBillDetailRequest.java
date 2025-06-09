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
public class GetTransactionBillDetailRequest extends BaseReq  {

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
     * lastId
     * 
     */
    @JsonProperty("last_id")
    private Integer lastId;
    /**
     * businessType
     * 
     */
    @JsonProperty("business_type")
    private Integer businessType;
    /**
     * length
     * 
     */
    @JsonProperty("length")
    private Integer length;
}

