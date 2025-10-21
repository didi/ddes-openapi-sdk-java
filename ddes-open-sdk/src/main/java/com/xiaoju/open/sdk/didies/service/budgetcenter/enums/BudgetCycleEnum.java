package com.xiaoju.open.sdk.didies.service.budgetcenter.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BudgetCycleEnum {
  /**
   * 说明：其中2、3只对部门生效，需要设置白名单，须联系客户经理）
   */
  NONE(0, "不限额"),
  MONTH(1, "自然月"),
  QUARTER(2, "自然季度"),
  YEAR(2, "自然年"),
  ;

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}