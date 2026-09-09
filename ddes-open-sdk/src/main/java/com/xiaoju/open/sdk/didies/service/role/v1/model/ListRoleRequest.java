package com.xiaoju.open.sdk.didies.service.role.v1.model;

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
public class ListRoleRequest extends BaseReq  {

    /**
     * companyId
     *
     */
    @JsonProperty("company_id")
    private String companyId;
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

