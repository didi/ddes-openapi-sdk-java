package com.xiaoju.open.sdk.didies.service.legalentity;



import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.CreateLegalEntityApiReply;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.CreateLegalEntityRequest;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.DelLegalEntityApiReply;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.DelLegalEntityRequest;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.GetLegalEntityApiReply;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.GetLegalEntityRequest;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.UpdateLegalEntityApiReply;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.UpdateLegalEntityRequest;
import com.xiaoju.open.sdk.didies.service.legalentity.v1.V1;

public class LegalEntity extends BaseService {

    protected final ITokenHolder tokenHolder;

    protected final Config config;

    private final V1 v1;

    public LegalEntity(ITokenHolder tokenHolder, Config config) {
        this.tokenHolder = tokenHolder;
        this.config = config;
        this.v1 = new V1(tokenHolder, config);
    }

    public V1 v1() {
        return this.v1;
    }
}

