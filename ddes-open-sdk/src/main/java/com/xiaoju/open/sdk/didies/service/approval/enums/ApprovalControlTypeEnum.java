package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;

@Getter
public enum ApprovalControlTypeEnum {

    DAILY_CLEAR(1, "日清");

    private final Integer code;
    private final String description;

    ApprovalControlTypeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
