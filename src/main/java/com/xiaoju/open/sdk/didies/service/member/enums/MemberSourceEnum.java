package com.xiaoju.open.sdk.didies.service.member.enums;

import lombok.Getter;

@Getter
public enum MemberSourceEnum {

  UNKNOWN(0, "未知"),
  PC_ADD_ONE_BY_ONE(1, "PC逐一添加"),
  PC_BATCH_IMPORT(2, "PC批量导入"),
  EMAIL_INVITATION(3, "邮件邀请");

  private final Integer code;
  private final String description;

  MemberSourceEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
