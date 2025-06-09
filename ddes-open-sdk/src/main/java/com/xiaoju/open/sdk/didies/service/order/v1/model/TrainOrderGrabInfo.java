package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TrainOrderGrabInfo  {

    /**
     * 滴滴ID或travelerId用于关联乘客信息，多个英文逗号隔开
     * 
     */
    @JsonProperty("passenger_traveler_id")
    private List<String> passengerTravelerId;
    /**
     * 格式：yyyy-MM-dd  ，多个英文逗号隔开，包含主选，主选是第一个。
     * 
     */
    @JsonProperty("selected_time")
    private List<String> selectedTime;
    /**
     * 多个英文逗号隔开
     * 
     */
    @JsonProperty("selected_train_code")
    private List<String> selectedTrainCode;
    /**
     * 多个英文逗号隔开，字母
     * 
     */
    @JsonProperty("selected_seat_type")
    private List<String> selectedSeatType;
    /**
     * 多个英文逗号隔开，名称
     * 
     */
    @JsonProperty("seat_type_name")
    private List<String> seatTypeName;
    /**
     * 城市中文名，主选
     * 
     */
    @JsonProperty("departure_city_name")
    private String departureCityName;
    /**
     * 滴滴城市ID，主选
     * 
     */
    @JsonProperty("departure_city_id")
    private String departureCityId;
    /**
     * 城市中文名，主选
     * 
     */
    @JsonProperty("arrival_city_name")
    private String arrivalCityName;
    /**
     * 滴滴城市ID，主选
     * 
     */
    @JsonProperty("arrival_city_id")
    private String arrivalCityId;
    /**
     * 主选
     * 
     */
    @JsonProperty("departure_station_name")
    private String departureStationName;
    /**
     * 主选
     * 
     */
    @JsonProperty("arrival_station_name")
    private String arrivalStationName;
    /**
     * 单位：分 按照每人每种抢票情况最高价汇总
     * 
     */
    @JsonProperty("total_grab_price")
    private Integer totalGrabPrice;
    /**
     * 单位：分 实时收取的服务费 抢票按照百分比收时，该字段会变更
     * 
     */
    @JsonProperty("total_service_fee")
    private Integer totalServiceFee;
    /**
     * 单位：分 抢票成功时收取的服务费
     * 
     */
    @JsonProperty("total_grab_service_fee")
    private Integer totalGrabServiceFee;
    /**
     * 单位：分 total_grab_price+total_service_fee+total_grab_service_fee总和的公司支付部分
     * 
     */
    @JsonProperty("company_pay")
    private Integer companyPay;
    /**
     * 单位：分 total_grab_price+total_service_fee+total_grab_service_fee总和的个人支付部分
     * 
     */
    @JsonProperty("personal_pay")
    private Integer personalPay;
}

