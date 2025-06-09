package com.xiaoju.open.sdk.didies.service.order.enums;

import lombok.Getter;

@Getter
public enum ApprovalIdTypeEnum {

  OUT_APPROVAL_ID(1, "out_approval_id（外部申请单单号）"),
  APPROVAL_ID(2, "approval_id（滴滴内部申请单号）");

  private final Integer code;
  private final String description;

  ApprovalIdTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
