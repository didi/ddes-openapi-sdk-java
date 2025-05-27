package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;

@Getter
public enum SettleTypeNameEnum {
  RIDE_HAILING("网约车"),
  DESIGNATED_DRIVER("代驾"),
  TAXI("出租车"),
  BUSINESS_TRAVEL("商旅");

  private final String description;

  SettleTypeNameEnum(String description) {
    this.description = description;
  }
}
