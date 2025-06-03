package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalPolicyTypeEnum {

  OUT_RANK_ID(1, "外部职级编号"),
  EMPLOYEE_NUMBER(2, "员工工号"),
  EMPLOYEE_PHONE(3, "员工手机号"),
  EMPLOYEE_EMAIL(4, "员工邮箱"),
  REGULATION_ID(5, "制度ID");

  private final Integer code;
  private final String description;

  ApprovalPolicyTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
