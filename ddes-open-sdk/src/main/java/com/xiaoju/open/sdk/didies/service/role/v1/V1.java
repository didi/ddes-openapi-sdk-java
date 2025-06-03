package com.xiaoju.open.sdk.didies.service.role.v1;

import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.role.v1.model.ListRoleApiReply;
import com.xiaoju.open.sdk.didies.service.role.v1.model.ListRoleRequest;

public class V1 extends BaseService {

    public V1(ITokenHolder tokenHolder, Config config) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 角色查询【返回data字段为数组，特殊处理】
    * 用于查询员工角色信息
    * @param listRoleRequest  (required)
    * @return ListRoleApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public ListRoleApiReply listRole(ListRoleRequest listRoleRequest) throws Exception {
        return doGet(listRoleRequest, "/river/Role/get", ListRoleApiReply.class, 0);
        
    }
}

