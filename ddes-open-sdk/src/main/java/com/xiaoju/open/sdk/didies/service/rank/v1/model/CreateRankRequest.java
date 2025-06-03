package com.xiaoju.open.sdk.didies.service.rank.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.RankInfo;
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
public class CreateRankRequest extends BaseReq  {

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
    private RankInfo paramJsonObj;
}

