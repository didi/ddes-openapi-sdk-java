package com.xiaoju.open.sdk.didies.service.traveler.v1.model;

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
public class CreateTravelerRequest extends BaseReq  {

    /**
     * 公司 ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 请求参数，(将 param_json 转为 json 字符串)
     * 
     */
    @JsonProperty("param_json")
    private String paramJson;
    /**
     * paramJsonObj
     * 
     */
    @JsonProperty("param_json__obj__")
    private TravelerInfo paramJsonObj;
    /**
     * 归属企业名称，集团账户【上级公司统一对接】场景使用
     *
     */
    @JsonProperty("belong_enterprise_name")
    private String belongEnterpriseName;
    /**
     * 纳税人识别号，集团账户【上级公司统一对接】场景使用，与belong_enterprise_name二选一
     *
     */
    @JsonProperty("taxpayer_no")
    private String taxpayerNo;
}

