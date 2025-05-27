package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;

@Getter
public enum TrainTicketStatusEnum {

  HOLDING("Holding", "占座中"),
  HELD("Held", "占座成功"),
  CANCELLED("Cancelled", "已取消"),
  TICKETING("Ticketing", "出票中"),
  OPEN_FOR_USE("Openforuse", "待乘车"),
  OUTBOUND("Outbound", "已出站"),
  REFUNDING("refunding", "退票中"),
  REFUNDED("Refunded", "已退票"),
  CHANGING("Changing", "改签中"),
  CHANGED("Changed", "已改签"),
  WAIT_FOR_APPROVAL("Waitforapproval", "待审批"),
  REFUNDED_OTHER("Refoundedother", "其它平台退票"),
  CHANGED_OTHER("Chagnedother", "其它平台改签"),
  REFUNDED_AFTER_CHANGED_OTHER("Refoundedafterchagnedother", "其它平台退改"),
  UNKNOWN("Unknow", "未知");

  private final String code;
  private final String description;

  TrainTicketStatusEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }
}