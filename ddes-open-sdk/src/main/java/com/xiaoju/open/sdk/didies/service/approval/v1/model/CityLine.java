package com.xiaoju.open.sdk.didies.service.approval.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
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
public class CityLine  {

    /**
     * startId
     * 
     */
    @JsonProperty("start_id")
    private String startId;
    /**
     * startName
     * 
     */
    @JsonProperty("start_name")
    private String startName;
    /**
     * endId
     * 
     */
    @JsonProperty("end_id")
    private String endId;
    /**
     * endName
     * 
     */
    @JsonProperty("end_name")
    private String endName;
}

