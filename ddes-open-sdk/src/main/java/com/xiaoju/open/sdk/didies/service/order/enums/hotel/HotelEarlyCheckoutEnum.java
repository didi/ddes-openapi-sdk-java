package com.xiaoju.open.sdk.didies.service.order.enums.hotel;

import lombok.Getter;

@Getter
public enum HotelEarlyCheckoutEnum {

  NOT_EARLY_CHECKOUT(0, "非提前离店"),
  EARLY_CHECKOUT(1, "提前离店");

  private final Integer code;
  private final String description;

  HotelEarlyCheckoutEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
