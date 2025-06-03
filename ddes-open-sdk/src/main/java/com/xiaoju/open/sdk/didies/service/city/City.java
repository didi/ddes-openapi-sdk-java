package com.xiaoju.open.sdk.didies.service.city;



import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListAirportCityApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListAirportCityRequest;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCarCityApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCarCityRequest;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCityApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCityRequest;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCountryApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListCountryRequest;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListHotelCityApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListHotelCityRequest;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListTrainCityApiReply;
import com.xiaoju.open.sdk.didies.service.city.v1.model.ListTrainCityRequest;
import com.xiaoju.open.sdk.didies.service.city.v1.V1;

public class City extends BaseService {

    protected final ITokenHolder tokenHolder;

    protected final Config config;

    private final V1 v1;

    public City(ITokenHolder tokenHolder, Config config) {
        this.tokenHolder = tokenHolder;
        this.config = config;
        this.v1 = new V1(tokenHolder, config);
    }

    public V1 v1() {
        return this.v1;
    }
}

