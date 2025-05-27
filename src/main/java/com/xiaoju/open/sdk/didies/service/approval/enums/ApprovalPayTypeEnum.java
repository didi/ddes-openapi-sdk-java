package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalPayTypeEnum {
  // 0-企业支付、1-个人支付需报销、2-混合支付（企业和个人各支付部分）
  COMPANY_PAY(0, "企业支付"),
  PERSONAL_PAY(1, "个人支付需报销"),
  MIXED_PAY(2, "混合支付（企业和个人各支付部分）"),
  ;

  private final Integer code;
  private final String description;

  ApprovalPayTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
