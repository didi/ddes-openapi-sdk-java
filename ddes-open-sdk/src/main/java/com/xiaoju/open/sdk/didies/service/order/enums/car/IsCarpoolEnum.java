package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;

@Getter
public enum IsCarpoolEnum {

  NOT_CARPOOL(0, "非拼车"),
  CARPOOL(1, "拼车");

  private final Integer code;
  private final String description;

  IsCarpoolEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
