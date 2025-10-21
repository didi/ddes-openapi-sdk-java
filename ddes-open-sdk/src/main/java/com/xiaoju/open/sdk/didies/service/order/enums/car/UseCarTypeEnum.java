package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UseCarTypeEnum {

  TAXI(1, "出租车"),
  SPECIAL_CAR(2, "专车"),
  EXPRESS(3, "快车"),
  DESIGNATED_DRIVER(4, "代驾"),
  LUXURY_CAR(5, "豪华车");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
