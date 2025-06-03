package com.xiaoju.open.sdk.didies.service.budgetcenter.enums;


import lombok.Getter;

@Getter
public enum BudgetMemberUsedEnum {
  /**
   * 使用范围，枚举值数字 type=2时生效，
   * 说明：不传默认为0 (枚举 2需要设置白名单，须联系客户经理。报错误码10001)
   */
  ALL(0, "全员可见"),
  PROJECT_MEMBER(1, "项目成员内可见"),
  COMPANY(2, "公司主体内可见"),
  ;

  private final Integer code;
  private final String description;

  BudgetMemberUsedEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}