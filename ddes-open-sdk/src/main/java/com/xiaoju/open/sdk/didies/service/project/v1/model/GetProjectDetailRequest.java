package com.xiaoju.open.sdk.didies.service.project.v1.model;

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
public class GetProjectDetailRequest extends BaseReq  {

    /**
     * 企业ID
     *
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 项目ID
     *
     */
    @JsonProperty("project_id")
    private String projectId;
    /**
     * 项目名称
     *
     */
    @JsonProperty("project_name")
    private String projectName;
    /**
     * 项目编码
     *
     */
    @JsonProperty("project_code")
    private String projectCode;
    /**
     * 偏移量
     *
     */
    @JsonProperty("offset")
    private Integer offset;
    /**
     * 每页大小，最大为100，默认为20
     *
     */
    @JsonProperty("lenth")
    private Integer lenth;
    /**
     * 归属企业名称（集团账户参数）
     *
     */
    @JsonProperty("belong_enterprise_name")
    private String belongEnterpriseName;
    /**
     * 纳税人识别号（集团账户参数）
     *
     */
    @JsonProperty("taxpayer_no")
    private String taxpayerNo;
}
