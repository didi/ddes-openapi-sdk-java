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
public class H5ToAirport  {

    /**
     * 制度规则 id
     * 
     */
    @JsonProperty("rule_id")
    private String ruleId;
    /**
     * 送机为toAirport
     * 
     */
    @JsonProperty("jumpPage")
    private String jumpPage;
    /**
     * 机场ID，如不传需手动选择
     * 
     */
    @JsonProperty("airport_id")
    private String airportId;
    /**
     * 如不传以手动选择地址为起点
     * 
     */
    @JsonProperty("city_id")
    private String cityId;
    /**
     * 如不传以手动选择地址为起点
     * 
     */
    @JsonProperty("lat_from")
    private String latFrom;
    /**
     * 如不传以手动选择地址为起点
     * 
     */
    @JsonProperty("lng_from")
    private String lngFrom;
    /**
     * 如不传以手动选择地址为起点
     * 
     */
    @JsonProperty("poi_from_name")
    private String poiFromName;
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

