package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StopoverPointsStatusEnum {

  NOT_PASSED(0, "还未经过途径点"),
  PASSED(1, "已经经过途径点");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
