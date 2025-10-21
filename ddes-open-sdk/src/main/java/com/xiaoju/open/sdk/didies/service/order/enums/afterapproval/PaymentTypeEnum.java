package com.xiaoju.open.sdk.didies.service.order.enums.afterapproval;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentTypeEnum {

  POST_APPROVAL(0, "行后审批单"),
  ENTERPRISE_TO_PERSONAL(1, "企业转个人支付"),
  PERSONAL_TO_ENTERPRISE(2, "个人支转企业");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
