package com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model;

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





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LeaderItem  {

    /**
     * 主管ID
     * 
     */
    @JsonProperty("leader_id")
    private String leaderId;
    /**
     * 主管姓名
     * 
     */
    @JsonProperty("leader_name")
    private String leaderName;
    /**
     * 主管类型，枚举英文：major 主要主管 other 其他主管
     * 
     */
    @JsonProperty("leader_type")
    private String leaderType;
}

