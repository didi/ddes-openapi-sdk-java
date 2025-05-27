package com.xiaoju.open.sdk.didies.service.member.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.core.model.BaseReq;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class GetMemberQuotaRequest extends BaseReq  {

    /**
     * endDate
     * 
     */
    @JsonProperty("end_date")
    private String endDate;
    /**
     * companyId
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * memberIds
     * 
     */
    @JsonProperty("member_ids")
    private String memberIds;
    /**
     * employeeNumbers
     * 
     */
    @JsonProperty("employee_numbers")
    private String employeeNumbers;
    /**
     * startDate
     * 
     */
    @JsonProperty("start_date")
    private String startDate;
}

