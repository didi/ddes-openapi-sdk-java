package com.xiaoju.open.sdk.didies.service.bill.enums.flight;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IsAddedEnum {

  NORMAL(0, "正常机票"),
  MANUAL(1, "手工单机票");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
