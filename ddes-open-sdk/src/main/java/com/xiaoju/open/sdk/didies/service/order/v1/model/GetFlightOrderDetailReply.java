package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.order.v1.model.DomesticFlightData;
import com.xiaoju.open.sdk.didies.service.order.v1.model.InternationalFlightData;
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
public class GetFlightOrderDetailReply  {

    /**
     * 符合查询条件的数据总数
     * 
     */
    @JsonProperty("total")
    private Integer total;
    /**
     * domesticflightData
     * 
     */
    @JsonProperty("domesticflight_data")
    private DomesticFlightData domesticflightData;
    /**
     * internationalflightData
     * 
     */
    @JsonProperty("internationalflight_data")
    private InternationalFlightData internationalflightData;
}

