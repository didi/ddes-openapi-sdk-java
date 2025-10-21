package com.xiaoju.open.sdk.didies.service.approval.v1.model;

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
public class GetApprovalDetailRequest extends BaseReq  {

    /**
     * outApprovalId
     * 
     */
    @JsonProperty("out_approval_id")
    private String outApprovalId;
    /**
     * companyId
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * approvalId
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
}

