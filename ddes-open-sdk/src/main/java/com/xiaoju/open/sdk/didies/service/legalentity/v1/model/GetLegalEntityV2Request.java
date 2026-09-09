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
public class GetLegalEntityV2Request extends BaseReq  {

    /**
     * companyId
     *
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * keyword，模糊查询条件，可使用 out_legal_entity_id 或 name 查询
     *
     */
    @JsonProperty("keyword")
    private String keyword;
    /**
     * legal_entity_id，滴滴侧公司主体 id 精准查询
     *
     */
    @JsonProperty("legal_entity_id")
    private String legalEntityId;
    /**
     * out_legal_entity_id，公司主体外部编号精准查询
     *
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
    /**
     * 数据开始位置，集团路径下必填
     *
     */
    @JsonProperty("offset")
    private Integer offset;
    /**
     * 数据条数（最大100条），集团路径下必填
     *
     */
    @JsonProperty("length")
    private Integer length;
    /**
     * 归属企业名称，集团账户【上级公司统一对接】定位子公司使用，与 taxpayer_no 二选一
     *
     */
    @JsonProperty("belong_enterprise_name")
    private String belongEnterpriseName;
    /**
     * 纳税人识别号，集团账户【上级公司统一对接】定位子公司使用，与 belong_enterprise_name 二选一
     *
     */
    @JsonProperty("taxpayer_no")
    private String taxpayerNo;
    /**
     * 是否查询下级公司数据，取值 "1"：查询当前公司以及下级公司数据，"0"：仅查询当前公司数据（默认值）。
     * 注意：文档标注为 boolean，但服务端按整数解析，实测传 "true" 会报 strconv.ParseInt 错误
     *
     */
    @JsonProperty("query_sub_company")
    private String querySubCompany;
    /**
     * 下一页的token，首次查询不传，后续从上一次响应的 nextToken 中获取
     *
     */
    @JsonProperty("next_token")
    private String nextToken;
}
