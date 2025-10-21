package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BillConfirmBusinessTypeEnum {
  RIDE_HAILING(0, "网约车"),
  BUSINESS_TRAVEL(1, "商旅");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
