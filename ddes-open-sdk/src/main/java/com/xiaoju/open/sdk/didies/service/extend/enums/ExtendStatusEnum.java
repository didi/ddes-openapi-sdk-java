package com.xiaoju.open.sdk.didies.service.extend.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExtendStatusEnum {

  NORMAL(1, "正常"),
  DISABLED(2, "停用");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
