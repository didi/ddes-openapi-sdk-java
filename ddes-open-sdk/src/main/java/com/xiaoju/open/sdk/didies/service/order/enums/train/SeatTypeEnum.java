package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;

@Getter
public enum SeatTypeEnum {

  HARD_SEAT("1", "硬座"),
  SOFT_SEAT("2", "软座"),
  HARD_SLEEPER("3", "硬卧"),
  SOFT_SLEEPER("4", "软卧"),
  COMPARTMENT_HARD_SLEEPER("5", "包厢硬卧"),
  HIGH_SOFT_SLEEPER("6", "高级软卧"),
  FIRST_SOFT_SEAT("7", "一等软座"),
  SECOND_SOFT_SEAT("8", "二等软座"),
  BUSINESS_SEAT("9", "商务座"),
  HIGH_SPEED_SLEEPER("A", "高级动卧"),
  MIXED_HARD_SEAT("B", "混编硬座"),
  MIXED_HARD_SLEEPER("C", "混编硬卧"),
  COMPARTMENT_SOFT_SEAT("D", "包厢软座"),
  SPECIAL_SOFT_SEAT("E", "特等软座"),
  SLEEPER("F", "动卧"),
  TWO_PERSON_SOFT_COMPARTMENT("G", "二人软包"),
  ONE_PERSON_SOFT_COMPARTMENT("H", "一人软包"),
  FIRST_SLEEPER("I", "一等卧"),
  SECOND_SLEEPER("J", "二等卧"),
  MIXED_SOFT_SEAT("K", "混编软座"),
  MIXED_SOFT_SLEEPER("L", "混编软卧"),
  FIRST_SEAT("M", "一等座"),
  SECOND_SEAT("O", "二等座"),
  SPECIAL_SEAT("P", "特等座"),
  MULTI_FUNCTION_SEAT("Q", "多功能座"),
  SECOND_PACKAGE_SEAT("S", "二等包座");

  private final String code;
  private final String description;

  SeatTypeEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }
}
