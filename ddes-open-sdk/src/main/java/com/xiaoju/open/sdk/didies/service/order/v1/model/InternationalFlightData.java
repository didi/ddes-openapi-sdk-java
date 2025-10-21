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
public class InternationalFlightData  {

    /**
     * 国际机票数据-订单列表
     * 
     */
    @JsonProperty("order_list")
    private List<InternationalFlightOrderListItem> orderList;
}

