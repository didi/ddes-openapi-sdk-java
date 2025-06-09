package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.order.v1.model.TrainOrderChangeListItem;
import com.xiaoju.open.sdk.didies.service.order.v1.model.TrainOrderGrabInfo;
import com.xiaoju.open.sdk.didies.service.order.v1.model.TrainOrderInfo;
import com.xiaoju.open.sdk.didies.service.order.v1.model.TrainOrderPassengerListItem;
import com.xiaoju.open.sdk.didies.service.order.v1.model.TrainOrderPriceInfo;
import com.xiaoju.open.sdk.didies.service.order.v1.model.TrainOrderRcListItem;
import com.xiaoju.open.sdk.didies.service.order.v1.model.TrainOrderRefundListItem;
import com.xiaoju.open.sdk.didies.service.order.v1.model.TrainOrderTicketListItem;
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

