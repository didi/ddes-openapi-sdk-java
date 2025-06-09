package com.xiaoju.open.sdk.didies.service.login.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class H5AirportPickUp  {

    /**
     * 制度规则 id
     * 
     */
    @JsonProperty("rule_id")
    private String ruleId;
    /**
     * 预约接机为airportPickUp
     * 
     */
    @JsonProperty("jumpPage")
    private String jumpPage;
    /**
     * 航班号，如不传需手动选择
     * 
     */
    @JsonProperty("flight_no")
    private String flightNo;
    /**
     * 航班出发日期，如 flight_no有参数，此字段必传
     * 
     */
    @JsonProperty("flight_depart_date")
    private String flightDepartDate;
    /**
     * 差旅、申请用车，必传
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
    /**
     * 如不传以手动选择地址为终点
     * 
     */
    @JsonProperty("to_city_id")
    private String toCityId;
    /**
     * 如不传以手动选择地址为终点
     * 
     */
    @JsonProperty("lat_to")
    private String latTo;
    /**
     * 如不传以手动选择地址为终点
     * 
     */
    @JsonProperty("lng_to")
    private String lngTo;
    /**
     * 如不传以手动选择地址为终点
     * 
     */
    @JsonProperty("poi_to_name")
    private String poiToName;
    /**
     * 乘车人手机号，代叫必传
     * 
     */
    @JsonProperty("passenger_phone")
    private String passengerPhone;
    /**
     * 设置passenger_phone后可传入 如不传入默认使用在 滴滴管理后台填入的名称或乘客+手机号后四位
     * 
     */
    @JsonProperty("passenger_name")
    private String passengerName;
    /**
     * 如需锁定地址，必传
     * 
     */
    @JsonProperty("restrict_poi_flag")
    private String restrictPoiFlag;
    /**
     * 是否在预估页面隐藏价格相关信息 1 是 0 否，不传等于0
     * 
     */
    @JsonProperty("hide_estimate_price_flag")
    private String hideEstimatePriceFlag;
}

