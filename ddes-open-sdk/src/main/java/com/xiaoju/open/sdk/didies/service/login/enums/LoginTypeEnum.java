package com.xiaoju.open.sdk.didies.service.login.enums;

import lombok.Getter;

@Getter
public enum LoginTypeEnum {

  H5(2, "企业版app H5"),
  PC(3, "PC");

  private final Integer code;
  private final String description;

  LoginTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
