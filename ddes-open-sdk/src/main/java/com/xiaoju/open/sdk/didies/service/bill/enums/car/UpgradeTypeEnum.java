package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UpgradeTypeEnum {
  NON_UPGRADE("非升舱单"),
  UPGRADE("升舱"),
  SPECIAL_CAR_POOLING("专车拼车"),
  DOWNGRADE("降舱");

  /**
   * code
   */
  private final String code;
}
