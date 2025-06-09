package com.xiaoju.open.sdk.didies.service.approval.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.MeetingTrip;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.Trip;
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
public class TravelDetail  {

    /**
     * 行程开始时间，格式： YYYY-MM-DD
     * 
     */
    @JsonProperty("start_date")
    private String startDate;
    /**
     * 行程结束时间，格式： YYYY-MM-DD
     * 
     */
    @JsonProperty("end_date")
    private String endDate;
    /**
     * 行程信息，行程信息；行程使用的制度(regulation_id)中，出差城市配置为无需填写时，trips可为空。否则必传，需按照行程顺序填写 详见 trip
     * 
     */
    @JsonProperty("trips")
    private List<Trip> trips;
    /**
     * meetingTrip
     * 
     */
    @JsonProperty("meeting_trip")
    private MeetingTrip meetingTrip;
    /**
     * 行程起点城市是否包含市内用车权限和酒店，（0-不包含，1-包含），trips第一行视为起点城市；默认为无市内用车和酒店，不管控和轻度管控不生效 不影响接送机服务
     * 
     */
    @JsonProperty("start_city_rule")
    private Integer startCityRule;
    /**
     * 行程终点城市是否包含市内用车权限和酒店，（0-不包含，1-包含），trips最后一行视为终点城市，不管控和轻度管控不生效 不影响接送机服务,中度管控只对市内用车生效。严格管控下，对市内用车和酒店生效
     * 
     */
    @JsonProperty("end_city_rule")
    private Integer endCityRule;
    /**
     * 火车票次数，火车票次数；火车票次数 （不传走默认计算逻辑，传0代表火车票不可用）
     * 
     */
    @JsonProperty("train_total_count")
    private Integer trainTotalCount;
    /**
     * 机票次数，机票次数（不传走默认计算逻辑，传0代表机票不可用，对国内机票、国际机票都生效）
     * 
     */
    @JsonProperty("flight_total_count")
    private Integer flightTotalCount;
    /**
     * 酒店总间夜，酒店总间夜（不传走默认计算逻辑，传0代表酒店不可用，对国内酒店、国际酒店都生效）
     * 
     */
    @JsonProperty("hotel_total_count")
    private Integer hotelTotalCount;
    /**
     * 接送机总次数，接送机总次数（不传走默认计算逻辑，其他参数代表接送机总次数）
     * 
     */
    @JsonProperty("pickup_total_count")
    private Integer pickupTotalCount;
    /**
     * 品类控制开关，品类控制开关；制度有权限时,控制申请单是否创建品类对应服务 3-市内用车；4-火车票服务；6-机票服务；9-接送服务；10-酒店服务；11-国际机票服务，12 国际酒店服务 如果传了机火两个品类。制度上只开了机票品牌。则创建申请单成功，只能使用机票服务 category_control 传空数组会报错 举例：[4,10]，同时传递国内国际机票类别时，需要至少有一段国内城市对，否则报错。
     * 
     */
    @JsonProperty("category_control")
    private List<Integer> categoryControl;
}

