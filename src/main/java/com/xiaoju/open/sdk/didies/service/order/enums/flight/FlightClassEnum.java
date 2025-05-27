package com.xiaoju.open.sdk.didies.service.order.enums.flight;

import lombok.Getter;

@Getter
public enum FlightClassEnum {

    FIRST_CLASS("F", "头等舱"),
    BUSINESS_CLASS("C", "商务舱"),
    ECONOMY_CLASS("Y", "经济舱");

    private final String code;
    private final String description;

    FlightClassEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
