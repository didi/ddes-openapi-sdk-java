package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalTripTypeEnum {

  OTHER(0, "其他"),
  TRAIN(1, "火车"),
  FLIGHT(2, "飞机");

  private final Integer code;
  private final String description;

  ApprovalTripTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
