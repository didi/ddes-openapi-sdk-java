package com.xiaoju.open.sdk.didies.service.approval.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalPassReply  {

    /**
     * 审批单号
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
    /**
     * errorInfoList
     * 
     */
    @JsonProperty("error_info_list")
    private List<ErrorInfoListItem> errorInfoList;
}

