package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;

@Getter
public enum IsSensitiveEnum {

    NOT_SENSITIVE(0, "不是敏感订单"),
    SENSITIVE(1, "敏感订单");

    private final Integer code;
    private final String description;

    IsSensitiveEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
