package com.xiaoju.open.sdk.didies.service.order.enums.hotel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HotelRcTypeEnum {

  ROOM_RATE("房费RC", "房费RC"),
  STAR_RATING("星级RC", "星级RC"),
  EARLY_BOOKING("提前预定RC", "提前预定RC"),
  AGREEMENT_PRICE("协议价RC", "协议价RC");

  /**
   * 状态码
   */
  private final String code;
  /**
   * 描述
   */
  private final String description;
}
