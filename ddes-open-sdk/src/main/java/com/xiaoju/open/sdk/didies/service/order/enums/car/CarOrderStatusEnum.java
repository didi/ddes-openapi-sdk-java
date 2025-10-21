package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CarOrderStatusEnum {

  PAID(2, "已支付"),
  REFUNDED(3, "已退款"),
  CANCELLED(4, "已取消"),
  PARTIAL_REFUND(7, "部分退款");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
