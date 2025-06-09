package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.core.model.BaseReq;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;




@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GetFlightEstimatePriceRequest extends BaseReq  {

    /**
     * 企业ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 出发城市id
     * 
     */
    @JsonProperty("departure_city_id")
    private String departureCityId;
    /**
     * 到达城市id
     * 
     */
    @JsonProperty("arrival_city_id")
    private String arrivalCityId;
    /**
     * 出发时间，格式 2024-01-31
     * 
     */
    @JsonProperty("date")
    private String date;
    /**
     * 1表示只要直飞，2表示只要中转，3或0或者不传表示全都搜索
     * 
     */
    @JsonProperty("search_type")
    private Integer searchType;
}

