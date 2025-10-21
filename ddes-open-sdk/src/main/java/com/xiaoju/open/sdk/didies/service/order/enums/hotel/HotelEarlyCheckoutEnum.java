package com.xiaoju.open.sdk.didies.service.order.enums.hotel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HotelEarlyCheckoutEnum {

  NOT_EARLY_CHECKOUT(0, "非提前离店"),
  EARLY_CHECKOUT(1, "提前离店");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
