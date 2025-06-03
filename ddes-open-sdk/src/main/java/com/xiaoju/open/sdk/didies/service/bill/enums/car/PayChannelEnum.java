package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;

@Getter
public enum PayChannelEnum {
  BANK_CARD("银行卡"),
  DEFU_TONG("德付通"),
  PRE_DEPOSIT("预存"),
  CASH_BACK("返现"),
  CREDIT("授信"),
  TRIAL_FUND("试用金"),
  E_ACCOUNT("电子账户");

  private final String description;

  PayChannelEnum(String description) {
    this.description = description;
  }
}
