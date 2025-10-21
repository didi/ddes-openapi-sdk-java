package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OperationTypeEnum {

  NONE(0, "无"),
  MARK(1, "标记"),
  EXPLANATION(3, "解释说明"),
  PERSONAL_PAYMENT(4, "个人支付");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
