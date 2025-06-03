package com.xiaoju.open.sdk.didies.service.traveler;



import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.CreateTravelerApiReply;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.CreateTravelerRequest;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.DelTravelerApiReply;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.DelTravelerRequest;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.UpdateTravelerApiReply;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.UpdateTravelerRequest;
import com.xiaoju.open.sdk.didies.service.traveler.v1.V1;

public class Traveler extends BaseService {

    protected final ITokenHolder tokenHolder;

    protected final Config config;

    private final V1 v1;

    public Traveler(ITokenHolder tokenHolder, Config config) {
        this.tokenHolder = tokenHolder;
        this.config = config;
        this.v1 = new V1(tokenHolder, config);
    }

    public V1 v1() {
        return this.v1;
    }
}

