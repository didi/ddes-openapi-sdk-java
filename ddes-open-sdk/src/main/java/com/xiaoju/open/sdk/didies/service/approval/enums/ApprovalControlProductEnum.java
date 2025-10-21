package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApprovalControlProductEnum {

  CITY_CAR(1, "市内用车");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
