package com.xiaoju.open.sdk.didies.service.bill.enums.flight;

import lombok.Getter;

@Getter
public enum RebookTypeEnum {

  VOLUNTARY("自愿", "自愿"),
  INVOLUNTARY("非自愿", "非自愿");

  private final String code;
  private final String description;

  RebookTypeEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }
}
