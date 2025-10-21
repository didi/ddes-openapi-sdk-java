package com.xiaoju.open.sdk.didies.service.budgetcenter.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BudgetIsLimitQuotaEnum {
  /**
   * 是否限额，枚举值数字0 不限制 1 限制
   */
  NO(0, "不限制"),
  YES(1, "限制"),
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