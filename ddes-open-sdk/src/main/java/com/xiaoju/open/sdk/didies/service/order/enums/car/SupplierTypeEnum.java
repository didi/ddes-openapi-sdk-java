package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;

@Getter
public enum SupplierTypeEnum {

  SELF_OPERATED(0, "自营"),
  API(1, "API"),
  HUAXIAOZHU(2, "花小猪自营"),
  HONGHU(3, "鸿鹄三方");

  private final Integer code;
  private final String description;

  SupplierTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
