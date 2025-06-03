package com.xiaoju.open.sdk.didies.service.order.enums;

import lombok.Getter;

@Getter
public enum SearchTimeEnum {

    ALL("all", "所有时间"),
    BOOK_TIME("book_time", "预订时间"),
    EXCHANGE_TIME("exchange_time", "改签时间"),
    REFUND_TIME("refund_time", "退票时间"),
    CHANGE_TIME("change_time", "更新时间"),
    PAY_TIME("pay_time", "支付时间");

    private final String code;
    private final String description;

    SearchTimeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
