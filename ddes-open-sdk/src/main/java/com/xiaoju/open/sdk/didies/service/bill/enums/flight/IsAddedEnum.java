package com.xiaoju.open.sdk.didies.service.bill.enums.flight;

import lombok.Getter;

@Getter
public enum IsAddedEnum {

  NORMAL(0, "正常机票"),
  MANUAL(1, "手工单机票");

  private final Integer code;
  private final String description;

  IsAddedEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
