package com.xiaoju.open.sdk.didies.service.order.enums.train;

import lombok.Getter;

@Getter
public enum TravelerTypeEnum {

    INTERNAL(0, "内部员工"),
    EXTERNAL(1, "外部员工");

    private final Integer code;
    private final String description;

    TravelerTypeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
