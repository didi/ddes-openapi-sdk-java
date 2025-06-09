package com.xiaoju.open.sdk.didies.service.afterapproval.v1.model;

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
public class GetPersonalReceiptOrderRequest extends BaseReq  {

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
     * offset
     * 
     */
    @JsonProperty("offset")
    private String offset;
    /**
     * length
     * 
     */
    @JsonProperty("length")
    private String length;
    /**
     * type
     * 
     */
    @JsonProperty("type")
    private Integer type;
    /**
     * phone
     * 
     */
    @JsonProperty("phone")
    private String phone;
    /**
     * queryTimeType
     * 
     */
    @JsonProperty("query_time_type")
    private Integer queryTimeType;
    /**
     * startDate
     * 
     */
    @JsonProperty("start_date")
    private String startDate;
    /**
     * status
     * 
     */
    @JsonProperty("status")
    private Integer status;
}

