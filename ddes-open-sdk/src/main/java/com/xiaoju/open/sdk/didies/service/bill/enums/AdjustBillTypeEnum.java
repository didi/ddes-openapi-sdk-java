package com.xiaoju.open.sdk.didies.service.bill.enums;

import lombok.Getter;

@Getter
public enum AdjustBillTypeEnum {

  DEFER_TO_NEXT_PERIOD(1, "订单计入下期"),
  ADJUSTMENT(2, "订单信息调整");

  private final int code;
  private final String description;

AdjustBillTypeEnum(int code, String description) {
    this.code = code;
    this.description = description;
  }
}
