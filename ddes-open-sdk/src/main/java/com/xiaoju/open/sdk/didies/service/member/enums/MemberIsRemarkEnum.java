package com.xiaoju.open.sdk.didies.service.member.enums;

import lombok.Getter;

@Getter
public enum MemberIsRemarkEnum {

  OPTIONAL(0, "选填"),
  REQUIRED(1, "必填"),
  BY_POLICY(2, "按制度填写");

  private final Integer code;
  private final String description;

  MemberIsRemarkEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
