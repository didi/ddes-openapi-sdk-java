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
public class DailyAmountControl  {

    /**
     * 每人日金额管控
     * 
     */
    @JsonProperty("daily_amount")
    private Integer dailyAmount;
    /**
     * 管控方式1 日清
     * 
     */
    @JsonProperty("control_type")
    private Integer controlType;
    /**
     * 1 市内用车
     * 
     */
    @JsonProperty("control_product")
    private List<Integer> controlProduct;
}

