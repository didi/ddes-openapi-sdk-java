package com.xiaoju.open.sdk.didies.service.order.enums;

import lombok.Getter;

@Getter
public enum PayTypeEnum {

  COMPANY_PAY(0, "企业支付"),
  PERSONAL_ADVANCE(1, "个人垫付"),
  MIXED_PAY(2, "混合支付");

  private final Integer code;
  private final String description;

  PayTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
