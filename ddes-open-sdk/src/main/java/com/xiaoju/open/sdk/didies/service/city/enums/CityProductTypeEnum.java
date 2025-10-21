package com.xiaoju.open.sdk.didies.service.city.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CityProductTypeEnum {
  /**
   * 国家类型, 枚举值数字
   */
  CAR(10, "用车"),
  FLIGHT(20, "机票"),
  HOTEL(30, "酒店"),
  TRAIN(40, "火车票"),
  ;

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}