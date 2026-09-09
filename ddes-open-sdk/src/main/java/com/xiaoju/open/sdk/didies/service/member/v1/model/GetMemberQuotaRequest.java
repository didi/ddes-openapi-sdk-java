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
public class GetMemberQuotaRequest extends BaseReq  {

    /**
     * endDate
     * 
     */
    @JsonProperty("end_date")
    private String endDate;
    /**
     * companyId
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * memberIds
     * 
     */
    @JsonProperty("member_ids")
    private String memberIds;
    /**
     * employeeNumbers
     * 
     */
    @JsonProperty("employee_numbers")
    private String employeeNumbers;
    /**
     * startDate
     *
     */
    @JsonProperty("start_date")
    private String startDate;
    /**
     * 限额查询类型，1：仅查月限额（默认），2：查询所有限额（2026.02 限额接口升级）
     *
     */
    @JsonProperty("monthly_limit_only_query")
    private String monthlyLimitOnlyQuery;
    /**
     * 归属企业名称（查询参数），集团账户【上级公司统一对接】场景使用
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
}

