package com.xiaoju.open.sdk.didies.service.bill.enums.flight;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionTypeEnum {

  ISSUE(0, "出票"),
  CHANGE(1, "改签"),
  REFUND(2, "退票"),
  OFFLINE_CHANGE(3, "线下改签"),
  OFFLINE_REFUND(4, "线下退票");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
