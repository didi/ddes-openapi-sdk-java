package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IsReassignmentEnum {
  YES("是"),
  NO("否");

  /**
   * code
   */
  private final String code;
}
