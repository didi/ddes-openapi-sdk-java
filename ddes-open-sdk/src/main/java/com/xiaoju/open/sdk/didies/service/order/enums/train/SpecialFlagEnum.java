package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;

@Getter
public enum SpecialFlagEnum {

  NO(0, "无"),
  YES(1, "有");

  private final Integer code;
  private final String description;

  SpecialFlagEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
