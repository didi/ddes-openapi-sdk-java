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
public class CurAppRover  {

    /**
     * 人员类型主键；英文枚举：employee_number ，email  ，phone
     * 
     */
    @JsonProperty("type")
    private String type;
    /**
     * 人员主键对应的值
     * 
     */
    @JsonProperty("value")
    private String value;
}

