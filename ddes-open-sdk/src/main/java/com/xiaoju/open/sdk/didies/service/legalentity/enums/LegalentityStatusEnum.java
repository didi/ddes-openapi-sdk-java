package com.xiaoju.open.sdk.didies.service.legalentity.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LegalentityStatusEnum {

  ENABLE(0, "启用"),
  DISABLE(1, "停用"),
  ;

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}