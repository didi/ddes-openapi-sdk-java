package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;

@Getter
public enum OperationTypeEnum {

  NONE(0, "无"),
  MARK(1, "标记"),
  EXPLANATION(3, "解释说明"),
  PERSONAL_PAYMENT(4, "个人支付");

  private final Integer code;
  private final String description;

  OperationTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
