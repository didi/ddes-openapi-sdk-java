package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OrderPassengerInfo  {

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
     * 乘客唯一值
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
     * 外部出行人唯一ID
     * 
     */
    @JsonProperty("out_traveler_id")
    private String outTravelerId;
    /**
     * 外部员工标记，枚举值数字：0 内部员工 1 外部员工
     * 
     */
    @JsonProperty("is_traveler")
    private Integer isTraveler;
    /**
     * costShare
     * 
     */
    @JsonProperty("cost_share")
    private CostShare costShare;
}

