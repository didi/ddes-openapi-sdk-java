package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DayDifferenceEnum {

  SAME_DAY(0, "当天到达"),
  NEXT_DAY(1, "第二天到达");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
