package com.xiaoju.open.sdk.didies.service.order.v1.model;

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
public class FlightOrderPassengerInfo  {

    /**
     * 乘客姓名
     * 
     */
    @JsonProperty("passenger_name")
    private String passengerName;
    /**
     * 乘客手机号
     * 
     */
    @JsonProperty("passenger_phone")
    private String passengerPhone;
    /**
     * 乘客唯一值，内部员工同memberId
     * 
     */
    @JsonProperty("passenger_traveler_id")
    private String passengerTravelerId;
    /**
     * 乘客员工编号
     * 
     */
    @JsonProperty("passenger_employee_id")
    private String passengerEmployeeId;
    /**
     * 外部员工标记，枚举值数字：1 外部员工 0 内部员工
     * 
     */
    @JsonProperty("is_traveler")
    private Integer isTraveler;
    /**
     * 成本中心名称，建议使用budget_center_list
     * 
     */
    @JsonProperty("budget_center_name")
    private String budgetCenterName;
    /**
     * 成本中心code，外部项目或部门code，建议使用budget_center_list
     * 
     */
    @JsonProperty("budget_center_code")
    private String budgetCenterCode;
    /**
     * 成本中心id，滴滴内部主键，建议使用budget_center_list
     * 
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * 多成本中心，参考budget_center_list对象
     * 
     */
    @JsonProperty("budget_center_list")
    private List<BudgetCenterListItem> budgetCenterList;
}

