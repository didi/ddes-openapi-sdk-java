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
public class RelatedEmployeeInfo  {

    /**
     * 关联员工滴滴ID
     *
     */
    @JsonProperty("related_employee_id")
    private String relatedEmployeeId;
    /**
     * 关联员工手机号
     *
     */
    @JsonProperty("related_employee_phone")
    private String relatedEmployeePhone;
    /**
     * 关联员工工号
     *
     */
    @JsonProperty("related_employee_employee_number")
    private String relatedEmployeeEmployeeNumber;
    /**
     * 关联员工邮箱
     *
     */
    @JsonProperty("related_employee_email")
    private String relatedEmployeeEmail;
}
