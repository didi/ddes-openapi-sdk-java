package com.xiaoju.open.sdk.didies.service.order.enums.flight;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FlightClassEnum {

  FIRST_CLASS("F", "头等舱"),
  BUSINESS_CLASS("C", "商务舱"),
  ECONOMY_CLASS("Y", "经济舱");

  /**
   * 状态码
   */
  private final String code;
  /**
   * 描述
   */
  private final String description;
}
