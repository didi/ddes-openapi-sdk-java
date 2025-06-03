package com.xiaoju.open.sdk.didies.service.bill.enums.hotel;

import lombok.Getter;

@Getter
public enum HotelTypeEnum {

  AGREEMENT_PRICE("酒店协议价", "酒店协议价"),
  MEMBER_HOTEL("会员酒店", "会员酒店");

  private final String code;
  private final String description;

  HotelTypeEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }
}
