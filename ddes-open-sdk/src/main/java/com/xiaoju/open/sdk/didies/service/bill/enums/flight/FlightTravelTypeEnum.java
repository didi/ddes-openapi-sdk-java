package com.xiaoju.open.sdk.didies.service.bill.enums.flight;

import lombok.Getter;

@Getter
public enum FlightTravelTypeEnum {

  DOMESTIC_MAINLAND(0, "国内大陆"),
  INTERNATIONAL(1, "国际+港澳台");

  private final Integer code;
  private final String description;

  FlightTravelTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
