package com.xiaoju.open.sdk.didies.service.bill.enums.hotel;

import lombok.Getter;

@Getter
public enum IsVatEnum {

  YES("是", "是"),
  NO("否", "否");

  private final String code;
  private final String description;

  IsVatEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }
}
