package com.xiaoju.open.sdk.didies.service.legalentity.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateLegalEntityReply  {

    /**
     * 公司主体id
     * 
     */
    @JsonProperty("legal_entity_id")
    private String legalEntityId;
}

