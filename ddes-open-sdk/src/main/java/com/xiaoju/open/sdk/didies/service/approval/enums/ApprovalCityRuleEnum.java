package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalCityRuleEnum {

  NO(0, "不包含"),
  YES(1, "包含"),
  ;

  private final Integer code;
  private final String description;

  ApprovalCityRuleEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
