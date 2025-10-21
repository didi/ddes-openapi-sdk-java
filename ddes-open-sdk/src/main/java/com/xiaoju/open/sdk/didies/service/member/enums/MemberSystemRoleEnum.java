package com.xiaoju.open.sdk.didies.service.member.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberSystemRoleEnum {

  VEHICLE_BOOKER(0, "车辆预定人员"),
  NORMAL_ADMIN(1, "普通管理员"),
  SUPER_ADMIN(2, "超级管理员");

  /**
   * 状态码
   */
  private final Integer code;
  /**
   * 描述
   */
  private final String description;
}
