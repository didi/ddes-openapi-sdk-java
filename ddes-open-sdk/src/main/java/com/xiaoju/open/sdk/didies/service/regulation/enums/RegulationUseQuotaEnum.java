package com.xiaoju.open.sdk.didies.service.regulation.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RegulationUseQuotaEnum {

  NOT_USE(0, "不使用"),
  USE(1, "使用");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
