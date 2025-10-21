package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SupplierTypeEnum {

  SELF_OPERATED(0, "自营"),
  API(1, "API"),
  HUAXIAOZHU(2, "花小猪自营"),
  HONGHU(3, "鸿鹄三方");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
