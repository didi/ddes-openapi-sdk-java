package com.xiaoju.open.sdk.didies.service.extend.enums;

import lombok.Getter;

@Getter
public enum ExtendStatusEnum {

  NORMAL(1, "正常"),
  DISABLED(2, "停用");

  private final Integer code;
  private final String description;

  ExtendStatusEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
