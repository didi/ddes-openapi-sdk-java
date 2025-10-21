package com.xiaoju.open.sdk.didies.service.order.enums.afterapproval;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum QueryTimeTypeEnum {

  REJECT_TIME(0, "审批单驳回时间"),
  PERSONAL_PAYMENT_TIME(1, "个人付款时间");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
