package com.xiaoju.open.sdk.ddes.service.role

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum
import com.xiaoju.open.sdk.didies.service.role.Role
import com.xiaoju.open.sdk.didies.service.role.v1.model.ListRoleApiReply
import com.xiaoju.open.sdk.didies.service.role.v1.model.ListRoleRequest
import com.xiaoju.open.sdk.didies.utils.JacksonUtils
import spock.lang.Ignore
import spock.lang.Specification

/**
 * API tests for Role
 */
@Ignore
class RoleTest extends Specification {

    private Role api

    def setup() {
        Config config = Config.builder()
                .baseUrl("https://api.es.xiaojukeji.com")
                .clientId("替换成自己的clientId")
                .clientSecret("替换成自己的clientSecret")
                .signKey("替换成自己的signKey")
                .enableRequestLog(true)
                .logLevel(LogLevelEnum.INFO).build()
        ApiClient client = new ApiClient(config)
        api = client.role()
    }

    /**
     * 角色查询【返回data字段为数组，特殊处理】
     *
     * 用于查询员工角色信息
     */
    def listRoleTest() {
        ListRoleRequest body = new ListRoleRequest(
                companyId: "替换成自己的companyId",
        )

        ListRoleApiReply response = api.v1().listRole(body)

        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
}