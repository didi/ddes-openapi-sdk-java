package com.xiaoju.open.sdk.didies.service.order.enums.flight;

import lombok.Getter;

@Getter
public enum FlightOrderStatusEnum {

  TO_BE_PAID("Tobepaid", "待支付"),
  WAIT_FOR_APPROVAL("Waitforapproval", "待审批"),
  TICKETING("Ticketing", "待出票"),
  TICKETED("Ticketed", "已出票"),
  ACCOUNTING_FOR_CHANGE_FEE("Accountingforchangefee", "改签待核算"),
  CHANGING("Changing", "改签中"),
  REFUNDING("refunding", "退票中"),
  COMPLETED("Completed", "已完成"),
  REFUNDED("Refunded", "已退票"),
  PARTIAL_REFUND("Partialrefund", "部分退票"),
  CLOSED("Closed", "订单关闭"),
  CANCELLED("Cancelled", "已取消"),
  UNKNOWN("Unknow", "未知");

  private final String code;
  private final String description;

  FlightOrderStatusEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }
}
