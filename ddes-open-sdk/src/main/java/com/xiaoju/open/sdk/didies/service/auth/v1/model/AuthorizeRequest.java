package com.xiaoju.open.sdk.didies.service.auth.v1.model;

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
public class AuthorizeRequest extends BaseReq  {

    /**
     * 申请应用时分配的AppSecret
     * 
     */
    @JsonProperty("client_secret")
    private String clientSecret;
    /**
     * 请求的类型，填写client_credentials
     * 
     */
    @JsonProperty("grant_type")
    private String grantType;
}

