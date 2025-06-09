package com.xiaoju.open.sdk.didies.service.regulation.enums;

import lombok.Getter;

@Getter
public enum RegulationApproveTypeEnum {

  NO_APPROVAL(0, "无需审批"),
  PRE_TRIP_APPROVAL(1, "行前审批"),
  TRAVEL_APPROVAL(2, "差旅");

  private final Integer code;
  private final String description;

  RegulationApproveTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
