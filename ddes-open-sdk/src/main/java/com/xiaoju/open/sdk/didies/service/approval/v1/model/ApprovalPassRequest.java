package com.xiaoju.open.sdk.didies.service.approval.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.CurAppRover;
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
public class ApprovalPassRequest extends BaseReq  {

    /**
     * 企业ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 授权对象，授权对象枚举：1：订单 2：审批单
     * 
     */
    @JsonProperty("object_type")
    private Integer objectType;
    /**
     * 授权id，object_type对应对象的值 滴滴订单号或滴滴审批单号
     * 
     */
    @JsonProperty("object_id")
    private Long objectId;
    /**
     * 审批类型，审批类型枚举：4：个转企类型 21：企业级事前审批单用车
     * 
     */
    @JsonProperty("object_approval_type")
    private Integer objectApprovalType;
    /**
     * 审批类型，审批类型枚举：1：通过 2 拒绝
     * 
     */
    @JsonProperty("is_pass")
    private Integer isPass;
    /**
     * 当前审批人，举例：\&quot;{\\\&quot;type\\\&quot;:\\\&quot;phone\\\&quot;,\\\&quot;value\\\&quot;:\\\&quot;11100077098\\\&quot;}\&quot;
     * 
     */
    @JsonProperty("cur_approver")
    private String curApprover;
    /**
     * curApproverObj
     * 
     */
    @JsonProperty("cur_approver__obj__")
    private CurAppRover curApproverObj;
}

