package com.xiaoju.open.sdk.didies.service.bill.enums;

import lombok.Getter;

@Getter
public enum BillStatusEnum {

  GENERATING(0, "生成中"),
  TO_BE_CONFIRMED(1, "生成成功（待确认）"),
  GENERATION_FAILED(2, "生成失败"),
  CONFIRMED(3, "已确认");

  private final Integer code;
  private final String description;

  BillStatusEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
