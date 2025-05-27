package com.xiaoju.open.sdk.didies.service.regulation.enums;

import lombok.Getter;

@Getter
public enum RegulationApprovalTypeEnum {

  NO_APPROVAL(0, "无需审批"),
  TRAVEL(1, "差旅"),
  PRE_TRIP_BY_COUNT(2, "行前审批按次数"),
  PRE_TRIP_BY_DATE(3, "行前审批按日期");

  private final Integer code;
  private final String description;

  RegulationApprovalTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
