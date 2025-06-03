package com.xiaoju.open.sdk.ddes.service.order

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum
import com.xiaoju.open.sdk.didies.service.order.Order
import com.xiaoju.open.sdk.didies.service.order.enums.OrderTypeEnum
import com.xiaoju.open.sdk.didies.service.order.v1.model.*
import com.xiaoju.open.sdk.didies.utils.JacksonUtils
import spock.lang.Ignore
import spock.lang.Specification

import java.text.SimpleDateFormat

/**
 * API tests for Order
 */
@Ignore
class OrderTest extends Specification {

    private Order api

    def setup() {
        Config config = Config.builder()
                .baseUrl("https://api.es.xiaojukeji.com")
                .clientId("替换成自己的clientId")
                .clientSecret("替换成自己的clientSecret")
                .signKey("替换成自己的signKey")
                .enableRequestLog(true)
                .logLevel(LogLevelEnum.INFO).build()
        ApiClient client = new ApiClient(config)
        api = client.order()
    }

    /**
     * 用车订单详情查询
     */
    def getCarOrderDetailTest() {
        GetCarOrderDetailRequest getCarOrderDetailRequest = new GetCarOrderDetailRequest(
                companyId: "替换成自己的companyId", orderId: "1125960027718380"
        )
        GetCarOrderDetailApiReply response = api.v1().getCarOrderDetail(getCarOrderDetailRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 机票预估价接口
     *
     * 按航线获取国内机票票价，以此来做预算管理
     */
    def getFlightEstimatePriceTest() {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date())
        GetFlightEstimatePriceRequest getFlightEstimatePriceRequest = new GetFlightEstimatePriceRequest(
                companyId: "替换成自己的companyId",
                departureCityId: "1",
                arrivalCityId: "4",
                date: currentDate
        )
        GetFlightEstimatePriceApiReply response = api.v1().getFlightEstimatePrice(getFlightEstimatePriceRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 国内机票订单详情查询
     *
     * 该接口用于使用订单号查询机票明细的信息。一般通过列表接口获取国内，国际对应的订单号。  注意  - 详情接口只支持订单号+国内、国际查询的方式。 - 机票订单数据只返回因公订单的数据，不包含手工补单数据，包含国际机票的手工单。 - 变价实际出票金额暂不提供。 - company_real_pay、personal_real_pay用户页面点完支付时有值 - 服务包客服退，需要按照订单号重新获取，或外部申请单号重新获取。 - 订单数据不建议作为报销数据使用。
     */
    def getFlightOrderDetailTest() {
        GetFlightOrderDetailRequest getFlightOrderDetailRequest = new GetFlightOrderDetailRequest(
                companyId: "替换成自己的companyId",
                productType: 1,
                orderIds: "1125964865466609"
        )

        GetFlightOrderDetailApiReply response = api.v1().getFlightOrderDetail(getFlightOrderDetailRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 国际机票订单详情查询
     *
     * 该接口用于使用订单号查询机票明细的信息。一般通过列表接口获取国内，国际对应的订单号。  注意  - 详情接口只支持订单号+国内、国际查询的方式。 - 机票订单数据只返回因公订单的数据，不包含手工补单数据，包含国际机票的手工单。 - 变价实际出票金额暂不提供。 - company_real_pay、personal_real_pay用户页面点完支付时有值 - 服务包客服退，需要按照订单号重新获取，或外部申请单号重新获取。 - 订单数据不建议作为报销数据使用。
     */
    def getFlightOrderDetailTest_International() {
        GetFlightOrderDetailRequest getFlightOrderDetailRequest = new GetFlightOrderDetailRequest(
                companyId: "替换成自己的companyId", productType: 2, orderIds: "1125927580156572"
        )
        GetFlightOrderDetailApiReply response = api.v1().getFlightOrderDetail(getFlightOrderDetailRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 酒店订单详情查询【国内】
     *
     *
     */
    def getHotelOrderDetailTest() {
        GetHotelOrderDetailRequest getHotelOrderDetailRequest = new GetHotelOrderDetailRequest(
                companyId: "替换成自己的companyId", orderIds: "1125964839286792", productType: 1
        )

        GetHotelOrderDetailApiReply response = api.v1().getHotelOrderDetail(getHotelOrderDetailRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }

    /**
     * 酒店订单详情查询【国际】
     *
     *
     */
    def getHotelOrderDetailTest_international() {
        GetHotelOrderDetailRequest getHotelOrderDetailRequest = new GetHotelOrderDetailRequest(
                companyId: "替换成自己的companyId", orderIds: "1125952703827485", productType: 2
        )
        GetHotelOrderDetailApiReply response = api.v1().getHotelOrderDetail(getHotelOrderDetailRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 用车列表接口
     *
     *
     */
    def getOrderTest() {
        GetOrderRequest getOrderRequest = new GetOrderRequest(
                companyId: "替换成自己的companyId",
                startDate: "2025-03-17",
                endDate: "2025-03-22",
                offset: 0,
                length: 1
        )

        GetOrderApiReply response = api.v1().getOrder(getOrderRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 火车票订单详情查询
     *
     *
     */
    def getTrainOrderDetailTest() {
        GetTrainOrderDetailRequest getTrainOrderDetailRequest = new GetTrainOrderDetailRequest(
                companyId: "替换成自己的companyId", orderIds: "1125964839894891"
        )

        GetTrainOrderDetailApiReply response = api.v1().getTrainOrderDetail(getTrainOrderDetailRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 订单号列表查询
     *
     * 说明  - 该接口用于查询机票，酒店，火车票，用车订单号的查询，明细的信息需要使用订单号在对应的品类的订单详情查询接口中获取;  注意  - out_approval_id/approval_id有值时(approval_id优先级最高)，其他查询条件不生效（时间除外）。查询所有品类时，返回所有的品类信息; - start_time，end_time成对出现，查询时间起止都包含在条件内。其他查询条件依赖时间查询存在，不可以单独使用。时间范围：30天;
     */
    def listOrderTest() {
        ListOrderRequest listOrderRequest = new ListOrderRequest(
                companyId: "替换成自己的companyId",
                paramJsonObj: new ParamJsonObj(
                        orderType: OrderTypeEnum.DOMESTIC_HOTEL.getCode(),
                        curPage: 1,
                        limit: 10,
                        searchTime: new SearchTime(
                                startTime: "2025-04-24 00:00:00",
                                endTime: "2025-04-25 00:00:00"
                        )
                )
        )

        ListOrderApiReply response = api.v1().listOrder(listOrderRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 火车票直达列表接口
     *
     *
     */
    def listTrainLeftTicketTest() {

        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date())
        ListTrainLeftTicketRequest listTrainLeftTicketRequest = new ListTrainLeftTicketRequest(
//                train_date=当天时间，from_station_name='成都东'，to_station_name='重庆北'
                companyId: "替换成自己的companyId",
                trainDate: currentDate,
                fromStationName: "成都东",
                toStationName: "重庆北"
        )
        ListTrainLeftTicketApiReply response = api.v1().listTrainLeftTicket(listTrainLeftTicketRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 火车票中转车次列表
     *
     *
     */
    def listTransferTrainTicketTest() {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date())
        ListTransferTrainTicketRequest listTransferTrainTicketRequest = new ListTransferTrainTicketRequest(
                // train_date=当天时间，from_station_name='成都东'，to_station_name='重庆北'
                companyId: "替换成自己的companyId",
                trainDate: currentDate,
                fromStationName: "成都东",
                toStationName: "重庆北"
        )

        ListTransferTrainTicketApiReply response = api.v1().listTransferTrainTicket(listTransferTrainTicketRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }

}