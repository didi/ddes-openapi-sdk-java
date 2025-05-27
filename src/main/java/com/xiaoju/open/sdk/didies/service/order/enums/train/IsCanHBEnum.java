package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;

@Getter
public enum IsCanHBEnum {

  NOT_SUPPORT(0, "不支持候补"),
  CAN_HB(1, "可候补"),
  FULL_HB(2, "候补人数已达上限");

  private final Integer code;
  private final String description;

  IsCanHBEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
