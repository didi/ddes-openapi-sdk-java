package com.xiaoju.open.sdk.didies.service.login.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class H5CharteredCar  {

    /**
     * 制度规则 id
     * 
     */
    @JsonProperty("rule_id")
    private String ruleId;
    /**
     * 跳转地址为: homeAddress
     * 
     */
    @JsonProperty("jumpPage")
    private String jumpPage;
    /**
     * 差旅、申请用车，必传
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
}

