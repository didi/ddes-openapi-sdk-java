package com.xiaoju.open.sdk.didies.service.city.enums;


import lombok.Getter;

@Getter
public enum CityProductTypeEnum {
  /**
   * 国家类型, 枚举值数字
   */
  CAR(10, "用车"),
  FLIGHT(20, "机票"),
  HOTEL(30, "酒店"),
  TRAIN(40, "火车票"),
  ;

  private final Integer code;
  private final String description;

  CityProductTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}