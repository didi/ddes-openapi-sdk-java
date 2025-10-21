package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SpecialFlagEnum {

  NO(0, "无"),
  YES(1, "有");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
