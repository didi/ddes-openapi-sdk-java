package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SettleTypeNameEnum {
  RIDE_HAILING("网约车"),
  DESIGNATED_DRIVER("代驾"),
  TAXI("出租车"),
  BUSINESS_TRAVEL("商旅");

  /**
   * code
   */
  private final String code;
}
