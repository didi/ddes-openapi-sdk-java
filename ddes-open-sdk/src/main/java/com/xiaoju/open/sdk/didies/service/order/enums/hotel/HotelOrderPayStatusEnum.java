package com.xiaoju.open.sdk.didies.service.order.enums.hotel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HotelOrderPayStatusEnum {

  UNPAID(0, "未支付"),
  PAID(1, "已支付"),
  ;

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
