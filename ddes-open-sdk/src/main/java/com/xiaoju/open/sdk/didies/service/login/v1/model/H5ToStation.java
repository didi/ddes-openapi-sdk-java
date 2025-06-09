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
public class H5ToStation  {

    /**
     * 制度规则 id
     * 
     */
    @JsonProperty("rule_id")
    private String ruleId;
    /**
     * 送站为toStation
     * 
     */
    @JsonProperty("jumpPage")
    private String jumpPage;
    /**
     * 预约时间，必传;如需制定预约时间，必传，格式”今天|14:30”，只支持[今天、明天、后天]
     * 
     */
    @JsonProperty("appointment_time")
    private String appointmentTime;
    /**
     * 差旅、申请用车，必传
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
    /**
     * 如不传以定位获取的地址为起点
     * 
     */
    @JsonProperty("lat_from")
    private String latFrom;
    /**
     * 如不传以定位获取的地址为起点
     * 
     */
    @JsonProperty("lng_from")
    private String lngFrom;
    /**
     * 如不传以定位获取的地址为起点
     * 
     */
    @JsonProperty("poi_from_name")
    private String poiFromName;
    /**
     * 如不传以手动选择地址为起点
     * 
     */
    @JsonProperty("city_id")
    private String cityId;
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

