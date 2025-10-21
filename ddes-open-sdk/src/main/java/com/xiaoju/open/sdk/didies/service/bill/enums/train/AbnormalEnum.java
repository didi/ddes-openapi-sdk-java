package com.xiaoju.open.sdk.didies.service.bill.enums.train;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AbnormalEnum {

  NORMAL(""),
  OFFLINE_CHANGE("线下已改签"),
  OFFLINE_REFUND("线下已退票"),
  OFFLINE_CHANGE_REFUND("线下已改签后线下退票");

  /**
   * 状态码
   */
  private final String code;
}
