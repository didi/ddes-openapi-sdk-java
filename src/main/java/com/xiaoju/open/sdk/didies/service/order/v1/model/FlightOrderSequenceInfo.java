package com.xiaoju.open.sdk.didies.service.order.v1.model;

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





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FlightOrderSequenceInfo  {

    /**
     * 航程序号，票下的航段计数，单程时为1
     * 
     */
    @JsonProperty("sequence")
    private Integer sequence;
    /**
     * 预计起飞时间，格式：yyyy-MM-dd HH:mm:ss
     * 
     */
    @JsonProperty("departure_time")
    private String departureTime;
    /**
     * 预计到达时间，格式：yyyy-MM-dd HH:mm:ss
     * 
     */
    @JsonProperty("arrival_time")
    private String arrivalTime;
    /**
     * 航班号
     * 
     */
    @JsonProperty("flight_number")
    private String flightNumber;
    /**
     * 共享航班号
     * 
     */
    @JsonProperty("share_flight_number")
    private String shareFlightNumber;
    /**
     * 舱等，枚举值字母： 物理舱位   F  头等舱     C 商务      Y经济
     * 
     */
    @JsonProperty("class")
    private String propertyClass;
    /**
     * 舱位类型，枚举值数字： 0 未配置,1 头等舱,2 超值头等舱,3 商务舱,4 经济舱,5 经济舱精选,6 经济舱y舱
     * 
     */
    @JsonProperty("cabin_type")
    private Integer cabinType;
    /**
     * 起飞城市，城市中文名
     * 
     */
    @JsonProperty("departure_city")
    private String departureCity;
    /**
     * 起飞城市ID，滴滴城市ID
     * 
     */
    @JsonProperty("departure_city_id")
    private String departureCityId;
    /**
     * 到达城市，城市中文名
     * 
     */
    @JsonProperty("arrival_city")
    private String arrivalCity;
    /**
     * 到达城市ID，滴滴城市ID
     * 
     */
    @JsonProperty("arrival_city_id")
    private String arrivalCityId;
    /**
     * 经停城市，城市中文名
     * 
     */
    @JsonProperty("stop_city")
    private String stopCity;
    /**
     * 经停城市ID，滴滴城市ID
     * 
     */
    @JsonProperty("stop_city_id")
    private String stopCityId;
    /**
     * 起飞机场，机场中文名
     * 
     */
    @JsonProperty("departure_airport")
    private String departureAirport;
    /**
     * 起飞机场代码，机场IATACODE
     * 
     */
    @JsonProperty("departure_airport_code")
    private String departureAirportCode;
    /**
     * 到达机场，机场中文名
     * 
     */
    @JsonProperty("arrival_airport")
    private String arrivalAirport;
    /**
     * 到达机场代码，机场IATACODE
     * 
     */
    @JsonProperty("arrival_airport_code")
    private String arrivalAirportCode;
    /**
     * 经停机场，机场中文名
     * 
     */
    @JsonProperty("stop_airport")
    private String stopAirport;
    /**
     * 经停机场代码，机场IATACODE
     * 
     */
    @JsonProperty("stop_airport_code")
    private String stopAirportCode;
}

