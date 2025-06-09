package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;

@Getter
public enum BillConfirmBusinessTypeEnum {
  RIDE_HAILING(0, "网约车"),
  BUSINESS_TRAVEL(1, "商旅");

  private final int code;
  private final String description;

  BillConfirmBusinessTypeEnum(int code, String description) {
    this.code = code;
    this.description = description;
  }
}
