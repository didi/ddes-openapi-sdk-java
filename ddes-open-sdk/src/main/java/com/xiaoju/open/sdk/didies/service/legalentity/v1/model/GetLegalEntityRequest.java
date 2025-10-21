package com.xiaoju.open.sdk.didies.service.legalentity.v1.model;

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
public class GetLegalEntityRequest extends BaseReq  {

    /**
     * legalEntityId
     * 
     */
    @JsonProperty("legal_entity_id")
    private String legalEntityId;
    /**
     * companyId
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * offset
     * 
     */
    @JsonProperty("offset")
    private Integer offset;
    /**
     * length
     * 
     */
    @JsonProperty("length")
    private Integer length;
    /**
     * keyword
     * 
     */
    @JsonProperty("keyword")
    private String keyword;
}

