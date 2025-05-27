package com.xiaoju.open.sdk.didies.core.exception;

public class ServerTimeoutException extends RuntimeException {

  public ServerTimeoutException() {
    super("请求响应超时！");
  }

}
