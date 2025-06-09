package com.xiaoju.open.sdk.didies.service.login.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class H5TravelList  {

    /**
     * 差旅/审批单id
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
    /**
     * 跳转地址为travelList
     * 
     */
    @JsonProperty("jumpPage")
    private String jumpPage;
}

