package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApprovalInvoiceEnum {

  NO(0, "未开"),
  YES(1, "已开")
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
