package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;

@Getter
public enum PricingModeEnum {

  REAL_TIME(0, "实时计价"),
  FIXED_PRICE(1, "一口价"),
  TWO_PRICE(2, "两口价(一口价变成实时计价)");

  private final Integer code;
  private final String description;

  PricingModeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
