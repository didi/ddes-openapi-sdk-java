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
public class ApprovalDetail  {

    /**
     * approvalId
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
    /**
     * outApprovalId
     * 
     */
    @JsonProperty("out_approval_id")
    private String outApprovalId;
    /**
     * approvalType
     * 
     */
    @JsonProperty("approval_type")
    private Integer approvalType;
    /**
     * type
     * 
     */
    @JsonProperty("type")
    private Integer type;
    /**
     * budgetCenterId
     * 
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * reason
     * 
     */
    @JsonProperty("reason")
    private String reason;
    /**
     * extraInfo
     * 
     */
    @JsonProperty("extra_info")
    private String extraInfo;
    /**
     * startDate
     * 
     */
    @JsonProperty("start_date")
    private String startDate;
    /**
     * endDate
     * 
     */
    @JsonProperty("end_date")
    private String endDate;
    /**
     * approvalStatus
     * 
     */
    @JsonProperty("approval_status")
    private Integer approvalStatus;
    /**
     * sceneId
     * 
     */
    @JsonProperty("scene_id")
    private Integer sceneId;
    /**
     * cityType
     * 
     */
    @JsonProperty("city_type")
    private Integer cityType;
    /**
     * travelBudget
     * 
     */
    @JsonProperty("travel_budget")
    private TravelBudget travelBudget;
    /**
     * passengerList
     * 
     */
    @JsonProperty("passenger_list")
    private List<PassengerInfo> passengerList;
    /**
     * travelerList
     * 
     */
    @JsonProperty("traveler_list")
    private List<Traveler> travelerList;
    /**
     * applicant
     * 
     */
    @JsonProperty("applicant")
    private PassengerInfo applicant;
    /**
     * travelDetail
     * 
     */
    @JsonProperty("travel_detail")
    private String travelDetail;
    /**
     * businessTripDetail
     * 
     */
    @JsonProperty("business_trip_detail")
    private String businessTripDetail;
    /**
     * carRule
     * 
     */
    @JsonProperty("car_rule")
    private List<CarRule> carRule;
    /**
     * hotelRule
     * 
     */
    @JsonProperty("hotel_rule")
    private List<HotelRule> hotelRule;
    /**
     * flightRule
     * 
     */
    @JsonProperty("flight_rule")
    private List<FlightRule> flightRule;
    /**
     * trainRule
     * 
     */
    @JsonProperty("train_rule")
    private List<TrainRule> trainRule;
    /**
     * budgetCenterList
     * 
     */
    @JsonProperty("budget_center_list")
    private List<BudgetCenterListItem> budgetCenterList;
}

