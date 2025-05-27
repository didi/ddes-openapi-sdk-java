package com.xiaoju.open.sdk.didies.service.rank;



import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.CreateRankApiReply;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.CreateRankRequest;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.DelRankApiReply;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.DelRankRequest;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.ListRankApiReply;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.ListRankRequest;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.UpdateRankApiReply;
import com.xiaoju.open.sdk.didies.service.rank.v1.model.UpdateRankRequest;
import com.xiaoju.open.sdk.didies.service.rank.v1.V1;

public class Rank extends BaseService {

    protected final ITokenHolder tokenHolder;

    protected final Config config;

    private final V1 v1;

    public Rank(ITokenHolder tokenHolder, Config config) {
        this.tokenHolder = tokenHolder;
        this.config = config;
        this.v1 = new V1(tokenHolder, config);
    }

    public V1 v1() {
        return this.v1;
    }
}

