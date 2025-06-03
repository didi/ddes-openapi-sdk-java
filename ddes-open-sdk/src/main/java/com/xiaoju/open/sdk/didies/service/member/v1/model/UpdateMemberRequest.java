package com.xiaoju.open.sdk.didies.service.member.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.member.v1.model.MemberInfo;
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
public class UpdateMemberRequest extends BaseReq  {

    /**
     * 企业ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 员工在滴滴企业的ID，member_id或employee_number不能同时为空。优先级member_id高于employee_number
     * 
     */
    @JsonProperty("member_id")
    private Long memberId;
    /**
     * 员工工号
     * 
     */
    @JsonProperty("employee_number")
    private String employeeNumber;
    /**
     * 是否含有证件信息，是否含有证件信息，当传证件信息时，此字符传1，其他情况不传或传0
     * 
     */
    @JsonProperty("has_card_info")
    private Integer hasCardInfo;
    /**
     * 员工信息，详见 data
     * 
     */
    @JsonProperty("data")
    private String data;
    /**
     * dataObj
     * 
     */
    @JsonProperty("data__obj__")
    private MemberInfo dataObj;
}

