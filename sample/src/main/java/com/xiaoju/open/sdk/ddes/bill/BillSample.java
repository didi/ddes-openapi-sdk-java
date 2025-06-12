package com.xiaoju.open.sdk.ddes.bill;

import com.xiaoju.open.sdk.didies.ApiClient;
import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.service.bill.enums.AdjustBillDataBusinessTypeEnum;
import com.xiaoju.open.sdk.didies.service.bill.enums.AdjustBillTypeEnum;
import com.xiaoju.open.sdk.didies.service.bill.enums.BusinessLineEnum;
import com.xiaoju.open.sdk.didies.service.bill.enums.BusinessTypeEnum;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.*;
import com.xiaoju.open.sdk.didies.utils.JacksonUtils;

import java.util.ArrayList;
import java.util.List;

public class BillSample {

  public static void main(String[] args) throws Exception {
    Config config = new Config()
        .setClientId("your_client_id")
        .setClientSecret("your_client_secret")
        .setSignKey("your_sign_key");

    ApiClient client = new ApiClient(config);

    // 测试调用
//    billConfirmTest(client);
//    getAdjustBillDataResultTest(client);
//    getBillDetailOfDaiJiaTest(client);
//    getBillDetailOfDomesticFlightTest(client);
//    getBillDetailOfDomesticHotelTest(client);
//    getBillDetailOfInterFlightTest(client);
//    getBillDetailOfInterHotelTest(client);
//    getBillDetailOfManualOrderTest(client);
//    getBillDetailOfTaxiTest(client);
//    getBillDetailOfTrainTicketTest(client);
//    getBillDetailOfWangYCTest(client);
//    getBillStructureTest(client);
//    getBillSummaryTest(client);
//    getNotGenBillDetailOfDaiJiaTest(client);
//    getNotGenBillDetailOfFlightTest(client);
//    getNotGenBillDetailOfHotelTest(client);
//    getNotGenBillDetailOfInterFlightTest(client);
//    getNotGenBillDetailOfInterHotelTest(client);
//    getNotGenBillDetailOfManualOrderTest(client);
//    getNotGenBillDetailOfTaxiTest(client);
//    getNotGenBillDetailOfTrainTest(client);
//    getNotGenBillDetailOfWangYCTest(client);
//    getTransactionBillDetailTest(client);
//    getTransactionBillDetailOfTaxiTest(client);
//    listBillTest(client);
//    listBillTest_business(client);
//    listBillTest_taxi(client);
//    updateAdjustBillDataTest(client);
  }

  public static void billConfirmTest(ApiClient client) throws Exception {
    BillConfirmRequest billConfirmRequest = BillConfirmRequest.builder()
        .billId("")
        .companyId("companyId") // 必填
        .build();
    BillConfirmApiReply response = client.bill().v1().billConfirm(billConfirmRequest);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("billConfirmTest end");
  }

