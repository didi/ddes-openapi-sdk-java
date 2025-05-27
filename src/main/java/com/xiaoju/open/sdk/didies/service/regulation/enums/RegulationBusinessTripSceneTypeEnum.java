package com.xiaoju.open.sdk.didies.service.regulation.enums;

import lombok.Getter;

@Getter
public enum RegulationBusinessTripSceneTypeEnum {

  PERSONAL_CAR(0, "个人用车"),
  BUSINESS_TRIP(1, "商务出行"),
  APPROVAL_TRAVEL(2, "需审批差旅制度"),
  OVERTIME(3, "加班"),
  COMMUTING(4, "办公地点通勤"),
  EPIDEMIC_COMMUTING(5, "疫期通勤"),
  MEETING_CAR(11, "会议用车"),
  PROXY_CALL(91, "代叫车"),
  AIRPORT_PICKUP(92, "接送机"),
  CHARTERED_CAR(93, "包车"),
  DESIGNATED_DRIVER(94, "代驾"),
  PRIVATE_CAR(95, "私车同行"),
  PRE_TRIP_APPROVAL(96, "行前审批"),
  NO_APPROVAL_TRAVEL(104, "无需审批差旅制度");

  private final Integer code;
  private final String description;

  RegulationBusinessTripSceneTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
