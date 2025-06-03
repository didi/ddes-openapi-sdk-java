package com.xiaoju.open.sdk.didies.service.afterapproval.enums;

import lombok.Getter;

@Getter
public enum AfterApprovalIsPassEnum {

  NO(0, "驳回"),
  YES(1, "通过"),
  ;

  private final Integer code;
  private final String description;

  AfterApprovalIsPassEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
