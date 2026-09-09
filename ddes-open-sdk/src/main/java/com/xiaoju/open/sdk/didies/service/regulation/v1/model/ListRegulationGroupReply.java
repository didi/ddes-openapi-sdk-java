package com.xiaoju.open.sdk.didies.service.regulation.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaoju.open.sdk.didies.core.model.BaseGroupPageReply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;




@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ListRegulationGroupReply extends BaseGroupPageReply  {

    /**
     * 制度列表
     *
     */
    @JsonProperty("records")
    private List<RegulationGroupRecord> records;
}
