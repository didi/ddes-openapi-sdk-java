package com.xiaoju.open.sdk.didies.service.project.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;




@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DelMemberErrorInfo  {

    /**
     * 错误原因
     *
     */
    @JsonProperty("error_msg")
    private String errorMsg;
    /**
     * 失败的员工ID数组
     *
     */
    @JsonProperty("error_member_ids")
    private List<String> errorMemberIds;
    /**
     * 失败的员工值数组
     *
     */
    @JsonProperty("error_member_values")
    private List<String> errorMemberValues;
}
