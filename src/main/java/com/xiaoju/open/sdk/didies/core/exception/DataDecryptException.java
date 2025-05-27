package com.xiaoju.open.sdk.didies.core.exception;

/**
 * @author : qinglong
 * @description :
 * @date : 2025/4/28 10:58
 * @since :
 */
public class DataDecryptException extends RuntimeException {

  public DataDecryptException(String message) {
    super(message);
  }

  public DataDecryptException() {
    super("数据加解密异常！");
  }

  public DataDecryptException(String message, Throwable cause) {
    super(message, cause);
  }
}
