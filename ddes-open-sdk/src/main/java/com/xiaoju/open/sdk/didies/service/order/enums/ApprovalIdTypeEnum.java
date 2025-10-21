package com.xiaoju.open.sdk.didies.service.order.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApprovalIdTypeEnum {

  OUT_APPROVAL_ID(1, "out_approval_id（外部申请单单号）"),
  APPROVAL_ID(2, "approval_id（滴滴内部申请单号）");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
