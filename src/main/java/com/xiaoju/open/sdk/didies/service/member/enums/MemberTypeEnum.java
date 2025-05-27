package com.xiaoju.open.sdk.didies.service.member.enums;

import lombok.Getter;

@Getter
public enum MemberTypeEnum {

  PHONE(0, "手机号"),  // 默认值设为0
  EMPLOYEE_ID(1, "工号"),
  EMAIL(2, "邮箱");

  private final Integer code;
  private final String description;

  MemberTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
