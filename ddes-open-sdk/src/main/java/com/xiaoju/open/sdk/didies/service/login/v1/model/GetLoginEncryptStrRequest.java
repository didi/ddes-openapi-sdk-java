package com.xiaoju.open.sdk.didies.service.login.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaoju.open.sdk.didies.core.model.BaseReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;




@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GetLoginEncryptStrRequest extends BaseReq  {

    /**
     * appType
     * 
     */
    @JsonProperty("app_type")
    private String appType;
    /**
     * productType
     * 
     */
    @JsonProperty("product_type")
    private Integer productType;
    /**
     * companyId
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * phone
     * 
     */
    @JsonProperty("phone")
    private String phone;
    /**
     * employeeNumber
     * 
     */
    @JsonProperty("employee_number")
    private String employeeNumber;
    /**
     * email
     * 
     */
    @JsonProperty("email")
    private String email;
}

