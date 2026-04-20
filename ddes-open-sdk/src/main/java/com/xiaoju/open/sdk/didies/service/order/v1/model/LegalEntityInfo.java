package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LegalEntityInfo  {

    /**
     * 叫车人所属公司id
     * 
     */
    @JsonProperty("legal_entity_id")
    private String legalEntityId;
    /**
     * 叫车人所属公司业务编码
     * 
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
    /**
     * 叫车人所属公司名称
     * 
     */
    @JsonProperty("legal_entity_name")
    private String legalEntityName;
}

