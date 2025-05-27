package com.xiaoju.open.sdk.didies.service.regulation.enums;

import lombok.Getter;

@Getter
public enum RegulationUseQuotaEnum {

  NOT_USE(0, "不使用"),
  USE(1, "使用");

  private final Integer code;
  private final String description;

  RegulationUseQuotaEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
