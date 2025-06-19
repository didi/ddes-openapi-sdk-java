package com.xiaoju.open.sdk.didies.core.exception;

/**
 * 认证失败异常
 */
public class AuthorizeException extends RuntimeException {

  /**
   * 构造函数
   */
  public AuthorizeException() {
    super("接口认证失败！");
  }

  /**
   * 构造函数
   *
   * @param message 异常信息
   */
  public AuthorizeException(String message) {
    super(message);
  }
}
