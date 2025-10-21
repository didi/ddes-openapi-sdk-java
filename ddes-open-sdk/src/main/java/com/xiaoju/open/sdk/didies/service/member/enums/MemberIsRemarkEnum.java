package com.xiaoju.open.sdk.didies.service.member.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberIsRemarkEnum {

  OPTIONAL(0, "选填"),
  REQUIRED(1, "必填"),
  BY_POLICY(2, "按制度填写");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
