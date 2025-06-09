package com.xiaoju.open.sdk.didies.service.order.enums;

import lombok.Getter;

@Getter
public enum OrderDetailProductTypeEnum {

  DOMESTIC(1, "国内"),
  INTERNATIONAL(2, "国际");

  private final Integer code;
  private final String description;

  OrderDetailProductTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
