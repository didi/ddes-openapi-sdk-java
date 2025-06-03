package com.xiaoju.open.sdk.didies.service.budgetcenter.enums;


import lombok.Getter;

@Getter
public enum BudgetCycleEnum {
  /**
   * 说明：其中2、3只对部门生效，需要设置白名单，须联系客户经理）
   */
  NONE(0, "不限额"),
  MONTH(1, "自然月"),
  QUARTER(2, "自然季度"),
  YEAR(2, "自然年"),
  ;

  private final Integer code;
  private final String description;

  BudgetCycleEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}