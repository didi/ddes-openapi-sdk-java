package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;

@Getter
public enum UseCarTypeEnum {

  TAXI(1, "出租车"),
  SPECIAL_CAR(2, "专车"),
  EXPRESS(3, "快车"),
  DESIGNATED_DRIVER(4, "代驾"),
  LUXURY_CAR(5, "豪华车");

  private final Integer code;
  private final String description;

  UseCarTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
