package com.xiaoju.open.sdk.didies.service.order.enums.hotel;

import lombok.Getter;

@Getter
public enum SearchTypeEnum {

  DIRECT_ONLY(1, "只要直飞"),
  TRANSFER_ONLY(2, "只要中转"),
  ALL(3, "全部搜索");

  private final Integer code;
  private final String description;

  SearchTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
