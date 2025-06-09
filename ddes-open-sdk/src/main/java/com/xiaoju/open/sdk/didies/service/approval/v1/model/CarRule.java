package com.xiaoju.open.sdk.didies.service.approval.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;



@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CarRule  {

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
    private Integer ruleStatus;
    /**
     * cityId
     * 
     */
    @JsonProperty("city_id")
    private String cityId;
    /**
     * cityName
     * 
     */
    @JsonProperty("city_name")
    private String cityName;
    /**
     * useScene
     * 
     */
    @JsonProperty("use_scene")
    private Integer useScene;
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
     * totalMoney
     * 
     */
    @JsonProperty("total_money")
    private BigDecimal totalMoney;
    /**
     * availableMoney
     * 
     */
    @JsonProperty("available_money")
    private BigDecimal availableMoney;
    /**
     * perorderMoney
     * 
     */
    @JsonProperty("perorder_money")
    private BigDecimal perorderMoney;
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

