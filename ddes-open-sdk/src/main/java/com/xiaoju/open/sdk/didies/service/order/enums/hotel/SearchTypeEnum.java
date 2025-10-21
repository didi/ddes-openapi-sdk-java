package com.xiaoju.open.sdk.didies.service.order.enums.hotel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SearchTypeEnum {

  DIRECT_ONLY(1, "只要直飞"),
  TRANSFER_ONLY(2, "只要中转"),
  ALL(3, "全部搜索");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
