package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;

@Getter
public enum CarOrderSourceEnum {

    WEB(0, "Web"),
    APP(1, "滴滴出行App"),
    H5(2, "H5"),
    OPEN_API(3, "OpenAPI"),
    ENTERPRISE_APP(4, "企业APP"),
    INVITATION_COUPON(5, "邀约券"),
    SDK(6, "SDK"),
    WEBAPP(8, "Webapp"),
    ENTERPRISE_H5(10, "企业app H5");

    private final Integer code;
    private final String description;

    CarOrderSourceEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
