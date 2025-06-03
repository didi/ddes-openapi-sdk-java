package com.xiaoju.open.sdk.didies.service.order.enums.afterapproval;

import lombok.Getter;

@Getter
public enum PaymentTypeEnum {

  POST_APPROVAL(0, "行后审批单"),
  ENTERPRISE_TO_PERSONAL(1, "企业转个人支付"),
  PERSONAL_TO_ENTERPRISE(2, "个人支转企业");

  private final Integer code;
  private final String description;

  PaymentTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
