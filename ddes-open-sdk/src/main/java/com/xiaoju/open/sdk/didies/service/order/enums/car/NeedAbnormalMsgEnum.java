package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NeedAbnormalMsgEnum {

  NO(0, "否"),
  YES(1, "是");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
