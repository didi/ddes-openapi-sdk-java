package com.xiaoju.open.sdk.didies.service.approval.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfoListItem  {

    /**
     * errNo
     * 
     */
    @JsonProperty("err_no")
    private Integer errNo;
    /**
     * errMsg
     * 
     */
    @JsonProperty("err_msg")
    private String errMsg;
}

