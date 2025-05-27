package com.xiaoju.open.sdk.didies.service.order.enums.hotel;

import lombok.Getter;

@Getter
public enum HotelOrderPayStatusEnum {

  UNPAID(0, "未支付"),
  PAID(1, "已支付"),
  ;

  private final Integer code;
  private final String description;

  HotelOrderPayStatusEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
