package com.xiaoju.open.sdk.didies.service.auth.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.core.model.BaseResp;
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
public class AuthorizeApiReply extends BaseResp  {

    /**
     * 接口获取授权后的access token
     * 
     */
    @JsonProperty("access_token")
    private String accessToken;
    /**
     * access_token的生命周期，单位是秒数
     * 
     */
    @JsonProperty("expires_in")
    private Integer expiresIn;
    /**
     * access_token类型  
     * 
     */
    @JsonProperty("token_type")
    private String tokenType;
    /**
     * 权限范围
     * 
     */
    @JsonProperty("scope")
    private String scope;
}

