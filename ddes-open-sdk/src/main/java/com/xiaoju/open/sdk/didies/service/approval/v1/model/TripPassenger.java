package com.xiaoju.open.sdk.didies.service.approval.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.BudgetCenterListItem;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TripPassenger  {

    /**
     * 出行人类型，枚举值数字：0：员工；1：外部出行人
     * 
     */
    @JsonProperty("passenger_type")
    private Integer passengerType;
    /**
     * 多成本中心
     * 
     */
    @JsonProperty("budget_center_list")
    private List<BudgetCenterListItem> budgetCenterList;
    /**
     * 出行人姓名/员工姓名
     * 
     */
    @JsonProperty("passenger_name")
    private String passengerName;
    /**
     * 出行人类型，0：手机号，passenger_phone 1：工号；employee_number 必填 2：邮箱：email 必填 默认为0 以 member_type 对应的值为准，其他字段传了不生效
     * 
     */
    @JsonProperty("member_type")
    private Integer memberType;
    /**
     * 员工手机号，举例：15100000000
     * 
     */
    @JsonProperty("passenger_phone")
    private String passengerPhone;
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
    /**
     * 外部出行人 ID
     * 
     */
    @JsonProperty("traveler_id")
    private String travelerId;
    /**
     * 执行政策指定项类型，1：out_rank_id 外部职级编号 2：employee_number 员工工号 3：employee_phone 员工手机号 4：employee_email 员工邮箱 5：regulation_id 制度I 指定生效policy_type_value内对应的值
     * @deprecated
     */
    @JsonProperty("policy_type")
    private Integer policyType;
    /**
     * 执行政策指定项
     * @deprecated
     */
    @JsonProperty("policy_type_value")
    private String policyTypeValue;
}

