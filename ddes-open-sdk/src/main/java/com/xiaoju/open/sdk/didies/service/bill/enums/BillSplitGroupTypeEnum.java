package com.xiaoju.open.sdk.didies.service.bill.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BillSplitGroupTypeEnum {

  DEPARTMENT(1, "按部门拆分"),
  PROJECT(2, "按项目拆分"),
  COMPANY(4, "按公司拆分"),
  CUSTOM_FIELD(6, "按自定义字段、用车制度、用车权限拆分"),
  UNKNOWN(8, "未知主体");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
