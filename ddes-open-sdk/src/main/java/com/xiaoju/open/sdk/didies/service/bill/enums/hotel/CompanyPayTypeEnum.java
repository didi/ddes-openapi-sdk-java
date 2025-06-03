package com.xiaoju.open.sdk.didies.service.bill.enums.hotel;

import lombok.Getter;

@Getter
public enum CompanyPayTypeEnum {

  CONSUMPTION("消费", "消费"),
  REFUND("退款", "退款");

  private final String code;
  private final String description;

  CompanyPayTypeEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }
}
