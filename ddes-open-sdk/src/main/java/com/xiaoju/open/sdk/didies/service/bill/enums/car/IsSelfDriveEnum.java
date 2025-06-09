package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;

@Getter
public enum IsSelfDriveEnum {
  YES("是"),
  NO("否");

  private final String description;

  IsSelfDriveEnum(String description) {
    this.description = description;
  }
}
