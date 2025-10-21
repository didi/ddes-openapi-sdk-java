package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApprovalTypeEnum {

  TRAVEL(1, "差旅"),
  PRE_TRIP_BY_TIMES(2, "行前审批按次数"),
  PRE_TRIP_BY_DATE(3, "行前审批按日期");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
