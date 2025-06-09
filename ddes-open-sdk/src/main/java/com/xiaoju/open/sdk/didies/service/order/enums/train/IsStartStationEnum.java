package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;

@Getter
public enum IsStartStationEnum {

  PASSING_STATION(0, "经过站"),
  START_STATION(1, "始发站");

  private final Integer code;
  private final String description;

  IsStartStationEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
