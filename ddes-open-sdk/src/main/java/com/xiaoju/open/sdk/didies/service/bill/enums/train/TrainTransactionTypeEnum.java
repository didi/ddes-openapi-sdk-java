package com.xiaoju.open.sdk.didies.service.bill.enums.train;

import lombok.Getter;

@Getter
public enum TrainTransactionTypeEnum {

  ISSUE("出票", "出票"),
  CHANGE("改签", "改签"),
  REFUND("退票", "退票");

  private final String code;
  private final String description;

  TrainTransactionTypeEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }
}
