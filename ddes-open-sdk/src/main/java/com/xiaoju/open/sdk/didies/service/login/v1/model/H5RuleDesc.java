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
public class H5RuleDesc  {

    /**
     * 制度id
     * 
     */
    @JsonProperty("institution_id")
    private String institutionId;
    /**
     * 跳转地址为ruleDesc
     * 
     */
    @JsonProperty("jumpPage")
    private String jumpPage;
}

