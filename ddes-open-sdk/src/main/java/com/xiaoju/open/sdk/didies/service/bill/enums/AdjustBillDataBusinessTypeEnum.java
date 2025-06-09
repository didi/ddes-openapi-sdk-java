package com.xiaoju.open.sdk.didies.service.bill.enums;

import lombok.Getter;

@Getter
public enum AdjustBillDataBusinessTypeEnum {
  RIDE_HAILING(1, "网约车"),
  BUSINESS_TRAVEL(2, "商旅"),
  DESIGNATED_DRIVER(40, "代驾"),
  TAXI(100, "出租车");

  private final int code;
  private final String description;

  AdjustBillDataBusinessTypeEnum(int code, String description) {
    this.code = code;
    this.description = description;
  }
}
