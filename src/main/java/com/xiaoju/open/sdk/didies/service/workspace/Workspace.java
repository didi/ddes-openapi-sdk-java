package com.xiaoju.open.sdk.didies.service.workspace;



import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.workspace.v1.model.CreateWorkplaceApiReply;
import com.xiaoju.open.sdk.didies.service.workspace.v1.model.CreateWorkplaceRequest;
import com.xiaoju.open.sdk.didies.service.workspace.v1.model.DeleteWorkplaceApiReply;
import com.xiaoju.open.sdk.didies.service.workspace.v1.model.DeleteWorkplaceRequest;
import com.xiaoju.open.sdk.didies.service.workspace.v1.model.UpdateWorkplaceApiReply;
import com.xiaoju.open.sdk.didies.service.workspace.v1.model.UpdateWorkplaceRequest;
import com.xiaoju.open.sdk.didies.service.workspace.v1.V1;

public class Workspace extends BaseService {

    protected final ITokenHolder tokenHolder;

    protected final Config config;

    private final V1 v1;

    public Workspace(ITokenHolder tokenHolder, Config config) {
        this.tokenHolder = tokenHolder;
        this.config = config;
        this.v1 = new V1(tokenHolder, config);
    }

    public V1 v1() {
        return this.v1;
    }
}

