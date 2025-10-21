package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GetHotelOrderDetailReply  {

    /**
     * 符合查询条件的数据总数
     * 
     */
    @JsonProperty("total")
    private Integer total;
    /**
     * domestichotelData
     * 
     */
    @JsonProperty("domestichotel_data")
    private DomesticHotelData domestichotelData;
    /**
     * internationalhotelData
     * 
     */
    @JsonProperty("internationalhotel_data")
    private InternationalHotelData internationalhotelData;
}

