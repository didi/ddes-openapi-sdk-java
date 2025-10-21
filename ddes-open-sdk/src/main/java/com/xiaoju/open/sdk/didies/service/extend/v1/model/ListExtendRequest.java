package com.xiaoju.open.sdk.didies.service.extend.v1.model;

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
public class ListExtendRequest extends BaseReq  {

    /**
     * rootCode
     * 
     */
    @JsonProperty("root_code")
    private String rootCode;
    /**
     * companyId
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
}

