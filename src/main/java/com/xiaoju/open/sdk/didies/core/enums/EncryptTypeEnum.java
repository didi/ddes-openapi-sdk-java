package com.xiaoju.open.sdk.didies.core.enums;

import lombok.Getter;

@Getter
public enum EncryptTypeEnum {

    NORMAL(0, "不加密"),
    AES128(1, "aes 128"),
    AES256(2, "aes 256");

    private final Integer type;
    private final String desc;

    EncryptTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
