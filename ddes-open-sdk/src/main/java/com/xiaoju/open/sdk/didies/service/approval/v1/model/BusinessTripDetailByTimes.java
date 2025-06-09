package com.xiaoju.open.sdk.didies.service.approval.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;



@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessTripDetailByTimes  {

    /**
     * 开始时间，开始时间，需要大于等于接口调用当前时间。时间格式为：2015-06-16 12:00:09
     * 
     */
    @JsonProperty("start_time")
    private String startTime;
    /**
     * 结束时间，结束时间，需大于等于开始时间。时间格式为：2015-06-16 12:00:09
     * 
     */
    @JsonProperty("end_time")
    private String endTime;
    /**
     * 滴滴出发城市 ID，出发城市 ID；制度配置需要填写时必填
     * 
     */
    @JsonProperty("departure_city_id")
    private Integer departureCityId;
    /**
     * 出发地城市名称，出发地城市名称（指定出发地时必填）
     * 
     */
    @JsonProperty("departure_city")
    private String departureCity;
    /**
     * 滴滴目的地城市ID，目的地城市id（指定目的地时必填）
     * 
     */
    @JsonProperty("destination_city_id")
    private Integer destinationCityId;
    /**
     * 目的地城市名称，目的地城市名称（指定目的地时必填）
     * 
     */
    @JsonProperty("destination_city")
    private String destinationCity;
    /**
     * 出发地名称，出发地名称（最多50个字）（指定出发地时必填）
     * 
     */
    @JsonProperty("start_name")
    private String startName;
    /**
     * 出发地详细地址，出发地详细地址（最多100个字）（指定出发地时必填）
     * 
     */
    @JsonProperty("start_address")
    private String startAddress;
    /**
     * 出发地纬度，出发地纬度 （指定出发地时必填）
     * 
     */
    @JsonProperty("flat")
    private BigDecimal flat;
    /**
     * 出发地经度，出发地经度 （指定出发地时必填）
     * 
     */
    @JsonProperty("flng")
    private BigDecimal flng;
    /**
     * 目的地名称，目的地名称（最多50个字）（指定目的地时必填）
     * 
     */
    @JsonProperty("end_name")
    private String endName;
    /**
     * 目的地详细地址，目的地详细地址（最多100个字）（指定目的地时必填）
     * 
     */
    @JsonProperty("end_address")
    private String endAddress;
    /**
     * 目的地纬度，目的地纬度（指定目的地时必填）
     * 
     */
    @JsonProperty("tlat")
    private BigDecimal tlat;
    /**
     * 目的地经度，目的地经度（指定目的地时必填）
     * 
     */
    @JsonProperty("tlng")
    private BigDecimal tlng;
    /**
     * 是否往返，是否往返，0-不往返，1-往返，默认为0
     * 
     */
    @JsonProperty("is_return")
    private Integer isReturn;
    /**
     * 用车次数，用车次数，当is_return为1时，用车次数必须为偶数（去程一次+回程一次 制度配置为无需填写，传了不生效
     * 
     */
    @JsonProperty("trip_times")
    private Integer tripTimes;
    /**
     * 每单限额，每单限额，单位:分，需大于100生效, 需是 100 的整数倍 1. 制度配置了由员工填写，小于 100 为不限 2. 制度配置为无需填写，传了不生效 3. 制度配置金额，用户也传了。以配置的为主
     * 
     */
    @JsonProperty("perorder_money_quota")
    private Integer perorderMoneyQuota;
    /**
     * 总限额，总限额，单位：分，需大于100生效，需是 100 的整数倍 1. 制度配置了由员工填写，小于 100 为不限 2. 制度配置为无需填写，传了不生效
     * 
     */
    @JsonProperty("total_money_quota")
    private Integer totalMoneyQuota;
}

