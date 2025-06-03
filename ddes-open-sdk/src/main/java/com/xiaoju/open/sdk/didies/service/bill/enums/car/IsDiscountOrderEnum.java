package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;

@Getter
public enum IsDiscountOrderEnum {
  YES("是"),
  NO("否");

  private final String description;

  IsDiscountOrderEnum(String description) {
    this.description = description;
  }
}
