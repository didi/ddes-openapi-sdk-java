package com.xiaoju.open.sdk.didies.service.budgetcenter.enums;


import lombok.Getter;

@Getter
public enum BudgetIsExactNameEnum {
  /**
   * 是否精确查询名称，枚举值数字
   */
  NO(0, "否"),
  YES(1, "是"),
  ;

  private final Integer code;
  private final String description;

  BudgetIsExactNameEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}