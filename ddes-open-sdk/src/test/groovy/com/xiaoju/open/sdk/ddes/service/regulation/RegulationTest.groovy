package com.xiaoju.open.sdk.ddes.service.regulation

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum
import com.xiaoju.open.sdk.didies.service.regulation.Regulation
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.GetRegulationApiReply
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.GetRegulationRequest
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.ListRegulationApiReply
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.ListRegulationRequest
import com.xiaoju.open.sdk.didies.utils.JacksonUtils
import spock.lang.Ignore
import spock.lang.Specification

/**
 * API tests for Regulation
 */
@Ignore
class RegulationTest extends Specification {

    private Regulation api

    def setup() {
        Config config = new Config()
                .setClientId("your_client_id")
                .setClientSecret("your_client_secret")
                .setSignKey("your_sign_key")
        ApiClient client = new ApiClient(config)
        api = client.regulation()
    }

    /**
     * 制度详情【原始JSON示例与文档对不上，待验证】
     *
     * 说明 - 用于查询ES或审批单生成的制度详情；  注意 - 返回结果中，souece&#x3D;2或3时，表明此条制度是由需审批类的制度模板，通过员工申请、审批后生成，此时，以institution_id通过当前接口再次查询，可获得制度模板的详细信息；  1. source：1代表通用规则，非审批而来，2代表行前审批，3代表差旅 2. source&#x3D;2 &amp; scene_type &#x3D;1时，代表由行前审批制度，审批而来的自叫车 3. source&#x3D;2 &amp; scene_type &#x3D;91时，代表由行前审批制度，审批而来的代叫车 4. source&#x3D;3 &amp; scene_type &#x3D;1时，代表由差旅制度，审批而来的市内用车 5. source&#x3D;3 &amp; scene_type &#x3D;92时，代表由差旅制度，审批而来的接送服务用车 6. source&#x3D;4 无需审批代订场景下的临时制度；
     */
    def getRegulationTest() {
        GetRegulationRequest getRegulationApiRequest = new GetRegulationRequest(
                companyId: "替换成自己的companyId", regulationId: "1125927807992439"
        )

        GetRegulationApiReply response = api.v1().getRegulation(getRegulationApiRequest)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }
    /**
     * 制度列表
     *
     * 说明 - 用于查询ES后台制度信息
     */
    def listRegulationTest() {
        ListRegulationRequest body = new ListRegulationRequest(
                companyId: "替换成自己的companyId"
        )

        ListRegulationApiReply response = api.v1().listRegulation(body)
        println(JacksonUtils.toJson(response))
        expect:
        response != null
    }

}