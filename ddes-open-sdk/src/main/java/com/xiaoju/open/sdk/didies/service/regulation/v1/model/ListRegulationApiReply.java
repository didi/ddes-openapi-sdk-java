package com.xiaoju.open.sdk.didies.service.regulation.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaoju.open.sdk.didies.core.model.BaseResp;
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
public class ListRegulationApiReply extends BaseResp  {

    /**
     * 数据对象
     * 
     */
    @JsonProperty("data")
    private List<RegulationInfo> data;
}

