package com.xiaoju.open.sdk.didies.service.bill.enums.flight;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UpgradeFinalStatusEnum {

  NOT_FINAL(-1, "起飞未到终态/预定口径"),
  SPECIAL(0, "特殊-私退私改"),
  USED(1, "终态-已使用"),
  REFUNDED(2, "终态-已退票");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
