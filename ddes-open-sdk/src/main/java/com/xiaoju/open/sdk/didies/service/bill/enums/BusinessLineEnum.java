package com.xiaoju.open.sdk.didies.service.bill.enums;

import lombok.Getter;

@Getter
public enum BusinessLineEnum {

  RIDE_HAILING(0, "网约车"),
  BUSINESS_TRAVEL(1, "商旅"),
  TAXI(100, "出租车");

  private final Integer code;
  private final String description;

  BusinessLineEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
