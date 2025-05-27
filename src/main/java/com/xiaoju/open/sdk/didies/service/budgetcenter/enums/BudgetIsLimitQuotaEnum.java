package com.xiaoju.open.sdk.didies.service.budgetcenter.enums;


import lombok.Getter;

@Getter
public enum BudgetIsLimitQuotaEnum {
  /**
   * 是否限额，枚举值数字0 不限制 1 限制
   */
  NO(0, "不限制"),
  YES(1, "限制"),
  ;

  private final Integer code;
  private final String description;

  BudgetIsLimitQuotaEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}