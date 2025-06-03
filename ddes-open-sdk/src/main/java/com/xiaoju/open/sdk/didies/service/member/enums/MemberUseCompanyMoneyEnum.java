package com.xiaoju.open.sdk.didies.service.member.enums;

import lombok.Getter;

@Getter
public enum MemberUseCompanyMoneyEnum {

  NO(0, "否"),
  YES(1, "是");

  private final Integer code;
  private final String description;

  MemberUseCompanyMoneyEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
