package com.xiaoju.open.sdk.didies.service.order.enums.afterapproval;

import lombok.Getter;

@Getter
public enum QueryTimeTypeEnum {

  REJECT_TIME(0, "审批单驳回时间"),
  PERSONAL_PAYMENT_TIME(1, "个人付款时间");

  private final Integer code;
  private final String description;

  QueryTimeTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
