package com.xiaoju.open.sdk.didies.core.exception;

/**
 * 服务器响应超时异常
 */
public class ServerTimeoutException extends RuntimeException {

  /**
   * 构造函数
   */
  public ServerTimeoutException() {
    super("请求响应超时！");
  }

}
