package com.xiaoju.open.sdk.didies.service.order.enums.afterapproval;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentStatusEnum {

  PENDING(0, "待付款"),
  PAID(1, "已付款"),
  CANCELLED(2, "已取消"),
  CREATION_FAILED(3, "创建失败");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
