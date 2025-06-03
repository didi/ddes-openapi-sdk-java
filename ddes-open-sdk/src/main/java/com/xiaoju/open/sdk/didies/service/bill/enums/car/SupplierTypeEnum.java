package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;

@Getter
public enum SupplierTypeEnum {
  DIDI_SELF_OPERATED("滴滴自营"),
  DIDI_SUB_BRAND("滴滴旗下品牌"),
  THIRD_PARTY("第三方服务");

  private final String description;

  SupplierTypeEnum(String description) {
    this.description = description;
  }
}
