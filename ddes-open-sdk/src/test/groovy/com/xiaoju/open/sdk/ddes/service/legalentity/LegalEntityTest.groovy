package com.xiaoju.open.sdk.ddes.service.legalentity

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum
import com.xiaoju.open.sdk.didies.service.legalentity.LegalEntity
import com.xiaoju.open.sdk.didies.service.legalentity.v1.model.*
import com.xiaoju.open.sdk.didies.utils.JacksonUtils
import spock.lang.Ignore
import spock.lang.Specification

/**
 * API tests for LegalEntity
 */
@Ignore
class LegalEntityTest extends Specification {

    private LegalEntity api

    def setup() {
        Config config = Config.builder()
                .baseUrl("https://api.es.xiaojukeji.com")
                .clientId("替换成自己的clientId")
                .clientSecret("替换成自己的clientSecret")
                .signKey("替换成自己的signKey")
                .enableRequestLog(true)
                .logLevel(LogLevelEnum.INFO).build()
        ApiClient client = new ApiClient(config)
        api = client.legalentity()
    }

    /**
     * 公司主体新增
     *
     * 说明： * 新增公司主体信息后，可以使用查询接口查询ES后台的维护情况。
     */
    def createLegalEntityTest() {
        CreateLegalEntityRequest createLegalEntityRequest = new CreateLegalEntityRequest(
                companyId: "替换成自己的companyId", "name": "自定义",
        )
        CreateLegalEntityApiReply response = api.v1().createLegalEntity(createLegalEntityRequest)
        println JacksonUtils.toJson(response)
        return response
    }

    /**
     * 公司主体修改
     *
     * 说明： * 修改公司主体信息后，可以使用查询接口查询ES后台的维护情况。
     */
    def updateLegalEntityTest(legal_entity_id) {
        UpdateLegalEntityRequest updateLegalEntityRequest = new UpdateLegalEntityRequest(
                companyId: "替换成自己的companyId",
                legalEntityId: legal_entity_id,
                name: "自定义_修改"
        )
        UpdateLegalEntityApiReply response = api.v1().updateLegalEntity(updateLegalEntityRequest)
        println(JacksonUtils.toJson(response))
    }

    /**
     * 公司主体停用
     *
     * 说明：停用公司主体信息。
     */
    def delLegalEntityTest(legalEntityId) {
        DelLegalEntityRequest delLegalEntityRequest = new DelLegalEntityRequest(
                companyId: "替换成自己的companyId",
                legalEntityId: legalEntityId
        )
        DelLegalEntityApiReply response = api.v1().delLegalEntity(delLegalEntityRequest)
        println JacksonUtils.toJson(response)
        return response
    }

    /**
     * 公司主体查询
     *
     * 说明： * 查询公司在滴滴侧的具体信息; * 通过获取的信息用于确认相关的配置信息，可以用于同步滴滴ES后台的信息; * 只返回有效的公司信息。不包含禁用和过期的公司主体信息。需要返回全部的，是不是需要重新封接口。
     */
    def getLegalEntityTest(legalEntityId) {
        GetLegalEntityRequest getLegalEntityApiRequest = new GetLegalEntityRequest(
                companyId: "替换成自己的companyId",
                legalEntityId: legalEntityId
        )
        GetLegalEntityApiReply response = api.v1().getLegalEntity(getLegalEntityApiRequest)
        println JacksonUtils.toJson(response)
    }


    /**
     * 公司主体查询
     *
     * 说明： * 查询公司在滴滴侧的具体信息; * 通过获取的信息用于确认相关的配置信息，可以用于同步滴滴ES后台的信息; * 只返回有效的公司信息。不包含禁用和过期的公司主体信息。需要返回全部的，是不是需要重新封接口。
     */
    def getLegalEntityTest1() {
        GetLegalEntityRequest getLegalEntityApiRequest = new GetLegalEntityRequest(
//                companyId: "替换成自己的companyId",
//                legalEntityId: legalEntityId
                companyId: "1125923905976852",
                length: 1,
                offset: 0,

        )
        GetLegalEntityApiReply response = api.v1().getLegalEntity(getLegalEntityApiRequest)
        println JacksonUtils.toJson(response)

        expect:
        response!= null
    }

    /**
     * 整合测试
     * 1、创建
     * 2、更新
     * 3、查询
     * 4、删除
     */
    def combineAll() {
        def createResp = createLegalEntityTest()
        def legal_entity_id = createResp.getData().getLegalEntityId()
        getLegalEntityTest(legal_entity_id)
        updateLegalEntityTest(legal_entity_id)
        def delResp = delLegalEntityTest(legal_entity_id)
        expect:
        delResp != null

    }

}