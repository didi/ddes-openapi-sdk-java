package com.xiaoju.open.sdk.didies.core.exception;

/**
 * 数据加解密异常
 */
public class DataEncryptException extends RuntimeException {

  /**
   * 构造函数
   *
   * @param message 异常信息
   */
  public DataEncryptException(String message) {
    super(message);
  }

  /**
   * 构造函数
   */
  public DataEncryptException() {
    super("数据加解密异常！");
  }

  /**
   * 构造函数
   *
   * @param message 异常信息
   * @param cause   异常原因
   */
  public DataEncryptException(String message, Throwable cause) {
    super(message, cause);
  }
}
