package com.xiaoju.open.sdk.didies.service.login.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5AirportPickUp;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5AirportPickUpNow;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5BTrip;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5BTripCategory;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5BTripOrderDetail;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5CallCarAppointment;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5CallCarNow;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5CallCenter;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5CharteredCar;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5HomeAddress;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5Invoice;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5MyWallet;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5OrderDetail;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5OrderList;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5RuleDesc;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5RuleList;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5StationPickUp;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5ToAirport;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5ToStation;
import com.xiaoju.open.sdk.didies.service.login.v1.model.H5TravelList;
import com.xiaoju.open.sdk.didies.service.login.v1.model.PCLogin;
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
public class GetLoginEncryptStrReply  {

    /**
     * 跳转链接
     * 
     */
    @JsonProperty("encrypt_str")
    private String encryptStr;
    /**
     * 实时用车需要用到的参数
     * 
     */
    @JsonProperty("callCarNow")
    private H5CallCarNow callCarNow;
    /**
     * callCarAppointment
     * 
     */
    @JsonProperty("callCarAppointment")
    private H5CallCarAppointment callCarAppointment;
    /**
     * airportPickUpNow
     * 
     */
    @JsonProperty("airportPickUpNow")
    private H5AirportPickUpNow airportPickUpNow;
    /**
     * airportPickUp
     * 
     */
    @JsonProperty("airportPickUp")
    private H5AirportPickUp airportPickUp;
    /**
     * toAirport
     * 
     */
    @JsonProperty("toAirport")
    private H5ToAirport toAirport;
    /**
     * stationPickUp
     * 
     */
    @JsonProperty("stationPickUp")
    private H5StationPickUp stationPickUp;
    /**
     * toStation
     * 
     */
    @JsonProperty("toStation")
    private H5ToStation toStation;
    /**
     * orderDetail
     * 
     */
    @JsonProperty("orderDetail")
    private H5OrderDetail orderDetail;
    /**
     * travelList
     * 
     */
    @JsonProperty("travelList")
    private H5TravelList travelList;
    /**
     * h5RuleList
     * 
     */
    @JsonProperty("h5RuleList")
    private H5RuleList h5RuleList;
    /**
     * h5RuleDesc
     * 
     */
    @JsonProperty("h5RuleDesc")
    private H5RuleDesc h5RuleDesc;
    /**
     * h5OrderList
     * 
     */
    @JsonProperty("H5OrderList")
    private H5OrderList h5OrderList;
    /**
     * h5Invoice
     * 
     */
    @JsonProperty("h5Invoice")
    private H5Invoice h5Invoice;
    /**
     * h5MyWallet
     * 
     */
    @JsonProperty("h5MyWallet")
    private H5MyWallet h5MyWallet;
    /**
     * h5CallCenter
     * 
     */
    @JsonProperty("h5CallCenter")
    private H5CallCenter h5CallCenter;
    /**
     * h5HomeAddress
     * 
     */
    @JsonProperty("h5HomeAddress")
    private H5HomeAddress h5HomeAddress;
    /**
     * h5CharteredCar
     * 
     */
    @JsonProperty("h5CharteredCar")
    private H5CharteredCar h5CharteredCar;
    /**
     * h5Trip
     * 
     */
    @JsonProperty("h5Trip")
    private H5BTrip h5Trip;
    /**
     * h5BTripCategory
     * 
     */
    @JsonProperty("h5BTripCategory")
    private H5BTripCategory h5BTripCategory;
    /**
     * h5BTripOrderDetail
     * 
     */
    @JsonProperty("h5BTripOrderDetail")
    private H5BTripOrderDetail h5BTripOrderDetail;
    /**
     * pcLogin
     * 
     */
    @JsonProperty("pcLogin")
    private PCLogin pcLogin;
}

