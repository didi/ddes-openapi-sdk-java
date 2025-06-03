package com.xiaoju.open.sdk.didies.core.exception;

public class AuthorizeException extends RuntimeException {

  public AuthorizeException() {
    super("接口认证失败！");
  }

  public AuthorizeException(String message) {
    super(message);
  }
}
