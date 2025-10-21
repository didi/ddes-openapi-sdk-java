package com.xiaoju.open.sdk.didies.service.bill.enums.flight;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FlightTravelTypeEnum {

  DOMESTIC_MAINLAND(0, "国内大陆"),
  INTERNATIONAL(1, "国际+港澳台");
  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
