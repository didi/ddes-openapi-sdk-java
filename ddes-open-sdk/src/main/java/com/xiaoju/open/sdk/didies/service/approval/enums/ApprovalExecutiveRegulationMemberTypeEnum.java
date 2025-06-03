package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalExecutiveRegulationMemberTypeEnum {

  PHONE(0, "手机号"),
  EMPLOYEE_ID(1, "工号"),
  EMAIL(2, "邮箱");

  private final Integer code;
  private final String description;

  ApprovalExecutiveRegulationMemberTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
