package com.xiaoju.open.sdk.didies.service.city.enums;


import lombok.Getter;

@Getter
public enum CityCountryLevelEnum {
  /**
   * 国家类型, 枚举值数字
   */
  INNER(0, "国内"),
  INTERNATIONAL(1, "国外城市"),
  ALL(2, "国内和国外城市"),
  ;

  private final Integer code;
  private final String description;

  CityCountryLevelEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}