package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IsStartStationEnum {

  PASSING_STATION(0, "经过站"),
  START_STATION(1, "始发站");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
