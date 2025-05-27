package com.xiaoju.open.sdk.didies.service.budgetcenter.enums;


import lombok.Getter;

@Getter
public enum BudgetTypeEnum {
  DEPARTMENT(1, "部门"),
  PROJECT(2, "项目");

  private final Integer code;
  private final String description;

  BudgetTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}