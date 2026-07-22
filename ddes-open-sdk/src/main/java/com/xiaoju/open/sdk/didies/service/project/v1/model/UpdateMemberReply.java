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
public class UpdateMemberReply  {

    /**
     * 成功绑定的员工ID数组
     *
     */
    @JsonProperty("success_data")
    private List<String> successData;
    /**
     * 失败的员工信息数组
     *
     */
    @JsonProperty("error_data")
    private List<UpdateMemberErrorInfo> errorData;
    /**
     * 成功绑定的员工值数组
     *
     */
    @JsonProperty("success_member_values")
    private List<String> successMemberValues;
}
