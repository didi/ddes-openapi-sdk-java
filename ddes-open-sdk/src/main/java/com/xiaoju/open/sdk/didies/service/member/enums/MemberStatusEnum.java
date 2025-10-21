package com.xiaoju.open.sdk.didies.service.member.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberStatusEnum {

  NORMAL(1, "正常"),
  RESIGNED(4, "离职"),
  UNBOUND_PHONE(6, "未绑定手机号");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
