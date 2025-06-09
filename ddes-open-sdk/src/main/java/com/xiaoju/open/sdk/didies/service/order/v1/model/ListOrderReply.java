package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.order.v1.model.CarData;
import com.xiaoju.open.sdk.didies.service.order.v1.model.DomesticFlightIdData;
import com.xiaoju.open.sdk.didies.service.order.v1.model.DomesticHotelIdData;
import com.xiaoju.open.sdk.didies.service.order.v1.model.InternationalFlightIdData;
import com.xiaoju.open.sdk.didies.service.order.v1.model.InternationalHotelIdData;
import com.xiaoju.open.sdk.didies.service.order.v1.model.TrainData;
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
public class ListOrderReply  {

    /**
     * domesticflightData
     * 
     */
    @JsonProperty("domesticflight_data")
    private DomesticFlightIdData domesticflightData;
    /**
     * internationalflightData
     * 
     */
    @JsonProperty("internationalflight_data")
    private InternationalFlightIdData internationalflightData;
    /**
     * domestichotelData
     * 
     */
    @JsonProperty("domestichotel_data")
    private DomesticHotelIdData domestichotelData;
    /**
     * internationalhotelData
     * 
     */
    @JsonProperty("internationalhotel_data")
    private InternationalHotelIdData internationalhotelData;
    /**
     * trainData
     * 
     */
    @JsonProperty("train_data")
    private TrainData trainData;
    /**
     * carData
     * 
     */
    @JsonProperty("car_data")
    private CarData carData;
}

