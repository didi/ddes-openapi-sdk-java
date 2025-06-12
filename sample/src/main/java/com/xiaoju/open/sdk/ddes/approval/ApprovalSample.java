package com.xiaoju.open.sdk.ddes.approval;

import com.xiaoju.open.sdk.didies.ApiClient;
import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.service.approval.enums.ApprovalCityRuleEnum;
import com.xiaoju.open.sdk.didies.service.approval.enums.ApprovalExecutiveRegulationTypeEnum;
import com.xiaoju.open.sdk.didies.service.approval.enums.ApprovalIsPassTypeEnum;
import com.xiaoju.open.sdk.didies.service.approval.enums.ApprovalObjectApprovalTypeEnum;
import com.xiaoju.open.sdk.didies.service.approval.enums.ApprovalObjectTypeEnum;
import com.xiaoju.open.sdk.didies.service.approval.enums.ApprovalPassengerTypeEnum;
import com.xiaoju.open.sdk.didies.service.approval.enums.ApprovalTypeEnum;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.ApprovalPassApiReply;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.ApprovalPassRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.BusinessTripDetailByDate;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.BusinessTripDetailByTimes;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.CancelApprovalApiReply;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.CancelApprovalRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.CreateApprovalApiReply;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.CreateApprovalBusinessByDateRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.CreateApprovalBusinessByTimesRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.CreateApprovalRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.ExtendFieldList;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.GetApprovalDetailApiReply;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.GetApprovalDetailRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.ListApprovalOrderApiReply;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.ListApprovalOrderRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.TravelCity;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.TravelDetail;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.Trip;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.TripPassenger;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.UpdateApprovalApiReply;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.UpdateApprovalBusinessByDateRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.UpdateApprovalBusinessByTimesRequest;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.UpdateApprovalRequest;
import com.xiaoju.open.sdk.didies.service.member.enums.MemberTypeEnum;
import com.xiaoju.open.sdk.didies.utils.JacksonUtils;

import java.util.ArrayList;
import java.util.List;

public class ApprovalSample {

  public static void main(String[] args) throws Exception {
    Config config = new Config()
        .setClientId("your_client_id")
        .setClientSecret("your_client_secret")
        .setSignKey("your_sign_key");

    ApiClient client = new ApiClient(config);

    createTravelApproval(client); // 创建差旅审批单
    updateTravelApproval(client); // 更新差旅审批单

    createBusinessByDateApproval(client); // 创建用车按日期审批单
    updateBusinessByDateApproval(client); // 更新用车按日期审批单

    createBusinessByTimesApproval(client); // 创建用车按次数审批单
    updateBusinessByTimesApproval(client); // 更新用车按次数审批单

  }

