package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;


@Getter
public enum UseCarTypeV2Enum {
  OVERTIME("加班"),
  DAILY_COMMUTE("日常出勤"),
  AIRPORT_TRANSFER("接送机");

  private final String description;

  UseCarTypeV2Enum(String description) {
    this.description = description;
  }
}
