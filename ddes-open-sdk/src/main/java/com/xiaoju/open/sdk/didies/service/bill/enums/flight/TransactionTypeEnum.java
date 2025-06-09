package com.xiaoju.open.sdk.didies.service.bill.enums.flight;

import lombok.Getter;

@Getter
public enum TransactionTypeEnum {

  ISSUE(0, "出票"),
  CHANGE(1, "改签"),
  REFUND(2, "退票"),
  OFFLINE_CHANGE(3, "线下改签"),
  OFFLINE_REFUND(4, "线下退票");

  private final Integer code;
  private final String description;

  TransactionTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
