package com.xiaoju.open.sdk.didies.service.member.enums;

import lombok.Getter;

@Getter
public enum MemberSendMessageEnum {

  NOT_SEND(0, "不发送"),
  SEND(1, "发送");

  private final Integer code;
  private final String description;

  MemberSendMessageEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
