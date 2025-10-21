package com.xiaoju.open.sdk.didies.service.regulation.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RegulationApproveTypeEnum {

  NO_APPROVAL(0, "无需审批"),
  PRE_TRIP_APPROVAL(1, "行前审批"),
  TRAVEL_APPROVAL(2, "差旅");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
