package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;

@Getter
public enum SubUseCarTypeEnum {

    CITY_CAR(0, "市内用车"),
    AIRPORT_PICKUP(1, "接送机"),
    TRAIN_STATION_PICKUP(2, "接送站"),
    BUS_STATION_PICKUP(3, "接送汽车站"),
    FERRY_PICKUP(4, "接送渡口");

    private final Integer code;
    private final String description;

    SubUseCarTypeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
