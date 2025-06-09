package com.xiaoju.open.sdk.didies.service.regulation.enums;

import lombok.Getter;

@Getter
public enum IsWorkspaceEnum {

  NO(0, "否"),
  YES(1, "是");

  private final Integer code;
  private final String description;

  IsWorkspaceEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
