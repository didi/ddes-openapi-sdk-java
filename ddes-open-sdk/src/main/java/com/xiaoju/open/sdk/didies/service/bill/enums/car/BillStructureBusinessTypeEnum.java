package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BillStructureBusinessTypeEnum {
  RIDE_HAILING(1, "网约车"),
  DESIGNATED_DRIVER(40, "代驾"),
  TAXI(100, "出租车"),
  BUSINESS_TRAVEL(2, "商旅");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
