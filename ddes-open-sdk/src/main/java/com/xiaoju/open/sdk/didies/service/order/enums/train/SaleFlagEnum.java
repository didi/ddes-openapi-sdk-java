package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SaleFlagEnum {

  NORMAL(0, "正常售票"),
  UNAVAILABLE(1, "不能发售"),
  SPECIAL(2, "特殊车辆");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
