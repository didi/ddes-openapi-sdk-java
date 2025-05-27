package com.xiaoju.open.sdk.didies.service.order.enums;

import lombok.Getter;

@Getter
public enum BookerTypeEnum {

  EMPLOYEE_NUMBER("employee_number", "工号"),
  EMAIL("email", "邮箱"),
  PHONE("phone", "手机号");

  private final String code;
  private final String description;

  BookerTypeEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }
}
