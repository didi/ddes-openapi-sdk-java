package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalTripReturnTypeEnum {

  ONE_WAY(0, "单程"),
  ROUND_TRIP(1, "往返");

  private final Integer code;
  private final String description;

  ApprovalTripReturnTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
