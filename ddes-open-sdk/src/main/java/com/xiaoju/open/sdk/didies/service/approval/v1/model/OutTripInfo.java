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





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OutTripInfo  {

    /**
     * 外部申请单开始时间，时间戳
     * 
     */
    @JsonProperty("begin_time")
    private Long beginTime;
    /**
     * 外部申请单结束时间，时间戳
     * 
     */
    @JsonProperty("end_time")
    private Long endTime;
    /**
     * 出差事由，滴滴首页卡片合并展示的事由
     * 
     */
    @JsonProperty("travel_purpose")
    private String travelPurpose;
}

