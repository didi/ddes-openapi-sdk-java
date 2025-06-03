package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;

@Getter
public enum SaleFlagEnum {

  NORMAL(0, "正常售票"),
  UNAVAILABLE(1, "不能发售"),
  SPECIAL(2, "特殊车辆");

  private final Integer code;
  private final String description;

  SaleFlagEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
