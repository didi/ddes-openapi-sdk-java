package com.xiaoju.open.sdk.didies.service.bill.enums.train;

import lombok.Getter;

@Getter
public enum AbnormalEnum {

  NORMAL("", ""),
  OFFLINE_CHANGE("线下已改签", "线下已改签"),
  OFFLINE_REFUND("线下已退票", "线下已退票"),
  OFFLINE_CHANGE_REFUND("线下已改签后线下退票", "线下已改签后线下退票");

  private final String code;
  private final String description;

  AbnormalEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }
}
