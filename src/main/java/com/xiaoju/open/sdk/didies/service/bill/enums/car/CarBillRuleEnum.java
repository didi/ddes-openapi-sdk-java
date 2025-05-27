package com.xiaoju.open.sdk.didies.service.bill.enums.car;


import lombok.Getter;

@Getter
public enum CarBillRuleEnum {
  TAXI("出租车"),
  SPECIAL_CAR("专车"),
  EXPRESS_CAR("快车"),
  DESIGNATED_DRIVER("代驾"),
  LUXURY_CAR("豪华车"),
  PRIVATE_CAR_FOR_PUBLIC("私车公用"),
  SIMULTANEOUS_CALL("同时呼叫");

  private final String description;

  CarBillRuleEnum(String description) {
    this.description = description;
  }
}
