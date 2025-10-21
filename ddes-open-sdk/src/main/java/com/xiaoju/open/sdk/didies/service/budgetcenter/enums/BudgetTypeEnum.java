package com.xiaoju.open.sdk.didies.service.budgetcenter.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BudgetTypeEnum {
  DEPARTMENT(1, "部门"),
  PROJECT(2, "项目");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}