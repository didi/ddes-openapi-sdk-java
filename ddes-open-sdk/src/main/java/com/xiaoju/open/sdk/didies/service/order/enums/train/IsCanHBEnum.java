package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IsCanHBEnum {

  NOT_SUPPORT(0, "不支持候补"),
  CAN_HB(1, "可候补"),
  FULL_HB(2, "候补人数已达上限");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
