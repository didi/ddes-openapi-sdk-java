package com.xiaoju.open.sdk.didies.service.bill.enums.car;

import lombok.Getter;


@Getter
public enum DeductionTypeNameEnum {
  ORDER_COMPANY_PAYMENT("订单企业支付扣款"),
  ORDER_COMPANY_REFUND("订单企业支付后退款"),
  COMPANY_TO_PERSON_REFUND("企业支付转个人支付退款"),
  APPROVAL_REJECT_REFUND("行后审批驳回后退款"),
  PERSON_TO_COMPANY_PAYMENT("个人支付转企业支付扣款"),
  OFFLINE_COMPANY_PAYMENT("线下企业支付扣款"),
  COMPANY_TO_PERSON_RECHARGE("企业支付转个人支付充值"),
  APPROVAL_REJECT_RECHARGE("行后审批驳回后充值");

  private final String description;

  DeductionTypeNameEnum(String description) {
    this.description = description;
  }
}
