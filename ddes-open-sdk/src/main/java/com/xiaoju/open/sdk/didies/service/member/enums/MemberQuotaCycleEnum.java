package com.xiaoju.open.sdk.didies.service.member.enums;


import lombok.Getter;

@Getter
public enum MemberQuotaCycleEnum {

  UNLIMITED(0, "不限期"),
  MONTH(1, "自然月"),
  ;

  private final Integer code;
  private final String description;

  MemberQuotaCycleEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}