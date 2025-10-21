package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SupplierTypeEnum {
  DIDI_SELF_OPERATED("滴滴自营"),
  DIDI_SUB_BRAND("滴滴旗下品牌"),
  THIRD_PARTY("第三方服务");

  /**
   * code
   */
  private final String code;
}
