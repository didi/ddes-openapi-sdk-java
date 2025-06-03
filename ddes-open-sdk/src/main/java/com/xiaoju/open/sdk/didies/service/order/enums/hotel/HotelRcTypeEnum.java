package com.xiaoju.open.sdk.didies.service.order.enums.hotel;

import lombok.Getter;

@Getter
public enum HotelRcTypeEnum {

  ROOM_RATE("房费RC", "房费RC"),
  STAR_RATING("星级RC", "星级RC"),
  EARLY_BOOKING("提前预定RC", "提前预定RC"),
  AGREEMENT_PRICE("协议价RC", "协议价RC");

  private final String code;
  private final String description;

  HotelRcTypeEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }
}
