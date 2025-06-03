package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;

@Getter
public enum BillStructureBusinessTypeEnum {
  RIDE_HAILING(1, "网约车"),
  DESIGNATED_DRIVER(40, "代驾"),
  TAXI(100, "出租车"),
  BUSINESS_TRAVEL(2, "商旅");

  private final int code;
  private final String description;

  BillStructureBusinessTypeEnum(int code, String description) {
    this.code = code;
    this.description = description;
  }
}
