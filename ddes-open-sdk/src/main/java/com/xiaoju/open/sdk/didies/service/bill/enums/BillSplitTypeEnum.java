package com.xiaoju.open.sdk.didies.service.bill.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BillSplitTypeEnum {

  TRAVELER_DEPARTMENT(1, "按出行人部门拆分"),
  BOOKER_DEPARTMENT(2, "按预订人部门拆分"),
  COST_CENTER(3, "按成本中心拆分"),
  TRAVELER_COMPANY(4, "按出行人所属公司拆分"),
  BOOKER_COMPANY(5, "按预订人所属公司拆分"),
  CUSTOM_FIELD(6, "按自定义字段拆分"),
  MULTI_DIMENSION(7, "多维拆帐");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
