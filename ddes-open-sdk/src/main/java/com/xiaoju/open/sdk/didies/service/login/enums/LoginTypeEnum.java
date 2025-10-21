package com.xiaoju.open.sdk.didies.service.login.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LoginTypeEnum {

  H5(2, "企业版app H5"),
  PC(3, "PC");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
