package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;

@Getter
public enum UserPayTypeEnum {
  USER_INITIATED("用户主动支付"),
  SYSTEM_AUTO("系统自动支付"),
  SYSTEM_THEN_USER("系统自动支付后用户主动支付");

  private final String description;

  UserPayTypeEnum(String description) {
    this.description = description;
  }
}
