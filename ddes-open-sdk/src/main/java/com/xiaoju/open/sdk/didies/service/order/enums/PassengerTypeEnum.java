package com.xiaoju.open.sdk.didies.service.order.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PassengerTypeEnum {

  EMPLOYEE_NUMBER("employee_number", "工号"),
  EMAIL("email", "邮箱"),
  PHONE("phone", "手机号");

  /**
   * 状态码
   */
  private final String code;
  /**
   * 描述
   */
  private final String description;
}
