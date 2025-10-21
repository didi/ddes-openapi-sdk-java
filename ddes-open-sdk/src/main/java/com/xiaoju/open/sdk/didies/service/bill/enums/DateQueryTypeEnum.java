package com.xiaoju.open.sdk.didies.service.bill.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DateQueryTypeEnum {
  COMPLETE_SETTLEMENT_TIME(0, "返回【完单时间】/【结算时间】在入参【开始日期】、【结束日期】内的数据"),
  SETTLEMENT_UPDATE_TIME(1, "返回【结算信息更新时间】在入参【开始日期】、【结束日期】内的数据");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
