package com.xiaoju.open.sdk.didies.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
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

