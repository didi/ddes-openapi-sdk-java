package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalUseCarTypeEnum {

  CAR(2, "专车"),
  FAST(3, "快车");

  private final Integer code;
  private final String description;

  ApprovalUseCarTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}