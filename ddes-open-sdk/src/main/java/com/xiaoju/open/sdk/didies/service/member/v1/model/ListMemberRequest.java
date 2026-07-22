package com.xiaoju.open.sdk.didies.service.member.v1.model;

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
public class ListMemberRequest extends BaseReq  {

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
     * realname
     * 
     */
    @JsonProperty("realname")
    private String realname;
    /**
     * phone
     * 
     */
    @JsonProperty("phone")
    private String phone;
    /**
     * lastId
     * 
     */
    @JsonProperty("last_id")
    private String lastId;
    /**
     * employeeNumber
     * 
     */
    @JsonProperty("employee_number")
    private String employeeNumber;
    /**
     * email
     * 
     */
    @JsonProperty("email")
    private String email;
    /**
     * status
     * 
     */
    @JsonProperty("status")
    private String status;
    /**
     * 归属企业名称（查询参数）
     *
     */
    @JsonProperty("belong_enterprise_name")
    private String belongEnterpriseName;
    /**
     * 纳税人识别号（查询参数）
     *
     */
    @JsonProperty("taxpayer_no")
    private String taxpayerNo;
    /**
     * 是否查询子公司（查询参数）
     *
     */
    @JsonProperty("query_sub_company")
    private String querySubCompany;
    /**
     * 下一页token（查询参数）
     *
     */
    @JsonProperty("next_token")
    private String nextToken;
}

