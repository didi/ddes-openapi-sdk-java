package com.xiaoju.open.sdk.didies.service.bill.enums.train;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TrainTransactionTypeEnum {

  ISSUE("出票"),
  CHANGE("改签"),
  REFUND("退票");

  /**
   * 状态码
   */
  private final String code;
}
