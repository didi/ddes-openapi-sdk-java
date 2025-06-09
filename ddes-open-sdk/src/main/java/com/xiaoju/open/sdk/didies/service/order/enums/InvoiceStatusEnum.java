package com.xiaoju.open.sdk.didies.service.order.enums;

import lombok.Getter;

@Getter
public enum InvoiceStatusEnum {

  NOT_INVOICED(0, "未开"),
  INVOICED(1, "开过");

  private final Integer code;
  private final String description;

  InvoiceStatusEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