  public static void getAdjustBillDataResultTest(ApiClient client) throws Exception {
    GetAdjustBillDataResultRequest request = GetAdjustBillDataResultRequest.builder()
        .billId(1125966073074006L)
        .adjustReqId("1747987703615")
        .companyId("替换成自己的companyId") // 必填
        .build();

    GetAdjustBillDataResultApiReply response = client.bill().v1().getAdjustBillDataResult(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  public static void getBillDetailOfDaiJiaTest(ApiClient client) throws Exception {
    GetBillDetailOfDaiJiaRequest request = GetBillDetailOfDaiJiaRequest.builder()
        .companyId("替换成自己的companyId") // 必填
        .billId("1125957079305278")
        .length(100)
        .businessType(BusinessTypeEnum.DESIGNATED_DRIVER.getCode()) // 必填
        .paymentPeriod("2025-05-14~2025-05-15")
        .build();
    GetBillDetailOfDaiJiaApiReply response = client.bill().v1().getBillDetailOfDaiJia(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  public static void getBillDetailOfDomesticFlightTest(ApiClient client) throws Exception {
    GetBillDetailOfDomesticFlightRequest request = GetBillDetailOfDomesticFlightRequest.builder()
        .companyId("替换成自己的companyId") // 必填
        .billId("1125967084045554")
        .businessType(BusinessTypeEnum.DOMESTIC_FLIGHT.getCode()) // 必填
        .length(100)
        .build();
    GetBillDetailOfDomesticFlightApiReply response = client.bill().v1().getBillDetailOfDomesticFlight(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 已出账单(按业务类型拆分 - 国内酒店)
   */
  public static void getBillDetailOfDomesticHotelTest(ApiClient client) throws Exception {
    GetBillDetailOfDomesticHotelRequest request = GetBillDetailOfDomesticHotelRequest.builder()
        .companyId("替换成自己的companyId")
        .billId("1125967084045554")
        .businessType(BusinessTypeEnum.DOMESTIC_HOTEL.getCode()) // 必填
        .length(100)
        .build();
    GetBillDetailOfDomesticHotelApiReply response = client.bill().v1().getBillDetailOfDomesticHotel(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }


  /**
   * 已出账单(按业务类型拆分 - 国际机票)
   */
  public static void getBillDetailOfInterFlightTest(ApiClient client) throws Exception {
    GetBillDetailOfInterFlightRequest request = GetBillDetailOfInterFlightRequest.builder()
        .companyId("替换成自己的companyId") // 必填
        .businessType(BusinessTypeEnum.DOMESTIC_FLIGHT.getCode()) // 必填
        .length(100)
        .build();
    GetBillDetailOfInterFlightApiReply response = client.bill().v1().getBillDetailOfInterFlight(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 已出账单(按业务类型拆分 - 海外酒店)
   */
  public static void getBillDetailOfInterHotelTest(ApiClient client) throws Exception {
    GetBillDetailOfInterHotelRequest request = GetBillDetailOfInterHotelRequest.builder()
        .companyId("替换成自己的companyId")
        .billId("1125966074000462")
        .businessType(BusinessTypeEnum.INTERNATIONAL_HOTEL.getCode()) // 必填
        .length(100)
        .build();
    GetBillDetailOfInterHotelApiReply response = client.bill().v1().getBillDetailOfInterHotel(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }


  /**
   * 已出账单(按业务类型拆分 - 增值手工单)
   */
  public static void getBillDetailOfManualOrderTest(ApiClient client) throws Exception {
    GetBillDetailOfManualOrderRequest request = GetBillDetailOfManualOrderRequest.builder()
        .companyId("替换成自己的companyId") // 必填
        .businessType(BusinessTypeEnum.MANUAL_ORDER.getCode()) // 必填
        .billId("1125966074000462")
        .length(100)
        .build();

    GetBillDetailOfManualOrderApiReply response = client.bill().v1().getBillDetailOfManualOrder(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }


  /**
   * 已出账单(按业务类型拆分 - 出租车)
   */
  public static void getBillDetailOfTaxiTest(ApiClient client) throws Exception {
    GetBillDetailOfTaxiRequest request = GetBillDetailOfTaxiRequest.builder()
        .companyId("替换成自己的companyId") // 必填
        .businessType(BusinessTypeEnum.TAXI.getCode()) // 必填
        .billId("1125962263860239")
        .length(100)
        .build();
    GetBillDetailOfTaxiApiReply response = client.bill().v1().getBillDetailOfTaxi(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 已出账单(按业务类型拆分 - 火车票)
   */
  public static void getBillDetailOfTrainTicketTest(ApiClient client) throws Exception {
    GetBillDetailOfTrainTicketRequest request = GetBillDetailOfTrainTicketRequest.builder()
        .companyId("替换成自己的companyId") // 必填
        .businessType(BusinessTypeEnum.TRAIN_TICKET.getCode()) // 必填
        .billId("1125967160953370")
        .length(100)
        .build();
    GetBillDetailOfTrainTicketApiReply response = client.bill().v1().getBillDetailOfTrainTicket(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 已出账单(按业务类型拆分 - 网约车)
   */
  public static void getBillDetailOfWangYCTest(ApiClient client) throws Exception {
    GetBillDetailOfWangYCRequest request = GetBillDetailOfWangYCRequest.builder()
        .companyId("替换成自己的companyId") // 必填
        .businessType(BusinessTypeEnum.RIDE_HAILING.getCode()) // 必填
        .billId("1125966721993062")
        .length(100)
        .build();

    GetBillDetailOfWangYCApiReply response = client.bill().v1().getBillDetailOfWangYC(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 网约车、商旅账单树查询
   */
  public static void getBillStructureTest(ApiClient client) throws Exception {
    GetBillStructureRequest request = GetBillStructureRequest.builder()
        .companyId("替换成自己的companyId")
        .paymentPeriod("2025-04-01~2025-04-30")
        .businessType(String.valueOf(AdjustBillDataBusinessTypeEnum.RIDE_HAILING.getCode()))
        .build();
    GetBillStructureApiReply response = client.bill().v1().getBillStructure(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 账单汇总查询-商旅、网约车、出租车
   */
  public static void getBillSummaryTest(ApiClient client) throws Exception {

    GetBillSummaryRequest request = GetBillSummaryRequest.builder()
        .companyId("替换成自己的companyId")
        .billId("1125966073074006")
        .businessLine(BusinessLineEnum.RIDE_HAILING.getCode())
        .build();

    GetBillSummaryApiReply response = client.bill().v1().getBillSummary(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }


  /**
   * 未出账单(按业务类型拆分 - 代驾)
   */
  public static void getNotGenBillDetailOfDaiJiaTest(ApiClient client) throws Exception {
    GetNotGenBillDetailOfDaiJiaRequest request = GetNotGenBillDetailOfDaiJiaRequest.builder()
        .companyId("替换成自己的companyId")
        .businessType(BusinessTypeEnum.DESIGNATED_DRIVER.getCode())
        .startDate("2025-05-03 17:50:00")
        .endDate("2025-05-04 17:50:00")
        .build();
    GetNotGenBillDetailOfDaiJiaApiReply response = client.bill().v1().getNotGenBillDetailOfDaiJia(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 未出账单(按业务类型拆分 - 国内机票)
   */
  public static void getNotGenBillDetailOfFlightTest(ApiClient client) throws Exception {
    GetNotGenBillDetailOfFlightRequest request = GetNotGenBillDetailOfFlightRequest.builder()
        .companyId("替换成自己的companyId")
        .businessType(BusinessTypeEnum.BILL_DOMESTIC_FLIGHT.getCode())
        .startDate("2025-05-03 17:50:00")
        .endDate("2025-05-04 17:50:00")
        .build();
    GetNotGenBillDetailOfFlightApiReply response = client.bill().v1().getNotGenBillDetailOfFlight(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 未出账单(按业务类型拆分 - 国内酒店)
   */
  public static void getNotGenBillDetailOfHotelTest(ApiClient client) throws Exception {
    GetNotGenBillDetailOfHotelRequest request = GetNotGenBillDetailOfHotelRequest.builder()
        .companyId("替换成自己的companyId")
        .businessType(BusinessTypeEnum.DOMESTIC_HOTEL.getCode())
        .startDate("2025-05-03 17:50:00")
        .endDate("2025-05-04 17:50:00")
        .build();

    GetNotGenBillDetailOfHotelApiReply response = client.bill().v1().getNotGenBillDetailOfHotel(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 未出账单(按业务类型拆分 - 国际机票)
   */
  public static void getNotGenBillDetailOfInterFlightTest(ApiClient client) throws Exception {
    GetNotGenBillDetailOfInterFlightRequest request = GetNotGenBillDetailOfInterFlightRequest.builder()
        .companyId("替换成自己的companyId")
        .businessType(BusinessTypeEnum.INTERNATIONAL_FLIGHT.getCode())
        .startDate("2025-05-03 17:50:00")
        .endDate("2025-05-04 17:50:00")
        .lastId("")
        .build();
    GetNotGenBillDetailOfInterFlightApiReply response = client.bill().v1().getNotGenBillDetailOfInterFlight(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 未出账单(按业务类型拆分 - 海外酒店)
   */
  public static void getNotGenBillDetailOfInterHotelTest(ApiClient client) throws Exception {
    GetNotGenBillDetailOfInterHotelRequest request = GetNotGenBillDetailOfInterHotelRequest.builder()
        .companyId("替换成自己的companyId")
        .businessType(BusinessTypeEnum.INTERNATIONAL_HOTEL.getCode())
        .startDate("2025-05-03 17:50:00")
        .endDate("2025-05-04 17:50:00")
        .build();
    GetNotGenBillDetailOfInterHotelApiReply response = client.bill().v1().getNotGenBillDetailOfInterHotel(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 未出账单(按业务类型拆分 - 增值手工单)
   */
  public static void getNotGenBillDetailOfManualOrderTest(ApiClient client) throws Exception {
    GetNotGenBillDetailOfManualOrderRequest request = GetNotGenBillDetailOfManualOrderRequest.builder()
        .companyId("替换成自己的companyId")
        .businessType(BusinessTypeEnum.MANUAL_ORDER.getCode())
        .startDate("2025-05-03 17:50:00")
        .endDate("2025-05-04 17:50:00")
        .build();

    GetNotGenBillDetailOfManualOrderApiReply response = client.bill().v1().getNotGenBillDetailOfManualOrder(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 未出账单(按业务类型拆分 - 出租车)
   */
  public static void getNotGenBillDetailOfTaxiTest(ApiClient client) throws Exception {
    GetNotGenBillDetailOfTaxiRequest request = GetNotGenBillDetailOfTaxiRequest.builder()
        .companyId("替换成自己的companyId")
        .businessType(BusinessTypeEnum.TAXI.getCode())
        .startDate("2025-05-03 17:50:00")
        .endDate("2025-05-04 17:50:00")
        .build();

    GetNotGenBillDetailOfTaxiApiReply response = client.bill().v1().getNotGenBillDetailOfTaxi(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }


  /**
   * 未出账单(按业务类型拆分 - 火车票)
   */
  public static void getNotGenBillDetailOfTrainTest(ApiClient client) throws Exception {
    GetNotGenBillDetailOfTrainRequest request = GetNotGenBillDetailOfTrainRequest.builder()
        .companyId("替换成自己的companyId")
        .businessType(BusinessTypeEnum.TRAIN_TICKET.getCode())
        .startDate("2025-05-03 17:50:00")
        .endDate("2025-05-04 17:50:00")
        .build();

    GetNotGenBillDetailOfTrainApiReply response = client.bill().v1().getNotGenBillDetailOfTrain(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }


  /**
   * 未出账单(按业务类型拆分 - 网约车)
   */
  public static void getNotGenBillDetailOfWangYCTest(ApiClient client) throws Exception {
    GetNotGenBillDetailOfWangYCRequest request = GetNotGenBillDetailOfWangYCRequest.builder()
        .companyId("替换成自己的companyId")
        .businessType(BusinessTypeEnum.RIDE_HAILING.getCode())
        .startDate("2025-05-03 17:50:00")
        .endDate("2025-05-04 17:50:00")
        .build();
    GetNotGenBillDetailOfWangYCApiReply response = client.bill().v1().getNotGenBillDetailOfWangYC(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 网约车、出租车交易明细 ~ 网约车
   */
  public static void getTransactionBillDetailTest(ApiClient client) throws Exception {
    GetTransactionBillDetailRequest request = GetTransactionBillDetailRequest.builder()
        .companyId("替换成自己的companyId")
        .businessType(BusinessTypeEnum.RIDE_HAILING.getCode())
        .length(100)
        .billId("1125966721993062")
        .build();

    GetTransactionBillDetailApiReply response = client.bill().v1().getTransactionBillDetail(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 网约车、出租车交易明细 ~ 出租车
   */
  public static void getTransactionBillDetailOfTaxiTest(ApiClient client) throws Exception {
    GetTransactionBillDetailOfTaxiRequest request = GetTransactionBillDetailOfTaxiRequest.builder()
        .companyId("替换成自己的companyId")
        .businessType(BusinessTypeEnum.TAXI.getCode())
        .length(100)
        .billId("1125966721993062")
        .build();

    GetTransactionBillDetailOfTaxiApiReply response = client.bill().v1().getTransactionBillDetailOfTaxi(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 账单列表接口
   */
  public static void listBillTest(ApiClient client) throws Exception {
    ListBillRequest request = ListBillRequest.builder()
        .companyId("替换成自己的companyId")
        .businessLine(BusinessLineEnum.RIDE_HAILING.getCode())
        .offset(0)
        .length(100)
        .build();

    ListBillApiReply response = client.bill().v1().listBill(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 账单列表接口
   */
  public static void listBillTest_business(ApiClient client) throws Exception {

    ListBillRequest request = ListBillRequest.builder()
        .companyId("替换成自己的companyId")
        .businessLine(BusinessLineEnum.BUSINESS_TRAVEL.getCode())
        .offset(0)
        .length(100)
        .build();

    ListBillApiReply response = client.bill().v1().listBill(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 账单列表接口
   */
  public static void listBillTest_taxi(ApiClient client) throws Exception {
    ListBillRequest request = ListBillRequest.builder()
        .companyId("替换成自己的companyId")
        .businessLine(BusinessLineEnum.TAXI.getCode())
        .offset(0)
        .length(100)
        .build();

    ListBillApiReply response = client.bill().v1().listBill(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }

  /**
   * 账单调整提交接口
   */
  public static void updateAdjustBillDataTest(ApiClient client) throws Exception {
    List<AdjustListItem> items = new ArrayList<>();
    items.add(AdjustListItem.builder().subBusinessType(AdjustBillDataBusinessTypeEnum.RIDE_HAILING.getCode()).subOrderId("1125963892688390").build());
    UpdateAdjustBillDataRequest request = UpdateAdjustBillDataRequest.builder()
        .companyId("替换成自己的companyId")
        .adjustReqId("1747987703615")
        .businessType(AdjustBillDataBusinessTypeEnum.BUSINESS_TRAVEL.getCode())
        .adjustType(AdjustBillTypeEnum.DEFER_TO_NEXT_PERIOD.getCode())
        .adjustList(items)
        .remark("手工单调账")
        .build();
    UpdateAdjustBillDataApiReply response = client.bill().v1().updateAdjustBillData(request);
    if (response != null) {
      System.out.println(JacksonUtils.toJson(response));
    }
    System.out.println("getAdjustBillDataResultTest end");
  }


}
