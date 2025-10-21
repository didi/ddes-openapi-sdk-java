package com.xiaoju.open.sdk.didies.core.exception;

/**
 * 未提供access_token异常
 */
public class AccessTokenNotGivenException extends RuntimeException {

  /**
   * 构造函数
   */
  public AccessTokenNotGivenException() {
    super("未提供access_token！");
  }

}
