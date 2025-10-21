package com.xiaoju.open.sdk.didies.service.bill.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AdjustBillTypeEnum {

  DEFER_TO_NEXT_PERIOD(1, "订单计入下期"),
  ADJUSTMENT(2, "订单信息调整");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
