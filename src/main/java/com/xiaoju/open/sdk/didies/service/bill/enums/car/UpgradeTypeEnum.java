package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;

@Getter
public enum UpgradeTypeEnum {
  NON_UPGRADE("非升舱单"),
  UPGRADE("升舱"),
  SPECIAL_CAR_POOLING("专车拼车"),
  DOWNGRADE("降舱");

  private final String description;

  UpgradeTypeEnum(String description) {
    this.description = description;
  }
}
