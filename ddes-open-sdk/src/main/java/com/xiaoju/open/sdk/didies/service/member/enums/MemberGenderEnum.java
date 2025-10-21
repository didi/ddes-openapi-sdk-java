package com.xiaoju.open.sdk.didies.service.member.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberGenderEnum {

  UNKNOWN(0, "未知"),
  MALE(1, "男"),
  FEMALE(2, "女");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
