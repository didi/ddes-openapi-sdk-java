package com.xiaoju.open.sdk.didies.service.regulation.v1;

import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.GetRegulationApiReply;
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.GetRegulationRequest;
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.ListRegulationApiReply;
import com.xiaoju.open.sdk.didies.service.regulation.v1.model.ListRegulationRequest;

public class V1 extends BaseService {

    public V1(ITokenHolder tokenHolder, Config config) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 制度详情【原始JSON示例与文档对不上，待验证】
    * 说明 - 用于查询ES或审批单生成的制度详情；  注意 - 返回结果中，souece&#x3D;2或3时，表明此条制度是由需审批类的制度模板，通过员工申请、审批后生成，此时，以institution_id通过当前接口再次查询，可获得制度模板的详细信息；  1. source：1代表通用规则，非审批而来，2代表行前审批，3代表差旅 2. source&#x3D;2 &amp; scene_type &#x3D;1时，代表由行前审批制度，审批而来的自叫车 3. source&#x3D;2 &amp; scene_type &#x3D;91时，代表由行前审批制度，审批而来的代叫车 4. source&#x3D;3 &amp; scene_type &#x3D;1时，代表由差旅制度，审批而来的市内用车 5. source&#x3D;3 &amp; scene_type &#x3D;92时，代表由差旅制度，审批而来的接送服务用车 6. source&#x3D;4 无需审批代订场景下的临时制度；
    * @param getRegulationRequest  (required)
    * @return GetRegulationApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetRegulationApiReply getRegulation(GetRegulationRequest getRegulationRequest) throws Exception {
        return doGet(getRegulationRequest, "/river/Regulation/detail", GetRegulationApiReply.class, 0);
        
    }
    /**
    * 制度列表
    * 说明 - 用于查询ES后台制度信息
    * @param listRegulationRequest  (required)
    * @return ListRegulationApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public ListRegulationApiReply listRegulation(ListRegulationRequest listRegulationRequest) throws Exception {
        return doGet(listRegulationRequest, "/river/Regulation/get", ListRegulationApiReply.class, 0);
        
    }
}

