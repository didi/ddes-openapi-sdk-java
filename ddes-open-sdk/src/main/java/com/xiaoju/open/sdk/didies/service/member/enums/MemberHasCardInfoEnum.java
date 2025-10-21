package com.xiaoju.open.sdk.didies.service.member.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberHasCardInfoEnum {

  // 是否含有证件信息，当传证件信息时，此字符传1，其他情况不传或传0
  NO(0, "不传"),
  YES(1, "传");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
