package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApprovalCityRuleEnum {

  NO(0, "不包含"),
  YES(1, "包含"),
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
