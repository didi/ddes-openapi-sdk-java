package com.xiaoju.open.sdk.didies.service.bill.enums;

import lombok.Getter;

@Getter
public enum PayTypeEnum {

  ENTERPRISE_PAYMENT("企业支付", "企业支付"),
  PERSONAL_PAYMENT("个人支付", "个人支付"),
  MIXED_PAYMENT("混合支付", "混合支付"),
  ENTERPRISE_WALLET("企业钱包支付", "企业钱包支付");

  private final String code;
  private final String description;

  PayTypeEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }
}
