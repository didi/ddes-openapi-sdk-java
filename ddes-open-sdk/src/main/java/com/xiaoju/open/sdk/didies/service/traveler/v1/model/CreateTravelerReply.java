package com.xiaoju.open.sdk.didies.service.traveler.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTravelerReply  {

    /**
     * 外部出行人在滴滴平台的 ID
     * 
     */
    @JsonProperty("id")
    private Long id;
}

