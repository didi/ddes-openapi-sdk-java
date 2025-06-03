package com.xiaoju.open.sdk.didies.service.legalentity.v1.model;

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
public class DelLegalEntityRequest extends BaseReq  {

    /**
     * 企业ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 需要删除的公司主体滴滴id，公司主体滴滴id和外部公司主体编号二者之一必填
     * 
     */
    @JsonProperty("legal_entity_id")
    private String legalEntityId;
    /**
     * 需要删除的外部公司主体编号，不可重复，滴滴后台有效的公司ID不重复
     * 
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
}

