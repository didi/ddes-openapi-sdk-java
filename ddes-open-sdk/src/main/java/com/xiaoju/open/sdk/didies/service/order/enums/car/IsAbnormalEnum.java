package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;

@Getter
public enum IsAbnormalEnum {

    NO(0, "否"),
    YES(1, "是");

    private final Integer code;
    private final String description;

    IsAbnormalEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
