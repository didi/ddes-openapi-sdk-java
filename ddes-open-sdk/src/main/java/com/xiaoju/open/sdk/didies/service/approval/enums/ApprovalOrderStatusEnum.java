package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalOrderStatusEnum {
  FAILED(1, "发单失败"),
  PAYED(2, "已支付"),
  REFUND(3, "已退款"),
  CANCEL(4, "已取消"),
  WAIT_PAY(5, "待支付"),
  PART_PAY(6, "部分支付"),
  PART_REFUND(7, "部分退款");

  private final Integer code;
  private final String description;

  ApprovalOrderStatusEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
