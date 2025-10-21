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
public class TrainOrderListItem  {

    /**
     * orderInfo
     * 
     */
    @JsonProperty("order_info")
    private TrainOrderInfo orderInfo;
    /**
     * priceInfo
     * 
     */
    @JsonProperty("price_info")
    private TrainOrderPriceInfo priceInfo;
    /**
     * 火车票基本信息
     * 
     */
    @JsonProperty("ticket_list")
    private List<TrainOrderTicketListItem> ticketList;
    /**
     * 抢票基本信息
     * 
     */
    @JsonProperty("grab_info")
    private List<TrainOrderGrabInfo> grabInfo;
    /**
     * 改签信息
     * 
     */
    @JsonProperty("change_list")
    private List<TrainOrderChangeListItem> changeList;
    /**
     * 退票信息
     * 
     */
    @JsonProperty("refund_list")
    private List<TrainOrderRefundListItem> refundList;
    /**
     * 出行人信息
     * 
     */
    @JsonProperty("passenger_list")
    private List<TrainOrderPassengerListItem> passengerList;
    /**
     * 管控信息
     * 
     */
    @JsonProperty("rc_list")
    private List<TrainOrderRcListItem> rcList;
}

