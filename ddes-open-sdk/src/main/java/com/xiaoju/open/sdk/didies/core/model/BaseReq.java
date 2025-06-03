package com.xiaoju.open.sdk.didies.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseReq  {

    /**
     * accessToken
     * 
     */
    @JsonProperty("access_token")
    private String accessToken;
    /**
     * sign
     * 
     */
    @JsonProperty("sign")
    private String sign;
    /**
     * clientId
     * 
     */
    @JsonProperty("client_id")
    private String clientId;
    /**
     * timestamp
     * 
     */
    @JsonProperty("timestamp")
    private String timestamp;
}

