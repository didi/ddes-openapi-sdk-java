package com.xiaoju.open.sdk.didies.service.role;



import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.role.v1.model.ListRoleApiReply;
import com.xiaoju.open.sdk.didies.service.role.v1.model.ListRoleRequest;
import com.xiaoju.open.sdk.didies.service.role.v1.V1;

public class Role extends BaseService {

    protected final ITokenHolder tokenHolder;

    protected final Config config;

    private final V1 v1;

    public Role(ITokenHolder tokenHolder, Config config) {
        this.tokenHolder = tokenHolder;
        this.config = config;
        this.v1 = new V1(tokenHolder, config);
    }

    public V1 v1() {
        return this.v1;
    }
}

