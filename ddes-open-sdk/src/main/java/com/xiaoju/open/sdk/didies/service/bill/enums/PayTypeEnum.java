package com.xiaoju.open.sdk.didies.service.bill.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PayTypeEnum {

  ENTERPRISE_PAYMENT("企业支付"),
  PERSONAL_PAYMENT("个人支付"),
  MIXED_PAYMENT("混合支付"),
  ENTERPRISE_WALLET("企业钱包支付");

  /**
   * 状态码
   */
  private final String code;
}
