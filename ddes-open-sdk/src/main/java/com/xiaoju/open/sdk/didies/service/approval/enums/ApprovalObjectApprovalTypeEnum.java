package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalObjectApprovalTypeEnum {

  PERSONAL_TO_ENTERPRISE(4, "个转企类型"),
  ENTERPRISE_CAR_USAGE(21, "企业级事前审批单用车")
  ;

  private final Integer code;
  private final String description;

  ApprovalObjectApprovalTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
