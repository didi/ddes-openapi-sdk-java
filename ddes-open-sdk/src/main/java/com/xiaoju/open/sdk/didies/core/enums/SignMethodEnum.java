package com.xiaoju.open.sdk.didies.core.enums;

import lombok.Getter;

@Getter
public enum SignMethodEnum {

  MD5("MD5"),
  SHA256("SHA256");

  private final String signMethod;

  SignMethodEnum(String signMethod) {
    this.signMethod = signMethod;
  }
}
