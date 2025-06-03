package com.xiaoju.open.sdk.didies.service.bill.enums;

import lombok.Getter;

@Getter
public enum BusinessTypeEnum {

  RIDE_HAILING(0, "网约车"),
  DESIGNATED_DRIVER(40, "代驾"),
  DOMESTIC_FLIGHT(11, "国内机票"),
  TAXI(100, "出租车"),
  DOMESTIC_HOTEL(201, "国内酒店"),
  BILL_DOMESTIC_FLIGHT(202, "账单国内机票"),
  TRAIN_TICKET(203, "火车票"),
  INTERNATIONAL_HOTEL(204, "国际酒店"),
  INTERNATIONAL_FLIGHT(205, "国际机票"),
  MANUAL_ORDER(531, "手工增值单");

  private final Integer code;
  private final String description;

  BusinessTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
