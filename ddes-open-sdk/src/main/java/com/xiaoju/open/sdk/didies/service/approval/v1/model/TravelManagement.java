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
public class TravelManagement  {

    /**
     * 每日金额管控内容
     * 
     */
    @JsonProperty("daily_amount_control")
    private List<DailyAmountControl> dailyAmountControl;
}

