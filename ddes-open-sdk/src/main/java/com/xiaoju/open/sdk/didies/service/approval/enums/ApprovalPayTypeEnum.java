package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApprovalPayTypeEnum {
  COMPANY_PAY(0, "企业支付"),
  PERSONAL_PAY(1, "个人支付需报销"),
  MIXED_PAY(2, "混合支付（企业和个人各支付部分）"),
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
