package com.xiaoju.open.sdk.didies.service.outapproval.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.core.model.BaseReq;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class UpdateOutApprovalStatusRequest extends BaseReq  {

    /**
     * 企业ID，滴滴企业ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 外部审批单id，使用滴滴消息通知中的out_id
     * 
     */
    @JsonProperty("out_id")
    private String outId;
    /**
     * 审批单状态，0 驳回 1 通过
     * 
     */
    @JsonProperty("status")
    private Integer status;
    /**
     * approvalType
     * 
     */
    @JsonProperty("approval_type")
    private Integer approvalType;
}

