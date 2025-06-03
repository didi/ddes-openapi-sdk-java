package com.xiaoju.open.sdk.didies.service.bill.enums.car;


import lombok.Getter;

@Getter
public enum CarBillTypeEnum {

  REALTIME("实时"),
  APPOINTMENT("预约"),
  ADJUST_ORDER_INCREASE("调账：订单调增"),
  ADJUST_ORDER_DECREASE("调账：订单调减"),
  ADJUST_SUBJECT_INCREASE("调账：主体调增"),
  ADJUST_SUBJECT_DECREASE("调账：主体调减"),
  NEXT_PERIOD("订单计入下一期");

  private final String description;

  CarBillTypeEnum(String description) {
    this.description = description;
  }
}
