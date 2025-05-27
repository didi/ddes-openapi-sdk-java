package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalExecutiveRegulationTypeEnum {

  EXECUTIVE_APPLICATION(0, "执行申请人制度"),
  EXECUTIVE_OUTER_PASSENGER(1, "执行外部出行人不限差标"),
  EXECUTIVE_PASSENGER(2, "执行出行人制度"),
  EXECUTIVE_MULTI_PASSENGER(3, "执行多人多差标制度"),
  ;

  private final Integer code;
  private final String description;

  ApprovalExecutiveRegulationTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
