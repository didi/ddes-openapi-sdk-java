package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;

@Getter
public enum IsCarpoolSuccessEnum {
  YES(1, "是"),
  NO(0, "否");

  private final int code;
  private final String description;

  IsCarpoolSuccessEnum(int code, String description) {
    this.code = code;
    this.description = description;
  }
}
