package com.xiaoju.open.sdk.didies.service.bill.enums.flight;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderFixTypeEnum {

  NOT_FIX(0, "非补偿单"),
  FIX(1, "补偿单");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
