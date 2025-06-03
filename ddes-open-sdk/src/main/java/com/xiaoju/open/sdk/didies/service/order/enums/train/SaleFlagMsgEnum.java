package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;

@Getter
public enum SaleFlagMsgEnum {

  UNAVAILABLE_REASON(1, "不能发售原因信息"),
  SPECIAL_NOTICE(2, "特殊提示信息");

  private final Integer code;
  private final String description;

  SaleFlagMsgEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
