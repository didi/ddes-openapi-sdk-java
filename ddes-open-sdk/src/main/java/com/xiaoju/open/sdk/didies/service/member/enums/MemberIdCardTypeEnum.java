package com.xiaoju.open.sdk.didies.service.member.enums;

import lombok.Getter;

@Getter
public enum MemberIdCardTypeEnum {

  ID_CARD(1, "身份证"),
  PASSPORT(2, "护照"),
  HMT_RESIDENCE(3, "港澳台居民居住证"),
  TAIWAN_COMPATRIOT(4, "台胞证"),
  MILITARY_ID(5, "军官证"),
  HOME_RETURN(6, "回乡证"),
  FOREIGN_PERMANENT(7, "外国人永久居留身份证");

  private final Integer code;
  private final String description;

  MemberIdCardTypeEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
