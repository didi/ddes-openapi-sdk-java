package com.xiaoju.open.sdk.didies.service.member.enums;

import lombok.Getter;

@Getter
public enum MemberSystemRoleEnum {

  VEHICLE_BOOKER(0, "车辆预定人员"),
  NORMAL_ADMIN(1, "普通管理员"),
  SUPER_ADMIN(2, "超级管理员");

  private final Integer code;
  private final String description;

  MemberSystemRoleEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
