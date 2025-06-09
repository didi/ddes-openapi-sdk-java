package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalTypeEnum {

  TRAVEL(1, "差旅"),
  PRE_TRIP_BY_TIMES(2, "行前审批按次数"),
  PRE_TRIP_BY_DATE(3, "行前审批按日期");

  private final Integer code;
  private final String description;

  ApprovalTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
