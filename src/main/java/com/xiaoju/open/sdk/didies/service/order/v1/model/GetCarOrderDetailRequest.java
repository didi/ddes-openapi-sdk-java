package com.xiaoju.open.sdk.didies.service.order.v1.model;

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
public class GetCarOrderDetailRequest extends BaseReq  {

    /**
     * companyId
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * needAbnormalMsg
     * 
     */
    @JsonProperty("need_abnormal_msg")
    private Integer needAbnormalMsg;
    /**
     * needRuleInfo
     * 
     */
    @JsonProperty("need_rule_info")
    private Integer needRuleInfo;
    /**
     * needCallEmployeeNumber
     * 
     */
    @JsonProperty("need_call_employee_number")
    private Integer needCallEmployeeNumber;
    /**
     * orderId
     * 
     */
    @JsonProperty("order_id")
    private String orderId;
}

