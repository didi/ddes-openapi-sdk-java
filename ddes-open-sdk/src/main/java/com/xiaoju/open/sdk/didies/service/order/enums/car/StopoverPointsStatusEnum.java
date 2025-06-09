package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;

@Getter
public enum StopoverPointsStatusEnum {

  NOT_PASSED(0, "还未经过途径点"),
  PASSED(1, "已经经过途径点");

  private final Integer code;
  private final String description;

  StopoverPointsStatusEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
