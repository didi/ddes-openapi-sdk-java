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
public class UpdateMemberRequest extends BaseReq  {

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
     * 项目编码
     *
     */
    @JsonProperty("project_code")
    private String projectCode;
    /**
     * 项目名称
     *
     */
    @JsonProperty("project_name")
    private String projectName;
    /**
     * 员工ID，多个用逗号分隔，最多支持100个
     *
     */
    @JsonProperty("member_ids")
    private String memberIds;
    /**
     * 员工信息类型：0=手机号，1=员工编号，2=邮箱
     *
     */
    @JsonProperty("member_type")
    private Integer memberType;
    /**
     * 员工信息数据，对应member_type，多个用逗号分隔，最多支持100个
     *
     */
    @JsonProperty("member_values")
    private String memberValues;
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
