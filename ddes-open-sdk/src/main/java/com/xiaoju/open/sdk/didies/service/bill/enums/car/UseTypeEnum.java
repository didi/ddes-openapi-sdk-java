package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;

@Getter
public enum UseTypeEnum {
  FOR_CUSTOMER("代客户叫车"),
  FOR_EMPLOYEE("员工自己用车");

  private final String description;

  UseTypeEnum(String description) {
    this.description = description;
  }
}
