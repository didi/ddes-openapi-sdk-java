package com.xiaoju.open.sdk.didies.service.order.enums.hotel;

import lombok.Getter;

@Getter
public enum HotelOrderStatusEnum {

  SUBMITTED("Submitted", "已提交"),
  BOOKING("Booking", "已提交预订"),
  CONFIRMING("Confirming", "商家确认中"),
  BOOKED("Booked", "预订成功"),
  CHECKED_IN("Checkedin", "已入住"),
  COMPLETED("Completed", "已完成"),
  CANCELLED_BEFORE_PAY("Cancelledbeforepay", "支付前取消"),
  CANCELLED_AFTER_PAY("Cancelledafterpay", "支付后取消"),
  NO_SHOW("Noshow", "预订未到"),
  UNKNOWN("Unknow", "未知");

  private final String code;
  private final String description;

  HotelOrderStatusEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }
}
