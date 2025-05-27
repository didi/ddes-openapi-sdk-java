package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;

@Getter
public enum IsFixedPriceEnum {
  YES("是"),
  NO("否");

  private final String description;

  IsFixedPriceEnum(String description) {
    this.description = description;
  }
}