  /**
   * 创建差旅审批单
   */
  public static void createTravelApproval(ApiClient client) throws Exception {
    List<Trip> trips = new ArrayList<>();
    List<TravelCity> toCities = new ArrayList<>();
    toCities.add(TravelCity.builder().id(17).name("成都市").build());
    trips.add(Trip.builder()
        .departureCity("北京市").departureCityId(1)
        .startDate("2025-04-21").endDate("2025-05-21")
        .tripType("1,2")
        .toCitys(toCities)
        .build());
    List<TripPassenger> passengerList = new ArrayList<>();
    passengerList.add(TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("熊x").memberType(MemberTypeEnum.PHONE.getCode()).build());
    passengerList.add(TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("李x").memberType(MemberTypeEnum.PHONE.getCode()).build());
    passengerList.add(TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("邓x").memberType(MemberTypeEnum.PHONE.getCode()).build());

    CreateApprovalRequest request = CreateApprovalRequest.builder()
        .companyId("替换成自己的companyId")
        .approvalType(ApprovalTypeEnum.TRAVEL.getCode())
        .regulationId("1125937551844010")
        .outApprovalId("java-sdk-test")
        .reason("sdk-test")
        .travelDetailObj(TravelDetail.builder()
            .startDate("2025-04-21")
            .endDate("2025-05-21")
            .trips(trips)
            .startCityRule(ApprovalCityRuleEnum.YES.getCode())
            .endCityRule(ApprovalCityRuleEnum.YES.getCode())
            .build())
        .memberType(MemberTypeEnum.PHONE.getCode())
        .phone("00016213494")
        .passengerListObj(passengerList)
        .executiveRegulationType(ApprovalExecutiveRegulationTypeEnum.EXECUTIVE_APPLICATION.getCode())
        .executiveRegulationId("1125937551844010")
        .executiveRegulationMemberType(MemberTypeEnum.PHONE.getCode())
        .executiveRegulationMember("00016213494")
        .build();
    CreateApprovalApiReply response = client.approval().v1().createTravelApproval(request);
    if (response != null) {
      System.out.println("response: " + JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 更新差旅审批单
   */
  public static void updateTravelApproval(ApiClient client) throws Exception {
    List<Trip> trips = new ArrayList<>();
    List<TravelCity> toCities = new ArrayList<>();
    toCities.add(TravelCity.builder().id(17).name("成都市").build());
    trips.add(Trip.builder()
        .departureCity("北京市").departureCityId(1)
        .startDate("2025-04-21").endDate("2025-05-21")
        .tripType("1,2")
        .toCitys(toCities)
        .build());
    List<TripPassenger> passengerList = new ArrayList<>();
    passengerList.add(TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("熊x").memberType(MemberTypeEnum.PHONE.getCode()).build());
    passengerList.add(TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("李x").memberType(MemberTypeEnum.PHONE.getCode()).build());
    passengerList.add(TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("邓x").memberType(MemberTypeEnum.PHONE.getCode()).build());
    UpdateApprovalRequest request = UpdateApprovalRequest.builder()
        .companyId("替换成自己的companyId")
        .approvalId("1125937551844010")
        .approvalType(ApprovalTypeEnum.TRAVEL.getCode())
        .outApprovalId("java-sdk-test-update")
        .reason("sdk-test")
        .travelDetailObj(TravelDetail.builder()
            .startDate("2025-04-21")
            .endDate("2025-05-21")
            .trips(trips)
            .startCityRule(ApprovalCityRuleEnum.YES.getCode())
            .endCityRule(ApprovalCityRuleEnum.YES.getCode())
            .build())
        .passengerListObj(passengerList)
        .build();
    UpdateApprovalApiReply response = client.approval().v1().updateApproval(request);
    if (response != null) {
      System.out.println("response: " + JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 创建用车按日期审批单
   */
  public static void createBusinessByDateApproval(ApiClient client) throws Exception {
    List<TripPassenger> passengerList = new ArrayList<>();
    passengerList.add(TripPassenger.builder().passengerType(0).passengerName("熊x").memberType(MemberTypeEnum.PHONE.getCode()).passengerPhone(
        "11100022245").build());
    passengerList.add(TripPassenger.builder().passengerType(0).passengerName("沈x").memberType(MemberTypeEnum.PHONE.getCode()).passengerPhone(
        "00016244610").build());

    CreateApprovalBusinessByDateRequest request = CreateApprovalBusinessByDateRequest.builder()
        .companyId("替换成自己的companyId")
        .approvalType(ApprovalTypeEnum.PRE_TRIP_BY_DATE.getCode())
        .outApprovalId("didi-sdk-test")
        .regulationId("1125927807992439")
        .budgetCenterId("1125950150116339")
        .reason("didi-sdk-test")
        .extendFieldListObj(ExtendFieldList.builder().extendField01("906188916").build())
        .businessTripDetailObj(BusinessTripDetailByDate.builder().startTime("2024-12-23").endTime("2024-12-30").tripAmount(70882).perorderMoneyQuota(70882).build())
        .memberType(MemberTypeEnum.PHONE.getCode())
        .phone("11100022245")
        .passengerListObj(passengerList)
        .executiveRegulationType(0)
        .executiveRegulationId("1125950150116339")
        .executiveRegulationMemberType(MemberTypeEnum.PHONE.getCode())
        .executiveRegulationMember("11100022245")
        .build();

    CreateApprovalApiReply response = client.approval().v1().createBusinessByDateApproval(request);
    if (response != null) {
      System.out.println("response: " + JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }


  /**
   * 更新用车按日期审批单
   */
  public static void updateBusinessByDateApproval(ApiClient client) throws Exception {
    List<TripPassenger> passengerList = new ArrayList<>();
    passengerList.add(TripPassenger.builder().passengerType(0).passengerName("熊x").memberType(MemberTypeEnum.PHONE.getCode()).passengerPhone(
        "11100022245").build());
    passengerList.add(TripPassenger.builder().passengerType(0).passengerName("沈x").memberType(MemberTypeEnum.PHONE.getCode()).passengerPhone(
        "00016244610").build());
    UpdateApprovalBusinessByDateRequest updateApprovalBusinessByDateRequest = UpdateApprovalBusinessByDateRequest.builder()
        .companyId("替换成自己的companyId").approvalType(ApprovalTypeEnum.PRE_TRIP_BY_DATE.getCode())
        .outApprovalId("didi-sdk-test")
        .budgetCenterId("1125950150116339")
        .reason("测试更新用车按日期申请单")
        .extendFieldListObj(ExtendFieldList.builder().extendField01("906188916").build())
        .businessTripDetailObj(BusinessTripDetailByDate.builder().startTime("2024-12-23").endTime("2024-12-30").tripAmount(70882).perorderMoneyQuota(70882).build())
        .passengerListObj(passengerList).build();

    UpdateApprovalApiReply response = client.approval().v1().updateBusinessByDateApproval(updateApprovalBusinessByDateRequest);
    if (response != null) {
      System.out.println("response: " + JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 创建用车按次数审批单
   */
  public static void createBusinessByTimesApproval(ApiClient client) throws Exception {

    List<TripPassenger> passengers = new ArrayList<>();
    passengers.add(TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("熊x").memberType(MemberTypeEnum.PHONE.getCode()).build());
    passengers.add(TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("沈x").memberType(MemberTypeEnum.PHONE.getCode()).build());
    CreateApprovalBusinessByTimesRequest createApprovalRequest = CreateApprovalBusinessByTimesRequest.builder()
        .companyId("替换成自己的companyId")
        .approvalType(ApprovalTypeEnum.PRE_TRIP_BY_TIMES.getCode())
        .outApprovalId("didi-sdk-test-by_times")
        .regulationId("1125928451544592")
        .budgetCenterId("1125950150116339")
        .reason("didi-sdk-test")
        .extendFieldListObj(ExtendFieldList.builder().extendField01("906188916").build())
        .businessTripDetailObj(BusinessTripDetailByTimes.builder().startTime("2024-12-23").endTime("2024-12-30").tripTimes(2).build())
        .memberType(MemberTypeEnum.PHONE.getCode())
        .phone("11100022245")
        .passengerListObj(passengers).build();
    CreateApprovalApiReply response = client.approval().v1().createBusinessByTimesApproval(createApprovalRequest);
    if (response != null) {
      System.out.println("response: " + JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  /**
   * 更新用车按次数审批单
   */
  public static void updateBusinessByTimesApproval(ApiClient client) throws Exception {
    List<TripPassenger> passengers = new ArrayList<>();
    passengers.add(TripPassenger.builder().passengerType(ApprovalPassengerTypeEnum.INNER.getCode()).passengerName("熊x").memberType(MemberTypeEnum.PHONE.getCode()).build());
    UpdateApprovalBusinessByTimesRequest updateApprovalBusinessByTimesRequest = UpdateApprovalBusinessByTimesRequest.builder()
        .companyId("替换成自己的companyId").approvalType(ApprovalTypeEnum.PRE_TRIP_BY_TIMES.getCode())
        .outApprovalId("didi-sdk-test-by_times")
        .budgetCenterId("1125950150116339")
        .reason("测试修改按次数")
        .extendFieldListObj(ExtendFieldList.builder().extendField01("906188916").build())
        .businessTripDetailObj(BusinessTripDetailByTimes.builder().startTime("2024-12-23").endTime("2024-12-30").tripTimes(2).build())
        .passengerListObj(passengers)
        .build();
    UpdateApprovalApiReply response = client.approval().v1().updateBusinessByTimesApproval(updateApprovalBusinessByTimesRequest);
    if (response != null) {
      System.out.println("response: " + JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }


  public static void approvalPassTest(ApiClient client) throws Exception {
    ApprovalPassRequest request = ApprovalPassRequest.builder()
        .companyId("替换成自己的companyId")
        .objectType(ApprovalObjectTypeEnum.ORDER.getCode())
        .objectId(1125965135320697L)
        .objectApprovalType(ApprovalObjectApprovalTypeEnum.PERSONAL_TO_ENTERPRISE.getCode())
        .isPass(ApprovalIsPassTypeEnum.PASS.getCode())
        .build();
    ApprovalPassApiReply response = client.approval().v1().approvalPass(request);
    if (response != null) {
      System.out.println("response: " + JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  public static void cancelApprovalTest(ApiClient client) throws Exception {
    CancelApprovalRequest cancelApprovalRequest = CancelApprovalRequest.builder()
        .companyId("替换成自己的companyId")
        .approvalId("1125966918712513")
        .isForce(1)
        .build();
    CancelApprovalApiReply response = client.approval().v1().cancelApproval(cancelApprovalRequest);
    if (response != null) {
      System.out.println("response: " + JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  public static void listApprovalOrderTest(ApiClient client) throws Exception {
    ListApprovalOrderRequest listApprovalOrderRequest = ListApprovalOrderRequest.builder()
        .companyId("替换成自己的companyId")
        .offset(0)
        .length(1)
        .approvalId("1125966918712513")
        .build();
    ListApprovalOrderApiReply response = client.approval().v1().listApprovalOrder(listApprovalOrderRequest);
    if (response != null) {
      System.out.println("response: " + JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }

  public static void getApprovalDetailTest(ApiClient client) throws Exception {
    GetApprovalDetailRequest getApprovalDetailRequest = GetApprovalDetailRequest.builder()
        .companyId("替换成自己的companyId")
        .approvalId("1125966918712513")
        .build();
    GetApprovalDetailApiReply response = client.approval().v1().getApprovalDetail(getApprovalDetailRequest);
    if (response != null) {
      System.out.println("response: " + JacksonUtils.toJson(response));
    }
    System.out.println("request catch error");
  }
}
