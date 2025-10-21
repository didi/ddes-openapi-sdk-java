package com.xiaoju.open.sdk.didies.service.member.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberTypeEnum {

  PHONE(0, "手机号"),  // 默认值设为0
  EMPLOYEE_ID(1, "工号"),
  EMAIL(2, "邮箱");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
