package com.xiaoju.open.sdk.ddes.service.rank

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum
import com.xiaoju.open.sdk.didies.service.rank.Rank
import com.xiaoju.open.sdk.didies.service.rank.v1.model.*
import com.xiaoju.open.sdk.didies.utils.JacksonUtils
import spock.lang.Ignore
import spock.lang.Specification

/**
 * API tests for Rank
 */
@Ignore
class RankTest extends Specification {

    private Rank api

    def setup() {
        Config config = new Config()
                .setClientId("your_client_id")
                .setClientSecret("your_client_secret")
                .setSignKey("your_sign_key")
        ApiClient client = new ApiClient(config)
        api = client.rank()
    }

    /**
     * 职级新增
     *
     * 说明 - 用于新增职级信息；  注意 - 公司职级总数限制 500 个;   param字段列表  | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | out_rank_id | 外部职级编号 | string | N | 限制 30 字符 | | name | 职级名称 | string | Y | 最长 30 字符，只能输入汉字、字母、数字、下划线、连字符、空格、点、括号、加、减和等号 | 
     */
    def createRankTest() {
        CreateRankRequest createRankRequest = new CreateRankRequest(
                companyId: "替换成自己的companyId",
                paramJsonObj: new RankInfo(
                        outRankId: "123",
                        name: "自定义"
                )
        )

        CreateRankApiReply response = api.v1().createRank(createRankRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 职级删除
     *
     * 说明 - 用于删除职级信息；  param字段列表  | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | rank_id | 滴滴侧职级 ID | string | N | 滴滴侧职级 ID和外部职级编号二者之一必填 | | out_rank_id | 外部职级编号 | string | N | 限制 30 字符 | 
     */
    def delRankTest() {
        DelRankRequest delRankRequest = new DelRankRequest(
                companyId: "替换成自己的companyId",
                paramJsonObj: new RankInfo(
                        rankId: "1125966903187442"
                )
        )

        DelRankApiReply response = api.v1().delRank(delRankRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 职级查询
     *
     * 说明 - 用于查询职级的列表信息
     */
    def listRankTest() {
        ListRankRequest rankRequest = new ListRankRequest(
                companyId: "替换成自己的companyId",
                offset: 0,
                length: 1
        )

        ListRankApiReply response = api.v1().listRank(rankRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 职级修改
     *
     * 说明 - 用于修改职级信息；  param字段列表  | 字段名 | 字段说明 | 字段类型 | 必填 | 备注 | | ---- | ---- | ---- | ---- | ---- | | rank_id | 滴滴侧职级 ID | string | N | 滴滴侧职级 ID和外部职级编号二者之一必填 | | out_rank_id | 外部职级编号 | string | N | 限制 30 字符 | | name | 职级名称 | string | Y | 最长 30 字符，只能输入汉字、字母、数字、下划线、连字符、空格、点、括号、加、减和等号 |
     */
    def updateRankTest() {
        UpdateRankRequest updateRankRequest = new UpdateRankRequest(
                companyId: "替换成自己的companyId",
                paramJsonObj: new RankInfo(
                        rankId: "1125966903187442",
                        outRankId: "1234",
                        name: "自定义_修改"
                )
        )

        UpdateRankApiReply response = api.v1().updateRank(updateRankRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }

}