package com.xiaoju.open.sdk.didies.service.member.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberQuotaCycleEnum {

  UNLIMITED(0, "不限期"),
  MONTH(1, "自然月"),
  ;

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}