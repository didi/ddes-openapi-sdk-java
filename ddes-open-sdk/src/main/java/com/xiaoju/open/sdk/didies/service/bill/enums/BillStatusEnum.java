package com.xiaoju.open.sdk.didies.service.bill.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BillStatusEnum {

  GENERATING(0, "生成中"),
  TO_BE_CONFIRMED(1, "生成成功（待确认）"),
  GENERATION_FAILED(2, "生成失败"),
  CONFIRMED(3, "已确认");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
