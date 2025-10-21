package com.xiaoju.open.sdk.didies.service.approval.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateApprovalReply  {

    /**
     * 申请应用时分配的AppKey
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
}

