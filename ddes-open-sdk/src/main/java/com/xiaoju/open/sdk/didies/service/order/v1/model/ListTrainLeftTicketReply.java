package com.xiaoju.open.sdk.didies.service.order.v1.model;

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
public class ListTrainLeftTicketReply  {

    /**
     * 车次详细信息
     * 
     */
    @JsonProperty("list")
    private List<TrainLeftTicketListItem> _list;
}

