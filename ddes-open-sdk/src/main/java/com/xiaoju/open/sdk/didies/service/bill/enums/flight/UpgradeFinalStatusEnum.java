package com.xiaoju.open.sdk.didies.service.bill.enums.flight;

import lombok.Getter;

@Getter
public enum UpgradeFinalStatusEnum {

  NOT_FINAL(-1, "起飞未到终态/预定口径"),
  SPECIAL(0, "特殊-私退私改"),
  USED(1, "终态-已使用"),
  REFUNDED(2, "终态-已退票");

  private final Integer code;
  private final String description;

  UpgradeFinalStatusEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
