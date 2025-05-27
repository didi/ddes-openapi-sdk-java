package com.xiaoju.open.sdk.didies.core.exception;

public class AccessTokenNotGivenException extends RuntimeException {

  public AccessTokenNotGivenException() {
    super("未提供access_token！");
  }

}
