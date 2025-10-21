package com.xiaoju.open.sdk.didies.service.order.enums.flight;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RcTypeEnum {

  CABIN_CLASS("舱等RC", "舱等RC"),
  LOW_PRICE("低价RC", "低价RC"),
  EARLY_BOOKING("提前预定RC", "提前预定RC"),
  TRAIN_DURATION_EXCEEDED("同行程火车耗时超标", "同行程火车耗时超标"),
  TRAIN_PRICE_EXCEEDED("同行程火车价格超标", "同行程火车价格超标");

  /**
   * 状态码
   */
  private final String code;
  /**
   * 描述
   */
  private final String description;
}
