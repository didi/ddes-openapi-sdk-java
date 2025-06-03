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
public class H5Invoice  {

    /**
     * 跳转地址为invoice
     * 
     */
    @JsonProperty("jumpPage")
    private String jumpPage;
}

