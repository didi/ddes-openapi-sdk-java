package com.xiaoju.open.sdk.didies.service.order.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderDetailProductTypeEnum {

  DOMESTIC(1, "国内"),
  INTERNATIONAL(2, "国际");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
