package com.xiaoju.open.sdk.didies.service.approval.v1.model;

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
public class Traveler  {

    /**
     * name
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * phone
     * 
     */
    @JsonProperty("phone")
    private String phone;
    /**
     * passengerType
     * 
     */
    @JsonProperty("passenger_type")
    private String passengerType;
    /**
     * passengerNumber
     * 
     */
    @JsonProperty("passenger_number")
    private String passengerNumber;
    /**
     * email
     * 
     */
    @JsonProperty("email")
    private String email;
    /**
     * budgetCenterList
     * 
     */
    @JsonProperty("budget_center_list")
    private List<BudgetCenterListItem> budgetCenterList;
}

