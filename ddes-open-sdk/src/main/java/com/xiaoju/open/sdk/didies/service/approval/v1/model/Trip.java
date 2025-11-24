package com.xiaoju.open.sdk.didies.service.approval.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Trip  {

    /**
     * 出发城市名称，出发城市名称 城市名称和城市ID建议传一种，不要一起传。
     * 
     */
    @JsonProperty("departure_city")
    private String departureCity;
    /**
     * 滴滴出发城市ID，出发城市 ID，国际需要使用ID
     * 
     */
    @JsonProperty("departure_city_id")
    private Integer departureCityId;
    /**
     * 到达城市名称，到达城市名称 ；非轻度管控必传
     * 
     */
    @JsonProperty("destination_city")
    private String destinationCity;
    /**
     * 滴滴到达城市ID，到达城市 ID；非轻度管控必传 国际需要使用ID
     * 
     */
    @JsonProperty("destination_city_id")
    private Integer destinationCityId;
    /**
     * 行程段开始时间，行程段开始时间 轻度管控模式下，必须与 travel_detail 中的 start_date 相同 举例：2023-01-02
     * 
     */
    @JsonProperty("start_date")
    private String startDate;
    /**
     * 行程段结束时间，行程段结束时间 轻度管控模式下，必须与 travel_detail 中的 end_date 相同 举例：2023-01-14
     * 
     */
    @JsonProperty("end_date")
    private String endDate;
    /**
     * 出行方式，出行方式：0-其他；1-火车 ;2-飞机；支持多个，多个用英文逗号分开（用车酒店默认根据制度配置生效）举例：0,1,2，中度管控按照第一段生效
     * 
     */
    @JsonProperty("trip_type")
    private String tripType;
    /**
     * 目的城市集合，轻度管控必传，其他模式传了不生效 举例：[{\&quot;id\&quot;:1,\&quot;name\&quot;:\&quot;北京\&quot;}]
     * 
     */
    @JsonProperty("to_citys")
    private List<TravelCity> toCitys;
    /**
     * 单程/往返，控制严格管控模式下，滴滴侧是否识别这个trip为往返行程生成返程行程权限 非必传字段，0-单程， 1-往返；默认为单程；传1后的拆分逻辑为：去程使用trip的传参生成，返程生成规则为：目的地-出发地，end_date-end_date，使用去程的trip_type；若对去程和返程的交通方式有分别管控诉求，不推荐使用此字段，建议拆成两个trip传输
     * 
     */
    @JsonProperty("is_return")
    private Integer isReturn;
    /**
     * 出发地维度 默认0; 1：国家；2：省；0：城市(包括县级市)
     * 
     */
    @JsonProperty("departure_address_dimension")
    private Integer departureAddressDimension;
    /**
     * 出发国家ID
     * 
     */
    @JsonProperty("departure_country_id")
    private Integer departureCountryId;
    /**
     * 出发国家名称
     * 
     */
    @JsonProperty("departure_country_name")
    private String departureCountryName;
    /**
     * 出发省ID
     * 
     */
    @JsonProperty("departure_province_id")
    private Integer departureProvinceId;
    /**
     * 出发省名称
     * 
     */
    @JsonProperty("departure_province_name")
    private String departureProvinceName;
    /**
     * 目的地维度 默认0; 1：国家；2：省；0：城市(包括县级市) 地址维度字段
     * 
     */
    @JsonProperty("destination_address_dimension")
    private Integer destinationAddressDimension;
    /**
     * 到达国家ID
     * 
     */
    @JsonProperty("destination_country_id")
    private Integer destinationCountryId;
    /**
     * 到达国家名称
     * 
     */
    @JsonProperty("destination_country_name")
    private String destinationCountryName;
    /**
     * 到达省ID
     * 
     */
    @JsonProperty("destination_province_id")
    private Integer destinationProvinceId;
    /**
     * 到达省名称
     * 
     */
    @JsonProperty("destination_province_name")
    private String destinationProvinceName;
}

