package com.xiaoju.open.sdk.didies.service.member.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberSourceEnum {

  UNKNOWN(0, "未知"),
  PC_ADD_ONE_BY_ONE(1, "PC逐一添加"),
  PC_BATCH_IMPORT(2, "PC批量导入"),
  EMAIL_INVITATION(3, "邮件邀请");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
