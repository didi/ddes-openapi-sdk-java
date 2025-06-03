package com.xiaoju.open.sdk.didies.service.bill.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AdjustListItem  {

    /**
     * 子订单号, 国内/国际机票/火车票：票id, 国内/海外酒店/增值服务：子订单号, 网约车/代驾/出租车：订单号;
     * 
     */
    @JsonProperty("sub_order_id")
    private String subOrderId;
    /**
     * 子品类,网约车：1 出租车：100 代驾：40 国内酒店：201 国内机票：202 火车票：203 国际酒店：204 国际机票：205 增值服务：531(还不支持,未来扩展)
     * 
     */
    @JsonProperty("sub_business_type")
    private Integer subBusinessType;
    /**
     * adjustFields
     * 
     */
    @JsonProperty("adjust_fields")
    private AdjustFields adjustFields;
}

