package com.xiaoju.open.sdk.didies.service.order.enums.flight;

import lombok.Getter;

@Getter
public enum RcTypeEnum {

    CABIN_CLASS("舱等RC", "舱等RC"),
    LOW_PRICE("低价RC", "低价RC"),
    EARLY_BOOKING("提前预定RC", "提前预定RC"),
    TRAIN_DURATION_EXCEEDED("同行程火车耗时超标", "同行程火车耗时超标"),
    TRAIN_PRICE_EXCEEDED("同行程火车价格超标", "同行程火车价格超标");

    private final String code;
    private final String description;

    RcTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
