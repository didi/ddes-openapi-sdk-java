package com.xiaoju.open.sdk.didies.service.regulation.enums;

import lombok.Getter;

@Getter
public enum RegulationStatusEnum {

  DISABLED(0, "停用"),
  NORMAL(1, "正常"),
  DELETED(2, "删除"),
  EXPIRED(3, "过期");

  private final Integer code;
  private final String description;

  RegulationStatusEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
