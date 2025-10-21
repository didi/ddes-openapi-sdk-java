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
public class SrvPackListItem  {

    /**
     * 服务包使用人员
     * 
     */
    @JsonProperty("passenger_traveler_id")
    private Integer passengerTravelerId;
    /**
     * 服务包订单号
     * 
     */
    @JsonProperty("srv_pack_order_id")
    private Integer srvPackOrderId;
    /**
     * 服务包金额，单位分
     * 
     */
    @JsonProperty("price_amount")
    private Integer priceAmount;
    /**
     * 服务包内容
     * 
     */
    @JsonProperty("data")
    private List<ServicePackageContent> data;
}

