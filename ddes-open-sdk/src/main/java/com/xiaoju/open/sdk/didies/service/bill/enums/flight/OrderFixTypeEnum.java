package com.xiaoju.open.sdk.didies.service.bill.enums.flight;

import lombok.Getter;

@Getter
public enum OrderFixTypeEnum {

  NOT_FIX(0, "非补偿单"),
  FIX(1, "补偿单");

  private final Integer code;
  private final String description;

  OrderFixTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
