package com.xiaoju.open.sdk.didies.service.outapproval.enums;

import lombok.Getter;

@Getter
public enum OutApprovalStatusEnum {

  NO(0, "驳回"),
  YES(1, "通过"),
  ;

  private final Integer code;
  private final String description;

  OutApprovalStatusEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
