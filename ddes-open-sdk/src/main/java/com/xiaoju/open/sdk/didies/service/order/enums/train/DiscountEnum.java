package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DiscountEnum {

  NO(0, "否"),
  YES(1, "是");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
