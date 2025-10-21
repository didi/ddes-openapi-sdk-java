package com.xiaoju.open.sdk.didies.service.outapproval.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OutApprovalStatusEnum {

  NO(0, "驳回"),
  YES(1, "通过"),
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
