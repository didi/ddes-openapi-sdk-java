package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalInvoiceEnum {

  NO(0, "未开"),
  YES(1, "已开")
  ;

  private final Integer code;
  private final String description;

  ApprovalInvoiceEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
