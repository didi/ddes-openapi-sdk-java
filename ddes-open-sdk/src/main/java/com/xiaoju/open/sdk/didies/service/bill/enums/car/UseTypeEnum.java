package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UseTypeEnum {
  FOR_CUSTOMER("代客户叫车"),
  FOR_EMPLOYEE("员工自己用车");

  /**
   * code
   */
  private final String code;
}
