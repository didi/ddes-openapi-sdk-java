package com.xiaoju.open.sdk.didies.service.regulation.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RegulationStatusEnum {

  DISABLED(0, "停用"),
  NORMAL(1, "正常"),
  DELETED(2, "删除"),
  EXPIRED(3, "过期");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
