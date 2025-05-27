package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;

@Getter
public enum ETicketTrainFlagEnum {

  NOT_SUPPORT(0, "不支持"),
  SUPPORT(1, "支持");

  private final Integer code;
  private final String description;

  ETicketTrainFlagEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
