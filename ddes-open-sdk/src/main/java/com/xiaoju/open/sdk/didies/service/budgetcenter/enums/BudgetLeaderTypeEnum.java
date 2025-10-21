package com.xiaoju.open.sdk.didies.service.budgetcenter.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BudgetLeaderTypeEnum {

  MAJOR("major", "主要主管"),
  OTHER("other", "其他主管"),
  ;

  /**
   * 状态码
   */
  private final String code;
  /**
   * 描述
   */
  private final String description;

}