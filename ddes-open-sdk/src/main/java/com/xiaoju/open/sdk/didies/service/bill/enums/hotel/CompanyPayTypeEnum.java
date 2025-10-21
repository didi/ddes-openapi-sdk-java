package com.xiaoju.open.sdk.didies.service.bill.enums.hotel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CompanyPayTypeEnum {

  CONSUMPTION("消费"),
  REFUND("退款");

  /**
   * code
   */
  private final String code;
}
