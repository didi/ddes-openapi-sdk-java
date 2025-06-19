package com.xiaoju.open.sdk.didies.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SignMethodEnum {

  MD5("MD5"),
  SHA256("SHA256");

  /**
   * 签名方法
   */
  private final String signMethod;
}
