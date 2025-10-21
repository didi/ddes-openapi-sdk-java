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
public class DomesticFlightOrderChangeListItem  {

    /**
     * changeInfo
     * 
     */
    @JsonProperty("change_info")
    private DomesticFlightOrderChangeInfo changeInfo;
}

