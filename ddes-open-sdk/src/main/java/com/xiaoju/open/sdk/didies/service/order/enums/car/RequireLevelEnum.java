package com.xiaoju.open.sdk.didies.service.order.enums.car;

import lombok.Getter;

@Getter
public enum RequireLevelEnum {

  COMFORT(100, "专车舒适型"),
  EXECUTIVE(200, "专车行政型"),
  BUSINESS(400, "专车商务型"),
  PREFERRED(500, "专车优选型"),
  EXPRESS(600, "普通快车"),
  EXPRESS_PLUS(900, "快车优享型"),
  LUXURY(1000, "豪华车"),
  BMW_5_SERIES(1400, "豪华车-宝马5系"),
  AUDI_A6L(1401, "豪华车-奥迪A6L"),
  LUXURY_SPECIAL(1402, "豪华车-专车页面下豪华车"),
  TESLA(1403, "豪华车-特斯拉"),
  MERCEDES_S_CLASS(1404, "豪华车-奔驰S级"),
  MERCEDES_V_CLASS(1405, "豪华车-奔驰V级"),
  LUXURY_6_SEATER(1406, "豪华车-豪华六座"),
  ALPHARD(1407, "豪华车-埃尔法"),
  SCENE_CAR(1408, "豪华车-场景车型"),
  PANAMERA(1409, "豪华车-Panamera"),
  LUXURY_SEDAN(1410, "豪华车-豪华轿车"),
  HONGQI_H7(1411, "豪华车-红旗H7"),
  INFINITI(1412, "豪华车-英菲尼迪"),
  PORSCHE(1413, "豪华车-保时捷"),
  LINCOLN_CONTINENTAL(1414, "豪华车-林肯大陆"),
  AUDI_A8L(1415, "豪华车-奥迪A8L"),
  ACURA_RDX(1416, "豪华车-讴歌RDX"),
  NIO_ES8(1417, "豪华车-蔚来ES8"),
  LAMBORGHINI(1418, "豪华车-兰博基尼"),
  LEXUS(1419, "豪华车-雷克萨斯"),
  VOLVO(1420, "豪华车-沃尔沃"),
  MERCEDES_E_CLASS(1500, "好豪华车-奔驰E级"),
  JAGUAR_LAND_ROVER(1600, "豪华车-捷豹路虎"),
  CORPORATE_TAXI(1100, "企业出租车"),
  PREFERRED_TAXI(2000, "优选出租车"),
  MULTI_CALL(2300, "同时呼叫"),
  CORPORATE_DISCOUNT_EXPRESS(40600, "企业特价快车");

  private final Integer code;
  private final String description;

  RequireLevelEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
