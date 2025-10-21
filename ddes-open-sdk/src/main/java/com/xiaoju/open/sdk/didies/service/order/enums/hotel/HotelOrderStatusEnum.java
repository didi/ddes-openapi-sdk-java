package com.xiaoju.open.sdk.didies.service.order.enums.hotel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
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

  /**
   * 状态码
   */
  private final String code;
  /**
   * 描述
   */
  private final String description;
}
