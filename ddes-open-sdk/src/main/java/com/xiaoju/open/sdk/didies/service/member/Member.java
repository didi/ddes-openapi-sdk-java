package com.xiaoju.open.sdk.didies.service.member;



import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.member.v1.model.CreateMemberApiReply;
import com.xiaoju.open.sdk.didies.service.member.v1.model.CreateMemberRequest;
import com.xiaoju.open.sdk.didies.service.member.v1.model.DelMemberApiReply;
import com.xiaoju.open.sdk.didies.service.member.v1.model.DelMemberRequest;
import com.xiaoju.open.sdk.didies.service.member.v1.model.GetMemberDetailApiReply;
import com.xiaoju.open.sdk.didies.service.member.v1.model.GetMemberDetailRequest;
import com.xiaoju.open.sdk.didies.service.member.v1.model.GetMemberQuotaApiReply;
import com.xiaoju.open.sdk.didies.service.member.v1.model.GetMemberQuotaRequest;
import com.xiaoju.open.sdk.didies.service.member.v1.model.ListMemberApiReply;
import com.xiaoju.open.sdk.didies.service.member.v1.model.ListMemberRequest;
import com.xiaoju.open.sdk.didies.service.member.v1.model.UpdateMemberApiReply;
import com.xiaoju.open.sdk.didies.service.member.v1.model.UpdateMemberRequest;
import com.xiaoju.open.sdk.didies.service.member.v1.V1;

public class Member extends BaseService {

    protected final ITokenHolder tokenHolder;

    protected final Config config;

    private final V1 v1;

    public Member(ITokenHolder tokenHolder, Config config) {
        this.tokenHolder = tokenHolder;
        this.config = config;
        this.v1 = new V1(tokenHolder, config);
    }

    public V1 v1() {
        return this.v1;
    }
}

