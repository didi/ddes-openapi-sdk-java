package com.xiaoju.open.sdk.didies.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EncryptTypeEnum {

  NORMAL(0, "不加密"),
  AES128(1, "aes 128"),
  AES256(2, "aes 256");

  /**
   * 类型
   */
  private final Integer type;
  /**
   * 描述
   */
  private final String description;
}
