package com.xiaoju.open.sdk.didies.core.exception;

public class DataEncryptException extends RuntimeException {

  public DataEncryptException(String message) {
    super(message);
  }

  public DataEncryptException() {
    super("数据加解密异常！");
  }

  public DataEncryptException(String message, Throwable cause) {
    super(message, cause);
  }
}
