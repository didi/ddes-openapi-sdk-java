package com.xiaoju.open.sdk.didies.service.member.enums;

import lombok.Getter;

@Getter
public enum MemberStatusEnum {

  NORMAL(1, "正常"),
  RESIGNED(4, "离职"),
  UNBOUND_PHONE(6, "未绑定手机号");

  private final Integer code;
  private final String description;

  MemberStatusEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
