package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SaleFlagMsgEnum {

  UNAVAILABLE_REASON(1, "不能发售原因信息"),
  SPECIAL_NOTICE(2, "特殊提示信息");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
