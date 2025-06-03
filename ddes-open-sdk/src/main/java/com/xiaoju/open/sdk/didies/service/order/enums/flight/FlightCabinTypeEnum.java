package com.xiaoju.open.sdk.didies.service.order.enums.flight;

import lombok.Getter;

@Getter
public enum FlightCabinTypeEnum {

  UNCONFIGURED(0, "未配置"),
  FIRST_CLASS(1, "头等舱"),
  PREMIUM_FIRST(2, "超值头等舱"),
  BUSINESS_CLASS(3, "商务舱"),
  ECONOMY_CLASS(4, "经济舱"),
  PREMIUM_ECONOMY(5, "经济舱精选"),
  ECONOMY_Y_CLASS(6, "经济舱y舱");

  private final Integer code;
  private final String description;

  FlightCabinTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
