package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.order.v1.model.DetailsAmount;
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
public class DomesticHotelOrderBaseInfo  {

    /**
     * 每日价格
     * 
     */
    @JsonProperty("details_amount")
    private List<DetailsAmount> detailsAmount;
    /**
     * 用户支付时间，格式：yyyy-MM-dd HH:mm:ss
     * 
     */
    @JsonProperty("pay_time")
    private String payTime;
    /**
     * 预订入住时间，格式：yyyy-MM-dd
     * 
     */
    @JsonProperty("checkin_time")
    private String checkinTime;
    /**
     * 预订离店时间，格式：yyyy-MM-dd
     * 
     */
    @JsonProperty("checkout_time")
    private String checkoutTime;
    /**
     * 预订成功时间，格式：yyyy-MM-dd HH:mm:ss
     * 
     */
    @JsonProperty("confirm_time")
    private String confirmTime;
    /**
     * 实际入住时间，最晚按照预订离店时间+1天更新 格式：yyyy-MM-dd
     * 
     */
    @JsonProperty("real_checkin_time")
    private String realCheckinTime;
    /**
     * 实际离店时间，最晚按照预订离店时间+1天更新 格式：yyyy-MM-dd
     * 
     */
    @JsonProperty("real_checkout_time")
    private String realCheckoutTime;
    /**
     * 城市，城市中文名
     * 
     */
    @JsonProperty("city_name")
    private String cityName;
    /**
     * 城市ID，滴滴城市ID
     * 
     */
    @JsonProperty("city_id")
    private String cityId;
    /**
     * 酒店中文名称
     * 
     */
    @JsonProperty("hotel_name")
    private String hotelName;
    /**
     * 酒店英文名称
     * 
     */
    @JsonProperty("hotel_english_name")
    private String hotelEnglishName;
    /**
     * 房型名称
     * 
     */
    @JsonProperty("room_name")
    private String roomName;
    /**
     * 预订房间数 ，不包含提前离店
     * 
     */
    @JsonProperty("room_num")
    private Integer roomNum;
    /**
     * 预订间夜数 ，不包含提前离店
     * 
     */
    @JsonProperty("room_night")
    private Integer roomNight;
    /**
     * 实际房间数 ，最晚按照预订离店时间+1天更新
     * 
     */
    @JsonProperty("real_room_number")
    private Integer realRoomNumber;
    /**
     * 实际间夜数 ，最晚按照预订离店时间+1天更新
     * 
     */
    @JsonProperty("real_room_night")
    private Integer realRoomNight;
    /**
     * 酒店发票类型，枚举值：增专，增普
     * 
     */
    @JsonProperty("invoice_type")
    private String invoiceType;
    /**
     * * 接口返回，文档未标注字段
     * 
     */
    @JsonProperty("county_name")
    private String countyName;
    /**
     * countyId
     * 
     */
    @JsonProperty("county_id")
    private String countyId;
    /**
     * country
     * 
     */
    @JsonProperty("country")
    private String country;
}

