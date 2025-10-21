package com.xiaoju.open.sdk.didies.service.city.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CityCountryLevelEnum {
  /**
   * 国家类型, 枚举值数字
   */
  INNER(0, "国内"),
  INTERNATIONAL(1, "国外城市"),
  ALL(2, "国内和国外城市"),
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