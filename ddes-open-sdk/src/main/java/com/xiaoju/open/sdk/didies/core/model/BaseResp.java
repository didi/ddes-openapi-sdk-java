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
public class BaseResp  {

    /**
     * errno
     * 
     */
    @JsonProperty("errno")
    private Integer errno;
    /**
     * errmsg
     * 
     */
    @JsonProperty("errmsg")
    private String errmsg;
    /**
     * encryptData
     * 
     */
    @JsonProperty("encrypt_data")
    private String encryptData;
    /**
     * requestId
     * 
     */
    @JsonProperty("request_id")
    private String requestId;
}

