package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;

@Getter
public enum CarOrderStatusEnum {

  PAID(2, "已支付"),
  REFUNDED(3, "已退款"),
  CANCELLED(4, "已取消"),
  PARTIAL_REFUND(7, "部分退款");

  private final Integer code;
  private final String description;

  CarOrderStatusEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
