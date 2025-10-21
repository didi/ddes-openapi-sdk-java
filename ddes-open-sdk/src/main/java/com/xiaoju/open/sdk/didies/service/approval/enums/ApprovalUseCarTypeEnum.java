package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApprovalUseCarTypeEnum {

  CAR(2, "专车"),
  FAST(3, "快车");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}