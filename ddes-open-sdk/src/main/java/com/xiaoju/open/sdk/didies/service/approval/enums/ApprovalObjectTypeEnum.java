package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalObjectTypeEnum {

  ORDER(1, "订单"),
  APPROVAL(2, "审批单")
  ;

  private final Integer code;
  private final String description;

  ApprovalObjectTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
