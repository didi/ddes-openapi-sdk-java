package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalControlProductEnum {

  CITY_CAR(1, "市内用车");

  private final Integer code;
  private final String description;

  ApprovalControlProductEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
