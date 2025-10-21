package com.xiaoju.open.sdk.didies.service.order.enums.flight;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FlightTicketStatusEnum {

  OPEN_FOR_USE("OpenForUse", "客票有效未使用"),
  CHECKED_IN("CheckedIn", "已办理值机手续"),
  BOARDED("Boarded", "已登机"),
  USED("Used", "已使用"),
  REFUNDED("Refunded", "已退票"),
  EXCHANGED("Exchanged", "电子客票已换开为其他客票"),
  SUSPENDED("Suspended", "系统处理中或认为挂起禁止使用"),
  VOID("Void", "已作废"),
  AIRPORT_CNTL("Airport CNTL", "机场控制"),
  CPN_NOTE("CPN Note", "机场控制"),
  UNKNOWN("UnKnow", "未知");

  /**
   * 状态码
   */
  private final String code;
  /**
   * 描述
   */
  private final String description;
}
