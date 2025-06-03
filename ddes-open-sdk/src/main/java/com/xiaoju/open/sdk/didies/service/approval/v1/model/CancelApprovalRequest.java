package com.xiaoju.open.sdk.didies.service.approval.v1.model;

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
public class CancelApprovalRequest extends BaseReq  {

    /**
     * 滴滴公司 ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 滴滴申请单ID，approval_id与out_approval_id同时存在时，以approval_id为准
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
    /**
     * 强制取消标志，1，是（需要开白名单）0，否
     * 
     */
    @JsonProperty("is_force")
    private Integer isForce;
    /**
     * 外部申请单ID，客户侧申请单ID，不大于 120 字符。eg: TA_100002，与返回中的approvalid一一对应
     * @deprecated
     */
    @JsonProperty("out_approval_id")
    private String outApprovalId;
}

