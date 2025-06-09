package com.xiaoju.open.sdk.didies.service.afterapproval.v1.model;

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
public class CreatePersonalReceiptRequest extends BaseReq  {

    /**
     * 企业ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 订单号
     * 
     */
    @JsonProperty("order_id")
    private String orderId;
    /**
     * 审批类型 (0 - 驳回，1 - 通过，默认为0)
     * 
     */
    @JsonProperty("is_pass")
    private Integer isPass;
    /**
     * 审批人手机号 (不填时默认为企业超管)
     * 
     */
    @JsonProperty("approver_phone")
    private String approverPhone;
    /**
     * 备注，驳回原因或者通过备注，限制 120 个字符
     * 
     */
    @JsonProperty("remark")
    private String remark;
}

