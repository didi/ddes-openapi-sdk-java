package com.xiaoju.open.sdk.didies.core.enums;

import lombok.Getter;

@Getter
public enum LogLevelEnum {

  DEBUG("debug"),
  INFO("info");

  private final String level;

  LogLevelEnum(String level) {
    this.level = level;
  }
}
