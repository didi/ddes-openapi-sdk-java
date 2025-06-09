package com.xiaoju.open.sdk.didies.service.member.enums;

import lombok.Getter;

@Getter
public enum MemberGenderEnum {

  UNKNOWN(0, "未知"),
  MALE(1, "男"),
  FEMALE(2, "女");

  private final Integer code;
  private final String description;

 MemberGenderEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
