package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalIsPassTypeEnum {

  PASS(1, "通过"),
  REJECT(2, "拒绝")
  ;

  private final Integer code;
  private final String description;

  ApprovalIsPassTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
