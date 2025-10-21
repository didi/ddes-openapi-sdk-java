package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UseCarTypeV2Enum {
  OVERTIME("加班"),
  DAILY_COMMUTE("日常出勤"),
  AIRPORT_TRANSFER("接送机");

  /**
   * code
   */
  private final String code;
}
