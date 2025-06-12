package com.xiaoju.open.sdk.ddes.service.budgetcenter

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum
import com.xiaoju.open.sdk.didies.service.budgetcenter.BudgetCenter
import com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model.*
import com.xiaoju.open.sdk.didies.utils.JacksonUtils
import spock.lang.Ignore
import spock.lang.Specification

/**
 * API tests for BudgetCenter
 */
@Ignore
class BudgetCenterTest extends Specification {

    private BudgetCenter api

    def setup() {
        Config config = new Config()
                .setClientId("your_client_id")
                .setClientSecret("your_client_secret")
                .setSignKey("your_sign_key")
        ApiClient client = new ApiClient(config)
        api = client.budgetcenter()
    }

    /**
     * 部门或项目新增
     *
     * 注意： * 部门数量上限是2000，如贵司超过2000个部门，请联系相应的对接同学添加白名单进行扩展; * 部门添加时，请不要并发操作，防止部门添加失败；  * 请求时无需中文转义；  说明  * 新建接口后，可以使用查询接口对齐信息;  * 建议保存新建之后返回的滴滴部门或项目的ID作为唯一主键，用于修改或删除的判断;
     */
    def createBudgetCenterTest() {
        CreateBudgetCenterRequest createBudgetCenterRequest = new CreateBudgetCenterRequest(
                companyId: "替换成自己的companyId",
                name: "自定义",
                type: 1,
                budgetCycle: 0,
                totalQuota: 0,
                outBudgetId: "自定义"
        )
        CreateBudgetCenterApiReply response = api.v1().createBudgetCenter(createBudgetCenterRequest)
        println JacksonUtils.toJson(response)
        expect:
        response != null
    }
    /**
     * 部门或项目停用
     *
     * 说明  * 停用接口后，可以使用查询接口对齐信息;  * 查询停用/删除的部门时，不返回;
     */
    def delBudgetCenterTest() {

        DelBudgetCenterRequest delBudgetCenterRequest = new DelBudgetCenterRequest(
                companyId: "替换成自己的companyId",
                id: 1125966620632586
        )

        DelBudgetCenterApiReply response = api.v1().delBudgetCenter(delBudgetCenterRequest)
        println JacksonUtils.toJson(response)
        expect:
        response != null
    }
    /**
     * 部门或项目查询
     *
     * 说明： * 查询项目或部门在滴滴侧的具体信息; * 通过获取的信息用于确认相关的配置信息，可以用于同步滴滴ES后台的信息，只能查询有效的部门。需要查询全部的状态。没有启用接口，过期时间修改逻辑需要确认；
     */
    def getBudgetCenterTest() {
        GetBudgetCenterRequest getBudgetCenterRequest = new GetBudgetCenterRequest(
                companyId: "替换成自己的companyId",
                offset: 0,
                length: 1
        )
        GetBudgetCenterApiReply response = api.v1().getBudgetCenter(getBudgetCenterRequest)
        println JacksonUtils.toJson(response)
        expect:
        response != null
    }
    /**
     * 部门或项目修改
     *
     * 说明  * 新建接口后，可以使用查询接口对齐信息;  * 建议保存新建之后返回的滴滴部门或项目的ID作为唯一主键，用于修改或删除的判断;
     */
    def updateBudgetCenterTest() {
        UpdateBudgetCenterRequest updateBudgetCenterRequest = new UpdateBudgetCenterRequest(
                companyId: "替换成自己的companyId",
                name: "自定义",
                type: 1,
                outBudgetId: "自定义"
        )
        UpdateBudgetCenterApiReply response = api.v1().updateBudgetCenter(updateBudgetCenterRequest)
        println JacksonUtils.toJson(response)
        expect:
        response != null
    }

}