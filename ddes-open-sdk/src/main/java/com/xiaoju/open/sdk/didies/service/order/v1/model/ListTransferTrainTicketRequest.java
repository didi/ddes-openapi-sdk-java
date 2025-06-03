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
public class ListTransferTrainTicketRequest extends BaseReq  {

    /**
     * 企业ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 上车日期，格式2021-01-01
     * 
     */
    @JsonProperty("train_date")
    private String trainDate;
    /**
     * 上车站站名
     * 
     */
    @JsonProperty("from_station_name")
    private String fromStationName;
    /**
     * 下车站站名
     * 
     */
    @JsonProperty("to_station_name")
    private String toStationName;
    /**
     * 当前页码，大于等于1且为正整数
     * 
     */
    @JsonProperty("cur_page")
    private Integer curPage;
}

