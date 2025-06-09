package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalSceneTypeEnum {

  PERSONAL(0, "个人用车"),
  BUSINESS(1, "商务出行"),
  TRAVEL(2, "差旅"),
  OVERTIME(3, "加班"),
  OFFICE(4, "办公地点通勤"),
  CAR_CALL(91, "代叫车"),
  CAR_PICKUP(92, "接送机");

  private final Integer code;
  private final String description;

  ApprovalSceneTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
