package com.xiaoju.open.sdk.didies.service.bill.enums.hotel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HotelTypeEnum {

  AGREEMENT_PRICE("酒店协议价"),
  MEMBER_HOTEL("会员酒店");

  /**
   * 状态码
   */
  private final String code;
}
