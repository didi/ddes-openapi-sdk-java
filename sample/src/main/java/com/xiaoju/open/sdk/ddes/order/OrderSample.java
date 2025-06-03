package com.xiaoju.open.sdk.ddes.order;

import com.xiaoju.open.sdk.didies.ApiClient;
import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.service.order.enums.OrderDetailProductTypeEnum;
import com.xiaoju.open.sdk.didies.service.order.enums.OrderTypeEnum;
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
import com.xiaoju.open.sdk.didies.service.order.v1.model.ParamJsonObj;
import com.xiaoju.open.sdk.didies.service.order.v1.model.SearchTime;
import com.xiaoju.open.sdk.didies.utils.JacksonUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderSample {

  public static void main(String[] args) throws Exception {
    Config config = Config.builder()
        .clientId("your_client_id")
        .clientSecret("your_client_secret")
        .signKey("your_sign_key")
        .build();

    ApiClient client = new ApiClient(config);
    //getCarOrderDetailTest(client);
    //getFlightEstimatePriceTest(client);
    //getFlightOrderDetailTest(client);
    //getFlightOrderDetailTest_International(client);
    //getHotelOrderDetailTest(client);
    //getHotelOrderDetailTest_international(client);
    //getOrderTest(client);
    //getTrainOrderDetailTest(client);
    //listOrderTest(client);
    //listTrainLeftTicketTest(client);
    //listTransferTrainTicketTest(client);
  }

  /**
   * 用车订单详情查询
   */
  public static void getCarOrderDetailTest(ApiClient client) throws Exception {
    GetCarOrderDetailRequest request = GetCarOrderDetailRequest.builder()
        .companyId("替换成自己的companyId")
        .orderId("1125960027718380")
        .build();
    GetCarOrderDetailApiReply response = client.order().v1().getCarOrderDetail(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 机票预估价接口
   * <p>
   * 按航线获取国内机票票价，以此来做预算管理
   */
  public static void getFlightEstimatePriceTest(ApiClient client) throws Exception {
    GetFlightEstimatePriceRequest request = GetFlightEstimatePriceRequest.builder()
        .companyId("替换成自己的companyId")
        .departureCityId("1")
        .arrivalCityId("4")
        .date(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        .build();
    GetFlightEstimatePriceApiReply response = client.order().v1().getFlightEstimatePrice(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 国内机票订单详情查询
   * <p>
   * 该接口用于使用订单号查询机票明细的信息。一般通过列表接口获取国内，国际对应的订单号。  注意  - 详情接口只支持订单号+国内、国际查询的方式。 - 机票订单数据只返回因公订单的数据，不包含手工补单数据，包含国际机票的手工单。 - 变价实际出票金额暂不提供。 -
   * company_real_pay、personal_real_pay用户页面点完支付时有值 - 服务包客服退，需要按照订单号重新获取，或外部申请单号重新获取。 - 订单数据不建议作为报销数据使用。
   */
  public static void getFlightOrderDetailTest(ApiClient client) throws Exception {
    GetFlightOrderDetailRequest request = GetFlightOrderDetailRequest.builder()
        .companyId("替换成自己的companyId")
        .productType(OrderDetailProductTypeEnum.DOMESTIC.getCode())
        .orderIds("1125964865466609").build();
    GetFlightOrderDetailApiReply response = client.order().v1().getFlightOrderDetail(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 国际机票订单详情查询
   * <p>
   * 该接口用于使用订单号查询机票明细的信息。一般通过列表接口获取国内，国际对应的订单号。  注意  - 详情接口只支持订单号+国内、国际查询的方式。 - 机票订单数据只返回因公订单的数据，不包含手工补单数据，包含国际机票的手工单。 - 变价实际出票金额暂不提供。 -
   * company_real_pay、personal_real_pay用户页面点完支付时有值 - 服务包客服退，需要按照订单号重新获取，或外部申请单号重新获取。 - 订单数据不建议作为报销数据使用。
   */
  public static void getFlightOrderDetailTest_International(ApiClient client) throws Exception {
    GetFlightOrderDetailRequest request = GetFlightOrderDetailRequest.builder()
        .companyId("替换成自己的companyId")
        .productType(OrderDetailProductTypeEnum.INTERNATIONAL.getCode())
        .orderIds("1125927580156572").build();
    GetFlightOrderDetailApiReply response = client.order().v1().getFlightOrderDetail(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 酒店订单详情查询【国内】
   */
  public static void getHotelOrderDetailTest(ApiClient client) throws Exception {
    GetHotelOrderDetailRequest request = GetHotelOrderDetailRequest.builder()
        .companyId("替换成自己的companyId")
        .orderIds("1125964839286792")
        .productType(OrderDetailProductTypeEnum.DOMESTIC.getCode())
        .build();
    GetHotelOrderDetailApiReply response = client.order().v1().getHotelOrderDetail(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 酒店订单详情查询【国际】
   */
  public static void getHotelOrderDetailTest_international(ApiClient client) throws Exception {
    GetHotelOrderDetailRequest request = GetHotelOrderDetailRequest.builder()
        .companyId("替换成自己的companyId")
        .orderIds("1125964839286792")
        .productType(OrderDetailProductTypeEnum.INTERNATIONAL.getCode())
        .build();
    GetHotelOrderDetailApiReply response = client.order().v1().getHotelOrderDetail(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 用车列表接口
   */
  public static void getOrderTest(ApiClient client) throws Exception {
    GetOrderRequest request = GetOrderRequest.builder()
        .companyId("替换成自己的companyId")
        .startDate("2025-03-17")
        .endDate("2025-03-22")
        .offset(0)
        .length(1)
        .build();
    GetOrderApiReply response = client.order().v1().getOrder(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 火车票订单详情查询
   */
  public static void getTrainOrderDetailTest(ApiClient client) throws Exception {
    GetTrainOrderDetailRequest request = GetTrainOrderDetailRequest.builder()
        .companyId("替换成自己的companyId")
        .orderIds("1125964839894891")
        .build();
    GetTrainOrderDetailApiReply response = client.order().v1().getTrainOrderDetail(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 订单号列表查询
   * <p>
   * 说明  - 该接口用于查询机票，酒店，火车票，用车订单号的查询，明细的信息需要使用订单号在对应的品类的订单详情查询接口中获取;  注意  - out_approval_id/approval_id有值时(approval_id优先级最高)
   * ，其他查询条件不生效（时间除外）。查询所有品类时，返回所有的品类信息; - start_time，end_time成对出现，查询时间起止都包含在条件内。其他查询条件依赖时间查询存在，不可以单独使用。时间范围：30天;
   */
  public static void listOrderTest(ApiClient client) throws Exception {
    ListOrderRequest request = ListOrderRequest.builder()
        .companyId("替换成自己的companyId")
        .paramJsonObj(ParamJsonObj.builder()
            .orderType(OrderTypeEnum.DOMESTIC_HOTEL.getCode())
            .curPage(1)
            .limit(10)
            .searchTime(SearchTime.builder()
                .startTime("2025-04-24 00:00:00")
                .endTime("2025-04-25 00:00:00").build())
            .build())
        .build();

    ListOrderApiReply response = client.order().v1().listOrder(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 火车票直达列表接口
   */
  public static void listTrainLeftTicketTest(ApiClient client) throws Exception {
    String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    ListTrainLeftTicketRequest request = ListTrainLeftTicketRequest.builder()
        .companyId("替换成自己的companyId")
        .trainDate(currentDate)
        .fromStationName("成都东")
        .toStationName("重庆北")
        .build();
    ListTrainLeftTicketApiReply response = client.order().v1().listTrainLeftTicket(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 火车票中转车次列表
   */
  public static void listTransferTrainTicketTest(ApiClient client) throws Exception {
    String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    ListTransferTrainTicketRequest request = ListTransferTrainTicketRequest.builder()
        .companyId("替换成自己的companyId")
        .trainDate(currentDate)
        .fromStationName("成都东")
        .toStationName("重庆北")
        .build();
    ListTransferTrainTicketApiReply response = client.order().v1().listTransferTrainTicket(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }
}
