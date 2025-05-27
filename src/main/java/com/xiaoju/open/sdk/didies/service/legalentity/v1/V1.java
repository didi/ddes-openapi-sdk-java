package com.xiaoju.open.sdk.didies.service.legalentity.v1;

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

public class V1 extends BaseService {

    public V1(ITokenHolder tokenHolder, Config config) {
        this.config = config;
        this.tokenHolder = tokenHolder;
    }

    /**
    * 公司主体新增
    * 说明： * 新增公司主体信息后，可以使用查询接口查询ES后台的维护情况。
    * @param createLegalEntityRequest  (required)
    * @return CreateLegalEntityApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public CreateLegalEntityApiReply createLegalEntity(CreateLegalEntityRequest createLegalEntityRequest) throws Exception {
        
        return doPost(createLegalEntityRequest, "/river/LegalEntity/add", CreateLegalEntityApiReply.class, 0);
    }
    /**
    * 公司主体停用
    * 说明： * 停用公司主体信息。
    * @param delLegalEntityRequest  (required)
    * @return DelLegalEntityApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public DelLegalEntityApiReply delLegalEntity(DelLegalEntityRequest delLegalEntityRequest) throws Exception {
        
        return doPost(delLegalEntityRequest, "/river/LegalEntity/del", DelLegalEntityApiReply.class, 0);
    }
    /**
    * 公司主体查询
    * 说明： * 查询公司在滴滴侧的具体信息; * 通过获取的信息用于确认相关的配置信息，可以用于同步滴滴ES后台的信息; * 只返回有效的公司信息。不包含禁用和过期的公司主体信息。需要返回全部的，是不是需要重新封接口。
    * @param getLegalEntityRequest  (required)
    * @return GetLegalEntityApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public GetLegalEntityApiReply getLegalEntity(GetLegalEntityRequest getLegalEntityRequest) throws Exception {
        return doGet(getLegalEntityRequest, "/river/LegalEntity/get", GetLegalEntityApiReply.class, 0);
        
    }
    /**
    * 公司主体修改
    * 说明： * 修改公司主体信息后，可以使用查询接口查询ES后台的维护情况。
    * @param updateLegalEntityRequest  (required)
    * @return UpdateLegalEntityApiReply
    * @throws Exception if an error occurs while attempting to invoke the API
    */
    public UpdateLegalEntityApiReply updateLegalEntity(UpdateLegalEntityRequest updateLegalEntityRequest) throws Exception {
        
        return doPost(updateLegalEntityRequest, "/river/LegalEntity/edit", UpdateLegalEntityApiReply.class, 0);
    }
}

