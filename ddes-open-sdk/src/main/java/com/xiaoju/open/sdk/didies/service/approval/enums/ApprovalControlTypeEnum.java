package com.xiaoju.open.sdk.didies.service.approval.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApprovalControlTypeEnum {

    DAILY_CLEAR(1, "日清");

    /**
     * 状态码
     */
    private final Integer code;
    /**
     * 描述
     */
    private final String description;
}
