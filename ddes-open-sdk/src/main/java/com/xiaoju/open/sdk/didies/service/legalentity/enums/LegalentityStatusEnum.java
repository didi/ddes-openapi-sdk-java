package com.xiaoju.open.sdk.didies.service.legalentity.enums;


import lombok.Getter;

@Getter
public enum LegalentityStatusEnum {

  ENABLE(0, "启用"),
  DISABLE(1, "停用"),
  ;

  private final Integer code;
  private final String description;

  LegalentityStatusEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}