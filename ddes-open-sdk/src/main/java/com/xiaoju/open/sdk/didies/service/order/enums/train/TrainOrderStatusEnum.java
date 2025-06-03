package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;

@Getter
public enum TrainOrderStatusEnum {

  HOLDING("Holding", "占座中"),
  TO_BE_PAID("Tobepaid", "待支付"),
  WAIT_FOR_APPROVAL("Waitforapproval", "待审批"),
  CANCELLED("Cancelled", "已取消"),
  CLOSED("Closed", "订单关闭"),
  TICKETING("Ticketing", "待出票"),
  TICKETED("Ticketed", "已出票"),
  REFUNDING("refunding", "退票中"),
  PARTIAL_REFUND("Partialrefund", "部分退票"),
  REFUNDED("Refunded", "已退票"),
  CHANGE_HOLDING("Change Holding", "改签占座中"),
  CHANGE_TO_BE_PAID("Change to be paid", "改签待支付"),
  CHANGING("Changing", "改签中"),
  COMPLETED("Completed", "已完成"),
  UNKNOWN("Unknow", "未知"),
  GRABBING("Grabbing", "抢票中"),
  GRAB_ERROR("Grab error", "抢票异常"),
  CANCELLING("Canceling", "取消中"),
  CANCEL_ERROR("Cancel error", "取消异常"),
  GRAB_FAILED("Grab failed", "抢票失败");

  private final String code;
  private final String description;

  TrainOrderStatusEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }
}