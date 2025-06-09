package com.xiaoju.open.sdk.didies.service.regulation.enums;

import lombok.Getter;

@Getter
public enum RegulationSourceEnum {

    COMMON_RULE(1, "通用规则"),
    PRE_TRIP_APPROVAL(2, "行前审批"),
    TRAVEL(3, "差旅"),
    NO_APPROVAL(4, "无需审批");

    private final Integer code;
    private final String description;

    RegulationSourceEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
