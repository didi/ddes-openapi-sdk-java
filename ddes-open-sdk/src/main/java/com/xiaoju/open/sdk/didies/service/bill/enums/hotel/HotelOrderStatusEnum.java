package com.xiaoju.open.sdk.didies.service.bill.enums.hotel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HotelOrderStatusEnum {

  SUBMITTED("已提交"),
  BOOKING("已提交预订"),
  REVIEWING("商家审核中"),
  BOOKED("预订成功"),
  CHECKED_IN("已入住"),
  COMPLETED("已完成"),
  ORDER_CANCELLED("已取消订单"),
  BOOKING_CANCELLED("已取消预订"),
  NO_SHOW("预订未到");

  /**
   * code
   */
  private final String code;
}
