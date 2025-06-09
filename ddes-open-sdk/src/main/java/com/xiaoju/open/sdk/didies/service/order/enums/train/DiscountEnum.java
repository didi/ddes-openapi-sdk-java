package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;

@Getter
public enum DiscountEnum {

  NO(0, "否"),
  YES(1, "是");

  private final Integer code;
  private final String description;

  DiscountEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
