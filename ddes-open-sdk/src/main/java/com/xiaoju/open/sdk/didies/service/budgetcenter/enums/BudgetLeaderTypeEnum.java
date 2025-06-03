package com.xiaoju.open.sdk.didies.service.budgetcenter.enums;


import lombok.Getter;

@Getter
public enum BudgetLeaderTypeEnum {

  MAJOR("major", "主要主管"),
  OTHER("other", "其他主管"),
  ;

  private final String code;
  private final String description;

  BudgetLeaderTypeEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }

}