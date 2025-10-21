package com.xiaoju.open.sdk.didies.service.budgetcenter.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BudgetIsExactNameEnum {
  /**
   * 是否精确查询名称，枚举值数字
   */
  NO(0, "否"),
  YES(1, "是"),
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