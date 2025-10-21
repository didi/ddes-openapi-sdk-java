package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApprovalCategoryControlEnum {

  CITY_CAR(3, "市内用车"),
  TRAIN_TICKET(4, "火车票服务"),
  FLIGHT_TICKET(6, "机票服务"),
  PICKUP(9, "接送服务"),
  HOTEL(10, "酒店服务"),
  INTERNATIONAL_FLIGHT(11, "国际机票服务"),
  INTERNATIONAL_HOTEL(12, "国际酒店服务");


  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
