package com.xiaoju.open.sdk.didies.service.bill.enums.flight;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RebookTypeEnum {

  VOLUNTARY("自愿"),
  INVOLUNTARY("非自愿");

  /**
   * code
   */
  private final String code;
}
