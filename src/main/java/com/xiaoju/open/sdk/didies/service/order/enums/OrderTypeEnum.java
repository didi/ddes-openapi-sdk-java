package com.xiaoju.open.sdk.didies.service.order.enums;

import lombok.Getter;

@Getter
public enum OrderTypeEnum {

  ALL("all", "所有类别"),
  DOMESTIC_FLIGHT("domesticflight", "国内机票"),
  INTERNATIONAL_FLIGHT("internationalflight", "国际机票"),
  DOMESTIC_HOTEL("domestichotel", "国内酒店"),
  INTERNATIONAL_HOTEL("internationalhotel", "国际酒店"),
  TRAIN("train", "火车票"),
  CAR("car", "用车");

  private final String code;
  private final String description;

  OrderTypeEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }
}
