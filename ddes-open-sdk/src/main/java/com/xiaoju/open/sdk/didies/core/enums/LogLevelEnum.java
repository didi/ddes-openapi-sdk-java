package com.xiaoju.open.sdk.didies.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LogLevelEnum {

  DEBUG("debug"),
  INFO("info");

  /**
   * 日志级别
   */
  private final String level;

}
