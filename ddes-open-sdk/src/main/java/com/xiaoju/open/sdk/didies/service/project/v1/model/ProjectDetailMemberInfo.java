package com.xiaoju.open.sdk.didies.service.project.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;




@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDetailMemberInfo  {

    /**
     * 员工在滴滴的id
     *
     */
    @JsonProperty("member_id")
    private String memberId;
    /**
     * 员工手机号
     *
     */
    @JsonProperty("phone")
    private String phone;
    /**
     * 员工工号
     *
     */
    @JsonProperty("employee_number")
    private String employeeNumber;
    /**
     * 员工邮箱
     *
     */
    @JsonProperty("email")
    private String email;
}
