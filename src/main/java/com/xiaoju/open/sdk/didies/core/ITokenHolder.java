package com.xiaoju.open.sdk.didies.core;

public interface ITokenHolder {

  /**
   * 获取token
   *
   * @return token
   */
  String getAccessToken();

  /**
   * 是否过期
   *
   * @return true | false
   */
  boolean isExpired();
}
