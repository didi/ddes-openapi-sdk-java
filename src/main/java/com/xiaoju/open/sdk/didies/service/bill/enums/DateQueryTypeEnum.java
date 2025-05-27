package com.xiaoju.open.sdk.didies.service.bill.enums;

import lombok.Getter;

@Getter
public enum DateQueryTypeEnum {
  COMPLETE_SETTLEMENT_TIME(0, "返回【完单时间】/【结算时间】在入参【开始日期】、【结束日期】内的数据"),
  SETTLEMENT_UPDATE_TIME(1, "返回【结算信息更新时间】在入参【开始日期】、【结束日期】内的数据");

  private final int code;
  private final String description;

  DateQueryTypeEnum(int code, String description) {
    this.code = code;
    this.description = description;
  }
}
