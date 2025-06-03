package com.xiaoju.open.sdk.didies.service.approval.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.TravelCity;
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
public class HotelRule  {

    /**
     * ruleId
     * 
     */
    @JsonProperty("rule_id")
    private String ruleId;
    /**
     * ruleName
     * 
     */
    @JsonProperty("rule_name")
    private String ruleName;
    /**
     * ruleStatus
     * 
     */
    @JsonProperty("rule_status")
    private String ruleStatus;
    /**
     * cityList
     * 
     */
    @JsonProperty("city_list")
    private List<TravelCity> cityList;
    /**
     * totalCount
     * 
     */
    @JsonProperty("total_count")
    private Integer totalCount;
    /**
     * availableCount
     * 
     */
    @JsonProperty("available_count")
    private Integer availableCount;
    /**
     * startTime
     * 
     */
    @JsonProperty("start_time")
    private String startTime;
    /**
     * endTime
     * 
     */
    @JsonProperty("end_time")
    private String endTime;
}

