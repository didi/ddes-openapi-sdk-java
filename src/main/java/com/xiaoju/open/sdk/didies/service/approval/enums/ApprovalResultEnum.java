package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalResultEnum {

  APPROVED(1, "通过"),
  REJECTED(2, "拒绝");

  private final Integer code;
  private final String description;

  ApprovalResultEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
