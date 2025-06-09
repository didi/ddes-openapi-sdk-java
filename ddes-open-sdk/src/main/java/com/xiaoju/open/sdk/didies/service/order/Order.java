package com.xiaoju.open.sdk.didies.service.order;



import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.order.v1.model.GetCarOrderDetailApiReply;
import com.xiaoju.open.sdk.didies.service.order.v1.model.GetCarOrderDetailRequest;
import com.xiaoju.open.sdk.didies.service.order.v1.model.GetFlightEstimatePriceApiReply;
import com.xiaoju.open.sdk.didies.service.order.v1.model.GetFlightEstimatePriceRequest;
import com.xiaoju.open.sdk.didies.service.order.v1.model.GetFlightOrderDetailApiReply;
import com.xiaoju.open.sdk.didies.service.order.v1.model.GetFlightOrderDetailRequest;
import com.xiaoju.open.sdk.didies.service.order.v1.model.GetHotelOrderDetailApiReply;
import com.xiaoju.open.sdk.didies.service.order.v1.model.GetHotelOrderDetailRequest;
import com.xiaoju.open.sdk.didies.service.order.v1.model.GetOrderApiReply;
import com.xiaoju.open.sdk.didies.service.order.v1.model.GetOrderRequest;
import com.xiaoju.open.sdk.didies.service.order.v1.model.GetTrainOrderDetailApiReply;
import com.xiaoju.open.sdk.didies.service.order.v1.model.GetTrainOrderDetailRequest;
import com.xiaoju.open.sdk.didies.service.order.v1.model.ListOrderApiReply;
import com.xiaoju.open.sdk.didies.service.order.v1.model.ListOrderRequest;
import com.xiaoju.open.sdk.didies.service.order.v1.model.ListTrainLeftTicketApiReply;
import com.xiaoju.open.sdk.didies.service.order.v1.model.ListTrainLeftTicketRequest;
import com.xiaoju.open.sdk.didies.service.order.v1.model.ListTransferTrainTicketApiReply;
import com.xiaoju.open.sdk.didies.service.order.v1.model.ListTransferTrainTicketRequest;
import com.xiaoju.open.sdk.didies.service.order.v1.V1;

public class Order extends BaseService {

    protected final ITokenHolder tokenHolder;

    protected final Config config;

    private final V1 v1;

    public Order(ITokenHolder tokenHolder, Config config) {
        this.tokenHolder = tokenHolder;
        this.config = config;
        this.v1 = new V1(tokenHolder, config);
    }

    public V1 v1() {
        return this.v1;
    }
}

