package com.xiaoju.open.sdk.didies.service.project.v1.model;

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
public class OutTravelerListReply  {

    /**
     * 外部出行人列表
     *
     */
    @JsonProperty("out_travelers")
    private List<OutTravelerInfo> outTravelers;
    /**
     * 此次查询符合条件的人员总数
     *
     */
    @JsonProperty("total")
    private Long total;
}
