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
public class DomesticFlightOrderListItem  {

    /**
     * orderInfo
     * 
     */
    @JsonProperty("order_info")
    private DomesticFlightOrderInfo orderInfo;
    /**
     * 票张详情
     * 
     */
    @JsonProperty("ticket_list")
    private List<DomesticFlightOrderTicketListItem> ticketList;
    /**
     * 改签信息
     * 
     */
    @JsonProperty("change_list")
    private List<DomesticFlightOrderChangeListItem> changeList;
    /**
     * 退票信息
     * 
     */
    @JsonProperty("refund_list")
    private List<DomesticFlightOrderRefundListItem> refundList;
    /**
     * 出行人信息
     * 
     */
    @JsonProperty("passenger_list")
    private List<FlightOrderPassengerItem> passengerList;
    /**
     * 管控信息
     * 
     */
    @JsonProperty("rc_list")
    private List<FlightOrderRcListItem> rcList;
    /**
     * priceInfo
     * 
     */
    @JsonProperty("price_info")
    private DomesticFlightOrderPriceInfo priceInfo;
    /**
     * srvPackInfo
     * 
     */
    @JsonProperty("srv_pack_info")
    private FlightOrderSrvPackInfo srvPackInfo;
}

