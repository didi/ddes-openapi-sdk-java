package com.xiaoju.open.sdk.didies.service.regulation.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RegulationSourceEnum {

  COMMON_RULE(1, "通用规则"),
  PRE_TRIP_APPROVAL(2, "行前审批"),
  TRAVEL(3, "差旅"),
  NO_APPROVAL(4, "无需审批");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
