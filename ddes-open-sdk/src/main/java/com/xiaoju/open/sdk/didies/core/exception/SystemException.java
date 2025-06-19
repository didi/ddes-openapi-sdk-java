package com.xiaoju.open.sdk.didies.core.exception;

/**
 * 系统异常
 */
public class SystemException extends RuntimeException {

  /**
   * 构造函数
   *
   * @param message 异常信息
   */
  public SystemException(String message) {
    super(message);
  }
}
