package com.xiaoju.open.sdk.didies.service.bill.enums.hotel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IsVatEnum {

  YES("是"),
  NO("否");

  /**
   * 状态码
   */
  private final String code;
}
