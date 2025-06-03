package com.xiaoju.open.sdk.didies.service.order.enums.afterapproval;

import lombok.Getter;

@Getter
public enum PaymentStatusEnum {

  PENDING(0, "待付款"),
  PAID(1, "已付款"),
  CANCELLED(2, "已取消"),
  CREATION_FAILED(3, "创建失败");

  private final Integer code;
  private final String description;

  PaymentStatusEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
