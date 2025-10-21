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
public class GetTrainOrderDetailReply  {

    /**
     * 符合查询条件的数据总数
     * 
     */
    @JsonProperty("total")
    private Integer total;
    /**
     * domestictrainData
     * 
     */
    @JsonProperty("domestictrain_data")
    private DomesticTrainData domestictrainData;
}

