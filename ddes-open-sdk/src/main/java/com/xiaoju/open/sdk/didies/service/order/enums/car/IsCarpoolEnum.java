package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IsCarpoolEnum {

  NOT_CARPOOL(0, "非拼车"),
  CARPOOL(1, "拼车");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
