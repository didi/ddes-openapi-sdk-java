package com.xiaoju.open.sdk.ddes.service.member

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.enums.EncryptTypeEnum
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum
import com.xiaoju.open.sdk.didies.service.member.Member
import com.xiaoju.open.sdk.didies.service.member.v1.model.*
import com.xiaoju.open.sdk.didies.utils.AesUtils
import com.xiaoju.open.sdk.didies.utils.JacksonUtils
import spock.lang.Ignore
import spock.lang.Specification

/**
 * API tests for Member
 */
@Ignore
class MemberTest extends Specification {

    Member api

    String signKey = "xxxxxx" // 此signKey用于敏感信息加密 需单独申请

    def setup() {
        Config config = Config.builder()
                .baseUrl("https://api.es.xiaojukeji.com")
                .clientId("替换成自己的clientId")
                .clientSecret("替换成自己的clientSecret")
                .signKey("替换成自己的signKey")
                .enableRequestLog(true)
                .logLevel(LogLevelEnum.INFO).build()
        ApiClient client = new ApiClient(config)
        api = client.member()

    }

    /**
     * 用户新增
     *
     * 注意  - 常驻地目前只支持如“北京”、“北京市”、“北京市海淀区”格式，不支持“海淀区”此类格式，如果传参中带了区县则必须把“市”、“区“、”县”字段都带上。 - 同一公司。连续添加员工，需要间隔 150ms - 人员唯一值可以在手机号，员工编号，邮箱中指定一个，如果多个一起传递时，会一起校验企业级内是否有存在重复的信息并报错返回。
     */
    def createMemberTest() {

        def encryptCardNo = AesUtils.encrypt("511321199812254672", signKey, EncryptTypeEnum.AES128)
        CreateMemberRequest createMemberRequest = new CreateMemberRequest(
                companyId: "替换成自己的companyId",
                dataObj: new MemberInfo(
                        realname: "自定义_",
                        email: "471811119@qq.com",
                        memberType: 2,
                        cardList: [
                                new CardInfo(
                                        cardType: 1,
                                        cardNo: encryptCardNo
                                )
                        ]
                )
        )

        CreateMemberApiReply response = api.v1().createMember(createMemberRequest)
        println JacksonUtils.toJson(response)
        expect:
        response != null
    }
    /**
     * 用户删除
     *
     * 说明： * 用于删除滴滴ES后台人员信息；
     */
    def delMemberTest() {
        DelMemberRequest delMemberRequest = new DelMemberRequest(
                companyId: "替换成自己的companyId",
                memberId: 1125966624062758
        )
        DelMemberApiReply response = api.v1().delMember(delMemberRequest)
        println JacksonUtils.toJson(response)
        expect:
        response != null
    }
    /**
     * 员工明细
     *
     * 注意： * 员工工号、手机号是精确查询，名字为模糊查询; * offset必须可以被length整除，如offset&#x3D;0,length&#x3D;100,0可以被100整除，合法；offset&#x3D;1,length&#x3D;100,1不能被100整除，不合法;   说明：   * 用户如果传了 last_id，除了 status，其他检索条件会失效;  * 当 status 为空或者没传，返回的为正常、离职和未绑手机号的员工;  * birth_date加密格式，返回的参数需要重新提供；
     */
    def getMemberDetailTest() {
        GetMemberDetailRequest getMemberDetailRequest = new GetMemberDetailRequest(
                companyId: "替换成自己的companyId",
                memberId: 1125966624062758
        )

        GetMemberDetailApiReply response = api.v1().getMemberDetail(getMemberDetailRequest)
        println JacksonUtils.toJson(response)
        expect:
        response != null
    }
    /**
     * 员工限额查询
     *
     * 用于查询滴滴ES后台已有的人员的限额信息。   说明：   * 限额查询请求的开始日期和结束日期时间跨度不能大于六个月。若只传开始日期，则返回结果为开始日期后当月；若只传结束日期，则返回结果为结束日期当月；  * 按指定类型返回对应查询日期内的限额信息；  * 若限额类型为自然月，开始、结束日期应传自然月开始日、结束日；若未传自然月开始日、结束日，则按自然月查询（只取年+月份），如：2020-05-03 至 2020-06-22，则按照2020-05-01 至 2020-06-31查询；
     */
    def getMemberQuotaTest() {
        GetMemberQuotaRequest getMemberQuotaRequest = new GetMemberQuotaRequest(
                companyId: "替换成自己的companyId",
                memberIds: "1125966624062758",
        )

        GetMemberQuotaApiReply response = api.v1().getMemberQuota(getMemberQuotaRequest)
        println JacksonUtils.toJson(response)
        expect:
        response != null
    }
    /**
     * 员工列表（批量查询）
     *
     * 注意： * 员工工号、手机号是精确查询，名字为模糊查询; * offset必须可以被length整除，如offset&#x3D;0,length&#x3D;100,0可以被100整除，合法；offset&#x3D;1,length&#x3D;100,1不能被100整除，不合法   说明：   * 用户如果传了 last_id，除了 status，其他检索条件会失效，首次查询时需要从0开始传递;  * 当 status 为空或者没传，返回的为正常、离职和未绑手机号的员工; * birth_date加密格式，返回的参数需要重新提供;
     */
    def listMemberTest() {
        ListMemberRequest listMemberRequest = new ListMemberRequest(
                companyId: "替换成自己的companyId",
                offset: 0,
                length: 1
        )

        ListMemberApiReply response = api.v1().listMember(listMemberRequest)
        println JacksonUtils.toJson(response)
        expect:
        response != null
    }
    /**
     * 用户修改【缺响应示例】
     *
     * 注意：  - 常驻地目前只支持如“北京”、“北京市”、“北京市海淀区”格式，不支持“海淀区”此类格式，如果传参中带了区县则必须把“市”、“区“、”县”字段都带上。  - 同一公司。连续添加员工，需要间隔 150ms
     */
    def updateMemberTest() {
        UpdateMemberRequest updateMemberRequest = new UpdateMemberRequest(
                companyId: "替换成自己的companyId",
                memberId: 1125966624062758,
                dataObj: new MemberInfo(
                        sex: 0
                )
        )
        UpdateMemberApiReply response = api.v1().updateMember(updateMemberRequest)
        println JacksonUtils.toJson(response)
        expect:
        response != null
    }

}