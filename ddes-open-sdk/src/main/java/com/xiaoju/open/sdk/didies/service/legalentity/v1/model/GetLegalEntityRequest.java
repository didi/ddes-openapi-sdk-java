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
    /**
     * 公司主体外部编号，可使用公司主体外部编号精准查询
     *
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
    /**
     * 归属企业名称（查询参数），集团账户【上级公司统一对接】场景使用，company_id传集团公司ID时可通过该字段确定处理哪个子公司的数据
     *
     */
    @JsonProperty("belong_enterprise_name")
    private String belongEnterpriseName;
    /**
     * 纳税人识别号（查询参数），集团账户【上级公司统一对接】场景使用，与belong_enterprise_name二选一
     *
     */
    @JsonProperty("taxpayer_no")
    private String taxpayerNo;
    /**
     * 是否查询下级公司数据（查询参数），集团账户【上级公司统一对接】场景使用，true：查询当前公司以及下级公司数据，false：仅查询当前公司数据（默认值）
     *
     */
    @JsonProperty("query_sub_company")
    private String querySubCompany;
}

