package com.xiaoju.open.sdk.didies.service.order.v1;

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

public class V1 extends BaseService {

    public V1(ITokenHolder tokenHolder, Config config) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 用车订单详情查询
    * 
    * @param getCarOrderDetailRequest  (required)
    * @return GetCarOrderDetailApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetCarOrderDetailApiReply getCarOrderDetail(GetCarOrderDetailRequest getCarOrderDetailRequest) throws Exception {
        return doGet(getCarOrderDetailRequest, "/river/Order/detail", GetCarOrderDetailApiReply.class, 0);
        
    }
    /**
    * 机票预估价接口
    * 按航线获取国内机票票价，以此来做预算管理
    * @param getFlightEstimatePriceRequest  (required)
    * @return GetFlightEstimatePriceApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetFlightEstimatePriceApiReply getFlightEstimatePrice(GetFlightEstimatePriceRequest getFlightEstimatePriceRequest) throws Exception {
        
        return doPost(getFlightEstimatePriceRequest, "/api-gateway/g/flight/info/estimatePrice", GetFlightEstimatePriceApiReply.class, 0);
    }
    /**
    * 机票订单详情查询
    * 该接口用于使用订单号查询机票明细的信息。一般通过列表接口获取国内，国际对应的订单号。  注意  - 详情接口只支持订单号+国内、国际查询的方式。 - 机票订单数据只返回因公订单的数据，不包含手工补单数据，包含国际机票的手工单。 - 变价实际出票金额暂不提供。 - company_real_pay、personal_real_pay用户页面点完支付时有值 - 服务包客服退，需要按照订单号重新获取，或外部申请单号重新获取。 - 订单数据不建议作为报销数据使用。
    * @param getFlightOrderDetailRequest  (required)
    * @return GetFlightOrderDetailApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetFlightOrderDetailApiReply getFlightOrderDetail(GetFlightOrderDetailRequest getFlightOrderDetailRequest) throws Exception {
        
        return doPost(getFlightOrderDetailRequest, "/api-gateway/g/flight/orderDetail", GetFlightOrderDetailApiReply.class, 0);
    }
    /**
    * 酒店订单详情查询
    * 
    * @param getHotelOrderDetailRequest  (required)
    * @return GetHotelOrderDetailApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetHotelOrderDetailApiReply getHotelOrderDetail(GetHotelOrderDetailRequest getHotelOrderDetailRequest) throws Exception {
        
        return doPost(getHotelOrderDetailRequest, "/api-gateway/g/hotel/orderDetail", GetHotelOrderDetailApiReply.class, 0);
    }
    /**
    * 用车列表接口
    * 
    * @param getOrderRequest  (required)
    * @return GetOrderApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetOrderApiReply getOrder(GetOrderRequest getOrderRequest) throws Exception {
        return doGet(getOrderRequest, "/river/Order/get", GetOrderApiReply.class, 0);
        
    }
    /**
    * 火车票订单详情查询
    * 
    * @param getTrainOrderDetailRequest  (required)
    * @return GetTrainOrderDetailApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetTrainOrderDetailApiReply getTrainOrderDetail(GetTrainOrderDetailRequest getTrainOrderDetailRequest) throws Exception {
        
        return doPost(getTrainOrderDetailRequest, "/api-gateway/g/train/orderDetail", GetTrainOrderDetailApiReply.class, 0);
    }
    /**
    * 订单号列表查询
    * 说明  - 该接口用于查询机票，酒店，火车票，用车订单号的查询，明细的信息需要使用订单号在对应的品类的订单详情查询接口中获取;  注意  - out_approval_id/approval_id有值时(approval_id优先级最高)，其他查询条件不生效（时间除外）。查询所有品类时，返回所有的品类信息; - start_time，end_time成对出现，查询时间起止都包含在条件内。其他查询条件依赖时间查询存在，不可以单独使用。时间范围：30天;
    * @param listOrderRequest  (required)
    * @return ListOrderApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public ListOrderApiReply listOrder(ListOrderRequest listOrderRequest) throws Exception {
        
        return doPost(listOrderRequest, "/open-apis/v1/order/list", ListOrderApiReply.class, 0);
    }
    /**
    * 火车票直达列表接口
    * 
    * @param listTrainLeftTicketRequest  (required)
    * @return ListTrainLeftTicketApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public ListTrainLeftTicketApiReply listTrainLeftTicket(ListTrainLeftTicketRequest listTrainLeftTicketRequest) throws Exception {
        
        return doPost(listTrainLeftTicketRequest, "/api-gateway/train/queryLeftTicket", ListTrainLeftTicketApiReply.class, 0);
    }
    /**
    * 火车票中转车次列表
    * 
    * @param listTransferTrainTicketRequest  (required)
    * @return ListTransferTrainTicketApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public ListTransferTrainTicketApiReply listTransferTrainTicket(ListTransferTrainTicketRequest listTransferTrainTicketRequest) throws Exception {
        
        return doPost(listTransferTrainTicketRequest, "/api-gateway/g/train/transfer/queryLeftTicket", ListTransferTrainTicketApiReply.class, 0);
    }
}

