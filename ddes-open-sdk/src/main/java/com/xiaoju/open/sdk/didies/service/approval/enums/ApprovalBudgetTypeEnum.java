package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalBudgetTypeEnum {

  APPLICATION(1, "申请单维度");

  private final Integer code;
  private final String description;

  ApprovalBudgetTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
