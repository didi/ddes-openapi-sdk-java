package com.xiaoju.open.sdk.didies.service.bill.enums.hotel;

import lombok.Getter;

@Getter
public enum HotelOrderStatusEnum {

  SUBMITTED("已提交", "已提交"),
  BOOKING("已提交预订", "已提交预订"),
  REVIEWING("商家审核中", "商家审核中"),
  BOOKED("预订成功", "预订成功"),
  CHECKED_IN("已入住", "已入住"),
  COMPLETED("已完成", "已完成"),
  ORDER_CANCELLED("已取消订单", "已取消订单"),
  BOOKING_CANCELLED("已取消预订", "已取消预订"),
  NO_SHOW("预订未到", "预订未到");

  private final String code;
  private final String description;

  HotelOrderStatusEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }
}
