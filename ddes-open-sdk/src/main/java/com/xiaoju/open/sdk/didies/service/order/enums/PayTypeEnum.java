package com.xiaoju.open.sdk.didies.service.order.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PayTypeEnum {

  COMPANY_PAY(0, "企业支付"),
  PERSONAL_ADVANCE(1, "个人垫付"),
  MIXED_PAY(2, "混合支付");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
