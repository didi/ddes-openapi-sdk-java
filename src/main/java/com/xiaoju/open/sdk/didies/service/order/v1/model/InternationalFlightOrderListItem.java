package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.order.v1.model.FlightOrderPassengerItem;
import com.xiaoju.open.sdk.didies.service.order.v1.model.FlightOrderRcListItem;
import com.xiaoju.open.sdk.didies.service.order.v1.model.FlightOrderSrvPackInfo;
import com.xiaoju.open.sdk.didies.service.order.v1.model.InterFlightOrderChangeListItem;
import com.xiaoju.open.sdk.didies.service.order.v1.model.InterFlightOrderInfo;
import com.xiaoju.open.sdk.didies.service.order.v1.model.InterFlightOrderPriceInfo;
import com.xiaoju.open.sdk.didies.service.order.v1.model.InterFlightOrderRefundListItem;
import com.xiaoju.open.sdk.didies.service.order.v1.model.InterFlightOrderTicketListItem;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class InternationalFlightOrderListItem  {

    /**
     * orderInfo
     * 
     */
    @JsonProperty("order_info")
    private InterFlightOrderInfo orderInfo;
    /**
     * 票张详情
     * 
     */
    @JsonProperty("ticket_list")
    private List<InterFlightOrderTicketListItem> ticketList;
    /**
     * 改签信息
     * 
     */
    @JsonProperty("change_list")
    private List<InterFlightOrderChangeListItem> changeList;
    /**
     * 退票信息
     * 
     */
    @JsonProperty("refund_list")
    private List<InterFlightOrderRefundListItem> refundList;
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
    private InterFlightOrderPriceInfo priceInfo;
    /**
     * srvPackInfo
     * 
     */
    @JsonProperty("srv_pack_info")
    private FlightOrderSrvPackInfo srvPackInfo;
}

