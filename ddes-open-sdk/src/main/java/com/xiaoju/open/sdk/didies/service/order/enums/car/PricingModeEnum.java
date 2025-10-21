package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PricingModeEnum {

  REAL_TIME(0, "实时计价"),
  FIXED_PRICE(1, "一口价"),
  TWO_PRICE(2, "两口价(一口价变成实时计价)");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
