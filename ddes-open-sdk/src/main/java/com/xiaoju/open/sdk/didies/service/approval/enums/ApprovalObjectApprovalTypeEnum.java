package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApprovalObjectApprovalTypeEnum {

  PERSONAL_TO_ENTERPRISE(4, "个转企类型"),
  ENTERPRISE_CAR_USAGE(21, "企业级事前审批单用车")
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
