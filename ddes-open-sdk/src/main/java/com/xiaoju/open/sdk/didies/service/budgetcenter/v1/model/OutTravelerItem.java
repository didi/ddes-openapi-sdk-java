package com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model;

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
public class OutTravelerItem  {

    /**
     * 外部出行人编码
     *
     */
    @JsonProperty("out_traveler_id")
    private String outTravelerId;
    /**
     * 外部出行人滴滴侧ID
     *
     */
    @JsonProperty("id")
    private Long id;
    /**
     * 关联员工列表，最多20个
     *
     */
    @JsonProperty("related_employees")
    private List<RelatedEmployeeItem> relatedEmployees;
}
