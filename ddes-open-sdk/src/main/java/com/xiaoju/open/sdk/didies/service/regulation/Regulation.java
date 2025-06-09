package com.xiaoju.open.sdk.didies.service.regulation;



import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.GetRegulationApiReply;
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.GetRegulationRequest;
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.ListRegulationApiReply;
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.ListRegulationRequest;
import com.xiaoju.open.sdk.didies.service.regulation.v1.V1;

public class Regulation extends BaseService {

    protected final ITokenHolder tokenHolder;

    protected final Config config;

    private final V1 v1;

    public Regulation(ITokenHolder tokenHolder, Config config) {
        this.tokenHolder = tokenHolder;
        this.config = config;
        this.v1 = new V1(tokenHolder, config);
    }

    public V1 v1() {
        return this.v1;
    }
}

