package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;

@Getter
public enum NeedRuleInfoEnum {

    NO(0, "不返回"),
    YES(1, "返回");

    private final Integer code;
    private final String description;

    NeedRuleInfoEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
