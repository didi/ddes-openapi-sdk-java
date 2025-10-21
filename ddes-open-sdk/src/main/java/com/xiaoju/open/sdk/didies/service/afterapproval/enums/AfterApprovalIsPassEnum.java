package com.xiaoju.open.sdk.didies.service.afterapproval.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 审批单是否通过枚举
 */
@Getter
@RequiredArgsConstructor
public enum AfterApprovalIsPassEnum {

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
