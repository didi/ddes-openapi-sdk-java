package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalPassengerTypeEnum {

  INNER(0, "员工"),
  OUTER(1, "外部出行人");

  private final Integer code;
  private final String description;

  ApprovalPassengerTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
