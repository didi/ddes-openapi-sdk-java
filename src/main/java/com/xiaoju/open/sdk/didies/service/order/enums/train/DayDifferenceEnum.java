package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;

@Getter
public enum DayDifferenceEnum {

  SAME_DAY(0, "当天到达"),
  NEXT_DAY(1, "第二天到达");

  private final Integer code;
  private final String description;

  DayDifferenceEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
